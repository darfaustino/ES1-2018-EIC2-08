package JUnitTests;

import static org.junit.Assert.*;

import javax.swing.JList;

import org.junit.Test;

import BDA.DateFilter;
import BDA.Email;
import BDA.FacePost;
import BDA.Facebook;
import BDA.Mail;

import BDA.T;
import BDA.TwitterApp;
import twitter4j.TwitterException;

public class DateFilter_filter {

	@Test
	public void test() {
		JList<Email> mail=new JList<>(Mail.FetchFromBackup());
		JList<T> tweet=new JList<>(TwitterApp.FetchFromBackup());
		JList<FacePost> face=new JList<>(Facebook.FetchFromBackup());

			DateFilter d = new DateFilter(face, mail, tweet);
			int i = 1;
			int j = 2;
			int k = 2018;
			try {
				d.dateFilter(i, j, k);
			} catch (TwitterException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			assertNotNull(d.getFacePosts());
			assertNotNull(d.getEmails());
			assertNotNull(d.getEmails());
			assertNotNull(i);
			assertNotNull(j);
			assertNotNull(k);
		}

	

}
