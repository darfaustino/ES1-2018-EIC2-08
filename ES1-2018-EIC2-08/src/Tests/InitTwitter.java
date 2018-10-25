package Tests;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class InitTwitter {

	@Test
	public void test() throws TwitterException {

		ConfigurationBuilder cb = new ConfigurationBuilder();
		assertNotNull(cb);
		
		cb.setDebugEnabled(true).setOAuthConsumerKey("W1f0VvgWPfT8OBqVxvy4Mw")
		.setOAuthConsumerSecret("zKH2yAtRyefwsgOO8h8Szc4kru68iEm95QmIG7svw")
		.setOAuthAccessToken("36481851-VhzByC4f9MSsZES1QZQ4e4iBvA9bWGLyv9HKFpy7c")
		.setOAuthAccessTokenSecret("OahDuXF2Lhl5xlNYALhYZir6xSflAxKP9Zh89T05po");

		
		TwitterFactory tf = new TwitterFactory(cb.build());
		assertNotNull(tf);
		
		Twitter twitter = tf.getInstance();
		assertNotNull(twitter);
		
		
		List<Status> statuses = twitter.getHomeTimeline();
		assertNotNull(statuses);

	}

}
