package project.battles;

import java.awt.image.BufferedImage;

import project.battles.demo.BattlesScreen;
import project.items.Weapon;
import project.save.ItemState;

public class KEnemy extends EnemyAI{
	
	public KEnemy(BufferedImage[][] images, int[] stats, int[] vision, Weapon weapon,int type){
		super(images,stats,vision,weapon,type);
		this.weapon = weapon;
		this.enemyClass = BattlesScreen.KENEMY;
	}
 
	public KEnemy(BufferedImage[][] images, int[] stats,int[] vision, Weapon weapon, int type, boolean[] conditions){
		super(images,stats,vision,weapon,type);
		this.targetLock = conditions[0];
		this.left = conditions[1];
		this.up = conditions[2];
		this.boss = conditions[3];
	}

	public ItemState getItems() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected void reaction() {
		// TODO Auto-generated method stub
		int vx = BattlesScreen.calculateVComponentPlayerToCursor(10, x, y, true);
		int vy = BattlesScreen.calculateVComponentPlayerToCursor(10, x, y, false);
		fire(x,y,-vx,-vy);
		steriods();
		goToPlayer();
	}

	@Override
	protected void run() {
		// TODO Auto-generated method stub
		int distanceX = x - BattlesScreen.character.getX();
		int distanceY = y - BattlesScreen.character.getY();
		if (distanceX >= 0){
			x++;
		}
		else {
			x--;
		}
		
		if (distanceY >= 0) {
			y++;
		}
		else {
			y--;
		} 
	}
	
	public void steriods(){
		if (strength != BattlesScreen.KE_STRENGTH*2)
		strength+= 1;
	}

}
