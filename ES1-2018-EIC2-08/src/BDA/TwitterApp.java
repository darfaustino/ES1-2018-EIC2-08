package BDA;
/**Represents the twitter app
 * 
 * 
 * @author  Gonçalo Cruz
 * 
 */


import java.util.List;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public final class TwitterApp {

	/**
	 * Represents all posts in this page.
	 */
	public static List<Status> statuses;
	
	
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
			Twitter twitter = tf.getInstance();
			
			statuses = twitter.getHomeTimeline();
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	
	/** List of latest tweets from user's home timeline.
	 * @throws TwitterException catches a Twitter Exception.
	 */
	public static void getTimeline() throws TwitterException {
		System.out.println("Showing home timeline.");
		for (Status status : statuses) {
			System.out.println(status.getUser().getName() + ":" + status.getText());
			System.out.println("-------------------------");
		}
	}
	

	/** Searching by user's name.
	 * 
	 * @param s is the name of the user.
	 * 
	 */
	public static void searchForUser(String s) {
		int counter = 0;
		int counterTotal = 0;
		for (Status status : statuses) {
			if (status.getUser().getName() != null && status.getUser().getName().contains(s)) {
				System.out.println(status.getUser().getName() + ":" + status.getText());
				counter++;
			}
			counterTotal++;
		}
		System.out.println("-------------\nNº of Results: " + counter + "/" + counterTotal);

	}


	/** Testing time line and search for user.
	 * @param args not used.
	 */
	public static void main(String[] args) {
		try {
			getTimeline();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		searchForUser("NAMI");
	}
}
    
