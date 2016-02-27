package project.battles.demo;

import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;

import project.battles.Projectiles;
import project.items.Weapon;
	/**
	 * 
	 * @ Author: Chieh-Huang Chen
	 * 
	 */
public abstract class SampleEnemyAI extends SampleCharacter{
	public static Arc2D.Double visioncone;
	protected int visionrange;
	protected int visiondegree;
	protected SampleWeapon weapon;
	protected boolean targetlock = false;
	protected boolean left = false;
	protected boolean up = false;
	protected boolean boss = false;
	protected abstract void reaction();
	protected abstract void run();
	
	public SampleEnemyAI(BufferedImage[][] images, int[] stats, int x, int y) {
		super(images, stats[0], x, y);
		this.visionrange = stats[1];
		this.visiondegree = stats[2];
	}
	public void GeneralEnemyAI(){
		if(checkAlive()){
			//do something
			//System.out.println("hello");
			if(targetlock == false)
				checkForPlayer();
			else
				reaction();
			moveUpAndDown();
			if(maxHP/10>currentHP){
				System.out.println(maxHP+" "+currentHP);
				run();
			}
		}
		//animation of death
		//dropItem();
	}
	public boolean checkAlive(){
		if(currentHP<0)
			return false;
		return true;
	}
	public void checkForPlayer(){
		//System.out.println("hello");
		int arcX = x+(width/2)-visionrange/2;
		int arcY = y+(height/2)-visionrange/2;
		
		visioncone = new Arc2D.Double(arcX,arcY, visionrange, visionrange, 225, 90, Arc2D.PIE);
		if(visioncone.contains(BattlesScreen.character.getX(), BattlesScreen.character.getY())){
			targetlock = true;
		}
	}
	public static void paintArc(Graphics2D g){
		g.draw(visioncone);
	}
	public void moveUpAndDown(){
		if(moveUp){
			y-=10;
			if(y<=0){
				moveUp = false;
				moveDown = true;
			}
		}
		else{
			y+=10;
			if(BattlesScreen.height <= y){
				System.out.println(y+" "+ BattlesScreen.height);
				moveUp = true;
				moveDown = false;
			}
		}
	}
	public void moveLeftAndRight(){
		if(moveRight){
			y-=10;
			if(y<=0){
				moveRight = false;
				moveLeft = true;
			}
		}
		else{
			y+=10;
			if(BattlesScreen.height <= y){
				System.out.println(y+" "+ BattlesScreen.height);
				moveUp = true;
				moveDown = false;
			}
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
		Projectiles bullet = new Projectiles(0, 0, 0, vx, vy, 0, BattlesScreen.projectiledemo);
		BattlesScreen.eBullets.add(bullet);
		equippedWeapon.reduceAmmoByOne();
	}
	
	public void dropItem(){
		if (currentHP <= 0){
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
