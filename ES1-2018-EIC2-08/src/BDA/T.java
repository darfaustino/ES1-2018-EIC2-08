package BDA;

/**Represents a tweet's object
 *
 * 
 */

public class T {
	/**
	 * Represents the the tweet's user.
	 */
		public String name;
		
		/**
		 * Represents the the tweet's text.
		 */
		public String text;
		

		/**
		 * Class constructor, creates a Tweet with a user and a text.
		 * 
		 */
		
		public T(String name, String text) {
			super();
			this.name = name;
			this.text = text;
		}
		
		/**
		 * Choose how to show the tweet
		 * 
		 */
		@Override
		public String toString() {
			return "<html> Tweet: <br/>" + text ;
		}
		
		
		

		
	}