package BDA;

import javax.mail.MessagingException;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class EmailSingular {
	public	JFrame launcher;
	private Email email;
	
	public EmailSingular(Email email){
		try {
			this.email=email;
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
		launcher.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		launcher.setLayout(new BorderLayout());
		launcher.setVisible(true);
		
		//Background
		Background background=new Background("images/emailsingular.png");
		background.setLayout(new GridBagLayout());
		background.setPreferredSize(new Dimension(800,600));

		GridBagConstraints c=new GridBagConstraints();
		c.gridx=0;
		c.gridy=0;
		c.gridheight=2;
		c.insets=new Insets(80, 0, 0, 0);
		
		JPanel text=new JPanel();
		text.setPreferredSize(new Dimension(730,380));
		background.add(text, c);
		
		JTextPane area=new JTextPane();
		area.setContentType("text/html");
		area.setPreferredSize(new Dimension(720,380));
		
		area.setText("<html> Email: "+ email.getSubject() +"<br/> <html>From: "+ email.getFrom()+ "<br/>Date:"+email.getTimestamp()+ "<br/><html>"+ email.getBody());
		
		JScrollPane scroll =new JScrollPane(area);
		scroll.setPreferredSize(new Dimension(720,380));
		text.add(scroll);
		
		
		JLabel r=new JLabel(new ImageIcon("images/responder.png"));
		r.setPreferredSize(new Dimension(300,70));
		c.gridx=0;
		c.gridy=2;
		c.insets=new Insets(15, 0, 0, 0);
		background.add(r,c);
		
		r.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				new GuiResponse(launcher, email);
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		launcher.add(background);
		launcher.setSize(800, 600);
		launcher.pack();

	 }
	/*
	public static void main(String args[]){
	    new EmailSingular();

	}*/
	}