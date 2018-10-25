package Projeto;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import java.awt.*;
	import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

	
public class SignUp {
	

		private	JFrame launcher;
		private JLabel  l1, l2, l3, l4;
		private JTextField tf1;
		private JButton btn1;
		private JPasswordField p1;
		
		public SignUp(JFrame launcher2){
			this.launcher=launcher2;
			init();
		}


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
					
					openMailForm(email_txt.getText(), p1.getPassword(), tf1.getText());
					
					
				}
			});;
		}


	public static void SaveXML(String Mainemail, char[] Mainpassword, String name, String email, char[] password){
		try {
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
					
					SaveXML(mainemail, mainpassword, name, email_txt.getText(), p1.getPassword());
					
				}
			});
			
			//Dar Refresh
			launcher.setSize(799,599);
			launcher.setSize(800,600);
		
	}


	public JFrame getLauncher() {
		return launcher;
	}


	public JLabel getL1() {
		return l1;
	}


	public JLabel getL2() {
		return l2;
	}


	public JLabel getL3() {
		return l3;
	}


	public JLabel getL4() {
		return l4;
	}


	public JTextField getTf1() {
		return tf1;
	}


	public JButton getBtn1() {
		return btn1;
	}

	
	public JPasswordField getP1() {
		return p1;
	}
		
		
		
		
}