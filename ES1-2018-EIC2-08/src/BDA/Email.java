package BDA;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;

public class Email implements Comparable<Email>{

	private Message msm;
	private String subject;
	private String from;
	private String body;
	private Date timestamp;
	
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
	
	public Date getTimestamp() {
		return timestamp;
	}

	


	public Message getMsm() {
		return msm;
	}

	public String getSubject() {
		return subject;
	}

	public String getFrom() {
		return from;
	}

	
	
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
