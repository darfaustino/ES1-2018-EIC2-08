package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import BDA.DateFilter;

public class InitDateFilter {

	@Test
	public void test() {
		DateFilter u= new DateFilter(null, null, null);
		boolean isVisible= u.isVisible();
		assertEquals(true,isVisible);
	}

}
