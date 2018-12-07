package BDA;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

	/**
	 * This class updates the window frame and displays the sign up form of our BDA application. 
	 * Also saves the user info in a xml file named config.xml.
	 *  
	 */

public class SignUp {

		private	JFrame launcher;
		private JLabel  l1, l2, l3, l4;
		private JTextField tf1;
		private JButton btn1;
		private JPasswordField p1;
		
		
		/**
		 * Class constructor, creates a Sign Up form.
		 * @param	 launcher2 the frame to add the components. 
		 */
		
		public SignUp(JFrame launcher2){
			this.launcher=launcher2;
			init();
		}

		/**
		 * Updates the previous window frame to the SignUp frame and opens the first part of the form, where the user creates an Account for the BDA application.
		 * Initiates the frame components (JLabels,JTextFields,	JPasswordField, and JButtons).
		 * Adds an ActionListener to the buttons.
		 * Places every component in the correct position.
		 */

		private void init() {
		
			
			//Background
			launcher.getContentPane().removeAll();
			launcher.setContentPane(new JLabel(new ImageIcon("images\\background.png")));
			
			//Imagens
			JLabel logo=new JLabel(new ImageIcon("images\\logo.png"));
			JLabel signup=new JLabel(new ImageIcon("images\\signup.png"));
			
			launcher.setLayout(new GridLayout(1,2));
			JPanel signform= new JPanel();
			signform.setOpaque(false);
			signform.setLayout(null);
			
			
			
			
			 
			  l1 = new JLabel("Name");
			  l2 = new JLabel("Password");
			  l3=  new JLabel("Gender");
			  
			  l4= new JLabel("Email");
			  
			  Cursor cur=new Cursor(Cursor.HAND_CURSOR);
			 
			  JRadioButton male=new JRadioButton("Male");
			  male.setCursor(cur);
			  JRadioButton female=new JRadioButton("Female");
			  female.setCursor(cur);
			  
			  ButtonGroup gender_grp=new ButtonGroup();
			  gender_grp.add(male);
			  gender_grp.add(female);
			  
			 
			  JTextField email_txt=new JTextField();
			  
			  tf1 = new JTextField();
			  p1 = new JPasswordField();
			  
			  
			  btn1 = new JButton("Next");
			  btn1.setCursor(cur);
			  
			  signup.setBounds(35,-50,400,400);
			  l1.setForeground(Color.black);
			  l2.setForeground(Color.black);
			  p1.setBounds(120, 270, 200, 30);
			  l3.setForeground(Color.black);
			  l4.setForeground(Color.black);
			  
			  l1.setBounds(50, 210, 200, 30);
			  tf1.setBounds(120, 210, 200, 30);
			  l2.setBounds(50, 270, 200, 30);
			  l3.setBounds(50,330,200,30);
			  male.setBounds(120, 330, 80, 30);
			  female.setBounds(180, 330, 80, 30);
			  male.setOpaque(false);
			  female.setOpaque(false);
			  l4.setBounds(50, 390, 200, 30);
			  email_txt.setBounds(120, 390, 200, 30);			 
			  btn1.setBounds(160, 430, 100, 30);
			  
			  signform.add(signup);
			  signform.add(l1);
			  signform.add(tf1);
			  signform.add(l2);
			  signform.add(l3);
			  signform.add(male);
			  signform.add(female);
			  signform.add(p1);
			  signform.add(l4);
			  signform.add(email_txt);
			  signform.add(btn1);

			
			launcher.add(logo);
			launcher.add(signform);
		
			//Dar Refresh
			launcher.setSize(799,599);
			launcher.setSize(800,600);
			
			
			btn1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					if(email_txt.getText().contains("@iscte-iul.pt") && p1.getPassword().length!=0){
						if(!duplicateMail(email_txt.getText())){
							openMailForm(email_txt.getText(), p1.getPassword(), tf1.getText());
						}else{
							JOptionPane.showMessageDialog(new JFrame(), "There's already one account with that email");
						}
					}else{
						if(p1.getPassword().length==0){
							JOptionPane.showMessageDialog(new JFrame(), "You must insert a password");
						}else{
						JOptionPane.showMessageDialog(new JFrame(), "You must use a ISCTE email");
					}
					}		
					
				}
			});;
		}

		
		/**
		 * It checks if the email isn't already present in an account.
		 * @param email		email that is going to be compared to the user's mails.
		 * @return			true if is a duplicate or false otherwise.
		 */
		
		public boolean duplicateMail(String email) {
			boolean duplicate=false;
			File file = new File("config.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
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
								duplicate=true;
								break;	
							}
						}
					}
				}
					
			} catch (ParserConfigurationException | SAXException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return duplicate;
		}
		
		/**
		 * It checks if a file named "config.xml" exists.
		 * If exists, it adds a new child Node("Account") to the file with the info of a new created account.
		 * If not, it creates the file, creates a ParentNode("ISCTEAccounts") and adds a new  child Node("Account") to the file with the info of a new created account.
		 * Also adds 2 child Node ("Facebook") and ("Twitter") to the Parent Node ("Account") with the respective access token in the Attributes.
		 * @param Mainemail The User's Login mail of the BDA application.
		 * @param Mainpassword The User's Login password of the BDA application.
		 * @param name The User's name.
		 * @param email The User's email account 
		 * @param password The User's email account password.
		 */

	public static void SaveXML(String Mainemail, char[] Mainpassword, String name, String email, char[] password){
		try {
			
		String facetoken="EAADoYhkS7RcBAEKHnrBd4T60iYQZCm1jfrK4xpq1quSDLCcQW7tAOXIw5TiK26A1MVZBTCV2jcijb8"
				+ "cdV1BtMuSZCOBdYRcDAMINHo7j4ws6F76RZC1uWuK18sZAZAZCSl99RXPJERm8okjSfMptfZCUKCc40KjUeEdtMi0a23ZCFJQZDZD";

		String twittertoken="djruORHuSHJcsJW060wtuGowg;LzofRAO9R7a8sZIDofWXoix6gtXiS43MzFsrFrlqiIeKo66Ly5;1063486441114820608-2pujB6rSntopZvEd6ENTrt3gOPspgv;DTB1yFxV0pelfd9BlbBbYar6GE34rbGHA6ceDBs0beCnd";
			
		File inputFile = new File("config.xml");
		Document doc;
		Element rootElement;
		if(inputFile.exists()){
			System.out.println("existe");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
		dBuilder = dbFactory.newDocumentBuilder();
         doc = dBuilder.parse(inputFile);
         rootElement=doc.getDocumentElement();
        		 
		}else{
			 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		     DocumentBuilder dBuilder;
			 dBuilder = dbFactory.newDocumentBuilder();
		     doc = dBuilder.newDocument();
		     rootElement = doc.createElement("ISCTEAccounts");
		     doc.appendChild(rootElement);
		}

		
        
		 Element newElement1 = doc.createElement("Account");
         newElement1.setAttribute("Email", Mainemail);
         newElement1.setAttribute("Name", name );
         newElement1.setAttribute("Password",new String(Mainpassword));
         rootElement.appendChild(newElement1);
         
         Element mail=doc.createElement("EmailAccount");
         mail.setAttribute("Email", email);
         mail.setAttribute("Password", new String(password));
         newElement1.appendChild(mail);
         
         Element facebook=doc.createElement("Facebook");
         facebook.setAttribute("Facebook", facetoken);
         newElement1.appendChild(facebook);
         
         Element twitter=doc.createElement("Twitter");
         twitter.setAttribute("Twitter", twittertoken);
         newElement1.appendChild(twitter);      
         
         Transformer transformer = TransformerFactory.newInstance().newTransformer();
         transformer.setOutputProperty(OutputKeys.INDENT, "yes");
         StreamResult result = new StreamResult(new FileOutputStream("config.xml"));
         DOMSource source = new DOMSource(doc);
         transformer.transform(source, result);
         System.out.println("Saved");
      
         
         
		} catch (ParserConfigurationException | IOException | TransformerFactoryConfigurationError | TransformerException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Updates the previous window frame, and opens the second part of the Sign Up form, where the user adds his email account.
	 * @param mainemail The User's BDA application email.
	 * @param mainpassword The User's BDA application password
	 * @param name The User's name.
	 */
	
	
	public void openMailForm(String mainemail, char[] mainpassword, String name){
		
		//ClearForm
		launcher.getContentPane().removeAll();
		launcher.setContentPane(new JLabel(new ImageIcon("images\\background.png")));
		
		//DesignMail
		JLabel logo=new JLabel(new ImageIcon("images\\logo.png"));
		JLabel signup=new JLabel(new ImageIcon("images\\signupemail.png"));
		
		launcher.setLayout(new GridLayout(1,2));
		JPanel signform= new JPanel();
		signform.setOpaque(false);
		signform.setLayout(null);
		
		  l2 = new JLabel("Password");  
		  l4= new JLabel("Email");
		  JTextField email_txt=new JTextField();
		  p1 = new JPasswordField();
		  btn1=new JButton("Concluido!");
		  
		  signup.setBounds(35,-50,400,400);
		  l2.setForeground(Color.black);
		  p1.setBounds(120, 320, 200, 30);
		  l4.setForeground(Color.black);
		  
		  p1.setBounds(120, 320, 200, 30);
		  l2.setBounds(50, 320, 200, 30);
		  l4.setBounds(50, 280, 200, 30);
		  email_txt.setBounds(120, 280, 200, 30);			 
		  btn1.setBounds(160, 360, 100, 30);
		  
		  signform.add(signup);
		  signform.add(l2);
		  signform.add(p1);
		  signform.add(l4);
		  signform.add(email_txt);
		  signform.add(btn1);
		  
		  	launcher.add(logo);
			launcher.add(signform);
		
			//Listener
			
			btn1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					if(email_txt.getText().contains("@iscte-iul.pt")){
						SaveXML(mainemail, mainpassword, name, email_txt.getText(), p1.getPassword());
						new Login(launcher);
						}else{
							if(p1.getPassword().length==0){
								JOptionPane.showMessageDialog(new JFrame(), "You must insert a password");
							}else{
							JOptionPane.showMessageDialog(new JFrame(), "You must use a ISCTE email");
						}
						}	
					
					
					
				}
			});
			
			//Dar Refresh
			launcher.setSize(799,599);
			launcher.setSize(800,600);
		
	}

	/**
	 * Gets the displayed JFrame.
	 * @return the displayed JFrame
	 */

	public JFrame getLauncher() {
		return launcher;
	}

	/**
	 * Gets the first JLabel.
	 * @return the first JLabel
	 */

	public JLabel getL1() {
		return l1;
	}

	/**
	 * Gets the second JLabel.
	 * @return the second JLabel.
	 */

	public JLabel getL2() {
		return l2;
	}

	/**
	 * Gets the third JLabel
	 * @return the third JLabel
	 */
	public JLabel getL3() {
		return l3;
	}

	/**
	 * Gets the forth JLabel.
	 * @return the forth JLabel
	 */

	public JLabel getL4() {
		return l4;
	}

	/**
	 * Gets the JTextField
	 * @return the JTextField
	 */
	public JTextField getTf1() {
		return tf1;
	}

	/**
	 * Gets the displayed JButton
	 * @return the JButton
	 */
	public JButton getBtn1() {
		return btn1;
	}

	/**
	 * Gets the JPasswordField
	 * @return the JPasswordField
	 */
	public JPasswordField getP1() {
		return p1;
	}
		
		
		
		
}