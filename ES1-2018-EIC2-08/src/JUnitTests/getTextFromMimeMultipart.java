package JUnitTests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.junit.Test;

import BDA.Mail;

public class getTextFromMimeMultipart {

	@Test
	public void test() {
		try {
		String s="This is the message";
		MimeMultipart m=new MimeMultipart();
		BodyPart messageBodyPart=new MimeBodyPart();
		messageBodyPart.setText(s);
		m.addBodyPart(messageBodyPart);
		String text=Mail.getTextFromMimeMultipart(m);
		assertEquals(s.trim(), text.trim());
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
