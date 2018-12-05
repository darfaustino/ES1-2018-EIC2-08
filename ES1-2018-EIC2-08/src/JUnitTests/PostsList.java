package JUnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;

import BDA.FacePost;
import BDA.Facebook;

public class PostsList {

	private Facebook fb;
	private String accessToken;
	
	@Before
	public void setUp() throws Exception {
		accessToken="EAADoYhkS7RcBAEKHnrBd4T60iYQZCm1jfrK4xpq1quSDLCcQW7tAOXIw5TiK26A1MVZBTCV2jcijb8"
				+ "cdV1BtMuSZCOBdYRcDAMINHo7j4ws6F76RZC1uWuK18sZAZAZCSl99RXPJERm8okjSfMptfZCUKCc40KjUeEdtMi0a23ZCFJQZDZD";
		fb=new Facebook(accessToken);
	}
	
	@Test
	public void test() {

		ArrayList<FacePost> test=fb.PostsList();
		assertFalse(test.isEmpty());
		
	}

}
