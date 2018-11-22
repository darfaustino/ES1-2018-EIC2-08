package BDA;

public class T {
		public String name;
		public String text;
		
		public T(String name, String text) {
			super();
			this.name = name;
			this.text = text;
		}

		@Override
		public String toString() {
			return name + " : " + text ;
		}
		
		
		

		
	}