package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import BDA.ContainsFilter;

public class InitContainsFilter {

	@Test
	public void test() {
		ContainsFilter u= new ContainsFilter(null, null, null);
		boolean isVisible= u.isVisible();
		assertEquals(true,isVisible);
	}

}
