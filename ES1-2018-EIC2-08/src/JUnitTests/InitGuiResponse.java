package JUnitTests;

import static org.junit.Assert.*;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import org.junit.Test;

import BDA.Email;

import BDA.GuiResponse;
import BDA.Mail;

public class InitGuiResponse {

	@Test
	public void test() {
		String email="darfo@iscte-iul.pt";
		String pass="EngenhariaSoftware98";
		DefaultListModel<Email> mail=Mail.LoginMail(email, pass);
		JFrame frame=new JFrame();
		frame.setVisible(true);
		GuiResponse response=new GuiResponse(email,pass,frame, mail.getElementAt(0));
		int width=response.getLauncher().getWidth();
		int height=response.getLauncher().getHeight();
		boolean isVisible= response.getLauncher().isVisible();
		assertTrue(width>=800);
		assertTrue(height>=600);
		assertEquals(true, isVisible);
	}

}
