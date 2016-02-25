package project.battles.demo;

import java.awt.image.BufferedImage;

import project.controls.OverworldSpriteControl;
import project.items.Weapon;
import project.save.ItemState;

public abstract class SampleCharacter {
	protected abstract ItemState getItems();
	protected abstract OverworldSpriteControl move();
	public int[] rawr = {50,5,200,100};
	protected BufferedImage sprite;
	protected SampleWeapon equippedWeapon = new SampleWeapon("blah","blah",rawr);
	protected int width = 100;
	protected int height = 100;
	protected String imgsrc;
	protected boolean Hostile;
	protected int maxHP;
	protected int currentHP;
	protected int positionX;
	protected int positionY;
	
	public String getImgsrc() {
		return imgsrc;
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
public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		equippedWeapon.fire(true);
	}	
	public void firePistol(int tx, int ty){//target location
		SampleProjectiles bullet = new SampleProjectiles(positionX, positionY, 0, tx, ty, 100, imgsrc);
		BattlesScreen.player.add(bullet);
		equippedWeapon.reduceAmmoByOne();
	}
	public void useMelee(){
		//requires pelham's class
	}
	public void useExplovies(){
		//requires a new class
	}
	public void fireRifle(int tx, int ty){
		SampleProjectiles bullet = new SampleProjectiles(positionX, positionY, 0, tx, ty, 200, imgsrc);
		BattlesScreen.player.add(bullet);
		equippedWeapon.reduceAmmoByOne();
	}
	public void fireHeavy(int tx, int ty){
		SampleProjectiles bullet = new SampleProjectiles(positionX, positionY, 0, tx, ty, 200, imgsrc);
		SampleProjectiles bullet1 = new SampleProjectiles(positionX, positionY, 0, tx, ty, 200, imgsrc);
		BattlesScreen.player.add(bullet);
		BattlesScreen.player.add(bullet1);
		equippedWeapon.reduceAmmoByOne();
	}
	public void fireSMG(int tx, int ty){
		SampleProjectiles bullet = new SampleProjectiles(positionX, positionY, 0, tx, ty, 200, imgsrc);
		BattlesScreen.player.add(bullet);
		equippedWeapon.reduceAmmoByOne();
	}
	
}
