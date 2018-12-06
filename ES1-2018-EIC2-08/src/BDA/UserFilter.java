package BDA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import twitter4j.TwitterException;

public class UserFilter extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JList<FacePost>facePosts;
	private JList<Email> emails;
	private JList<T> tweets;
	
	

	
	/**
	 * Create the frame.
	 * @param tweets 
	 * @param emails 
	 * @param facePosts 
	 */
	public UserFilter(JList<FacePost> facePosts, JList<Email> emails, JList<T> tweets) {
		this.facePosts=facePosts;
		this.emails=emails;
		this.tweets=tweets;
		setTitle("User Filter");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 333, 77);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Filter");
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					userFilter(textField.getText());
				} catch (TwitterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}});
		setVisible(true);
	}
	
	public void userFilter(String s) throws TwitterException {
		DefaultListModel<Email> e = new DefaultListModel<>();
		DefaultListModel<FacePost> f = new DefaultListModel<>();
		DefaultListModel<T> t = new DefaultListModel<>();

		for (int i = 0; i < tweets.getModel().getSize(); i++) {
			if (tweets.getModel().getElementAt(i).name.equals(s)) {
				t.addElement(tweets.getModel().getElementAt(i));
			}
		}
		for (int j = 0; j < emails.getModel().getSize(); j++) {
			if (emails.getModel().getElementAt(j).from.equals(s)) {
				e.addElement(emails.getModel().getElementAt(j));
			}
		}

		emails.setModel(e);
		facePosts.setModel(f);
		tweets.setModel(t);
	}

}

