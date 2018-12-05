package JUnitTests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.junit.Test;

import BDA.Facebook;

public class isFacebookOnline {

	@Test
	public void test() {
		
		boolean face=Facebook.isFacebookOnline();
		
		
		try {
			
			Socket socket=new Socket();
			int port = 80;
	        InetSocketAddress socketAddress = new InetSocketAddress("facebook.com", port);
			socket.connect(socketAddress, 3000);
			assertTrue(face);
			} catch (IOException e) {
				
				assertFalse(face);
				
			}
		
	}

}
