package BDA;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Class that changes email of the BDA account.
 */

public class ChangeMail {
	private JFrame launcher;
	private String email;

	/**
	 * Class that allows the user to change his password.
	 * @param email		The User's Login mail of the BDA application.
	 */
	
	public ChangeMail(String email){
		this.email=email;
		init();
	}
	
	/**
	 * Launches and builds the change password window.
	 * Initiates the frame components (JLabels,	JPasswordField, JTextFields and JButton).
	 * Adds an actionlistener to the button.
	 * Puts everything in the correct positions.
	 */

	private void init() {
		// SettingsJFrame
		launcher = new JFrame("BOM DIA ACADEMIA!");
		launcher.setResizable(false);
		launcher.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		launcher.setVisible(true);

		// Dar Refresh

		launcher.pack();
		launcher.setSize(800, 600);

		// Background
		launcher.setContentPane(new JLabel(new ImageIcon("images\\background.png")));

		// Imagens
		JLabel logo = new JLabel(new ImageIcon("images\\logo.png"));
		// JLabel signup=new JLabel(new ImageIcon("images\\signup.png"));

		launcher.setLayout(new GridLayout(1, 2));
		JPanel signform = new JPanel();
		signform.setOpaque(false);
		signform.setLayout(null);

		JLabel l1 = new JLabel("Email");
		JLabel l2 = new JLabel("New Email");
		JLabel l3 = new JLabel("Password");

		Cursor cur = new Cursor(Cursor.HAND_CURSOR);

		JTextField mail = new JTextField();
		JTextField newMail = new JTextField();
		JPasswordField pass = new JPasswordField();

		JButton btn1 = new JButton("Done");
		btn1.setCursor(cur);

		// signup.setBounds(35,-50,400,400);
		l1.setForeground(Color.black);
		l2.setForeground(Color.black);
		l3.setForeground(Color.black);

		l1.setBounds(100, 180, 200, 30);
		mail.setBounds(100, 210, 200, 30);
		l2.setBounds(100, 240, 200, 30);
		newMail.setBounds(100, 270, 200, 30);
		l3.setBounds(100, 300, 200, 30);
		pass.setBounds(100, 330, 200, 30);
		btn1.setBounds(160, 430, 100, 30);

		// signform.add(signup);
		signform.add(l1);
		signform.add(mail);
		signform.add(l2);
		signform.add(newMail);
		signform.add(l3);
		signform.add(btn1);
		signform.add(pass);

		launcher.add(logo);
		launcher.add(signform);

		// Dar Refresh
		launcher.setSize(799, 599);
		launcher.setSize(800, 600);

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (newMail.getText().contains("@iscte-iul.pt") && pass.getPassword().length != 0 && mail.getText().contains("@iscte-iul.pt")) {
					change(newMail.getText(), pass.getPassword());
				} else if (!newMail.getText().contains("@iscte-iul.pt") || !mail.getText().contains("@iscte-iul.pt")) {
					JOptionPane.showMessageDialog(new JFrame(), "You must use a ISCTE email");
				} else if (pass.getPassword().length == 0) {
					JOptionPane.showMessageDialog(new JFrame(), "You must insert a password");
				}
			}
		});
	}
	
	/**
	 * Checks the if the user email and password are correct.
	 * If case they aren´t correct it displays a message informing the user.
	 * Else it changes the user email, saves the changes in the XML file and opens the login window.
	 * 
	 * @param newMail		The user new email.
	 * @param pass			The user password.
	 */
	private void change(String newMail, char[] pass){
		File file = new File("config.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		boolean foundMail = false,foundPass = false;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();

			NodeList list = doc.getChildNodes().item(0).getChildNodes();
			
			for (int count = 0; count < list.getLength(); count++) {
				Node tempNode = list.item(count);
				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
					if (tempNode.hasAttributes()) {
						if (((Element) tempNode).getAttribute("Email").equals(email)) {
							foundMail = true;
							if (((Element) tempNode).getAttribute("Password").equals(new String(pass))) {
								((Element) tempNode).setAttribute("Email", newMail);
								foundPass = true;
								break;
							}
						}
					}
				}
			}
			if (foundMail && foundPass) {
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				StreamResult result = new StreamResult(new FileOutputStream("config.xml"));
				DOMSource source = new DOMSource(doc);
				transformer.transform(source, result);
				new Login(launcher);
			} else if (!foundMail) {
				JOptionPane.showMessageDialog(new JFrame(), "The old email is incorrect");
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "The password is incorrect");
			}
		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e1) {
			e1.printStackTrace();
		}		
	}
}
