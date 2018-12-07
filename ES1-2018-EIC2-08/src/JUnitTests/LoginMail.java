package JUnitTests;

import static org.junit.Assert.*;



import javax.swing.DefaultListModel;

import org.junit.Test;

import BDA.Email;
import BDA.Mail;

public class LoginMail {

	@Test
	public void test() {
		
		String email="darfo@iscte-iul.pt";
		String pass="EngenhariaSoftware98";
		
		DefaultListModel<Email> mail=Mail.LoginMail(email, pass);
		assertTrue(mail.size()>0);
		
	}

}
