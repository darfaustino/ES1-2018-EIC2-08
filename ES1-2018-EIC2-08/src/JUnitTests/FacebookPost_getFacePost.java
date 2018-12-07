package JUnitTests;

import static org.junit.Assert.*;


import java.util.Date;




import org.junit.Before;
import org.junit.Test;


import BDA.FacePost;
import BDA.FacebookPost;

public class FacebookPost_getFacePost {

	private FacePost fp;
	
	@Before
	public void setUp() throws Exception {
		fp= new FacePost("1", "test", "test",String.valueOf( new Date().getTime()));
		
	}
	@Test
	public void test() {
		FacebookPost f=new FacebookPost(fp);
		assertNotNull(f);
		assertEquals(fp, f.getFacePost());
	}

}
