package JUnitTests;

import static org.junit.Assert.*;

import javax.swing.DefaultListModel;

import org.junit.Test;


import BDA.T;
import BDA.TwitterApp;

public class Twitter_FetchFromBackup {

	@Test
	public void test() {
		DefaultListModel<T> tweets =TwitterApp.FetchFromBackup();
		assertFalse(tweets.isEmpty());
	}

}
