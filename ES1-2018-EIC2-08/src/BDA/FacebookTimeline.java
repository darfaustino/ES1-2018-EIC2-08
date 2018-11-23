package BDA;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

	/** 
	 * Facebook TimeLine.
	 *
	 */

public class FacebookTimeline {
	
	private Facebook face;
	
	/**
	 * Constructor, it initializes the Facebook and tries to start the GUI.
	 * When the GUI is started it will show a list of posts from Facebook.
	 * 
	 * @param f		The name of the Facebook that is on the FacebookTimeline.
	 */
	
	public FacebookTimeline(Facebook f){
		face=f;
		try {
			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	/**
	 * 
	 * @return		Returns the Facebook of the FacebookTimeline.
	 */
	
	public Facebook getFacebook(){
		return face;
	}

	/**
	 * Launches and builds the FacebookTimeline GUI.
	 * Initiates the frame and its components (JLabel,JScrollPane,Background, JPanel, and JList).
	 * Adds a ListSelectionListener to the JList.
	 * Puts everything in the correct positions. 
	 * 
	 * @throws IOException		If the Background image is not found.
	 */
	
	
	
	private void init() throws IOException {
		
		//SettingsJFrame
		JFrame launcher = new JFrame("BOM DIA ACADEMIA!");
		launcher.setResizable(false);
		launcher.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		launcher.setLayout(new BorderLayout());
		launcher.setVisible(true);
		
		//Background
		Background background=new Background("images/facebooktimeline.png");
		background.setLayout(new GridBagLayout());
		background.setPreferredSize(new Dimension(800,600));

		GridBagConstraints c=new GridBagConstraints();
		c.gridx=0;
		c.gridy=0;
		c.gridheight=2;
		c.insets=new Insets(80, 0, 0, 0);
		
		JPanel panel=new JPanel();
		panel.setPreferredSize(new Dimension(730,380));
		panel.setOpaque(false);
		background.add(panel, c);
		
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
		scroll2.setPreferredSize(new Dimension(720,375));
		panel.add(scroll2);
		
		
		JLabel r=new JLabel(new ImageIcon("images/responder.png"));
		r.setPreferredSize(new Dimension(300,70));
		c.gridx=0;
		c.gridy=2;
		c.insets=new Insets(15, 0, 0, 0);
		background.add(r,c);
		
		
		launcher.add(background);
		launcher.setSize(800, 600);
		launcher.pack();

	 }
}