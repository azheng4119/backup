package project.menus;

import java.awt.image.BufferedImage;
import java.util.List;

public class ChoiceMenu extends GridMenu {
	
	String description;
	
	public ChoiceMenu(int width, int height, int itemsAcross, int itemsDown, BufferedImage nullImage, 
	List<Selectable> page, String description) {
		super(width, height, itemsAcross, itemsDown, nullImage, page); //w and h defined later
		this.description = description;
	}
}
