package project.battles;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import project.controls.OverworldSpriteControl;
import project.directors.Character;
import project.save.ItemState;

public class MCharacter extends Character{
	private int level;
	
	ArrayList<Integer> pressedKeys = new ArrayList<Integer>();
//	private String[] setLoadOut;

	public MCharacter(BufferedImage[][] images, int[] stats){
		//this is where we change stats for characters
		super(images,stats,true);
		this.level = stats[9];
	}
	public int getLevel() {
		return level;
	}
	public void gainExp(int xp){
		exp+= xp;
		if (exp >= 100){
			level++;
			exp = exp%100;
		}
	}
	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		increaseCount();
		if(moveUp == true){
			if((count >= 0 && count < 5) || (count >= 10 && count < 15))
				return bsprite[0];
			if(count >= 5 && count < 10)
				return bsprite[1];
			if(count >= 15 && count < 20)
				return bsprite[2];
		}

		if(moveDown == true){
			if((count >= 0 && count < 5) || (count >= 10 && count < 15))
				return fsprite[0];
			if(count >= 5 && count < 10)
				return fsprite[1];
			if(count >= 15 && count < 20)
				return fsprite[2];
		}
		if(moveLeft == true){
			if((count >= 0 && count < 5) || (count >= 10 && count < 15))
				return lsprite[0];
			if(count >= 5 && count < 10)
				return lsprite[1];
			if(count >= 15 && count < 20)
				return lsprite[2];
		}

		if(moveRight == true){
			if((count >= 0 && count < 5) || (count >= 10 && count < 15))
				return rsprite[0];
			if(count >= 5 && count < 10)
				return rsprite[1];
			if(count >= 15 && count < 20)
				return rsprite[2];
		}
		return fsprite[0];
	}

}

		//	@Override
		//	public ItemState getItems() {
		//		// TODO Auto-generated method stub
		//		return null;
		//	}
		//
		//	@Override
		//	public OverworldSpriteControl move() {
		//		// TODO Auto-generated method stub
		//		return null;
		//	}

	

