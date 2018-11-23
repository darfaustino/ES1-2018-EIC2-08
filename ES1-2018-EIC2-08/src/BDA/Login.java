package BDA;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import twitter4j.TwitterException;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Login {
	
	/**
	 * Login window.
	 */
	
	private	JFrame launcher;
	private JLabel  l1, l2;
	private JTextField tf1;
	private JButton btn1;
	private JPasswordField p1;
	private boolean Found;
	
	
	/**
	 * Constructor, calls method init() and builds the login window.
	 * @param launcher JFrame of the form
	 */
	
	
	public Login(JFrame launcher){
		this.launcher=launcher;
		init();
	}


	/**
	 * Launches and builds login window
	 * Initiates the frame components (JLabels,JTextFields,	JPasswordField, and JButtons).
	 * Adds an actionlistener to the button, which can login the Email, Facebook and Twitter if the respective account exists.
	 * Puts everything in the correct positions.
	 */
	
	private void init() {
		
		
		//Background
		launcher.getContentPane().removeAll();
		launcher.setContentPane(new JLabel(new ImageIcon("images\\background.png")));
		
		//Imagens
		JLabel logo=new JLabel(new ImageIcon("images\\logo.png"));
		JLabel login=new JLabel(new ImageIcon("images\\login.png"));
		
		launcher.setLayout(new GridLayout(1,2));
		JPanel loginform= new JPanel();
		loginform.setOpaque(false);
		loginform.setLayout(null);
		
		
		
		
		Cursor cur=new Cursor(Cursor.HAND_CURSOR);
		
		  l1 = new JLabel("Username");
		  l2 = new JLabel("Password");
		  tf1 = new JTextField();
		  p1 = new JPasswordField();
		  btn1 = new JButton("Login");
		  btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String email=tf1.getText();
				char[] pass=p1.getPassword();
				String ftoken="";
				String ttoken="";
				String username="";
				String password="";
				Found=false;
				
				
				
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

								if (((Element) tempNode).getAttribute("Email").equals(email)
										&& ((Element) tempNode).getAttribute("Password").equals(new String(pass))) {
									NodeList childs=tempNode.getChildNodes();
									Found=true;
									for(int i=0; i<childs.getLength(); i++){
										Node temp=childs.item(i);
									
										if(temp.hasAttributes()){
											if(((Element) temp).hasAttribute("Facebook")){
												ftoken=((Element) temp).getAttribute("Facebook");
											}
											if(((Element) temp).hasAttribute("Twitter")){
												ttoken=((Element) temp).getAttribute("Twitter");
												System.out.println(ttoken);
											}
											if(((Element) temp).hasAttribute("Email") && ((Element) temp).hasAttribute("Password")){
												username=((Element) temp).getAttribute("Email");
												password=((Element) temp).getAttribute("Password");
											}
											
										}
									}
									break;
									
								}
							}

						}

					}
					if(Found){
						try {
							
							Facebook face=new Facebook(ftoken);
							String[] tokens=ttoken.split(";");
							System.out.println(tokens);
							TwitterApp twitter=new TwitterApp(tokens[0], tokens[1], tokens[2], tokens[3]);
							launcher.dispose();
							new MainTimeline(face, twitter, username, password);
						} catch (TwitterException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else{
						JOptionPane.showMessageDialog(new JFrame(), "Error! Login Failed, please try gain!");
						
					}
					
				} catch (ParserConfigurationException | SAXException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
		});
		  JLabel text=new JLabel("Não tem conta, registe-se");
		 JButton here=new JButton("<HTML><FONT color=\"#000099\"><U>aqui</U></FONT></HTML>");
		 here.setBorderPainted(false);
		 here.setOpaque(false);
		 here.setBackground(Color.WHITE);
		 text.setBounds(120, 400, 200, 30);
		 here.setBounds(232, 400, 100, 30);
		 
		 here.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				new SignUp(launcher);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		 
		  btn1.setCursor(cur);
		  
		  login.setBounds(35,20,400,400);
		  l1.setForeground(Color.black);
		  l2.setForeground(Color.black);
		  l1.setBounds(50, 270, 200, 30);
		  l2.setBounds(50, 330, 200, 30);
		  tf1.setBounds(120, 270, 200, 30);
		  p1.setBounds(120, 330, 200, 30);
		  btn1.setBounds(160, 370, 100, 30);
		  
		  loginform.add(login);
		  loginform.add(l1);
		  loginform.add(tf1);
		  loginform.add(l2);
		  loginform.add(p1);
		  loginform.add(btn1);
		  loginform.add(text);
		  loginform.add(here);


		
		launcher.add(logo);
		launcher.add(loginform);
	
		//Dar Refresh
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

	/**
	 * Gets the JLabel l1.
	 * @return l1
	 */
	public JLabel getL1() {
		return l1;
	}

	/**
	 * Gets the JLabel l2.
	 * @return l2
	 */

	public JLabel getL2() {
		return l2;
	}

	/**
	 * Gets the JTextField tf1.
	 * @return tf1
	 */

	public JTextField getTf1() {
		return tf1;
	}

	/**
	 * Gets the JButton btn1
	 * @return btn1
	 */
	public JButton getBtn1() {
		return btn1;
	}

	/**
	 * Gets the JPasswordField p1
	 * @return p1
	 */
	public JPasswordField getP1() {
		return p1;
	}




	}

