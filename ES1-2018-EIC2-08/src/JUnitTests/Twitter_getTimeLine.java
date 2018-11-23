package JUnitTests;

import static org.junit.Assert.*;
import org.junit.Test;

import BDA.T;
import BDA.TwitterApp;

import java.util.List;

import javax.swing.DefaultListModel;

import twitter4j.Status;
import twitter4j.TwitterException;


public class Twitter_getTimeLine {
	
	@Test
	public void test() {
		TwitterApp ta=new TwitterApp("W1f0VvgWPfT8OBqVxvy4Mw","zKH2yAtRyefwsgOO8h8Szc4kru68iEm95QmIG7svw", "36481851-VhzByC4f9MSsZES1QZQ4e4iBvA9bWGLyv9HKFpy7c","OahDuXF2Lhl5xlNYALhYZir6xSflAxKP9Zh89T05po");
		DefaultListModel<T> test= new DefaultListModel <T> ();
		try {
			test = ta.getTimeline();
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		for (int i =0; i<test.size();i++) {
			assertNotNull(test.getElementAt(i));
		}
	}

}
