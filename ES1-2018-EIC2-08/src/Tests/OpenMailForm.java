package Tests;
import static org.junit.Assert.*;

import org.junit.Test;

import Projeto.Home;
import Projeto.SignUp;

public class OpenMailForm {

	@Test
	public void test() {
	
		Home home=new Home();
		SignUp sign=new SignUp(home.getLauncher());
		
		//Jlabel2
		
		int l2width=sign.getL2().getWidth();
		int l2height=sign.getL2().getHeight();
		int l2X=sign.getL2().getX();
		int l2Y= sign.getL2().getY();
		String password=sign.getL2().getText();
		assertEquals(200, l2width);
		assertEquals(30, l2height);
		assertEquals(50, l2X);
		assertEquals(320, l2Y);
		assertEquals("Password", password);
		
		//Jlabel4
		
		int l4width=sign.getL4().getWidth();
		int l4height=sign.getL4().getHeight();
		int l4X=sign.getL4().getX();
		int l4Y= sign.getL4().getY();
		String email=sign.getL4().getText();
		assertEquals(200, l4width);
		assertEquals(30, l4height);
		assertEquals(50, l4X);
		assertEquals(280, l4Y);
		assertEquals("Email", email);
		
		//Passwordfield1
		
		int p1width=sign.getP1().getWidth();
		int p1height=sign.getP1().getHeight();
		int p1X=sign.getP1().getX();
		int p1Y= sign.getP1().getY();
		assertEquals(200, p1width);
		assertEquals(30, p1height);
		assertEquals(120, p1X);
		assertEquals(320, p1Y);
		
		//Button1
		
		int btn1width=sign.getBtn1().getWidth();
		int btn1height=sign.getBtn1().getHeight();
		int btn1X=sign.getBtn1().getX();
		int btn1Y= sign.getBtn1().getY();
		assertEquals(100, btn1width);
		assertEquals(30, btn1height);
		assertEquals(160, btn1X);
		assertEquals(360, btn1Y);
		
		
	}
}