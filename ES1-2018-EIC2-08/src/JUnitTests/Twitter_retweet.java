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
		TwitterApp ta=new TwitterApp();
		
		T t = new T ("goncalo", "ola");
		assertNotNull(ta.twitter);
		assertNotNull(t);
		Status status=null;
		try {
			status = ta.twitter.updateStatus("Retweet:  " + t.name + ":" + t.text);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(status);
	
		
	}

}
