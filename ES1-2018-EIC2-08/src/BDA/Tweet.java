package BDA;

import javax.swing.*;
import twitter4j.TwitterException;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**Represents the tweet's Frame.
 * 
 * 
 */

public class Tweet {
	/**
	 * Represents the frame.
	 */
	private	JFrame launcher;
	/**
	 * Represents the tweet.
	 */
	private T t;
	/**
	 * Represents the twitter.
	 */
	private TwitterApp twitter;
	
	
	/**
	 * Constructor, creates a frame with the tweet.
	 * @param twitter represents twitter
	 * @param t tweet
	 * 
	 */
	public Tweet(TwitterApp twitter, T t){
		this.twitter=twitter;
		this.t=t;
		try {
			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	/**
	 * Frame's creation and customization.
	 * @throws IOException Some error occurred
	 */
	public void init() throws IOException {
		
		//SettingsJFrame
		launcher = new JFrame("BOM DIA ACADEMIA!");
		launcher.setResizable(false);
		launcher.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		launcher.setLayout(new BorderLayout());
		launcher.setVisible(true);
		
		//Background
		Background background=new Background("images/backtweet.png");
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
		info.setText("From: "+ t.getName()+ "<br/>Date:"+t.getDate().toString());
		text.add(info, g);
		
		JTextPane area=new JTextPane();
		
		area.setContentType("text/html");
		area.setEditable(false);
		area.setPreferredSize(new Dimension(720,200));
		
		area.setText("<html>"+ t.getText());
		
		JScrollPane scroll =new JScrollPane(area);
		scroll.setPreferredSize(new Dimension(720,200));
		g.gridy=1;
		g.gridx=0;
		g.gridheight=2;
		text.add(scroll, g);
		
		text.add(scroll,g);
	
		background.add(text,c);
		
		JLabel r=new JLabel(new ImageIcon("images/btnret.png"));
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
				
				try {
					twitter.retweet(t);
				} catch (TwitterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
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
	
	}