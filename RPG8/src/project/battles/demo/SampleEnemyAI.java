package project.battles.demo;

import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;

import project.items.Weapon;
	/**
	 * 
	 * @ Author: Chieh-Huang Chen
	 * 
	 */
public abstract class SampleEnemyAI extends SampleCharacter{
	protected int hp;
	protected int maxhp;
	protected int visionrangeX;
	protected int visionrangeY;
	protected int visiondegree;
	protected SampleWeapon weapon;
	protected boolean targetlock = false;
	protected boolean left = false;
	protected boolean up = false;
	protected boolean boss = false;
	protected abstract void reaction();
	protected abstract void run();
	public void GeneralEnemyAI(){
		if(checkAlive()){
			//do something
			//System.out.println("hello");
			if(targetlock == false)
				checkForPlayer();
			else
				reaction();
			if(maxhp/10>hp){
				System.out.println(maxhp+" "+hp);
				run();
			}
		}
		//animation of death
		//dropItem();
	}
	public boolean checkAlive(){
		if(hp<0)
			return false;
		return true;
	}
	public void checkForPlayer(){
		int playerXposition=0;
		int playerYposition=0;
		//System.out.println("hello");
		Arc2D.Double visionrange = new Arc2D.Double(x, y, visionrangeX, visionrangeY, visiondegree, visiondegree+90, Arc2D.PIE);
		if(visionrange.contains(playerXposition, playerYposition)){
			targetlock = true;
		}
		else{
			wander();
		}
	}
	public void wander(){
		//System.out.println("a"+positionX);
		if(Math.abs(x-BattlesScreen.character.getX()) < 100){
			x--;
		}
		else{
			x++;
		}
		if(Math.abs(y-BattlesScreen.character.getY()) < 100){
			y--;
		}
		else{
			y++;
		}
		//System.out.println("b"+positionX);
//		if(true){
//			left = !left;
//		}; // check if its gonna crash into a wall or something
//		// need variables for other objects and boundaries
//		if(true){
//			up = !up;
//		}
	}
	public void firePistol(int vx, int vy){//target location
		SampleProjectiles bullet = new SampleProjectiles(0, 0, 0, vx, vy, 0, BattlesScreen.projectiledemo);
		BattlesScreen.enemy.add(bullet);
		equippedWeapon.reduceAmmoByOne();
	}
	
	public void dropItem(){
		if (hp <= 0){
			BattlesScreen.character.gainExp(10);
		}
	} 
	@Override
	public BufferedImage getImage() {
		/**
		 * Chieh-Huang Chen
		 */
		// TODO Auto-generated method stub
		// moveup use it as moving.
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
