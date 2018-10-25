package Projeto;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Background extends JPanel {

	
	/**
	 * Class that creates the app background image.
	 */
		public Image backgroundImage;
		
		/**
		 * Constructor, calls method init() and builds the app main window, where you can navigate to login or signup.
		 * @param launcher
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
