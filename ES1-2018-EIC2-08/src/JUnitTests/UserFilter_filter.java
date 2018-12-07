package JUnitTests;

import static org.junit.Assert.*;

import javax.swing.JList;

import org.junit.Test;

import BDA.Email;
import BDA.FacePost;
import BDA.Facebook;
import BDA.Mail;
import BDA.MainTimeline;
import BDA.T;
import BDA.TwitterApp;
import BDA.UserFilter;
import twitter4j.TwitterException;

public class UserFilter_filter {

	@Test
	public void test() {
		
		JList<Email> mail=new JList<>(Mail.FetchFromBackup());
		JList<T> tweet=new JList<>(TwitterApp.FetchFromBackup());
		JList<FacePost> face=new JList<>(Facebook.FetchFromBackup());
		
		
		
		UserFilter u= new UserFilter(face,mail, tweet);
		String s = "iscte";
		try {
			u.userFilter(s);
		} catch (TwitterException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		assertNotNull(u.getFacePosts());
		assertNotNull(u.getTweets());
		assertNotNull(u.getEmails());
		assertNotNull(s);

		
	}



}
