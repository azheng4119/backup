//Jason Lyan ---> Corrected by Melvin Cherian
package project.battles;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import project.battles.demo.BattlesScreen;
import project.items.Weapon;

public class Projectiles extends Collision{
	protected BufferedImage pImgSrc;
	protected double vx;
	protected double vy;
	protected int range;
	protected final int initX;
	protected final int initY;
	protected boolean collided;
	protected Rectangle hitBox; 
	
	

	public Projectiles(int x, int y, int damage, double vx, double vy, int range, BufferedImage pImgSrc){
		super(x, y, damage);
		//this.bulletType = bulletType; //this needs more clarity because it has to be created
		this.vx = vx;
		this.vy = vy;
		this.pImgSrc = pImgSrc;
		this.initX = x;
		this.initY = y;
		this.range= range;
		collided = false;
	}
	public BufferedImage getpImgSrc() {
		return pImgSrc;
	}

	public void updatePosition(){
		x += vx;
		y += vy;
		if(hitBox.intersects(BattlesScreen.enemy1.getBounds())){
			BattlesScreen.player.remove(this); 
		}
	}
	public boolean isCollided() {
		return collided;
	}
	public void checkRange(){//melvino
		double distance = Math.sqrt(Math.pow((x-initX), 2) + Math.pow((y-initY), 2));
		if(distance >= range)collided=true;
	}
	
	public void updateAndCheckAll(){
		updatePosition();
		checkRange();
	}
	
	@Override
	void collideWith(Character C) {//Working on this
		// TBD after discussing
		collided = true;
	}

	@Override
	public boolean canPassThrough() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void paintImage() {
		// TODO Auto-generated method stub
		
	}
	public Rectangle getHitBox() {
		return hitBox;
	}

	public void setHitBox(Rectangle hitBox) {
		this.hitBox = hitBox;
	}
}
