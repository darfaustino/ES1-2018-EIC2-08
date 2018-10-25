package Projeto;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Login {
	
	/**
	 * Login window.
	 */
	
	public	JFrame launcher;
	private JLabel  l1, l2;
	private JTextField tf1;
	private JButton btn1;
	private JPasswordField p1;
	
	
	/**
	 * Constructor, calls method init() and builds the login window.
	 * @param launcher
	 */
	
	
	public Login(JFrame launcher){
		this.launcher=launcher;
		init();
	}


	/**
	 * Launches and builds login window
	 * Initiates the frame components (JLabels,JTextFields,	JPasswordField, and JButtons).
	 * Adds an actionlistener to the button.
	 * Puts everything in the correct positions.
	 */
	
	public void init() {
		
		
		//Background
		launcher.getContentPane().removeAll();
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
		  JLabel text=new JLabel("Não tem conta, registe-se");
		 JButton here=new JButton("<HTML><FONT color=\"#000099\"><U>aqui</U></FONT></HTML>");
		 here.setBorderPainted(false);
		 here.setOpaque(false);
		 here.setBackground(Color.WHITE);
		 text.setBounds(120, 400, 200, 30);
		 here.setBounds(232, 400, 100, 30);
		 
		 here.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				new SignUp(launcher);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		 
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
		  loginform.add(text);
		  loginform.add(here);


		
		launcher.add(logo);
		launcher.add(loginform);
	
		//Dar Refresh
		launcher.setSize(799,599);
		launcher.setSize(800,600);
	}

/**
 * Gets the JFrame that serves as launcher of the window.
 * @return launcher
 */
	public JFrame getLauncher() {
		return launcher;
	}

	/**
	 * Gets the JLabel l1.
	 * @return l1
	 */
	public JLabel getL1() {
		return l1;
	}

	/**
	 * Gets the JLabel l2.
	 * @return l2
	 */

	public JLabel getL2() {
		return l2;
	}

	/**
	 * Gets the JTextField tf1.
	 * @return tf1
	 */

	public JTextField getTf1() {
		return tf1;
	}

	/**
	 * Gets the JButton btn1
	 * @return btn1
	 */
	public JButton getBtn1() {
		return btn1;
	}

	/**
	 * Gets the JPasswordField p1
	 * @return p1
	 */
	public JPasswordField getP1() {
		return p1;
	}




	}

