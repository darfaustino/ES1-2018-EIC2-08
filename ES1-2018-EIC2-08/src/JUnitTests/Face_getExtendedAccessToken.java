package JUnitTests;

import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.Test;


import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;


public class Face_getExtendedAccessToken {
	private FacebookClient fbClient;
	private String accessToken;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		accessToken="EAADoYhkS7RcBAEKHnrBd4T60iYQZCm1jfrK4xpq1quSDLCcQW7tAOXIw5TiK26A1MVZBTCV2jcijb8"
				+ "cdV1BtMuSZCOBdYRcDAMINHo7j4ws6F76RZC1uWuK18sZAZAZCSl99RXPJERm8okjSfMptfZCUKCc40KjUeEdtMi0a23ZCFJQZDZD";
		fbClient=new DefaultFacebookClient(accessToken);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testUseExtendedAccessToken() {
		AccessToken extendedAccessToken = fbClient.obtainExtendedAccessToken("255508025109783","97c2eea96f770959e83591baa238ab01");
		assertNotNull(extendedAccessToken);
		
		accessToken=extendedAccessToken.getAccessToken();
		assertEquals(accessToken, extendedAccessToken.getAccessToken());
		
		fbClient = new DefaultFacebookClient(accessToken);
		assertNotNull( fbClient);
	}

}
