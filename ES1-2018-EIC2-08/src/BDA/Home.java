package BDA;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * 
 * Main App class.
 * 
 * @author Goncalo Duarte
 * @author Diogo Faustino
 * @author Miguel Pedroso
 * @author Gonçalo Cruz
 */


public class Home {

	/**
	 * Initial window class
	 */
	
	public	JFrame launcher;

	/**
	 * Constructor, calls method init() and builds the app main window, where you can navigate to login or signup.
	 */
	
	public Home(){
	try {
		init();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	/**
	 * Launches and builds the app main window.
	 * Initiates the frame components (JLabels,JTextFields,	JPasswordField, and JButtons).
	 * Adds an actionlistener to the buttons.
	 * Puts everything in the correct positions.
	 * @throws IOException	 if the Background image is not found.
	 */

	public void init() throws IOException {
	
	//SettingsJFrame
	launcher = new JFrame("BOM DIA ACADEMIA!");
	launcher.setResizable(false);
	launcher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	launcher.setLayout(new BorderLayout());
	launcher.setVisible(true);
	
	//Background
	Background background=new Background("images/background.png");
	background.setLayout(new BorderLayout());
	background.setPreferredSize(new Dimension(800,600));
	launcher.add(background);
	
	
	//Imagens
	JLabel logo=new JLabel(new ImageIcon("images\\logo.png"));
	JLabel login=new JLabel(new ImageIcon("images\\login.png"));
	JLabel signup=new JLabel(new ImageIcon("images\\signup.png"));
	
	
	JPanel t= new JPanel(new GridLayout(2,1));
	t.setOpaque(false);
	t.add(login, BorderLayout.NORTH);
	t.add(signup, BorderLayout.SOUTH);
	
	
	background.add(logo, BorderLayout.PAGE_START);
	background.add(t, BorderLayout.CENTER);
	
	//Dar Refresh
	
	launcher.pack();
	launcher.setSize(800, 600);
	
	//Add MouseListeners
	
	login.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
			new Login(launcher);
			
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
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	});
	
	signup.addMouseListener(new MouseListener() {
		
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
	
}


	/**
	 * Gets the JFrame that serves as launcher of the window.
	 * @return launcher
	 */

public JFrame getLauncher() {
	return launcher;
}

/**
 * Starts the app.
 * @param args is not used. 
 */

public static void main(String args[]){
    new Home();
}





}