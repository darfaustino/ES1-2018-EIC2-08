package BDA;

import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;

public class Email {

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

	@Override
	public String toString() {
		
			return "Email: "+ subject +"From: "+ from;
		
		
	}
	
	
	
	
	
	
}
