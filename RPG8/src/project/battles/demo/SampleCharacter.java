package project.battles.demo;

import java.awt.image.BufferedImage;

import project.controls.OverworldSpriteControl;
import project.items.Weapon;
import project.save.ItemState;

public abstract class SampleCharacter {
	protected abstract ItemState getItems();
	protected abstract OverworldSpriteControl move();
	public int[] rawr = {50,5,200,100};
	protected BufferedImage[] fsprite;
	protected BufferedImage[] bsprite;
	protected BufferedImage[] lsprite;
	protected BufferedImage[] rsprite;
	protected boolean moveUp = false;
	protected boolean moveDown = false;
	protected boolean moveLeft = false;
	protected boolean moveRight = false;
	protected SampleWeapon equippedWeapon = new SampleWeapon("blah","blah",rawr);
	protected int width = 100;
	protected int height = 100;
	protected String imgsrc;
	protected boolean Hostile;
	protected boolean walking = false;
	protected int maxHP;
	protected int currentHP;
	protected int positionX;
	protected int positionY;
	
	public String getImgsrc() {
		return imgsrc;
	}

	public BufferedImage getImage(int count){
		BufferedImage sprite;
		if(moveUp == true){
			if(count >= 0 && count < 5)
				return bsprite[0];
			else
				return bsprite[1];
		}

		if(moveDown == true){
			if(count >= 0 && count < 5)
				return fsprite[0];
			else
				return fsprite[1];
		}
		if(moveLeft == true){
			if(count >= 0 && count < 5)
				return lsprite[0];
			else
				return lsprite[1];
		}

		if(moveRight == true){
			if(count >= 0 && count < 5)
				return rsprite[0];
			else
				return rsprite[1];
		}
		return fsprite[0];
	}

	public SampleWeapon getEquippedWeapon() {
		return equippedWeapon;
	}
	public void setEquippedWeapon(SampleWeapon equippedWeapon) {
		this.equippedWeapon = equippedWeapon;
	}
	public boolean isHostile() {
		return Hostile;
	}
	public void setHostile(boolean hostile) {
		Hostile = hostile;
	}
	public int getMaxHP() {
		return maxHP;
	}
	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}
	public int getCurrentHP() {
		return currentHP;
	}
	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}
	public int getPositionX() {
		return positionX;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	public void setMoveUp(boolean moveUp) {
		this.moveUp = moveUp;
	}
	public void setMoveDown(boolean moveDown) {
		this.moveDown = moveDown;
	}
	public void setMoveLeft(boolean moveLeft) {
		this.moveLeft = moveLeft;
	}
	public void setMoveRight(boolean moveRight) {
		this.moveRight = moveRight;
	}
	public boolean isMoveUp() {
		return moveUp;
	}
	public boolean isMoveDown() {
		return moveDown;
	}
	public boolean isMoveLeft() {
		return moveLeft;
	}
	public boolean isMoveRight() {
		return moveRight;
	}
	public void setWalking(boolean walking) {
		this.walking = walking;
	}
	
}
