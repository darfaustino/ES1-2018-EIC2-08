package BDA;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;
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

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.User;

	/** 
	 * Facebook App.
	 *
	 */
	
public class Facebook {
	
	private String accessToken;
	private FacebookClient fbClient;

	/**
	 * Constructor, it initializes both attributes: the access token and the Facebook Client.
	 * 
	 * @param acessToken	The name of the string that is going to be the accessToken.
	 */
	
	public Facebook(String acessToken){
		this.accessToken=acessToken; //expira 21/12/2018
		fbClient = new DefaultFacebookClient(accessToken);
		BackupFPosts(this.PostsList());
	}
	
	/**
	 * Connects the Facebook Client with the posts of the user's time line.
	 * Creates a DefaultListModel.
	 * Scrolls through all the posts of all the pages of the user's time line.
	 * Filters the posts: they must have something written and have the word "ISCTE" also written there.
	 * Counts each post and filtered post.
	 * Prints the number, id, time when it was created and message of each filtered post.
	 * Adds the filtered posts to the DefaultListModel.
	 * Prints the number of filtered and total number of posts covered.
	 * 
	 * @return 		Returns the DefaultListModel that contains the filtered posts.
	 */
	public DefaultListModel<FacePost> getTimeLinePosts(){
		Connection<Post> result = fbClient.fetchConnection("me/feed", Post.class);
		int counter = 0;
		int counterTotal = 0;
		DefaultListModel<FacePost> lista= new DefaultListModel<FacePost>();
		for (List<Post> page : result) {
			for (Post aPost : page) {
				
				if (aPost.getMessage() != null) {
					
					lista.addElement((new FacePost(aPost, counter)));
					counter++;
				}
				counterTotal++;
			}
		}
		
		return lista;
	}
	

	/**
	 * Creates an access token with an extended expired date with the use of the AppId and AppSecret.
	 * It uses the new token to create a new Facebook Client.
	 */
	
	public void useExtendedAccessToken(){
		//extendedAccessToken=fbClient.obtainExtendedAccessToken(AppID, AppSecret);
		AccessToken extendedAccessToken = fbClient.obtainExtendedAccessToken("255508025109783","97c2eea96f770959e83591baa238ab01");
		accessToken=extendedAccessToken.getAccessToken();
		fbClient = new DefaultFacebookClient(accessToken);
		System.out.println("ExtendedAccessToken: " + extendedAccessToken.getAccessToken());
		System.out.println("Expires: " + extendedAccessToken.getExpires());
	}
	

	

	
	public ArrayList<FacePost> PostsList(){
		Connection<Post> result = fbClient.fetchConnection("me/feed", Post.class);
		int counter = 0;
		int counterTotal = 0;
		ArrayList<FacePost> lista= new ArrayList<FacePost>();
		for (List<Post> page : result) {
			for (Post aPost : page) {
				// Filters only posts that contain the word "ISCTE"
				if (aPost.getMessage() != null /*&& aPost.getMessage().contains("ISCTE")*/) {
					lista.add((new FacePost(aPost, counter)));
					counter++;
				}
				counterTotal++;
			}
		}
		return lista;
	}
	
	
	public  static boolean isFacebookOnline(){
		try {
			
		Socket socket=new Socket();
		int port = 80;
        InetSocketAddress socketAddress = new InetSocketAddress("facebook.com", port);
		socket.connect(socketAddress, 3000);
		return true;
		} catch (IOException e) {
			
			return false;
			
		}
		
		}

        	public static void BackupFPosts(ArrayList<FacePost> list1){
        		
        		try {
    				
        			File file = new File("config.xml");
        			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        			DocumentBuilder dBuilder;
        			dBuilder = dbFactory.newDocumentBuilder();
        			Document doc = dBuilder.parse(file);
        			Element root=doc.getDocumentElement();
        			
        				NodeList list = doc.getChildNodes().item(0).getChildNodes();
        				for (int count = 0; count < list.getLength(); count++) {

        					Node tempNode = list.item(count);
        					if(tempNode.getNodeName().equals("Facebook")){
        						System.out.println("found");
        						tempNode.getParentNode().removeChild(tempNode);
        					}
        				}
        				
        				Element mail=doc.createElement("Facebook");
        				root.appendChild(mail);
        				
        				for(FacePost e:list1){
        					Element email=doc.createElement("Post");
        					email.setAttribute("Id", String.valueOf(e.getId()));
        					email.setAttribute("Message", e.getMessage());
        					email.setAttribute("Story", e.getStory());
        					email.setAttribute("Date", String.valueOf(e.getDate().getTime()));
        					mail.appendChild(email);
        				}
        			
        			 Transformer transformer = TransformerFactory.newInstance().newTransformer();
        	         transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        	         StreamResult result = new StreamResult(new FileOutputStream("config.xml"));
        	         DOMSource source = new DOMSource(doc);
        	         transformer.transform(source, result);
        	         System.out.println("Backup");
        			
        			
        			
        			
        		
        		} catch (ParserConfigurationException | SAXException | IOException | TransformerFactoryConfigurationError | TransformerException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			}
	}
        	
        	
        	public static DefaultListModel<FacePost> FetchFromBackup(){
        		
        		DefaultListModel<FacePost> posts = new DefaultListModel<FacePost>();
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
        				
        				if(tempNode.getNodeName().equals("Facebook")){
        					
        					NodeList elist=tempNode.getChildNodes();
        					for(int i=0; i<elist.getLength(); i++){
        						Node m=elist.item(i);
        						
        						if (m.getNodeType() == Node.ELEMENT_NODE && m.getNodeName().equals("Post")) {
        						posts.addElement(new FacePost(((Element) m).getAttribute("Id"), ((Element) m).getAttribute("Message"), ((Element) m).getAttribute("Story"), ((Element) m).getAttribute("Date")));
        					}
        					}
        					
        				}
        				
        			}

        		} catch (ParserConfigurationException | SAXException | IOException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        		return posts;
        	}
	
}
