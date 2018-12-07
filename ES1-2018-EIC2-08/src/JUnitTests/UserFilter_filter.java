package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import BDA.UserFilter;
import twitter4j.TwitterException;

public class UserFilter_filter {

	@Test
	public void test() {
		UserFilter u= new UserFilter(null, null, null);
		String s = "iscte";
		
		try {
			u.userFilter(s);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(s);
		
	}

}
