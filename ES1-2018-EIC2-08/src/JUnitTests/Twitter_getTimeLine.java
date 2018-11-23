package JUnitTests;

import static org.junit.Assert.*;
import org.junit.Test;

import BDA.T;
import BDA.TwitterApp;

import java.util.List;

import javax.swing.DefaultListModel;

import twitter4j.Status;
import twitter4j.TwitterException;


public class Twitter_getTimeLine {
	
	@Test
	public void test() {
		TwitterApp ta = new TwitterApp("djruORHuSHJcsJW060wtuGowg","LzofRAO9R7a8sZIDofWXoix6gtXiS43MzFsrFrlqiIeKo66Ly5","1063486441114820608-2pujB6rSntopZvEd6ENTrt3gOPspgv","DTB1yFxV0pelfd9BlbBbYar6GE34rbGHA6ceDBs0beCnd");
		DefaultListModel<T> test= new DefaultListModel <T> ();
		try {
			test = ta.getTimeline();
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		for (int i =0; i<test.size();i++) {
			assertNotNull(test.getElementAt(i));
		}
	}

}
