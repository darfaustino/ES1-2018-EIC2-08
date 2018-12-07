package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import BDA.UserFilter;

public class InitUserFilter {

	@Test
	public void test() {
		UserFilter u= new UserFilter(null, null, null);
		boolean isVisible= u.isVisible();
		assertEquals(true,isVisible);
	}

}
