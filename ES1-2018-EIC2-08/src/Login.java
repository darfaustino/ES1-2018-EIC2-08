import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login {
	private	JFrame launcher;
	private JLabel  l1, l2;
	private JTextField tf1;
	private JButton btn1;
	private JPasswordField p1;
	
	Login(){

		init();
	}


	private void init() {
		
		//SettingsJFrame
		JFrame launcher = new JFrame("BOM DIA ACADEMIA!");
		launcher.setVisible(true);
		launcher.setSize(800, 600);
		launcher.setResizable(false);
		launcher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		launcher.setLayout(new BorderLayout());
		
		//Background
		launcher.setContentPane(new JLabel(new ImageIcon("images\\background.png")));
		
		//Imagens
		JLabel logo=new JLabel(new ImageIcon("images\\logo.png"));
		JLabel login=new JLabel(new ImageIcon("images\\login.png"));
		
		launcher.setLayout(new GridLayout(1,2));
		JPanel loginform= new JPanel();
		loginform.setOpaque(false);
		loginform.setLayout(null);
		
		
		
		
		Cursor cur=new Cursor(Cursor.HAND_CURSOR);
		
		  l1 = new JLabel("Username");
		  l2 = new JLabel("Password");
		  tf1 = new JTextField();
		  p1 = new JPasswordField();
		  btn1 = new JButton("Login");
		  btn1.setCursor(cur);
		  
		  login.setBounds(35,20,400,400);
		  l1.setForeground(Color.black);
		  l2.setForeground(Color.black);
		  l1.setBounds(50, 270, 200, 30);
		  l2.setBounds(50, 330, 200, 30);
		  tf1.setBounds(120, 270, 200, 30);
		  p1.setBounds(120, 330, 200, 30);
		  btn1.setBounds(160, 370, 100, 30);
		  
		  loginform.add(login);
		  loginform.add(l1);
		  loginform.add(tf1);
		  loginform.add(l2);
		  loginform.add(p1);
		  loginform.add(btn1);

	 

		  
		  
		  

		
		
		
		launcher.add(logo);
		launcher.add(loginform);
	
		//Dar Refresh
		launcher.setSize(799,599);
		launcher.setSize(800,600);
	}









	public static void main(String args[]){
	    new Login();
	}





	}

