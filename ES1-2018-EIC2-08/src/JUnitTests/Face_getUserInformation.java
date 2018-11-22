package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;

public class Face_getUserInformation {

	private FacebookClient fbClient;
	private String accessToken;
	
	@Before
	public void setUp() throws Exception {
		accessToken="EAADoYhkS7RcBAEKHnrBd4T60iYQZCm1jfrK4xpq1quSDLCcQW7tAOXIw5TiK26A1MVZBTCV2jcijb8"
				+ "cdV1BtMuSZCOBdYRcDAMINHo7j4ws6F76RZC1uWuK18sZAZAZCSl99RXPJERm8okjSfMptfZCUKCc40KjUeEdtMi0a23ZCFJQZDZD";
		fbClient=new DefaultFacebookClient(accessToken);
	}

	@Test
	public void testGetUserInformation() {
		User me = fbClient.fetchObject("me", User.class);
		assertNotNull( me);
		
		System.out.println("Facebook:");
		System.out.println("Id: " + me.getId());
		System.out.println("Name: " + me.getName());
		System.out.println("Email: " + me.getEmail());
		System.out.println("Home town: " + me.getHometownName());
		//...me.get...
	}

}
