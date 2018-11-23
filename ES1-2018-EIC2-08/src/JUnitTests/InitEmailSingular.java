package JUnitTests;

import static org.junit.Assert.*;

import javax.mail.Message;
import javax.swing.DefaultListModel;

import org.junit.Test;

import BDA.Email;
import BDA.EmailSingular;
import BDA.Mail;

public class InitEmailSingular {

	@Test
	public void test() {
		String email="darfo@iscte-iul.pt";
		String pass="EngenhariaSoftware98";
		DefaultListModel<Email> mail=Mail.LoginMail(email, pass);
		EmailSingular emailsingular=new EmailSingular(mail.getElementAt(0));
		int width=emailsingular.getLauncher().getWidth();
		int height=emailsingular.getLauncher().getHeight();
		boolean isVisible= emailsingular.getLauncher().isVisible();
		assertTrue(width>=800);
		assertTrue(height>=600);
		assertEquals(true, isVisible);
		
		
	}

}
