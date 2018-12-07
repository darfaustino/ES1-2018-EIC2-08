package BDA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import twitter4j.TwitterException;

/**
 * Class that represents a date filter.
 *
 */

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
	 * @param tweets list of tweets
	 * @param emails list of emails
	 * @param facePosts list of posts
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
	
	/**
	 * Filters 3 lists by a certain date
	 * @param day chosen day
	 * @param month chosen month
	 * @param year chosen year
	 * @throws TwitterException twitter exception
	 */
	
	public void dateFilter(int day, int month, int year) throws TwitterException {
		DefaultListModel<Email> e = new DefaultListModel<>();
		DefaultListModel<FacePost> f = new DefaultListModel<>();
		DefaultListModel<T> t = new DefaultListModel<>();
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(year, month-1, day);
		Date filter=calendar.getTime();
		long time=filter.getTime()/(1000 * 60 * 60 * 24);

		for (int i = 0; i < tweets.getModel().getSize(); i++) {
			
			long date=tweets.getModel().getElementAt(i).getDate().getTime()/(1000 * 60 * 60 * 24);
		
			if (time==date) {
				t.addElement(tweets.getModel().getElementAt(i));
			}
		}
		for (int j = 0; j < emails.getModel().getSize(); j++) {
			long date=emails.getModel().getElementAt(j).getTimestamp().getTime()/(1000 * 60 * 60 * 24);
			if (time==date) {
				e.addElement(emails.getModel().getElementAt(j));
			}
		}

		for (int k = 0; k < facePosts.getModel().getSize(); k++) {
			long date=facePosts.getModel().getElementAt(k).getDate().getTime()/(1000 * 60 * 60 * 24);
			if (time==date) {
				f.addElement(facePosts.getModel().getElementAt(k));
			}
		}

		emails.setModel(e);
		facePosts.setModel(f);
		tweets.setModel(t);
		this.dispose();
	}

	/**
	 * Get the facebook posts
	 * @return list of facebook posts
	 */
	
	public JList<FacePost> getFacePosts() {
		return facePosts;
	}
	
	/**
	 * Get the emails
	 * @return list of emails
	 */

	public JList<Email> getEmails() {
		return emails;
	}

	
	/**
	 * Get the tweets
	 * @return list of tweets
	 */
	public JList<T> getTweets() {
		return tweets;
	}
	
	

}

