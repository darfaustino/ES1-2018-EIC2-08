package BDA;

import java.util.Date;


/**Represents a tweet's object
 *
 * 
 */

public class T {
	/**
	 * Represents the the tweet's user.
	 */
		private String name;
		
		/**
		 * Represents the the tweet's text.
		 */
	 private	String text;
		

	 /**
		 * Represents the the tweet's date.
		 */
	 private Date date;
	 
		/**
		 * Constructor, creates a Tweet with a user and a text.
		 * @param name name given
		 * @param text tweet given text
		 * @param date date of tweet
		 */
		
		
		
		public T(String name, String text, Date date) {
			super();
			this.name = name;
			this.text = text;
			this.date=date;
		}
		
		/**
		 * Choose how to show the tweet
		 * 
		 */
		@Override
		public String toString() {
			return "<html> Tweet: <br/>" + text ;
		}

		/**
		 * Gets the namo of the owner of the Tweet.
		 * @return  tweet's nameuser
		 */
		public String getName() {
			return name;
		}

		/**
		 * Gets the text of the Tweet.
		 * @return  tweet's text
		 */
		public String getText() {
			return text;
		}

		/**
		 *  Gets the date of the Tweet.
		 * @return  tweet's date
		 */
		public Date getDate() {
			return date;
		}
		
		
		

		
	}