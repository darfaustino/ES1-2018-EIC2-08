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
	
	/** 
	 * Facebook App.
	 *
	 */
	
	//AppID-255508025109783
	//AppSecret-97c2eea96f770959e83591baa238ab01
	String accessToken;
	FacebookClient fbClient;

	/**
	 * Constructor, it initializes both attributes: the access token and the Facebook Client.
	 */
	
	public Facebook(){
		accessToken="EAADoYhkS7RcBAEKHnrBd4T60iYQZCm1jfrK4xpq1quSDLCcQW7tAOXIw5TiK26A1MVZBTCV2jcijb8"
				+ "cdV1BtMuSZCOBdYRcDAMINHo7j4ws6F76RZC1uWuK18sZAZAZCSl99RXPJERm8okjSfMptfZCUKCc40KjUeEdtMi0a23ZCFJQZDZD"; //expira 21/12/2018
		fbClient = new DefaultFacebookClient(accessToken);
	}
	
	/**
	 * Connects the Facebook Client with the posts of the user's time line.
	 * Scrolls through all the posts of all the pages of the user's time line.
	 * Filters the posts: they must have something written and have the word "esta" also written there.
	 * Counts each post and filtered post.
	 * Prints the number, id, time when it was created and message of each filtered post.
	 * Prints the number of filtered and total number of posts covered.
	 */
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
	
	/**
	 * Scrolls through all the posts of all the pages of the user's home.
	 * Filters the posts: they must have something written and have the word "big" also written there.
	 * Counts each post and filtered post.
	 * Prints the number, id, time when it was created and message of each filtered post.
	 * Prints the number of filtered and total number of posts covered.
	 */
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
	
	/**
	 * Creates an access token with an extended expired date with the use of the AppId and AppSecret.
	 */
	
	public void getExtendedAccessToken(){
		//extendedAccessToken=fbClient.obtainExtendedAccessToken(AppID, AppSecret);
		AccessToken extendedAccessToken = fbClient.obtainExtendedAccessToken("255508025109783","97c2eea96f770959e83591baa238ab01");
		System.out.println("ExtendedAccessToken: " + extendedAccessToken.getAccessToken());
		System.out.println("Expires: " + extendedAccessToken.getExpires());
	}
	
	/**
	 * Prints the user's id, name, email and home town.
	 */
	
	public void getUserInformation(){
		User me = fbClient.fetchObject("me", User.class);
		System.out.println("Facebook:");
		System.out.println("Id: " + me.getId());
		System.out.println("Name: " + me.getName());
		System.out.println("Email: " + me.getEmail());
		System.out.println("Home town: " + me.getHometownName());
		//...me.get...
		
	}
	
	/**
	 * Scrolls through all the pages the user likes.
	 * Counts each page.
	 * Prints the number, id and number of likes of each page.
	 * Prints the total number of pages covered.
	 */
	
	public void getLikedPages() {
		Connection<Page> result = fbClient.fetchConnection("me/likes", Page.class);
		System.out.println("\nPosts:");
		int counter = 0;
		for (List<Page> feedPage : result) {
			for (Page page : feedPage) {
				System.out.println("---- Page " + counter + " ----");
				System.out.println("Name: "+ page.getName());
				System.out.println("Id: " + "fb.com/" + page.getId());
				System.out.println("Number of Likes: " + page.getLikesCount());
				counter++;	
			}
		}
		System.out.println("-------------\nNº of Results: " + counter);
		
	}
	
	/**
	 * Writes a post in the user's time line.
	 * Prints the post that is written.
	 * @param s		post that is written of the time line.
	 */
	
	public void createPostTimeLine(String s) {
		FacebookType post= fbClient.publish("me/feed", FacebookType.class, Parameter.with("message", s));
		System.out.println("fb.com/"+post.getId());
	}
	
	public static void main(String[] args) {
		Facebook fb=new Facebook();
		fb.getExtendedAccessToken();
		fb.getTimeLinePosts();
		fb.getUserInformation();	
		fb.getLikedPages();
		fb.createPostTimeLine("ES1 test"); //no permission
		fb.getHomePosts(); //no permission
	}

	
	
}
