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
	public	JFrame launcher;
	/**
	 * Represents the tweet.
	 */
	T t;
	/**
	 * Represents the twitter.
	 */
	TwitterApp twitter;
	
	
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
		
		JPanel tweet= new JPanel();
		tweet.setPreferredSize(new Dimension(730,380));
	 	c.gridx=0;
	 	c.gridy=0;
	 	c.gridheight=2;
	 	c.insets=new Insets(80, 0,0,0);
		tweet.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel(t.getName());
		tweet.add(lblNewLabel, BorderLayout.NORTH);
		
		JTextArea text = new JTextArea();
		text.append(t.getText());
		text.setEditable(false);
		tweet.add(text, BorderLayout.CENTER);
	
		background.add(tweet,c);

		launcher.add(background);
		launcher.setSize(800, 600);
		launcher.pack();
	 }
	
	}