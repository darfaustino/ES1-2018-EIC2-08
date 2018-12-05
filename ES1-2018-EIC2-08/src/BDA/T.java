package BDA;

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
		private String text;
		

		/**
		 * Constructor, creates a Tweet with a user and a text.
		 * @param name name given
		 * @param text tweet given text
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

		public String getName() {
			return name;
		}

		public String getText() {
			return text;
		}
		
		
		

		
	}