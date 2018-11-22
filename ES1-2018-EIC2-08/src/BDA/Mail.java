package BDA;
import java.io.IOException;
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
	
		public static void SendMail(Message message, String text){
			
			 try {
			
			String username="darfo@iscte-iul.pt";
			String password= "EngenhariaSoftware98";
			  String host = "outlook.office365.com";

		        Properties props = new Properties();
		        props.put("mail.imap.host", host);
		        props.put("mail.imap.port", "993");
		        props.put("mail.debug", "true");
		        props.put("mail.imap.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		        props.put("mail.imap.socketFactory.fallback", "false");
		        props.put("mail.imap.socketFactory.port", "993");
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
		/*
	public static String getTextFromMessage(Message message) throws MessagingException, IOException {
	    String result = "";
	    if (message.isMimeType("text/plain")) {
	        result = message.getContent().toString();
	    } else if (message.isMimeType("multipart/*")) {
	        MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
	        result = getTextFromMimeMultipart(mimeMultipart);
	    }
	    return result;
	}*/
	
	/**
	 * It retrieves the text a a MimeMultipart.
	 * @param mimeMultipart MimeMultipart to get the text from.
	 * @return the MimeMultipart's text.
	 * @throws MessagingException error with the Message
	 * @throws IOException error reading the Message
	 */
	
/*
	
	
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
	
	public static String getText(Part p) throws MessagingException, IOException {
		if (p.isMimeType("text/*")) {
			String s = (String) p.getContent();
			//textIsHtml = p.isMimeType("text/html");
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
}*/
		
		public static String getTextFromMessage(Message message) throws IOException, MessagingException {
		    String result = "";
		    if (message.isMimeType("text/plain")) {
		        result = message.getContent().toString();
		    } else if (message.isMimeType("multipart/*")) {
		        MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
		        result = getTextFromMimeMultipart(mimeMultipart);
		    }
		    return result;
		}

		private static String getTextFromMimeMultipart(
		        MimeMultipart mimeMultipart) throws IOException, MessagingException {

		    int count = mimeMultipart.getCount();
		    if (count == 0)
		        throw new MessagingException("Multipart with no body parts not supported.");
		    boolean multipartAlt = new ContentType(mimeMultipart.getContentType()).match("multipart/alternative");
		    if (multipartAlt)
		        // alternatives appear in an order of increasing 
		        // faithfulness to the original content. Customize as req'd.
		        return getTextFromBodyPart(mimeMultipart.getBodyPart(count - 1));
		    String result = "";
		    for (int i = 0; i < count; i++) {
		        BodyPart bodyPart = mimeMultipart.getBodyPart(i);
		        result += getTextFromBodyPart(bodyPart);
		    }
		    return result;
		}

		private static String getTextFromBodyPart(
		        BodyPart bodyPart) throws IOException, MessagingException {

		    String result = "";
		    if (bodyPart.isMimeType("text/plain")) {
		        result = (String) bodyPart.getContent();
		    } else if (bodyPart.isMimeType("text/html")) {
		        String html = (String) bodyPart.getContent();
		        result = org.jsoup.Jsoup.parse(html).text();
		    } else if (bodyPart.getContent() instanceof MimeMultipart){
		        result = getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
		    }
		    return result;
		}
}
