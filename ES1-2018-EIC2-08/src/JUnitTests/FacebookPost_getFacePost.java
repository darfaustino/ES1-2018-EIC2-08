package JUnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;

import org.junit.Before;
import org.junit.Test;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Post;

import BDA.FacePost;
import BDA.Facebook;
import BDA.FacebookPost;

public class FacebookPost_getFacePost {

	private FacePost fp;
	
	@Before
	public void setUp() throws Exception {
		Post w = new Post();
		fp= new FacePost(w, 0);
		
	}
	@Test
	public void test() {
		FacebookPost f=new FacebookPost(fp);
		assertNotNull(f);
		assertEquals(fp, f.getFacePost());
	}

}
