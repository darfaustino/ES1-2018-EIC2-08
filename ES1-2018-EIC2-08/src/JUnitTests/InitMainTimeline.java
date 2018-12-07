package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import BDA.Facebook;
import BDA.MainTimeline;
import BDA.TwitterApp;
import twitter4j.TwitterException;

public class InitMainTimeline {

	@Test
	public void test() {
		String email="darfo@iscte-iul.pt";
		String username="darfo@iscte-iul.pt";
		String password= "EngenhariaSoftware98";
		Facebook fb=new Facebook("EAADoYhkS7RcBAEKHnrBd4T60iYQZCm1jfrK4xpq1quSDLCcQW7tAOXIw5TiK26A1MVZBTCV2jcijb8"
				+ "cdV1BtMuSZCOBdYRcDAMINHo7j4ws6F76RZC1uWuK18sZAZAZCSl99RXPJERm8okjSfMptfZCUKCc40KjUeEdtMi0a23ZCFJQZDZD");
		TwitterApp tw=new TwitterApp("W1f0VvgWPfT8OBqVxvy4Mw","zKH2yAtRyefwsgOO8h8Szc4kru68iEm95QmIG7svw", "36481851-VhzByC4f9MSsZES1QZQ4e4iBvA9bWGLyv9HKFpy7c","OahDuXF2Lhl5xlNYALhYZir6xSflAxKP9Zh89T05po");
		
		try {
			MainTimeline main=new MainTimeline(email,fb,tw,username,password, true, true);
			int width=main.getLauncher().getWidth();
			int height=main.getLauncher().getHeight();
			boolean isVisible= main.getLauncher().isVisible();
			assertTrue(width>=800);
			assertTrue(height>=600);
			assertEquals(true, isVisible);
			
			
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
