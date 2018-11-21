package BDA;

import javax.mail.Message;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class MainTimeline {

public	JFrame launcher;
	
public MainTimeline(){
	try {
		init();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}	

public void init() throws IOException {
	
	//SettingsJFrame
	launcher = new JFrame("BOM DIA ACADEMIA!");
	launcher.setResizable(false);
	launcher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	launcher.setLayout(new BorderLayout());
	launcher.setVisible(true);
	
	//Background
	Background background=new Background("images/maintimeline.png");
	background.setLayout(new GridBagLayout());
	background.setPreferredSize(new Dimension(800,600));
	
	
	//JTextPanes
	JPanel email= new JPanel(new FlowLayout());
	email.setOpaque(false);
	email.setPreferredSize(new Dimension(245,490));
	GridBagConstraints c=new GridBagConstraints();
	c.gridx=0;
	c.gridy=0;
	c.insets=new Insets(70, 0,0,0);
	c.gridheight=3;
	background.add(email,c);
	
	JPanel facebook= new JPanel();
	facebook.setPreferredSize(new Dimension(245,490));
	c.gridx=1;
	c.gridy=0;
	c.gridheight=3;
	c.insets=new Insets(70,15,0,15);
	background.add(facebook,c);
	
	JPanel twitter= new JPanel();
	twitter.setPreferredSize(new Dimension(245,490));
	c.gridx=2;
	c.gridy=0;
	c.gridheight=3;
	c.insets=new Insets(70, 0,0,0);
	background.add(twitter,c);
	
	JList<Email> emails=new JList<Email>(Mail.LoginMail());
	//System.out.println(Mail.LoginMail());
	//emails.setFixedCellHeight(50);
	//emails.setFixedCellWidth(230);
//	emails.setBorder(new EmptyBorder(10,5, 10, 0));
	emails.setOpaque(false);
	emails.setPreferredSize(new Dimension(240,480));
	
	
	JScrollPane scroll=new JScrollPane(emails);
	scroll.setPreferredSize(new Dimension(240,480));
	//scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	email.add(scroll);
	
	
	launcher.add(background);
	launcher.setSize(800, 600);
	launcher.pack();
	
	

 }

public static void main(String args[]){
    new MainTimeline();
}


}