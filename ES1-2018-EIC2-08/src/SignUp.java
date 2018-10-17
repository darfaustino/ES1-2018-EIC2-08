import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;

	
public class SignUp {
	

		private	JFrame launcher;
		private JLabel  l1, l2, l3, l4, l5;
		private JTextField tf1;
		private JButton btn1;
		private JPasswordField p1;
		
		SignUp(){

			init();
		}


		private void init() {
			
			//SettingsJFrame
			JFrame launcher = new JFrame("BOM DIA ACADEMIA!");
			launcher.setVisible(true);
			launcher.setSize(800, 600);
			launcher.setResizable(false);
			launcher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			launcher.setLayout(new BorderLayout());
			
			//Background
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
			  
			  
			  btn1 = new JButton("Submit");
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
		}









		public static void main(String args[]){
		    new SignUp();
		}





		}