package BDA;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.DefaultListModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
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

/**
 * 
 * This class implements different Email functions.
 *
 */

public class Mail {
	
	
	
	
	
	/**
	 * It logins a OutLook email account, fetches and saves the most recent 20 emails of the inbox.
	 * @param password Account password
	 * @param username Account email
	 * @return  the 20 most recent emails in a DefaultListModel.
	 *
	 */
	public static DefaultListModel<Email> LoginMail(String username, String password) {
		try {
	
        String host = "outlook.office365.com";

        Properties props = new Properties();
        props.put("mail.imap.host", host);
        props.put("mail.imap.user", username);
        props.put("mail.imap.port", 993);
        props.put("mail.debug", "true");
        props.put("mail.imap.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.imap.socketFactory.fallback", "false");
        props.put("mail.imap.socketFactory.port", "993");
        Session session = Session.getInstance(props);
        Store store = session.getStore("imap");
        store.connect(host, 993, username, password);
        
	      //create the folder object and open it
	      Folder emailFolder = store.getFolder("INBOX");
	      emailFolder.open(Folder.READ_ONLY);

	      // retrieve the messages from the folder in an array and print it
	      Message[] messages = emailFolder.getMessages((emailFolder.getMessageCount()-20),(emailFolder.getMessageCount()));
	      
	      ArrayList<Email> order=new ArrayList<Email>();
	      
	      for(Message m: messages){
	    	  if(m.getFrom()[0].toString().contains("iscte")){
	    	  order.add(new Email(m));
	    	  }
	    	 
	      }
	      
	      Collections.sort(order);
	      BackupMail(order);
	      DefaultListModel<Email> emails=new DefaultListModel<Email>();
	      
	      for(Email e: order){
	    		  emails.addElement(e);
	    		 
	      }
	
	      return emails;

	      } catch (NoSuchProviderException e) {
	         e.printStackTrace();
	      } catch (MessagingException e) {
	         e.printStackTrace();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		return null;
		
	      }
	
		/**
		 * It responds to a given Message with a given Text via STMP. 
		 * @param message Message to respond to.
		 * @param text text to be sent.
		 */
	
		public static void SendMail(Message message, String text){
			
			 try {
			
			String username="darfo@iscte-iul.pt";
			String password= "EngenhariaSoftware98";
			  String host = "outlook.office365.com";

		        Properties props = new Properties();
		        
		        props.put("mail.debug", "true");
		        props.put("mail.smtp.auth", "true");
		        props.put("mail.smtp.starttls.enable", "true");
		        props.put("mail.smtp.host", host);
		        props.put("mail.smtp.port", "25");
		        Session session = Session.getInstance(props);
		        
		        Message replyMessage = new MimeMessage(session);
                replyMessage = (MimeMessage) message.reply(false);
                replyMessage.setFrom(new InternetAddress(InternetAddress.toString(message
           	         .getRecipients(Message.RecipientType.TO))));
                replyMessage.setText(text);
                replyMessage.setReplyTo(message.getReplyTo());
		        
			
			Transport t = session.getTransport("smtp");
            
 	     //connect to the smpt server using transport instance
	     //change the user and password accordingly	
           t.connect(username,password);
           t.sendMessage(replyMessage,
                  replyMessage.getAllRecipients());
           
            }catch (Exception e) {
				// TODO: handle exception
			}
		}
	
	
	
	
	/**
	 * It retrieves the text from a given Message.
	 * @param message Message to get the text from.
	 * @return the Message's text.
	 * @throws MessagingException error with the Message.
	 * @throws IOException error reading the Message.
	 */
	
		public static String getTextFromMessage(Message message) throws IOException, MessagingException {
		    String result = "";
		    if (message.isMimeType("text/*")) {
		        result = message.getContent().toString();
		    } else if (message.isMimeType("multipart/*")) {
		        MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
		        result = getTextFromMimeMultipart(mimeMultipart);
		    }else 
				if (message.isMimeType("multipart/alternative")) {
					// prefer html text over plain text
					Multipart mp = (Multipart) message.getContent();
					String text = null;
					for (int i = 0; i < mp.getCount(); i++) {
						Part bp = mp.getBodyPart(i);
						if (bp.isMimeType("text/plain")) {
							if (text == null)
								text = getText(bp);
							continue;
						} else if (bp.isMimeType("text/html")) {
							String s = getText(bp);
							if (s != null)
								return s;
						} else {
							return getTextFromMessage((Message)bp);
						}
					}
				}
					
		    return result;
		}
		
	
	/**
	 * It retrieves the text a a MimeMultipart.
	 * @param mimeMultipart MimeMultipart to get the text from.
	 * @return the MimeMultipart's text.
	 * @throws MessagingException error with the Message
	 * @throws IOException error reading the Message
	 */
	
	public static String getTextFromMimeMultipart(
	        MimeMultipart mimeMultipart)  throws MessagingException, IOException{
	    String result = "";
	    int count = mimeMultipart.getCount();
	    for (int i = 0; i < count; i++) {
	        BodyPart bodyPart = mimeMultipart.getBodyPart(i);
	        if (bodyPart.isMimeType("text/plain")) {
	            result = result + "\n" + bodyPart.getContent();
	            break; // without break same text appears twice in my tests
	        } else if (bodyPart.isMimeType("text/html")) {
	            String html = (String) bodyPart.getContent();
	            result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
	        } else if (bodyPart.getContent() instanceof MimeMultipart){
	            result = result + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
	        }
	    }
	    return result;
	}
	
	/**
	 * It retrieves the Message content inside a Part. 
	 * @param p Given Part
	 * @return The part's content
	 * @throws MessagingException Some Message exception occurred
	 * @throws IOException Some I/O Exception occurred
	 */
	
	public static String getText(Part p) throws MessagingException, IOException {
		if (p.isMimeType("text/*")) {
			String s = (String) p.getContent();
			// textIsHtml = p.isMimeType("text/html");
			return s;
		}

		if (p.isMimeType("multipart/alternative")) {
			// prefer html text over plain text
			Multipart mp = (Multipart) p.getContent();
			String text = null;
			for (int i = 0; i < mp.getCount(); i++) {
				Part bp = mp.getBodyPart(i);
				if (bp.isMimeType("text/plain")) {
					if (text == null)
						text = getText(bp);
					continue;
				} else if (bp.isMimeType("text/html")) {
					String s = getText(bp);
					if (s != null)
						return s;
				} else {
					return getText(bp);
				}
			}
			return text;
		} else if (p.isMimeType("multipart/*")) {
			Multipart mp = (Multipart) p.getContent();
			for (int i = 0; i < mp.getCount(); i++) {
				String s = getText(mp.getBodyPart(i));
				if (s != null)
					return s;
			}
		}

		return null;
	}
	
	public  static boolean isMailOnline(){
		try {
			
		Socket socket=new Socket();
		int port = 80;
        InetSocketAddress socketAddress = new InetSocketAddress("outlook.office365.com", port);
		socket.connect(socketAddress, 3000);
		return true;
		} catch (IOException e) {
			
			return false;
			
		}
	}
	
	
	private static void BackupMail(ArrayList<Email> list1){
	
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
					if(tempNode.getNodeName().equals("Mail")){
						System.out.println("found");
						tempNode.getParentNode().removeChild(tempNode);
					}
				}
				
				Element mail=doc.createElement("Mail");
				root.appendChild(mail);
				
				for(Email e:list1){
					Element email=doc.createElement("Email");
					email.setAttribute("Subject", e.getSubject());
					email.setAttribute("Body", e.getBody());
					email.setAttribute("From", e.getFrom());
					email.setAttribute("Date", String.valueOf(e.getTimestamp().getTime()));
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
	
	
	public static DefaultListModel<Email> FetchFromBackup(){
		
		DefaultListModel<Email> emails = new DefaultListModel<Email>();
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
				
				if(tempNode.getNodeName().equals("Mail")){
					
					NodeList elist=tempNode.getChildNodes();
					for(int i=0; i<elist.getLength(); i++){
						Node m=elist.item(i);
						
						if (m.getNodeType() == Node.ELEMENT_NODE && m.getNodeName().equals("Email")) {
						emails.addElement(new Email(((Element) m).getAttribute("Subject"), ((Element) m).getAttribute("From"), ((Element) m).getAttribute("Body"), ((Element) m).getAttribute("Date")));
					}
					}
					
				}
				
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emails;
	}
		

}
