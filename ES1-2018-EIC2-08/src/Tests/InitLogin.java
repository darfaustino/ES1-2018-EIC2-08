package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Projeto.Home;
import Projeto.Login;

public class InitLogin {

	@Test
	public void test() {
		Home home=new Home();
		Login login=new Login(home.getLauncher());
		
		//LoginFrame Test
		
		int width=login.getLauncher().getWidth();
		int height=login.getLauncher().getHeight();
		boolean isVisible= login.getLauncher().isVisible();
		int componentnumber=login.getLauncher().getComponentCount();
		assertEquals(800, width);
		assertEquals(600, height);
		assertEquals(true, isVisible);
		assertEquals(1, componentnumber);
		
		//JLabel1 Test
		
		int l1width=login.getL1().getWidth();
		int l1height=login.getL1().getHeight();
		int l1X=login.getL1().getX();
		int l1Y= login.getL1().getY();
		String username=login.getL1().getText();
		assertEquals(200, l1width);
		assertEquals(30, l1height);
		assertEquals(50, l1X);
		assertEquals(270, l1Y);
		assertEquals("Username", username);
	
		//JLabel2 Test
		
		int l2width=login.getL2().getWidth();
		int l2height=login.getL2().getHeight();
		int l2X=login.getL2().getX();
		int l2Y= login.getL2().getY();
		String password=login.getL2().getText();
		assertEquals(200, l2width);
		assertEquals(30, l2height);
		assertEquals(50, l2X);
		assertEquals(330, l2Y);
		assertEquals("Password", password);
		
		//JTextField Test
		
		int txtwidth=login.getTf1().getWidth();
		int txtheight=login.getTf1().getHeight();
		int txtX=login.getTf1().getX();
		int txtY=login.getTf1().getY();
		assertEquals(200,txtwidth);
		assertEquals(30, txtheight);
		assertEquals(120, txtX);
		assertEquals(270, txtY);
		
		//JPassword Test
		int passwidth=login.getP1().getWidth();
		int passheight=login.getP1().getHeight();
		int passX=login.getP1().getX();
		int passY=login.getP1().getY();
		assertEquals(200,passwidth);
		assertEquals(30, passheight);
		assertEquals(120, passX);
		assertEquals(330, passY);

		//JButton1 Test 
		int buttonwidth=login.getBtn1().getWidth();
		int buttonheight=login.getBtn1().getHeight();
		int buttonX=login.getBtn1().getX();
		int buttonY=login.getBtn1().getY();
		assertEquals(100,buttonwidth);
		assertEquals(30, buttonheight);
		assertEquals(160, buttonX);
		assertEquals(370, buttonY);
	}

}
