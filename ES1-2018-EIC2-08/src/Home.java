import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Home {

	
	
	private	JFrame launcher;

	public Home(){
	try {
		init();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}


private void init() throws IOException {
	
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
	//launcher.setContentPane(new JLabel(new ImageIcon("images\\background.png")));
	
	
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
	
	//t.add(login, BorderLayout.NORTH);
	
	//Dar Refresh
	
	//Add MouseListeners
	launcher.setSize(800, 600);
//	launcher.pack();
	
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









public static void main(String args[]){
    new Home();
}





}