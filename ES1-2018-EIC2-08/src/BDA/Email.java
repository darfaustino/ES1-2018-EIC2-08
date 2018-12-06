package BDA;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;

/**
 * 
 * @author Diogo
 *
 *Class that represents the object Email in the App
 *
 *
 */


public class Email implements Comparable<Email>{

	private Message msm;
	private String subject;
	String from;
	String body;
	Date timestamp;
	
	/**
	 * Constructor, receives a Message as a parameter and copies the message subject, body and whom is from.
	 * It creates the object Email.  
	 * @param msm Message received.
	 * @throws MessagingException It founds a problem in the Message
	 * @throws UnsupportedEncodingException It can´t decode the Message.getFrom().
	 * @throws IOException  I/O exception of some sort has occurred.
	 */
	
	public Email(Message msm) {
		try {
			this.msm = msm;
			subject=msm.getSubject();
			from= MimeUtility.decodeText(msm.getFrom()[0].toString());
			body=Mail.getTextFromMessage(this.msm);
			this.timestamp = msm.getReceivedDate();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Email(String subject, String from, String body, String date) {
		// TODO Auto-generated constructor stub
		this.subject=subject;
		this.from=from;
		this.body=body;
		this.timestamp=new Date(Long.parseLong(date));
		
	}

	/**
	 * Gets the Timestamp of the Email.
	 * @return timestamp
	 */
	
	public Date getTimestamp() {
		return timestamp;
	}

	
	/**
	 * Gets the original Message from the Email.
	 * @return the Message in the Email.
	 */

	public Message getMsm() {
		return msm;
	}
	
	/**
	 * Gets the Subject of the Email
	 * @return the subject of the Email
	 */

	public String getSubject() {
		return subject;
	}

	
	/**
	 * Gets address of the Email
	 * @return the address of the Email
	 */
	public String getFrom() {
		return from;
	}

	
	/**
	 * Gets the body content of the Email
	 * @return the mail body.
	 */
	public String getBody() {
		return body;
	}

	
	@Override
	public String toString() {
		return "<html> Email: "+ subject +"<br/>From: "+ from+ "<br/>Date:"+timestamp;
	}
	

	@Override
	public int compareTo(Email o) {
		// TODO Auto-generated method stub
		return o.getTimestamp().compareTo(getTimestamp());
	}
	
	
	
	
	
	
}
