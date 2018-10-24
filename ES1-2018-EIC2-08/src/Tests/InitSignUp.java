package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Projeto.Home;
import Projeto.SignUp;

public class InitSignUp {

	@Test
	public void test() {
		
		Home home=new Home();
		SignUp sign=new SignUp(home.getLauncher());
		
		//Frame Test
		int width=sign.getLauncher().getWidth();
		int height=sign.getLauncher().getHeight();
		boolean isVisible= sign.getLauncher().isVisible();
		int componentnumber=sign.getLauncher().getComponentCount();
		assertEquals(800, width);
		assertEquals(600, height);
		assertEquals(true, isVisible);
		assertEquals(1, componentnumber);
		
		//JLabel1
		int l1width=sign.getL1().getWidth();
		int l1height=sign.getL1().getHeight();
		int l1X=sign.getL1().getX();
		int l1Y= sign.getL1().getY();
		String username=sign.getL1().getText();
		assertEquals(200, l1width);
		assertEquals(30, l1height);
		assertEquals(50, l1X);
		assertEquals(210, l1Y);
		assertEquals("Name", username);
		
		//JLabel2
		
		int l2width=sign.getL2().getWidth();
		int l2height=sign.getL2().getHeight();
		int l2X=sign.getL2().getX();
		int l2Y= sign.getL2().getY();
		String password=sign.getL2().getText();
		assertEquals(200, l2width);
		assertEquals(30, l2height);
		assertEquals(50, l2X);
		assertEquals(270, l2Y);
		assertEquals("Password", password);
		
		//JLabel3 
		
		int l3width=sign.getL3().getWidth();
		int l3height=sign.getL3().getHeight();
		int l3X=sign.getL3().getX();
		int l3Y= sign.getL3().getY();
		String gender=sign.getL3().getText();
		assertEquals(200, l3width);
		assertEquals(30, l3height);
		assertEquals(50, l3X);
		assertEquals(330, l3Y);
		assertEquals("Gender", gender);
		
		
		
	}

}
