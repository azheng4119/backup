package project.storyV2;

import java.awt.image.BufferedImage;

public abstract class Cutscenes {
	
	BufferedImage image;
	
	public Cutscenes(){
		
	}
	
	protected final BufferedImage getBufferedImage(){
		return image;
		
	}
}
