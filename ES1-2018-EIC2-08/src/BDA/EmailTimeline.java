package BDA;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * Class shows a GUI with timeline exclusive of emails.
 * @author Diogo
 *
 */

public class EmailTimeline {
	public	JFrame launcher;
	
	/**
	 * Contructor, It calls the method init and creates the EmailTimeline GUI.
	 */
	
	public EmailTimeline(){
		try {
			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	
	/**
	 * Launches and builds the Email Timeline window.
	 * Initiates the frame components (JLabels,JPanels, JTextPane).
	 * Puts everything in the correct positions. 
	 * @throws IOException I/O exception of some sort has occurred
	 */
	
	public void init() throws IOException {
		
		//SettingsJFrame
		launcher = new JFrame("BOM DIA ACADEMIA!");
		launcher.setResizable(false);
		launcher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		launcher.setLayout(new BorderLayout());
		launcher.setVisible(true);
		
		//Background
		Background background=new Background("images/emailtimeline.png");
		background.setLayout(new BorderLayout());
		background.setPreferredSize(new Dimension(800,600));
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


	public static void main(String args[]){
	    new EmailTimeline();

	}
	}