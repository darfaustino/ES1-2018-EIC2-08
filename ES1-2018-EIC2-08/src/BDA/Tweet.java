package BDA;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Tweet {
	public	JFrame launcher;
	
	public Tweet(){
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
		launcher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		launcher.setLayout(new BorderLayout());
		launcher.setVisible(true);
		
		//Background
		Background background=new Background("images/twittersingular.png");
		background.setLayout(new BorderLayout());
		background.setPreferredSize(new Dimension(800,600));
		launcher.add(background);
		launcher.setSize(800, 600);
		launcher.pack();

	 }
	public static void main(String args[]){
	    new Tweet();

	}
	}