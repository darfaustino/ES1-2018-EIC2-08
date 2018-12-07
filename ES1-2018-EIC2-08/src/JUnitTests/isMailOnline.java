package JUnitTests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.junit.Test;

import BDA.Mail;

public class isMailOnline {

	@Test
	public void test() {
		
		boolean mail=Mail.isMailOnline();
		
		try {
			
			@SuppressWarnings("resource")
			Socket socket=new Socket();
			int port = 80;
	        InetSocketAddress socketAddress = new InetSocketAddress("outlook.office365.com", port);
			socket.connect(socketAddress, 3000);
			assertTrue(mail);
			} catch (IOException e) {
				
				assertFalse(mail);
				
			}
		
	}

}
