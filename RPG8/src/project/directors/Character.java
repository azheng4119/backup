package project.directors;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import project.battles.demo.SampleWeapon;
import project.controls.OverworldSpriteControl;
import project.save.ItemState;
import project.items.Weapon;
public abstract class Character {

	//public abstract ItemState getItems();
	//public abstract OverworldSpriteControl move();
	protected BufferedImage[] fsprite;
	protected BufferedImage[] bsprite;
	protected BufferedImage[] lsprite;
	protected BufferedImage[] rsprite;
	
	protected int count;
	protected boolean moveUp = false;
	protected boolean moveDown = false;
	protected boolean moveLeft = false;
	protected boolean moveRight = false;
	
	protected int width;
	protected int height;
	protected int x;
	protected int y;
	
	protected int maxHP;
	protected int currentHP;
	protected int maxArmor;
	protected int currentArmor;
	protected int sneakValue;//Enemies can sneak behind players too 
	protected int speed;
	protected int recovery;//Enemies can recover too.
	protected int exp; //Enemies will give exp to the player when it dies 
	protected int strength; // Muhammad said something about this for enemies and players in the earlier demo
	
	protected ArrayList<SampleWeapon> loadout;
	
	protected boolean hostile;
	
	protected boolean walking = false; // planning to do something with it
	
	public Weapon weapon;
	
	protected Character(BufferedImage[][] images,int[] stats, boolean hostile, Weapon weapon){
		//stats = { 0 X, 1 Y, 2 hp, 3 armor, 4 sneak, 5 speed,6 recovery, 7 exp, 8 strength,9 level}
		// we might create allies if we do this hostile method.
		//need an inventory for character and arraylist of weapons for parameters
		//need armor set
		this.bsprite = images[0];
		this.fsprite = images[1];
		this.lsprite = images[2];
		this.rsprite = images[3];
		
		this.width = bsprite[0].getWidth();
		this.height = bsprite[0].getHeight();
		this.x = stats[0];
		this.y = stats[1];
		
		this.maxHP = stats[2];
		this.currentHP = stats[2];
		this.maxArmor = stats[3];
		this.currentArmor = stats[3];
		this.sneakValue = stats[4];
		this.speed = stats[5];
		this.recovery = stats[6];
		this.exp = stats[7];
		this.strength = stats[8];
		
		this.hostile = hostile;
		
		this.weapon = weapon;
	}
	//ABSTRACT BELOW
	public abstract BufferedImage getImage();
	
	//NOT GETTERS/SETTERS BELOW
	public Rectangle getBounds(){ //Pelham made this change sorry in advance for changing your code
		return new Rectangle(x, y, width, height);
	}
	
	public void increaseCount(){
		/**
		 * Chieh-Huang Chen
		 */
		count++;
		if(count>=20)
			count=0;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getMaxHP() {
		return maxHP;
	}
	public int getCurrentHP() {
		return currentHP;
	}
	public int getMaxArmor() {
		return maxArmor;
	}
	public int getCurrentArmor() {
		return currentArmor;
	}
	public int getSneakValue() {
		return sneakValue;
	}
	public int getSpeed() {
		return speed;
	}
	public int getRecovery() {
		return recovery;
	}
	public int getExp() {
		return exp;
	}
	public int getStrength() {
		return strength;
	}
	public ArrayList<SampleWeapon> getLoadout() {
		return loadout;
	}
	public boolean isHostile() {
		return hostile;
	}
	public boolean isWalking() {
		return walking;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}
	public void setCurrentArmor(int currentArmor) {
		this.currentArmor = currentArmor;
	}
	public void setSneakValue(int sneakValue) {
		this.sneakValue = sneakValue;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void setRecovery(int recovery) {
		this.recovery = recovery;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public void setLoadout(ArrayList<SampleWeapon> loadout) {
		this.loadout = loadout;
	}
	public void setHostile(boolean hostile) {
		this.hostile = hostile;
	}
	public void setWeapon(Weapon equippedWeapon) {
		this.weapon = equippedWeapon;
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
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setWalking(boolean walking) {
		this.walking = walking;
	}

}