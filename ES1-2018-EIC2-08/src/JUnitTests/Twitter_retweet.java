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
		TwitterApp ta = new TwitterApp("djruORHuSHJcsJW060wtuGowg","LzofRAO9R7a8sZIDofWXoix6gtXiS43MzFsrFrlqiIeKo66Ly5","1063486441114820608-2pujB6rSntopZvEd6ENTrt3gOPspgv","DTB1yFxV0pelfd9BlbBbYar6GE34rbGHA6ceDBs0beCnd");
		T t = new T ("goncalo", "ola"+(Math.random()*100));
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
