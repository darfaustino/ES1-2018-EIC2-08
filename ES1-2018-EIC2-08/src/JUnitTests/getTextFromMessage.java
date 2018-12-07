package JUnitTests;

import static org.junit.Assert.*;

import java.io.IOException;

import java.util.Properties;


import javax.mail.Message;
import javax.mail.MessagingException;

import javax.mail.Session;

import javax.mail.internet.MimeMessage;

import org.junit.Test;

import BDA.Mail;

public class getTextFromMessage {

	@Test
	public void test() {
		String s="This is the message";
		Properties properties = new Properties();
	      properties.put("mail.pop3.host","pop.gmail.com");
	      properties.put("mail.pop3.port", "995");
	      properties.put("mail.pop3.starttls.enable", "true");
	      Session emailSession = Session.getDefaultInstance(properties);
		Message message=new MimeMessage(emailSession); 
		try {
			message.setText(s);
			String test=Mail.getTextFromMessage(message);
			assertEquals("This is the message", test);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
