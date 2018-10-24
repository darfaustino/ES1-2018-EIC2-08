package Projeto;
import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.User;

public class Facebook {
	//AppID-255508025109783
	//AppSecret-97c2eea96f770959e83591baa238ab01
	String accessToken="EAADoYhkS7RcBAEKHnrBd4T60iYQZCm1jfrK4xpq1quSDLCcQW7tAOXIw5TiK26A1MVZBTCV2jcijb8"
			+ "cdV1BtMuSZCOBdYRcDAMINHo7j4ws6F76RZC1uWuK18sZAZAZCSl99RXPJERm8okjSfMptfZCUKCc40KjUeEdtMi0a23ZCFJQZDZD"; //expira 21/12/2018
	
	FacebookClient fbClient = new DefaultFacebookClient(accessToken);

	public Facebook(){	}
	
	public void getTimeLinePosts(){
		Connection<Post> result = fbClient.fetchConnection("me/feed", Post.class);
		System.out.println("\nPosts:");
		int counter = 0;
		int counterTotal = 0;
		for (List<Post> page : result) {
			for (Post aPost : page) {
				// Filters only posts that contain the word "esta"
				if (aPost.getMessage() != null && aPost.getMessage().contains("esta")) {
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
	
	public void getHomePosts(){
		Connection<Post> result = fbClient.fetchConnection("me/home", Post.class);
		System.out.println("\nPosts:");
		int counter = 0;
		int counterTotal = 0;
		for (List<Post> page : result) {
			for (Post aPost : page) {
				// Filters only posts that contain the word "big"
				if (aPost.getMessage() != null && aPost.getMessage().contains("big")) {
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
	
	public void getExtendedAccessToken(){
		//extendedAccessToken=fbClient.obtainExtendedAccessToken(AppID, AppSecret);
		AccessToken extendedAccessToken = fbClient.obtainExtendedAccessToken("255508025109783","97c2eea96f770959e83591baa238ab01");
		System.out.println("ExtendedAccessToken: " + extendedAccessToken.getAccessToken());
		System.out.println("Expires: " + extendedAccessToken.getExpires());
	}
	
	public void getUserInformation(){
		User me = fbClient.fetchObject("me", User.class);
		System.out.println("Facebook:");
		System.out.println("Id: " + me.getId());
		System.out.println("Name: " + me.getName());
		//...me.get...
	}
	
	public void getLikedPages() {
		Connection<Page> result = fbClient.fetchConnection("me/likes", Page.class);
		System.out.println("\nPosts:");
		int counter = 0;
		int counterTotal = 0;
		for (List<Page> feedPage : result) {
			for (Page page : feedPage) {
				// Filters only posts that contain the word "big"
				//if (aPost.getMessage() != null && aPost.getMessage().contains("big")) {
					System.out.println("---- Page " + counter + " ----");
					System.out.println("Name: "+ page.getName());
					System.out.println("Id: " + "fb.com/" + page.getId());
					System.out.println("Number of Likes: " + page.getLikesCount());
					counter++;
				//}
				counterTotal++;
			}
		}
		System.out.println("-------------\nNº of Results: " + counter + "/" + counterTotal);
		
	}
	
	public void createPostTimeLine(String s) {
		FacebookType post= fbClient.publish("me/feed", FacebookType.class, Parameter.with("message", s));
		System.out.println("fb.com/"+post.getId());
	}
	public static void main(String[] args) {
		Facebook fb=new Facebook();
		fb.getExtendedAccessToken();
		fb.getTimeLinePosts();
		fb.getUserInformation();	
		fb.getHomePosts();
		fb.getLikedPages();
		fb.createPostTimeLine("ES1 teste");
	}

	
	
}
