package project.menus;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public abstract class Menu implements KeyListener{

	
	
	ArrayList<Selection> selections;
	BufferedImage image;
	int width;
	int height;
	int selectIndex;
	
	public Menu(int width, int height) {
		selections = new ArrayList<Selection>();
		selectIndex = 0;
		this.width=width;
		this.height=height;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		addSelections();
		update();
	}

	/**
	 * Finds all saved game files, initializes them as instances of SavedGameSelections
	 * adds them to savedGames
	 */
	public abstract void addSelections();

	public abstract void paintScreen(Graphics2D g2);

	public final void update(){
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		g2.setColor(new Color(200,200,200));
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.black);
		paintScreen(g2);
	}
	
	/**
	 * paints the screen
	 */
	
	
	public final void confirmSelection() {
		selections.get(selectIndex).confirm();
	}

	public final void selectNext() {
		if(selectIndex<selections.size()-1){
			selections.get(selectIndex).setSelect(false);
			selectIndex++;
		}else{
			selections.get(selectIndex).setSelect(false);
			selectIndex=0;
		}
		selections.get(selectIndex).setSelect(true);
	}

	public final void selectPrevious() {
		if(selectIndex>0){
			selections.get(selectIndex).setSelect(false);
			selectIndex--;
		}else{
			selections.get(selectIndex).setSelect(false);
			selectIndex=selections.size()-1;
		}
		selections.get(selectIndex).setSelect(true);
	}

	public final BufferedImage getImage() {
		return image;
	}


}
