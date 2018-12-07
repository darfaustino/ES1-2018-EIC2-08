package BDA;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Class that opens Email Response Form. 
 * @author Diogo
 *
 */

public class GuiResponse {

	private JFrame launcher;
	private Email email;
	private String username;
	private String password;
	
	/**
	 * Contructor, it initiates the frame and builds the Email Response Form GUI.
	 * @param launcher frame to be initiated;
	 * @param email  the Email which you want to respond.
	 * @param username Mail account email
	 * @param password Mail account password
	 */
	
	public GuiResponse(String username, String password, JFrame launcher, Email email) {
		this.launcher = launcher;
		this.email=email;
		this.username=username;
		this.password=password;
		init();
	}

	
	/**
	 * Launches and builds the Email Response Window.
	 * Initiates the frame components (JLabels,JTextPanes, JPanels , JTextField ).
	 * Adds an MouseListener to the JLabel.
	 * Puts everything in the correct positions. 
	 */
	
	private void init() {
		// TODO Auto-generated method stub
		
		launcher.getContentPane().removeAll();
		launcher.setContentPane(new JLabel(new ImageIcon("images\\emailsingular.png")));
		launcher.setLayout(new GridLayout(1,0));
		
		
		JPanel form=new JPanel();
		form.setPreferredSize(new Dimension(600, 600));
		form.setLayout(null);
		form.setOpaque(false);
		
		JLabel to=new JLabel("To:");
		JLabel email1=new JLabel(email.getFrom());
		JLabel assunto=new JLabel("Assunto:");
		JLabel message=new JLabel("Message:");
		JLabel enviar=new JLabel(new ImageIcon("images/enviar.png"));
		enviar.setPreferredSize(new Dimension(300,70));
		
		JTextField textto=new JTextField();
		JTextField textass=new JTextField();
		JTextArea messagetext=new JTextArea();
		
		
		enviar.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
				enviar.setEnabled(false);
				Mail.SendMail(email.getMsm(), messagetext.getText(),username, password);
				launcher.dispose();
				
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
		
		
		to.setBounds(90, 100, 20, 30);
		email1.setBounds(130, 90, 600, 50);
		assunto.setBounds(60, 150, 100, 30);
		message.setBounds(60, 200, 120, 30);
		
		textass.setBounds(130, 150, 620, 40);
		messagetext.setBounds(130, 200, 620, 250);
		enviar.setBounds(450, 500, 300, 70);
		
		
		form.add(assunto);
		form.add(to);
		form.add(message);
		form.add(textass);
		form.add(messagetext);
		form.add(enviar);
		form.add(email1);
		launcher.add(form);
		launcher.setSize(799,599);
		launcher.setSize(800,600);
		
		
	}
	
	/**
	 * Gets the JFrame that serves as launcher of the window.
	 * @return launcher
	 */

	public JFrame getLauncher() {
		return launcher;
	}
	
	
	
}
