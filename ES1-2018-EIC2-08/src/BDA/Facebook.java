package BDA;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.User;

	/** 
	 * Facebook App.
	 *
	 */
	
public class Facebook {
	
	private String accessToken;
	private FacebookClient fbClient;

	/**
	 * Constructor, it initializes both attributes: the access token and the Facebook Client.
	 * 
	 * @param acessToken	The name of the string that is going to be the accessToken.
	 */
	
	public Facebook(String acessToken){
		this.accessToken=acessToken; //expira 21/12/2018
		fbClient = new DefaultFacebookClient(accessToken);
	}
	
	/**
	 * Connects the Facebook Client with the posts of the user's time line.
	 * Creates a DefaultListModel.
	 * Scrolls through all the posts of all the pages of the user's time line.
	 * Filters the posts: they must have something written and have the word "ISCTE" also written there.
	 * Counts each post and filtered post.
	 * Prints the number, id, time when it was created and message of each filtered post.
	 * Adds the filtered posts to the DefaultListModel.
	 * Prints the number of filtered and total number of posts covered.
	 * 
	 * @return 		Returns the DefaultListModel that contains the filtered posts.
	 */
	public DefaultListModel<FacePost> getTimeLinePosts(){
		Connection<Post> result = fbClient.fetchConnection("me/feed", Post.class);
		System.out.println("\nPosts:");
		int counter = 0;
		int counterTotal = 0;
		DefaultListModel<FacePost> lista= new DefaultListModel<FacePost>();
		for (List<Post> page : result) {
			for (Post aPost : page) {
				// Filters only posts that contain the word "ISCTE"
				if (aPost.getMessage() != null /*&& aPost.getMessage().contains("ISCTE")*/) {
					System.out.println("---- Post " + counter + " ----");
					System.out.println("Id: " + "fb.com/" + aPost.getId());
					System.out.println("Message: " + aPost.getMessage());
					System.out.println("Created: " + aPost.getCreatedTime());
					System.out.println("From: " + aPost.getStory());
					lista.addElement((new FacePost(aPost, counter)));
					counter++;
				}
				counterTotal++;
			}
		}
		System.out.println("-------------\nNº of Results: " + counter + "/" + counterTotal);
		return lista;
	}
	

	/**
	 * Creates an access token with an extended expired date with the use of the AppId and AppSecret.
	 * It uses the new token to create a new Facebook Client.
	 */
	
	public void useExtendedAccessToken(){
		//extendedAccessToken=fbClient.obtainExtendedAccessToken(AppID, AppSecret);
		AccessToken extendedAccessToken = fbClient.obtainExtendedAccessToken("255508025109783","97c2eea96f770959e83591baa238ab01");
		accessToken=extendedAccessToken.getAccessToken();
		fbClient = new DefaultFacebookClient(accessToken);
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
}
