package BDA;
/**Represents the twitter app
 * 
 * 
 * @author  Gonçalo Cruz
 * 
 */


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public final class TwitterApp {

	/**
	 * Represents the twitter.
	 */
	public static Twitter twitter;
	/**
	 * Represents all posts in this page.
	 */
	static DefaultListModel<T> tweets;
	
	
	/**
	 * Constructor, creates a TwitterFactory with all the informations we have about the tokens that we gave.
	 * @param AuthConsumerKey consumer key
	 * @param AuthConsumerSecret secret consumer key
	 * @param AuthAccessToken access token
	 * @param AuthAccessTokenSecret secret token
	 */

	public TwitterApp(String AuthConsumerKey, String AuthConsumerSecret, String AuthAccessToken, String AuthAccessTokenSecret){
		
		try {

			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey(AuthConsumerKey)
					.setOAuthConsumerSecret(AuthConsumerSecret)
					.setOAuthAccessToken(AuthAccessToken)
					.setOAuthAccessTokenSecret(AuthAccessTokenSecret);

			TwitterFactory tf = new TwitterFactory(cb.build());
			twitter = tf.getInstance();	
			tweets= new DefaultListModel<T>();
			BackupTweets();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	
	/** List of latest tweets from user's home timeline.
	 * @throws TwitterException catches a Twitter Exception.
	 *  @return a list of tweets
	 */
	public  DefaultListModel<T> getTimeline() throws TwitterException {
		List <Status> statuses = twitter.getHomeTimeline();
		for (Status status : statuses) {
			T x = new T (status.getUser().getName(), status.getText());
			tweets.addElement(x);
		}	
					
		return tweets;
		
	}
	

	/** Searching by user's name.
	 * 
	 * @param s is the name of the user.
	 * 
	 */
//	public static void searchForUser(String s) {
//		int counter = 0;
//		int counterTotal = 0;
//		for (Status status : statuses) {
//			if (status.getUser().getName() != null && status.getUser().getName().contains(s)) {
//				System.out.println(status.getUser().getName() + ":" + status.getText());
//				counter++;
//			}
//			counterTotal++;
//		}
//		System.out.println("-------------\nNº of Results: " + counter + "/" + counterTotal);
//
//	}
	
	
	/** Retweet
	 * @param s tweet to retweet.
	 * @throws TwitterException error
	 */
	
	public void retweet(T s) throws TwitterException {
		Status status = twitter.updateStatus("Retweet:  " + s.getName() + ":" + s.getText());
		System.out.println("Successfully updated the status to [" + status.getText() + "].");
	}
	
	
	public  static boolean isTwitterOnline(){
		try {
			
		Socket socket=new Socket();
		int port = 80;
        InetSocketAddress socketAddress = new InetSocketAddress("twitter.com", port);
		socket.connect(socketAddress, 3000);
		return true;
		} catch (IOException e) {
			
			return false;
			
		}
	}
	
	public static void BackupTweets(){
		
		
		try {
			ArrayList<T> list1=new ArrayList<T>();
		List <Status> statuses = twitter.getHomeTimeline();
		for (Status status : statuses) {
			T x = new T (status.getUser().getName(), status.getText());
			list1.add(x);
		}
			
		File file = new File("config.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(file);
		Element root=doc.getDocumentElement();
		
			NodeList list = doc.getChildNodes().item(0).getChildNodes();
			for (int count = 0; count < list.getLength(); count++) {

				Node tempNode = list.item(count);
				if(tempNode.getNodeName().equals("Twitter")){
					System.out.println("found");
					tempNode.getParentNode().removeChild(tempNode);
				}
			}
			
			Element twitter=doc.createElement("Twitter");
			root.appendChild(twitter);
			
			for(T e:list1){
				Element tweet=doc.createElement("Tweet");
				tweet.setAttribute("Username", e.getName());
				tweet.setAttribute("Text", e.getText());
				twitter.appendChild(tweet);
			}
		
		 Transformer transformer = TransformerFactory.newInstance().newTransformer();
         transformer.setOutputProperty(OutputKeys.INDENT, "yes");
         StreamResult result = new StreamResult(new FileOutputStream("config.xml"));
         DOMSource source = new DOMSource(doc);
         transformer.transform(source, result);
         System.out.println("Backup");
	
	} catch (ParserConfigurationException | SAXException | IOException | TransformerFactoryConfigurationError | TransformerException | TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	
public static DefaultListModel<T> FetchFromBackup(){
		
		DefaultListModel<T> tweets = new DefaultListModel<T>();
		try {

			File file = new File("config.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;

			dBuilder = dbFactory.newDocumentBuilder();

			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();

			NodeList list = doc.getChildNodes().item(0).getChildNodes();
			for (int count = 0; count < list.getLength(); count++) {

				Node tempNode = list.item(count);
				
				if(tempNode.getNodeName().equals("Twitter")){
					
					NodeList elist=tempNode.getChildNodes();
					for(int i=0; i<elist.getLength(); i++){
						Node m=elist.item(i);
						
						if (m.getNodeType() == Node.ELEMENT_NODE && m.getNodeName().equals("Tweet")) {
						tweets.addElement(new T(((Element) m).getAttribute("Username"), ((Element) m).getAttribute("Text")));
					}
					}
					
				}
				
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets;
	}
	
	
	
}

