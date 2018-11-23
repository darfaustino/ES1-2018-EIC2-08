package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import BDA.EmailTimeline;
import BDA.Home;

public class InitEmailTimeline {

	@Test
	public void test() {
		EmailTimeline home=new EmailTimeline();
		int width=home.getLauncher().getWidth();
		int height=home.getLauncher().getHeight();
		boolean isVisible= home.getLauncher().isVisible();
		
		assertTrue(width>=800);
		assertTrue(height>=600);
		assertEquals(true, isVisible);
	}

}
