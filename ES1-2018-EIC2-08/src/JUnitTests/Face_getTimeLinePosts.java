package JUnitTests;

import static org.junit.Assert.*;

import java.util.List;

import javax.swing.DefaultListModel;

import org.junit.Before;
import org.junit.Test;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Post;

import BDA.FacePost;

public class Face_getTimeLinePosts {

	private FacebookClient fbClient;
	private String accessToken;
	
	@Before
	public void setUp() throws Exception {
		accessToken="EAADoYhkS7RcBAEKHnrBd4T60iYQZCm1jfrK4xpq1quSDLCcQW7tAOXIw5TiK26A1MVZBTCV2jcijb8"
				+ "cdV1BtMuSZCOBdYRcDAMINHo7j4ws6F76RZC1uWuK18sZAZAZCSl99RXPJERm8okjSfMptfZCUKCc40KjUeEdtMi0a23ZCFJQZDZD";
		fbClient=new DefaultFacebookClient(accessToken);
	}

	@Test
	public void getTimeLinePosts(){
		Connection<Post> result = fbClient.fetchConnection("me/feed", Post.class);
		assertNotNull( result);
		
		System.out.println("\nPosts:");
		int counter = 0;
		int counterTotal = 0;
		DefaultListModel<FacePost> lista= new DefaultListModel<FacePost>();
		assertNotNull(lista);
		for (List<Post> page : result) {
			assertNotNull( page);
			for (Post aPost : page) {
				// Filters only posts that contain the word "ISCTE"
				if (aPost.getMessage() != null /*&& aPost.getMessage().contains("ISCTE")*/) {
					assertNotNull( aPost.getMessage());
					//assertTrue(aPost.getMessage().contains("ISCTE"));
					
					System.out.println("---- Post " + counter + " ----");
					System.out.println("Id: " + "fb.com/" + aPost.getId());
					System.out.println("Message: " + aPost.getMessage());
					System.out.println("Created: " + aPost.getCreatedTime());
					System.out.println("From: " + aPost.getStory());
					lista.addElement((new FacePost(aPost, counter)));
					assertNotNull(lista.elementAt(counter));
					counter++;
				}
				counterTotal++;
			}
		}
		System.out.println("-------------\nNº of Results: " + counter + "/" + counterTotal);	
	}

}
