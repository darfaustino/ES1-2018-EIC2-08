package JUnitTests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.User;

public class Facebook_test {
	private FacebookClient fbClient;
	private String accessToken;
	
	@Before
	public void setUp() throws Exception {
		accessToken="EAADoYhkS7RcBAEKHnrBd4T60iYQZCm1jfrK4xpq1quSDLCcQW7tAOXIw5TiK26A1MVZBTCV2jcijb8"
				+ "cdV1BtMuSZCOBdYRcDAMINHo7j4ws6F76RZC1uWuK18sZAZAZCSl99RXPJERm8okjSfMptfZCUKCc40KjUeEdtMi0a23ZCFJQZDZD";
		fbClient=new DefaultFacebookClient(accessToken);
	}

	@Test
	public void testUseExtendedAccessToken() {
		AccessToken extendedAccessToken = fbClient.obtainExtendedAccessToken("255508025109783","97c2eea96f770959e83591baa238ab01");
		assertNotNull(extendedAccessToken);
		
		accessToken=extendedAccessToken.getAccessToken();
		assertEquals(accessToken, extendedAccessToken.getAccessToken());
		
		fbClient = new DefaultFacebookClient(accessToken);
		assertNotNull( fbClient);
		
		System.out.println("ExtendedAccessToken: " + extendedAccessToken.getAccessToken());
		System.out.println("Expires: " + extendedAccessToken.getExpires());
	}
	
	@Test
	public void testGetLikedPages() {
		Connection<Page> result = fbClient.fetchConnection("me/likes", Page.class);
		assertNotNull( result);
		
		System.out.println("\nPosts:");
		int counter = 0;
		for (List<Page> feedPage : result) {
			assertNotNull( feedPage);
			
			for (Page page : feedPage) {
				assertNotNull( page);
				
				System.out.println("---- Page " + counter + " ----");
				System.out.println("Name: "+ page.getName());
				System.out.println("Id: " + "fb.com/" + page.getId());
				System.out.println("Number of Likes: " + page.getLikesCount());
				counter++;	
			}
		}
		System.out.println("-------------\nNº of Results: " + counter);
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
	
	@Test
	public void testGetTimeLinePosts() {
		Connection<Post> result = fbClient.fetchConnection("me/feed", Post.class);
		assertNotNull( result);
		
		System.out.println("\nPosts:");
		int counter = 0;
		int counterTotal = 0;
		for (List<Post> page : result) {
			assertNotNull( page);
			for (Post aPost : page) {
				// Filters only posts that contain the word "esta"
				if (aPost.getMessage() != null && aPost.getMessage().contains("esta")) {
					assertNotNull( aPost.getMessage());
					assertTrue(aPost.getMessage().contains("esta"));
					
					
					System.out.println("---- Post " + counter + " ----");
					System.out.println("Id: " + "fb.com/" + aPost.getId());
					System.out.println("Message: " + aPost.getMessage());
					System.out.println("Created: " + aPost.getCreatedTime());
					counter++;
				}
				counterTotal++;
			}
		}
		System.out.println("-------------\nNº of Results: " + counter + "/" + counterTotal);
	}

}
