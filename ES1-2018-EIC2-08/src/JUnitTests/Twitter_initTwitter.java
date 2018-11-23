package JUnitTests;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Twitter_initTwitter {

	@Test
	public void test() throws TwitterException {

		ConfigurationBuilder cb = new ConfigurationBuilder();
		assertNotNull(cb);
		
		cb.setDebugEnabled(true).setOAuthConsumerKey("djruORHuSHJcsJW060wtuGowg")
		.setOAuthConsumerSecret("LzofRAO9R7a8sZIDofWXoix6gtXiS43MzFsrFrlqiIeKo66Ly5")
		.setOAuthAccessToken("1063486441114820608-2pujB6rSntopZvEd6ENTrt3gOPspgv")
		.setOAuthAccessTokenSecret("DTB1yFxV0pelfd9BlbBbYar6GE34rbGHA6ceDBs0beCnd");

		
		TwitterFactory tf = new TwitterFactory(cb.build());
		assertNotNull(tf);
		
		Twitter twitter = tf.getInstance();
		assertNotNull(twitter);
		
		
		List<Status> statuses = twitter.getHomeTimeline();
		assertNotNull(statuses);

	}

}
