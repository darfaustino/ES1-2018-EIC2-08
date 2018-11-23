package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;

import BDA.Facebook;
import BDA.FacebookTimeline;

public class FaceTimeline_getFacebook {

	private Facebook face;	
	
	@Before
	public void setUp() throws Exception {
		String accessToken="EAADoYhkS7RcBAEKHnrBd4T60iYQZCm1jfrK4xpq1quSDLCcQW7tAOXIw5TiK26A1MVZBTCV2jcijb8"
				+ "cdV1BtMuSZCOBdYRcDAMINHo7j4ws6F76RZC1uWuK18sZAZAZCSl99RXPJERm8okjSfMptfZCUKCc40KjUeEdtMi0a23ZCFJQZDZD";
		face=new Facebook(accessToken);
	}

	@Test
	public void init() {
		FacebookTimeline f = new FacebookTimeline(face);
		assertNotNull(f);
		assertEquals(face, f.getFacebook());
	}

}
