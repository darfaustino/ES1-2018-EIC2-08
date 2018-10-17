import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home {

	
	
	private	JFrame launcher;

Home(){

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
	JLabel signup=new JLabel(new ImageIcon("images\\signup.png"));
	
	
	launcher.setLayout(new GridLayout(2,1));
	JPanel t= new JPanel();
	t.setOpaque(false);
	t.setLayout(new BorderLayout());
	launcher.add(logo);
	launcher.add(t);
	//t.add(login, BorderLayout.NORTH);
	t.add(signup, BorderLayout.SOUTH);
	t.add(login, BorderLayout.NORTH);
	//Dar Refresh
	launcher.setSize(799,599);
	launcher.setSize(800,600);
}









public static void main(String args[]){
    new Home();
}





}