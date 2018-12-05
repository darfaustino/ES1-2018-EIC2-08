package JUnitTests;

import static org.junit.Assert.*;

import javax.swing.DefaultListModel;

import org.junit.Test;

import BDA.FacePost;
import BDA.Facebook;

public class FetchFromBackup {

	@Test
	public void test() {
		DefaultListModel<FacePost> posts =Facebook.FetchFromBackup();
		assertFalse(posts.isEmpty());
	}

}
