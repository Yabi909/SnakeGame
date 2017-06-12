package snakeGame;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader {
	
	private BufferedImage bi;
	
	public BufferedImage loadimage(String path) throws IOException{
		
		bi = ImageIO.read(getClass().getResource(path)); //menu background image loader
		return bi;
		
	}

}
