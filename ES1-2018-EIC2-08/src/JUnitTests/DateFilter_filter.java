package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import BDA.DateFilter;
import twitter4j.TwitterException;

public class DateFilter_filter {

	@Test
	public void test() {
		DateFilter d= new DateFilter(null, null, null);
		int i = 1;
		int j = 2;
		int k =2018;
		
		try {
			d.dateFilter(i, j, k);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(i);
		assertNotNull(j);
		assertNotNull(k);
	}

}
