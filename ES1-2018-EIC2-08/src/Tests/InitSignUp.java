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
		
		//JLabel4
		
				int l4width=sign.getL4().getWidth();
				int l4height=sign.getL4().getHeight();
				int l4X=sign.getL4().getX();
				int l4Y= sign.getL4().getY();
				String email=sign.getL4().getText();
				assertEquals(200, l4width);
				assertEquals(30, l4height);
				assertEquals(50, l4X);
				assertEquals(390, l4Y);
				assertEquals("Email", email);
				
				//TextField 1
				
				int tf1width=sign.getTf1().getWidth();
				int tf1height=sign.getTf1().getHeight();
				int tf1X=sign.getTf1().getX();
				int tf1Y= sign.getTf1().getY();
				assertEquals(200, tf1width);
				assertEquals(30, tf1height);
				assertEquals(120, tf1X);
				assertEquals(210, tf1Y);
				
				
				//Button1
				
				int btn1width=sign.getBtn1().getWidth();
				int btn1height=sign.getBtn1().getHeight();
				int btn1X=sign.getBtn1().getX();
				int btn1Y= sign.getBtn1().getY();
				assertEquals(100, btn1width);
				assertEquals(30, btn1height);
				assertEquals(160, btn1X);
				assertEquals(430, btn1Y);
				
				//PasswordField1
				
				int p1width=sign.getP1().getWidth();
				int p1height=sign.getP1().getHeight();
				int p1X=sign.getP1().getX();
				int p1Y= sign.getP1().getY();
				assertEquals(200, p1width);
				assertEquals(30, p1height);
				assertEquals(120, p1X);
				assertEquals(270, p1Y);
				
				
		
	}

}
