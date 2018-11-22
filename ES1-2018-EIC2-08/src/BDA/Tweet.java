package BDA;

import javax.swing.*;

import twitter4j.TwitterException;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Tweet {
	public	JFrame launcher;
	T t;
	TwitterApp twitter;
	
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

	public void init() throws IOException {
		
		//SettingsJFrame
		launcher = new JFrame("BOM DIA ACADEMIA!");
		launcher.setResizable(false);
		launcher.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		launcher.setLayout(new BorderLayout());
		launcher.setVisible(true);
		
		//Background
		Background background=new Background("images/twittersingular.png");
		background.setLayout(new GridBagLayout());
		background.setPreferredSize(new Dimension(800,600));

		JPanel tweet= new JPanel();
		tweet.setPreferredSize(new Dimension(730,380));
//	 	GridBagConstraints c=new GridBagConstraints();
//	 	c.gridx=0;
//	 	c.gridy=0;
//	 	c.gridheight=2;
//	 	c.insets=new Insets(80, 0,0,0);
		
		
		
		
		tweet.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel(t.name);
		tweet.add(lblNewLabel, BorderLayout.NORTH);
		
		JTextArea text = new JTextArea();
		text.append(t.text);
		text.setEditable(false);
		tweet.add(text, BorderLayout.CENTER);

		

//		JButton b = new JButton ("Retweet");
//		b.addActionListener(new ActionListener() { 
//			  public void actionPerformed(ActionEvent e) { 
//			    try {
//					twitter.retweet(t);
//				} catch (TwitterException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			  } 
//			} );
//		
//		
		
		
		background.add(tweet);
//		background.add(b);
	
		
		
		
		launcher.add(background);
		launcher.setSize(800, 600);
		launcher.pack();
	 }
	
	}