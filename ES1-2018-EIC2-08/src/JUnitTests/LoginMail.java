package JUnitTests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import BDA.Mail;

public class LoginMail {

	@Test
	public void test() {
		
		String email="darfo@iscte-iul.pt";
		ByteArrayOutputStream sink = new ByteArrayOutputStream();
		System.setOut(new PrintStream(sink, true));
		Mail.LoginMail();
		String emails=new String(sink.toByteArray());
		assertTrue(emails.contains(email));
	}

}
