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
		 * Constructor, creates a Tweet with a user and a text.
		 * @param name name given
		 * @param text tweet given text
		 */
		
		private Date date;
		
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

		public String getName() {
			return name;
		}

		public String getText() {
			return text;
		}

		public Date getDate() {
			return date;
		}
		
		
		

		
	}