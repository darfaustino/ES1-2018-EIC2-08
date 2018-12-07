package JUnitTests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Page;

public class Face_getLikedPages {

	private FacebookClient fbClient;
	private String accessToken;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		accessToken="EAADoYhkS7RcBAEKHnrBd4T60iYQZCm1jfrK4xpq1quSDLCcQW7tAOXIw5TiK26A1MVZBTCV2jcijb8"
				+ "cdV1BtMuSZCOBdYRcDAMINHo7j4ws6F76RZC1uWuK18sZAZAZCSl99RXPJERm8okjSfMptfZCUKCc40KjUeEdtMi0a23ZCFJQZDZD";
		fbClient=new DefaultFacebookClient(accessToken);
	}

	@Test
	public void testGetLikedPages() {
		Connection<Page> result = fbClient.fetchConnection("me/likes", Page.class);
		assertNotNull( result);
		
		
		for (List<Page> feedPage : result) {
			assertNotNull( feedPage);
			
			for (Page page : feedPage) {
				assertNotNull( page);
					
			}
		}
	}

}
