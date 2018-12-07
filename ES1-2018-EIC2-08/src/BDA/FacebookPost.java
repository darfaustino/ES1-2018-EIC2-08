package BDA;


import javax.swing.*;

import java.awt.*;

import java.io.IOException;

	/** 
 	* Facebook Post.
 	*
 	*/
	
public class FacebookPost {
	
	private FacePost face;
	
	/**
	 * Constructor, it initializes the Facebook and tries to start the GUI.
	 * When the GUI is started it will show the id, message, story and creation date of a post from Facebook.
	 * 
	 * @param f		The name of the Facebook that is on the FacebookPost.
	 */
	
	public FacebookPost(FacePost f){
		try {
			face=f;
			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	/**
	 * 
	 * @return 		Return the FacePost of FacebookPost.
	 */
	
	public FacePost getFacePost(){
		return face;
	}

	/**
	 * Launches and builds the FacebookPost GUI.
	 * Initiates the frame and its components (JLabel,JScrollPane,Background, JPanel, and JTextPane).
	 * Puts everything in the correct positions. 
	 * 
	 * @throws IOException		If the Background image is not found.
	 */
	
	private void init() throws IOException {
		
		//SettingsJFrame
				JFrame launcher = new JFrame("BOM DIA ACADEMIA!");
				launcher.setResizable(false);
				launcher.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
				launcher.setLayout(new BorderLayout());
				launcher.setVisible(true);
				
				//Background
				Background background=new Background("images/facebooktimeline.png");
				background.setLayout(new GridBagLayout());
				background.setPreferredSize(new Dimension(800,600));

				GridBagConstraints c=new GridBagConstraints();
				c.gridx=0;
				c.gridy=0;
				c.gridheight=2;
				c.insets=new Insets(80, 0, 0, 0);
				
				JPanel text=new JPanel(new GridBagLayout());
				text.setPreferredSize(new Dimension(730,380));
				text.setOpaque(false);
				background.add(text, c);
				
				GridBagConstraints g=new GridBagConstraints();
				g.gridx=0;
				g.gridy=0;
				g.gridwidth=3;
				JTextPane info=new JTextPane();
				info.setOpaque(false);
				info.setPreferredSize(new Dimension(720,100));
				info.setEditable(false);
				info.setContentType("text/html");
				info.setText("<html> Post id: "+ face.getId()+"<br/> <html>Story: "+ face.getStory()+ "<br/>Date:"+face.getDate().toString());
				text.add(info, g);
				
				JTextPane area=new JTextPane();
				
				area.setContentType("text/html");
				area.setEditable(false);
				area.setPreferredSize(new Dimension(720,280));
				
				area.setText("<html> Message: "+ face.getMessage());
				
				JScrollPane scroll =new JScrollPane(area);
				scroll.setPreferredSize(new Dimension(720,280));
				g.gridy=1;
				g.gridx=0;
				g.gridheight=2;
				text.add(scroll, g);
				
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