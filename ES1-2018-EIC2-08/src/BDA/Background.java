package BDA;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

	/**
	 * Class that creates the app background image.
	 */
@SuppressWarnings("serial")
public class Background extends JPanel {

	
	
		public Image backgroundImage;
		
		/**
		 * Constructor, calls method init() and builds the app main window, where you can navigate to login or signup.
		 * @param fileName Image filename.
		 * @throws IOException cannot read the image.
		 */
		
		public Background(String fileName) throws IOException {
		   backgroundImage = ImageIO.read(new File(fileName));
		   this.setOpaque(false);
		}

		
		
		
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			g.drawImage(backgroundImage,0,0,null);
		}
		
		
		
	

	
}
