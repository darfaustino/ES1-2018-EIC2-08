package JUnitTests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import org.junit.Test;

import BDA.Background;
import BDA.T;
import BDA.Tweet;
import BDA.TwitterApp;

public class Tweet_init {

	@Test
	public void test() {
		TwitterApp ta = new TwitterApp("djruORHuSHJcsJW060wtuGowg","LzofRAO9R7a8sZIDofWXoix6gtXiS43MzFsrFrlqiIeKo66Ly5","1063486441114820608-2pujB6rSntopZvEd6ENTrt3gOPspgv","DTB1yFxV0pelfd9BlbBbYar6GE34rbGHA6ceDBs0beCnd");
		T s = new T ("x","y",new Date());
		Tweet t= new Tweet(ta, s);
		assertNotNull(ta);
		assertNotNull(s);
		assertNotNull(t);
		
		
//		frame
		Background background=null;
		try {
			background=new Background("images/backtweet.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(background);
		
		
		
//      JLabel button	
		JLabel r=new JLabel(new ImageIcon("images/btnret.png"));		
		assertNotNull(r);
		
//      JLabel name	
		JLabel lblNewLabel = new JLabel(s.getName());
		assertTrue(lblNewLabel.getText().equals(s.getName()));
		
//      JArea text
		JTextArea text = new JTextArea();
		text.append(s.getText());
		assertTrue(text.getText().equals(s.getText()));
		
	}

}
