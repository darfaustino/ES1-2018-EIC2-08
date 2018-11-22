package BDA;
/**Represents the twitter app
 * 
 * 
 * @author  Gonçalo Cruz
 * 
 */


import java.util.List;

import javax.swing.DefaultListModel;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public final class TwitterApp {

	/**
	 * Represents the twitter.
	 */
	public static Twitter twitter;
	/**
	 * Represents all posts in this page.
	 */
	static DefaultListModel<T> tweets;
	
	
	/**
	 * Class constructor, creates a TwitterFactory with all the informations we have about the tokens that we gave.
	 * 
	 */

	public TwitterApp() {
		
		try {

			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey("W1f0VvgWPfT8OBqVxvy4Mw")
					.setOAuthConsumerSecret("zKH2yAtRyefwsgOO8h8Szc4kru68iEm95QmIG7svw")
					.setOAuthAccessToken("36481851-VhzByC4f9MSsZES1QZQ4e4iBvA9bWGLyv9HKFpy7c")
					.setOAuthAccessTokenSecret("OahDuXF2Lhl5xlNYALhYZir6xSflAxKP9Zh89T05po");

			TwitterFactory tf = new TwitterFactory(cb.build());
			twitter = tf.getInstance();	
			tweets= new DefaultListModel<T>();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	
	/** List of latest tweets from user's home timeline.
	 * @throws TwitterException catches a Twitter Exception.
	 *  @return a list of tweets
	 */
	public  DefaultListModel<T> getTimeline() throws TwitterException {
		List <Status> statuses = twitter.getHomeTimeline();
		for (Status status : statuses) {
			T x = new T (status.getUser().getName(), status.getText());
			tweets.addElement(x);
		}	
					
		return tweets;
		
	}
	

	/** Searching by user's name.
	 * 
	 * @param s is the name of the user.
	 * 
	 */
//	public static void searchForUser(String s) {
//		int counter = 0;
//		int counterTotal = 0;
//		for (Status status : statuses) {
//			if (status.getUser().getName() != null && status.getUser().getName().contains(s)) {
//				System.out.println(status.getUser().getName() + ":" + status.getText());
//				counter++;
//			}
//			counterTotal++;
//		}
//		System.out.println("-------------\nNº of Results: " + counter + "/" + counterTotal);
//
//	}
	
	
	/** Retweet
	 * @param tweet to retweet.
	 */
	
	public void retweet(T s) throws TwitterException {
		Status status = twitter.updateStatus("Retweet:  " + s.name + ":" + s.text);
		System.out.println("Successfully updated the status to [" + status.getText() + "].");
	}
	
}

