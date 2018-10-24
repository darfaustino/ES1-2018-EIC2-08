package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Projeto.Home;

public class InitHome {
		@Test
		public void test() {
			Home home=new Home();
			int width=home.getLauncher().getWidth();
			int height=home.getLauncher().getHeight();
			boolean isVisible= home.getLauncher().isVisible();
			int componentnumber=home.getLauncher().getComponentCount();
			assertEquals(800, width);
			assertEquals(600, height);
			assertEquals(true, isVisible);
			assertEquals(1, componentnumber);
		}

	

}
