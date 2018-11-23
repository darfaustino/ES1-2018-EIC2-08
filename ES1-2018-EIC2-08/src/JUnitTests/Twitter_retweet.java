package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import BDA.T;
import BDA.TwitterApp;
import twitter4j.Status;
import twitter4j.TwitterException;


public class Twitter_retweet {

	@Test
	public void test() {
		TwitterApp ta=new TwitterApp("W1f0VvgWPfT8OBqVxvy4Mw","zKH2yAtRyefwsgOO8h8Szc4kru68iEm95QmIG7svw", "36481851-VhzByC4f9MSsZES1QZQ4e4iBvA9bWGLyv9HKFpy7c","OahDuXF2Lhl5xlNYALhYZir6xSflAxKP9Zh89T05po");
		
		T t = new T ("goncalo", "ola");
		assertNotNull(TwitterApp.twitter);
		assertNotNull(t);
		Status status=null;
		try {
			status = TwitterApp.twitter.updateStatus("Retweet:  " + t.name + ":" + t.text);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(status);
	
		
	}

}
