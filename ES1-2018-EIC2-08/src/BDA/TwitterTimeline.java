package BDA;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import twitter4j.TwitterException;

import java.awt.*;
import java.io.IOException;


/**Represents the twitter time line's Frame.
 * 
 * 
 */

public class TwitterTimeline {
	/**
	 * Represents the frame.
	 */
	public	JFrame launcher;
	/**
	 * Represents the tweet's list.
	 */
	JList <T> tweets;
	/**
	 * Represents the twitter.
	 */
	TwitterApp t;
	
	
	/**
	 * Class constructor, creates a frame with the tweets posted recently.
	 * 
	 */
	public TwitterTimeline() throws TwitterException{
		try {
			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	/**
	 * Frame's creation and customization.
	 * 
	 */
	public void init() throws IOException, TwitterException {
		
		//SettingsJFrame
		launcher = new JFrame("BOM DIA ACADEMIA!");
		launcher.setResizable(false);
		launcher.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		launcher.setLayout(new BorderLayout());
		launcher.setVisible(true);
		
		//Background
		Background background=new Background("images/twittertimeline.png");
		background.setLayout(new GridBagLayout());
		background.setPreferredSize(new Dimension(800,600));

		
		JPanel twitter= new JPanel();
		twitter.setPreferredSize(new Dimension(730,380));
	 	GridBagConstraints c=new GridBagConstraints();
	 	c.gridx=0;
	 	c.gridy=0;
	 	c.gridheight=2;
	 	c.insets=new Insets(80, 0,0,0);
		background.add(twitter,c);
		
		
		t= new TwitterApp(null, null, null, null); 
		tweets=new JList<T>(t.getTimeline());
		
		((DefaultListCellRenderer) tweets.getCellRenderer()).setOpaque(false);
		tweets.setFixedCellHeight(60);
		tweets.setBorder(new EmptyBorder(10, 5, 10, 0));
		tweets.setOpaque(false);
		tweets.setPreferredSize(new Dimension(240, 600));
		
		tweets.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				if (tweets.getSelectedValue() != null && !e.getValueIsAdjusting()) {
					T selectedValue = tweets.getSelectedValue();
					new Tweet(t, selectedValue);
				}
			}
		});

		JScrollPane scroll=new JScrollPane(tweets);
		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);
		scroll.setPreferredSize(new Dimension(730,380));
		
		twitter.add(scroll);
		background.add(twitter);
		
		launcher.add(background);
	 	launcher.setSize(800, 600);
	 	launcher.pack();

		

	 }
	
	/**
	 * Starts the time line.
	 * @param args is not used. 
	 */
	public static void main(String args[]) throws TwitterException{
	    new TwitterTimeline();

	}
	}