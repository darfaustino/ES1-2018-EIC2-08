package BDA;

import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;

public class Email implements Comparable<Email>{

	private Message msm;
	private String subject;
	private String from;
	private Date timestamp;
	
	public Email(Message msm) {
		try {
			this.msm = msm;
			subject=msm.getSubject();
			from=msm.getFrom()[0].toString();
			this.timestamp = msm.getReceivedDate();
		} catch (MessagingException e) {
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
