package BDA;

import javax.mail.MessagingException;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * 
 * Class that updates the JFrame of the App and shows a singular email's content.
 * @author Diogo
 *
 */

public class EmailSingular {
	
	private	JFrame launcher;
	private Email email;
	
	/**
	 * Contructor, it call the methods necessary to create the GUI to show a email.
	 * @param email email to show.
	 */
	public EmailSingular(Email email){
		try {
			this.email=email;
			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	/**
	 * Launches and builds the email window.
	 * Initiates the frame components (JLabels,JTextPane).
	 * Adds an MouseListener to the JLabel.
	 * Puts everything in the correct positions. 
	 * @throws IOException I/O exception of some sort has occurred
	 */

	private void init() throws IOException {
		
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
		info.setText("<html> Email: "+ email.getSubject() +"<br/> <html>From: "+ email.getFrom()+ "<br/>Date:"+email.getTimestamp());
		text.add(info, g);
		
		JTextPane area=new JTextPane();
		
		area.setContentType("text/html");
		area.setEditable(false);
		area.setPreferredSize(new Dimension(720,280));
		
		area.setText("<html>"+ email.getBody());
		
		JScrollPane scroll =new JScrollPane(area);
		scroll.setPreferredSize(new Dimension(720,280));
		g.gridy=1;
		g.gridx=0;
		g.gridheight=2;
		text.add(scroll, g);
		
		
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

	/**
	 * Gets the JFrame that serves as launcher of the window.
	 * @return launcher
	 */
	
	public JFrame getLauncher() {
		return launcher;
	}
	
	
	
}