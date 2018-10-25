package Projeto;
import java.io.IOException;
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

public class Mail {
	

	public static void main(String[] args) {
		LoginMail();
	}

	public static  void LoginMail() {
		try {
		String host="pop.gmail.com";
		String mailstore="pop3";
		String username="insertmail@gmail.com";
		String password= "Insert pass";
		
//		Properties props=new Properties();
//		props.setProperty("mail.imaps.host", "imap.gmail.com");
//	    props.setProperty("mail.imaps.user", username);
//	    props.setProperty("mail.imaps.password", password);
//	    props.setProperty("mail.imaps.port", "993");
//	    props.setProperty("mail.imaps.auth", "true");
//	 //   props.setProperty("mail.debug", "true");
//	     Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//	    	    protected PasswordAuthentication getPasswordAuthentication() {
//	    	        return new PasswordAuthentication(username, password);
//	    	    }
//	    	});
//	     
//	     Store store;
//		
//			store = session.getStore("imaps");
//			store.connect();
//
//		      //create the folder object and open it
//		      Folder emailFolder = store.getFolder("INBOX");
//		      emailFolder.open(Folder.READ_ONLY);
//
//		      // retrieve the messages from the folder in an array and print it
//		      Message[] messages = emailFolder.getMessages();
//		      System.out.println("messages.length---" + messages.length);
//
//		      for (int i = 0, n = messages.length; i < n; i++) {
//		         Message message = messages[i];
//		         System.out.println("---------------------------------");
//		         System.out.println("Email Number " + (i + 1));
//		         System.out.println("Subject: " + message.getSubject());
//		         System.out.println("From: " + message.getFrom()[0]);
//		         System.out.println("Text: " + message.getContent().toString());
//
//		      }
//
//		      //close the store and folder objects
//		      emailFolder.close(false);
//		      store.close();
//		} catch (NoSuchProviderException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	     

		Properties properties = new Properties();

	      properties.put("mail.pop3.host", host);
	      properties.put("mail.pop3.port", "995");
	      properties.put("mail.pop3.starttls.enable", "true");
	      Session emailSession = Session.getDefaultInstance(properties);
	  
	      //create the POP3 store object and connect with the pop server
	      Store store = emailSession.getStore("pop3s");

	      store.connect(host, username, password);

	      //create the folder object and open it
	      Folder emailFolder = store.getFolder("INBOX");
	      emailFolder.open(Folder.READ_ONLY);

	      // retrieve the messages from the folder in an array and print it
	      Message[] messages = emailFolder.getMessages();
	      System.out.println("messages.length---" + messages.length);

	      for (int i = 0, n = 10; i < n; i++) {
	         Message message = messages[i];
	         System.out.println(username);
	         System.out.println("---------------------------------");
	         System.out.println("Email Number " + (i + 1));
	         System.out.println("Subject: " + message.getSubject());
	         System.out.println("From: " + message.getFrom()[0]);
	         System.out.println("Text: " + getTextFromMessage( message));

	      }

	      //close the store and folder objects
	      emailFolder.close(false);
	      store.close();

	      } catch (NoSuchProviderException e) {
	         e.printStackTrace();
	      } catch (MessagingException e) {
	         e.printStackTrace();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
	      }
	
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
