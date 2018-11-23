package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.restfb.types.Post;

import BDA.FacePost;

public class FacePost_getMessage {

private Post w;
	
	@Before
	public void setUp() throws Exception {
		w=new Post();
	}

	@Test
	public void test() {
		FacePost f=new FacePost(w, 0);
		assertNotNull(f);
		assertEquals(f.getMessage(),w.getMessage());
	}

}
