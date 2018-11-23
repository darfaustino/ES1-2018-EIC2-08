package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.swing.JList;

import org.junit.jupiter.api.Test;

import BDA.T;
import BDA.TwitterApp;
import BDA.Background;
import twitter4j.TwitterException;

class TwitterTimeLine_init {

	@Test
	void test() {
		TwitterApp ta = new TwitterApp("W1f0VvgWPfT8OBqVxvy4Mw","zKH2yAtRyefwsgOO8h8Szc4kru68iEm95QmIG7svw","36481851-VhzByC4f9MSsZES1QZQ4e4iBvA9bWGLyv9HKFpy7c","OahDuXF2Lhl5xlNYALhYZir6xSflAxKP9Zh89T05po");
		JList tweets= null;
		try {
			tweets=new JList<T>(ta.getTimeline());
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(ta);
		assertNotNull(tweets);
		

//		frame
		Background background=null;
		try {
			background=new Background("images/twittertimeline.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(background);
	}

}
