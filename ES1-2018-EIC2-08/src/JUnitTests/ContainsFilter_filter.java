package JUnitTests;

import static org.junit.Assert.*;

import javax.swing.JList;

import org.junit.Test;

import BDA.ContainsFilter;
import BDA.Email;
import BDA.FacePost;
import BDA.Facebook;
import BDA.Mail;
import BDA.MainTimeline;
import BDA.T;
import BDA.TwitterApp;
import twitter4j.TwitterException;

public class ContainsFilter_filter {

	@Test
	public void test() {
		JList<Email> mail=new JList<>(Mail.FetchFromBackup());
		JList<T> tweet=new JList<>(TwitterApp.FetchFromBackup());
		JList<FacePost> face=new JList<>(Facebook.FetchFromBackup());

			ContainsFilter u = new ContainsFilter(face, mail, tweet);
			String s = "de";
			try {
				u.containsFilter(s);
			} catch (TwitterException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			assertNotNull(u.getFacePosts());
			assertNotNull(u.getEmails());
			assertNotNull(u.getTweets());
			assertNotNull(s);

		}

	

}
