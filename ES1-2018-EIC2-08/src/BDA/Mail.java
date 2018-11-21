package BDA;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.swing.DefaultListModel;

/**
 * 
 * This class displays the mails of a given ISCTE email account.
 *
 */

public class Mail {
	

	/**
	 * It creates a store with the email account, fetches and prints 20 mails of the inbox.
	 * Closes the store and the inbox.
	 */
	public static DefaultListModel<Email> LoginMail() {
		try {
		
		String username="darfo@iscte-iul.pt";
		String password= "EngenhariaSoftware98";
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
	      DefaultListModel<Email> emails=new DefaultListModel<Email>();
	      
	      for(Email e: order){
	    		  emails.addElement(e);
	    		 
	      }
	     
	      //close the store and folder objects
	     // emailFolder.close(false);
	      //store.close();
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
	 * It retrieves the text from a given Message.
	 * @param message Message to get the text from.
	 * @return the Message's text.
	 * @throws MessagingException error with the Message.
	 * @throws IOException error reading the Message.
	 */
	public static String getTextFromMessage(Message message) throws MessagingException, IOException {
	    String result = "";
	    if (message.isMimeType("text/plain")) {
	        result = message.getContent().toString();
	    } else if (message.isMimeType("multipart/*")) {
	        MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
	        result = getTextFromMimeMultipart(mimeMultipart);
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
	

}
