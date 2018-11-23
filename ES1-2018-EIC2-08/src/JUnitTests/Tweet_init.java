package JUnitTests;

import static org.junit.Assert.*;

import java.io.IOException;

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
		TwitterApp ta = new TwitterApp("W1f0VvgWPfT8OBqVxvy4Mw","zKH2yAtRyefwsgOO8h8Szc4kru68iEm95QmIG7svw","36481851-VhzByC4f9MSsZES1QZQ4e4iBvA9bWGLyv9HKFpy7c","OahDuXF2Lhl5xlNYALhYZir6xSflAxKP9Zh89T05po");
		T s = new T ("x","y");
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
		JLabel lblNewLabel = new JLabel(s.name);
		assertTrue(lblNewLabel.getText().equals(s.name));
		
//      JArea text
		JTextArea text = new JTextArea();
		text.append(s.text);
		assertTrue(text.getText().equals(s.text));
		
	}

}
