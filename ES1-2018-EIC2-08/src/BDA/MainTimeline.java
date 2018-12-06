package BDA;

import javax.mail.Message;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.restfb.types.Post;

import twitter4j.TwitterException;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * Class that represents the app's MainTimiline with access to the Email,
 * Facebook and Twitter Timeline and to its respective contents
 * 
 * @author Diogo
 *
 */

public class MainTimeline {

	private JFrame launcher;
	private Facebook face;
	private TwitterApp twitterapp;
	private boolean isFaceOn;
	private boolean isMailOn;
	private boolean isTwitterOn;
	private JList<FacePost> facePosts;
	private JList<T> tweets;
	private JList<Email> emails;
	private DefaultListModel<Email> mail;

	/**
	 * Contructor, initiates the GUI and displays the content.
	 * 
	 * @param face     Given Facebook access
	 * @param twitter  Given Twitter access
	 * @param username Given Account Outlook Email
	 * @param password Given Account Outlook Password
	 * @throws TwitterException problem in the Twitter
	 */
	public MainTimeline(Facebook face, TwitterApp twitter, String username, String password, boolean f, boolean t)
			throws TwitterException {
		try {
			this.face = face;
			this.twitterapp = twitter;
			this.isFaceOn = f;
			this.isTwitterOn = t;
			this.isMailOn = Mail.isMailOnline();
			init(username, password);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * It creates the Gui with all its Features. Displays various Emails, Tweets and
	 * Facebook posts Gives acess to every Email, Tweets and Facebook posts
	 * displayed in the GUI
	 * 
	 * @param username Given email account
	 * @param password Given email account's password
	 * @throws IOException      Some I/O exception occurred.
	 * @throws TwitterException Some Twitter Exception occurred.
	 */

	private void init(String username, String password) throws IOException, TwitterException {

		// SettingsJFrame
		launcher = new JFrame("BOM DIA ACADEMIA!");
		launcher.setResizable(false);
		launcher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		launcher.setLayout(new BorderLayout());
		launcher.setVisible(true);

		// Background
		Background background = new Background("images/maintimeline.png");
		background.setLayout(new BorderLayout());
		background.setPreferredSize(new Dimension(800, 600));

		// Menu
		JMenuBar menuBar = new JMenuBar();
		launcher.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Filters");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("User Filter");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserFilter(facePosts, emails, tweets);
			}
		});

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Contains Filter");
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ContainsFilter(facePosts, emails, tweets);
			}
		});

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Date Filter");
		mnNewMenu.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DateFilter(facePosts, emails, tweets);
			}
		});

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Clean Filters");
		menuBar.add(mntmNewMenuItem_3);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					emails.setModel(mail);
					facePosts.setModel(face.getTimeLinePosts());
					tweets.setModel(twitterapp.getTimeline());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		// JTextPanes

		JPanel panel = new JPanel(new GridBagLayout());
		panel.setOpaque(false);
		panel.setPreferredSize(new Dimension(800, 515));

		JPanel email = new JPanel(new FlowLayout());
		email.setOpaque(false);
		email.setPreferredSize(new Dimension(245, 495));
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(50, 0, 0, 0);
		c.gridheight = 2;
		panel.add(email, c);

		JPanel facebook = new JPanel();
		facebook.setOpaque(false);
		facebook.setPreferredSize(new Dimension(245, 495));
		c.gridx = 1;
		c.gridy = 0;
		c.gridheight = 2;
		c.insets = new Insets(50, 15, 0, 15);
		panel.add(facebook, c);

		JPanel twitter = new JPanel();
		twitter.setOpaque(false);
		twitter.setPreferredSize(new Dimension(245, 495));
		c.gridx = 2;
		c.gridy = 0;
		c.gridheight = 2;
		c.insets = new Insets(50, 0, 0, 0);
		panel.add(twitter, c);
		background.add(panel);

		// JList<Email> emails;
		emails = new JList<Email>();

		((DefaultListCellRenderer) emails.getCellRenderer()).setOpaque(false);
		emails.setFixedCellHeight(70);
		emails.setBorder(new EmptyBorder(10, 5, 10, 0));
		emails.setOpaque(false);

		emails.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				if (emails.getSelectedValue() != null && !e.getValueIsAdjusting()) {
					Email selectedValue = emails.getSelectedValue();
					System.out.println("Body:" + selectedValue.getBody());
					new EmailSingular(selectedValue);
				}
			}
		});

		JScrollPane scroll = new JScrollPane(emails);
		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);
		scroll.setPreferredSize(new Dimension(250, 490));
		// email.add(scroll);

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				JTextPane load = new JTextPane();
				load.setEditable(false);
				load.setOpaque(false);
				load.setText("Loading...");
				load.setPreferredSize(new Dimension(100, 50));
				email.add(load);

				System.out.println(isMailOn);
				if (isMailOn) {

					mail = Mail.LoginMail(username, password);
				} else {
					mail = Mail.FetchFromBackup();
				}

				email.remove(load);
				emails.setModel(mail);
				email.add(scroll);
				launcher.revalidate();
				launcher.repaint();

			}
		}).start();

		// JList<FacePost> facePosts;
		System.out.println(isFaceOn);
		System.out.println(isTwitterOn);
		facePosts = new JList<FacePost>();

		if (isFaceOn && face != null) {
			facePosts.setModel(face.getTimeLinePosts());// filtro retirado pra teste
		} else {

			facePosts.setModel(Facebook.FetchFromBackup());
		}

		((DefaultListCellRenderer) facePosts.getCellRenderer()).setOpaque(false);
		facePosts.setFixedCellHeight(70);
		facePosts.setBorder(new EmptyBorder(10, 5, 10, 0));
		facePosts.setOpaque(false);

		facePosts.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				if (facePosts.getSelectedValue() != null && !e.getValueIsAdjusting()) {
					FacePost selectedValue = facePosts.getSelectedValue();
					new FacebookPost(selectedValue);
				}
			}
		});

		JScrollPane scroll2 = new JScrollPane(facePosts);
		scroll2.setOpaque(false);
		scroll2.getViewport().setOpaque(false);
		scroll2.setPreferredSize(new Dimension(250, 490));
		facebook.add(scroll2);

		tweets = new JList<T>();
		if (isTwitterOn && twitterapp != null) {
			tweets.setModel(twitterapp.getTimeline());
		} else {

			tweets.setModel(TwitterApp.FetchFromBackup());
		}

		((DefaultListCellRenderer) tweets.getCellRenderer()).setOpaque(false);
		tweets.setFixedCellHeight(70);
		tweets.setBorder(new EmptyBorder(10, 5, 10, 0));
		tweets.setOpaque(false);

		tweets.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				if (tweets.getSelectedValue() != null && !e.getValueIsAdjusting()) {
					T selectedValue = tweets.getSelectedValue();
					new Tweet(twitterapp, selectedValue);
				}
			}
		});

		//

		JScrollPane scroll3 = new JScrollPane(tweets);
		scroll3.setOpaque(false);
		scroll3.getViewport().setOpaque(false);
		scroll3.setPreferredSize(new Dimension(250, 490));
		twitter.add(scroll3);

		// Atualizar conteudo
		///////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JMenuItem button = new JMenuItem("Atualizar");
		menuBar.add(button);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isTwitterOn && twitterapp != null) {
					try {
						tweets.setModel(twitterapp.getTimeline());
					} catch (TwitterException e1) {
						e1.printStackTrace();
					}
				}
				
				if (isFaceOn && face != null) {
					facePosts.setModel(face.getTimeLinePosts());
				}
				if (isMailOn) {

					mail = Mail.LoginMail(username, password);
				}
				emails.setModel(mail);
			}
		});
		
		
//		JButton but = new JButton("Atualizar");
//
//		but.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (isTwitterOn && twitterapp != null) {
//					try {
//						tweets.setModel(twitterapp.getTimeline());
//					} catch (TwitterException e1) {
//						e1.printStackTrace();
//					}
//				}
//				if (isFaceOn && face != null) {
//					facePosts.setModel(face.getTimeLinePosts());
//				}
//				if (isMailOn) {
//
//					mail = Mail.LoginMail(username, password);
//				}
//				emails.setModel(mail);
//			}
//		});
		
		

//		JPanel buttons = new JPanel();
//		buttons.setOpaque(false);
//		but.setPreferredSize(new Dimension(100, 20));
//		buttons.setPreferredSize(new Dimension(200, 30));
//		buttons.add(but);
//		c.gridx=0;
//		c.gridy=0;
//		c.gridwidth=3;
//		c.insets=new Insets(0, 150,0,20);
		// c.gridheight=1;
		// c.insets=new Insets(10,10,0,0);
//		background.add(buttons, BorderLayout.PAGE_START);

		///////////////////////////////////////////////////////////////////////////////////////////////////////////

		launcher.add(background);
		launcher.setSize(800, 600);
		launcher.pack();

	}

	/**
	 * Gets the JFrame that serves as launcher of the window.
	 * 
	 * @return launcher
	 */

	public JFrame getLauncher() {
		return launcher;
	}

}