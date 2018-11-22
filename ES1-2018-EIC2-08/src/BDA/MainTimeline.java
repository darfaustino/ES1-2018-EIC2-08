package BDA;

import javax.mail.Message;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.restfb.types.Post;
import twitter4j.TwitterException;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class MainTimeline {

public	JFrame launcher;
	
public MainTimeline() throws TwitterException{
	try {
		init();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}	

public void init() throws IOException, TwitterException {
	
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
	facebook.setOpaque(false);
	facebook.setPreferredSize(new Dimension(245,490));
	c.gridx=1;
	c.gridy=0;
	c.gridheight=3;
	c.insets=new Insets(70,15,0,15);
	background.add(facebook,c);
	
	JPanel twitter= new JPanel();
	twitter.setOpaque(false);
	twitter.setPreferredSize(new Dimension(245,490));
	c.gridx=2;
	c.gridy=0;
	c.gridheight=3;
	c.insets=new Insets(70, 0,0,0);
	background.add(twitter,c);
	
	JList<Email> emails=new JList<Email>(Mail.LoginMail());
	System.out.println(Mail.LoginMail().size());
	((DefaultListCellRenderer)emails.getCellRenderer()).setOpaque(false);
	emails.setFixedCellHeight(70);
	emails.setBorder(new EmptyBorder(10,5, 10, 0));
	emails.setOpaque(false);

	emails.addListSelectionListener( new ListSelectionListener() {
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			
			if (emails.getSelectedValue() != null && !e.getValueIsAdjusting()) {
				Email selectedValue = emails.getSelectedValue();
				System.out.println("Body:"+ selectedValue.getBody());
				new EmailSingular(selectedValue);
			}
		}
	});
	
	
	JScrollPane scroll=new JScrollPane(emails);
	scroll.setOpaque(false);
	scroll.getViewport().setOpaque(false);
	scroll.setPreferredSize(new Dimension(250,500));
	email.add(scroll);
	
	
	Facebook face= new Facebook();
	JList<FacePost> facePosts=new JList<FacePost>(face.getTimeLinePosts());//filtro retirado pra teste
	((DefaultListCellRenderer)facePosts.getCellRenderer()).setOpaque(false);
	facePosts.setFixedCellHeight(70);
	facePosts.setBorder(new EmptyBorder(10,5, 10, 0));
	facePosts.setOpaque(false);

	facePosts.addListSelectionListener( new ListSelectionListener() {
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			
			if (facePosts.getSelectedValue() != null && !e.getValueIsAdjusting()) {
				FacePost selectedValue = facePosts.getSelectedValue();
				new FacebookPost(selectedValue);
			}
		}
	});
	
	
	JScrollPane scroll2=new JScrollPane(facePosts);
	scroll2.setOpaque(false);
	scroll2.getViewport().setOpaque(false);
	scroll2.setPreferredSize(new Dimension(250,500));
	facebook.add(scroll2);
	
	TwitterApp t= new TwitterApp();
	JList <T> tweets=new JList<T>(t.getTimeline());
	((DefaultListCellRenderer)tweets.getCellRenderer()).setOpaque(false);
	tweets.setFixedCellHeight(70);
	tweets.setBorder(new EmptyBorder(10,5, 10, 0));
	tweets.setOpaque(false);

	tweets.addListSelectionListener( new ListSelectionListener() {
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			
			if (tweets.getSelectedValue() != null && !e.getValueIsAdjusting()) {
				T selectedValue = tweets.getSelectedValue();
				new Tweet(t, selectedValue);
			}
		}
	});
	
	
	JScrollPane scroll3=new JScrollPane(tweets);
	scroll3.setOpaque(false);
	scroll3.getViewport().setOpaque(false);
	scroll3.setPreferredSize(new Dimension(250,500));
	twitter.add(scroll3);
	
	
	launcher.add(background);
	launcher.setSize(800, 600);
	launcher.pack();
	
	

 }

public static void main(String args[]) throws TwitterException{
    new MainTimeline();
}


}