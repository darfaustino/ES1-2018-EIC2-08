package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import BDA.ChangeName;

public class ChangeName_init {

	@Test
	public void test() {
		ChangeName a= new ChangeName("darfo@iscte-iul.pt");
		
		// Frame Test
		int width = a.getLauncher().getWidth();
		int height = a.getLauncher().getHeight();
		boolean isVisible = a.getLauncher().isVisible();
		int componentnumber = a.getLauncher().getComponentCount();
		assertEquals(800, width);
		assertEquals(600, height);
		assertEquals(true, isVisible);
		assertEquals(1, componentnumber);
	}

}
