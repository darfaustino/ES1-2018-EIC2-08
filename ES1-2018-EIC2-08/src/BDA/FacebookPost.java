package BDA;

import javax.mail.MessagingException;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class FacebookPost {
	public	JFrame launcher;
	private FacePost face;
	
	public FacebookPost(FacePost f){
		try {
			face=f;
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
				
				JPanel panel=new JPanel();
				panel.setPreferredSize(new Dimension(730,380));
				background.add(panel, c);
				
				JTextPane area=new JTextPane();
				area.setContentType("text/html");
				area.setPreferredSize(new Dimension(720,380));
				area.setText("FacePost: "+ face.getId() +"<br/>Date: "+face.getDate()+"<br/>Story: " + face.getStory()+"<br/><br/>Message: " + face.getMessage());
				
				JScrollPane scroll = new JScrollPane(area);
				panel.add(scroll);
				
				
				JLabel r=new JLabel(new ImageIcon("images/facebooktimeline.png"));
				r.setPreferredSize(new Dimension(300,70));
				c.gridx=0;
				c.gridy=2;
				c.insets=new Insets(15, 0, 0, 0);
				background.add(r,c);
				
				
				launcher.add(background);
				launcher.setSize(800, 600);
				launcher.pack();


	 }	
}