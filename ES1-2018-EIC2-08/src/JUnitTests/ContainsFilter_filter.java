package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import BDA.ContainsFilter;
import twitter4j.TwitterException;

public class ContainsFilter_filter {

	@Test
	public void test() {
		ContainsFilter u= new ContainsFilter(null, null, null);
		String s = "de";
		
		try {
			u.containsFilter(s);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(s);
		
	}

}
