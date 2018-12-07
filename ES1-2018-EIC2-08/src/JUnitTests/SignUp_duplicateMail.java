package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import BDA.Home;
import BDA.SignUp;

public class SignUp_duplicateMail {

	private String duplicate, notDuplicate;
	private Home h;
	
	@Before
	public void setUp() throws Exception {
		h=new Home();
		//dados de contas
		duplicate="diogo@iscte-iul.pt";
		notDuplicate="notReal@iscte-iul.pt";
	}

	@Test
	public void test() {
		SignUp a= new SignUp(h.getLauncher());
		boolean t=a.duplicateMail(duplicate);
		assertTrue(t);
		boolean f=a.duplicateMail(notDuplicate);
		assertFalse(f);
	}

}
