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

public class DateFilter extends JFrame {

	
	private JPanel contentPane;
	private JTextField day;
	private JTextField month;
	private JTextField year;
	private JList<FacePost>facePosts;
	private JList<Email> emails;
	private JList<T> tweets;

	
	/**
	 * Create the frame.
	 */
	public DateFilter(JList<FacePost> facePosts, JList<Email> emails, JList<T> tweets) {
		this.facePosts=facePosts;
		this.emails=emails;
		this.tweets=tweets;
		setTitle("Date Filter");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 333, 77);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		day = new JTextField();
		contentPane.add(day);
		day.setColumns(10);
		
		month = new JTextField();
		contentPane.add(month);
		month.setColumns(10);
		
		year = new JTextField();
		contentPane.add(year);
		year.setColumns(10);
		
		JButton btnNewButton = new JButton("Filter");
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dateFilter(Integer.parseInt(day.getText()), Integer.parseInt(month.getText()), Integer.parseInt(year.getText()));
				} catch (TwitterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}});
		setVisible(true);
	}
	
	public void dateFilter(int day, int month, int year) throws TwitterException {
		DefaultListModel<Email> e = new DefaultListModel<>();
		DefaultListModel<FacePost> f = new DefaultListModel<>();
		DefaultListModel<T> t = new DefaultListModel<>();

		for (int i = 0; i < tweets.getModel().getSize(); i++) {
			if (tweets.getModel().getElementAt(i).date.getDay() == day
					&& tweets.getModel().getElementAt(i).date.getMonth() == month-1
					&& tweets.getModel().getElementAt(i).date.getYear() == year-1900) {
				t.addElement(tweets.getModel().getElementAt(i));
			}
		}
		for (int j = 0; j < emails.getModel().getSize(); j++) {
			if (emails.getModel().getElementAt(j).timestamp.getDay() == day
					&& emails.getModel().getElementAt(j).timestamp.getMonth() == month-1
					&& emails.getModel().getElementAt(j).timestamp.getYear() == year-1900) {
				e.addElement(emails.getModel().getElementAt(j));
			}
		}

		for (int k = 0; k < facePosts.getModel().getSize(); k++) {
			if (facePosts.getModel().getElementAt(k).date.getDay()==day
					&& facePosts.getModel().getElementAt(k).date.getMonth()==month-1
					&& facePosts.getModel().getElementAt(k).date.getYear()==year-1900) {
				f.addElement(facePosts.getModel().getElementAt(k));
			}
		}

		emails.setModel(e);
		facePosts.setModel(f);
		tweets.setModel(t);
	}

}

