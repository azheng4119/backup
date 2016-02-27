package project.battles.demo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import project.battles.GEnemy;
import project.battles.KEnemy;
import project.battles.MCharacter;
import project.battles.Projectiles;
import project.directors.Game;
import project.directors.Screen;
import project.directors.UtilityMethods;
import project.items.Weapon;

public class BattlesScreen extends Screen implements ActionListener, KeyListener , MouseListener{
	/**
	 * ***********CHANGES! MUST READ********************
	 * RENAMING: 
	 * 	VARIABLES
	 * 		- char1 -> character
	 * 		- positionX -> x
	 * 		- positionY -> y
	 * 		- enemy1 -> enemyK
	 * 		- enemy2 -> enemyG
	 * 		
	 * 
	 * 	CONSTANTS
	 * 		- MOVE_UNIT -> P_SPEED
	 * 		- PPOSITION_X -> P_X
	 * 		- PPOSITION_Y -> P_Y
	 * 		- EPOSITION_X -> GE_X	GUARDENEMIES
	 * 		- EPOSITION_Y -> GE_Y
	 * 		- EPOSITION_X -> KE_X	KILLONSIGHTENEMIES
	 * 		- EPOSITION_Y -> KE_Y
	 * 
	 * NEW:
	 * 	VARIABLES
	 * 
	 * 	CONSTANTS // too lazy to list all the constants gave up
	 * 		-GE_SPEED	GUARDENEMIES' SPEED
	 * 		-KE_SPEED	KILLENEMIES' SPEED
	 * 		-FPS 1000/TIMER
	 * 		-GE_VISION ENEMIES' VISION RANGE
	 * 		-KE_VISION 
	 * 		-GE_DEGREE ENEMIES' LINE OF SIGHT
	 *		-KE_DEGREE
	 *
	 *	
	 */
	
	public static final int P_SPEED = 8;
	public static final int P_X = 300;
	public static final int P_Y = 300;
	public static final int P_HP = 100;
	public static final int P_ARMOR = 100;
	public static final int P_SNEAK = 100;
	public static final int P_RECOVERY = 100;
	public static final int P_EXP = 0;
	public static final int P_STRENGTH = 10;
	public static final int P_LEVEL = 10;
	
	public static final int GE_SPEED = 5;
	public static final int GE_X = 100;
	public static final int GE_Y = 100;
	public static final int GE_HP = 100;
	public static final int GE_ARMOR = 100;
	public static final int GE_SNEAK = 100;
	public static final int GE_RECOVERY = 10;
	public static final int GE_EXP = 10;
	public static final int GE_STRENGTH = 10;
	public static final int GE_LEVEL = 10;
	public static final int GE_DEGREE = 100;
	public static final int GE_VISION = 300;
	
	public static final int KE_SPEED = 5;
	public static final int KE_X = 100;
	public static final int KE_Y = 300;
	public static final int KE_HP = 100;
	public static final int KE_ARMOR = 100;
	public static final int KE_SNEAK = 100;
	public static final int KE_RECOVERY = 10;
	public static final int KE_EXP = 10;
	public static final int KE_STRENGTH = 10;
	public static final int KE_LEVEL = 10;
	public static final int KE_DEGREE = 100;
	public static final int KE_VISION = 300;
	
	public static final int FPS = 30;
	
	public static final int W_DMG = 10;
	public static final int W_VELOCITY = 10;
	public static final int W_AMMO = 10;
	public static final int W_RANGE = 300;
	
	public static MCharacter character;
	//public static SampleKEnemy enemy1;
	public static KEnemy enemy1;
	//public static SampleGEnemy enemy2;
	public static GEnemy enemy2;
	
	public static ArrayList<SampleEnemyAI> enemiesOnScreen= new ArrayList<SampleEnemyAI>();
	public static ArrayList<Projectiles> pBullets = new ArrayList<Projectiles>();
	public static ArrayList<Projectiles> eBullets = new ArrayList<Projectiles>();
	
	Timer timer = new Timer(FPS,this);
	ArrayList<Integer> pressedKeys = new ArrayList<Integer>();

	public static BufferedImage projectiledemo;
	public static BufferedImage weapondemo;
	
	Projectiles bullet;
	Weapon weapon;
	Weapon weapon1;
	Weapon weapon2;
	//stats = { 0 X, 1 Y, 2 hp, 3 armor, 4 sneak, 5 speed,6 recovery, 7 exp, 8 strength,9 level}
	public int[] enemyG = {GE_X,GE_Y,GE_ARMOR,GE_SNEAK,GE_SPEED,GE_RECOVERY,GE_EXP,GE_STRENGTH,GE_LEVEL};
	public int[] enemyK = {KE_X,KE_Y,KE_ARMOR,KE_SNEAK,KE_SPEED,KE_RECOVERY,KE_EXP,KE_STRENGTH,KE_LEVEL};
	public int[] visionG = {GE_VISION, GE_DEGREE};
	public int[] visionK = {KE_VISION, KE_DEGREE};
	public int[] projectilestats = {W_DMG,W_VELOCITY,W_AMMO,W_RANGE};
	public int[] playerstats = {P_X,P_Y,P_HP,P_ARMOR,P_SNEAK,P_SPEED,P_RECOVERY,P_EXP,P_STRENGTH,P_LEVEL};
	public BattlesScreen(Game game){
		super(game);
		Projectile();
		Weapon();
		MainCharacter();
		Enemy();
		//enemiesOnScreen.add(enemy1);
		//enemiesOnScreen.add(enemy2); change the type later
		update();
	}
	public void Projectile(){
		projectiledemo = UtilityMethods.getImageFromFile(this, "/images/items/bullet.png");
		bullet = new Projectiles(10, 10, 0, 10, 10, 100, projectiledemo);
	}
	public void Weapon(){
		 weapondemo = null;
		 BufferedImage [] pics = new BufferedImage [4];
		 weapon = new Weapon(pics,projectiledemo,projectilestats);
		 weapon1 = new Weapon(pics,projectiledemo,projectilestats);
		 weapon2 = new Weapon(pics,projectiledemo,projectilestats);
	}
	public void MainCharacter(){
		/**
		 * 
		 * @ Author: Chieh-Huang Chen
		 * 
		 */
		BufferedImage [][] animation = new BufferedImage [4][3];
		//		BufferedImage walk1 = null;
		//		BufferedImage walk2 = null;
		//		BufferedImage walk3 = null;
		BufferedImage origimage0 = UtilityMethods.getImageFromFile(this, "/maincharacter/mback1.png");
		BufferedImage origimage1 = UtilityMethods.getImageFromFile(this, "/maincharacter/mback2.png");
		BufferedImage origimage2 = UtilityMethods.getImageFromFile(this, "/maincharacter/mback3.png");
		//scale each image
		//walk1=UtilityMethods.getScaledImage(origimage0,100,SPRITE_HEIGHT);
		//walk2=UtilityMethods.getScaledImage(origimage1,90,SPRITE_HEIGHT);
		//walk3=UtilityMethods.getScaledImage(origimage2,90,SPRITE_HEIGHT);
		animation[0] = UtilityMethods.addImage(origimage0,origimage1,origimage2);
		origimage0 = UtilityMethods.getImageFromFile(this, "/maincharacter/mfront1.png");
		origimage1 = UtilityMethods.getImageFromFile(this, "/maincharacter/mfront2.png");
		origimage2 = UtilityMethods.getImageFromFile(this, "/maincharacter/mfront3.png");
		animation[1] = UtilityMethods.addImage(origimage0,origimage1,origimage2);
		origimage0 = UtilityMethods.getImageFromFile(this, "/maincharacter/mleft1.png");
		origimage1 = UtilityMethods.getImageFromFile(this, "/maincharacter/mleft2.png");
		origimage2 = UtilityMethods.getImageFromFile(this, "/maincharacter/mleft3.png");
		animation[2] = UtilityMethods.addImage(origimage0,origimage1,origimage2);
		origimage0 = UtilityMethods.getImageFromFile(this, "/maincharacter/mright1.png");
		origimage1 = UtilityMethods.getImageFromFile(this, "/maincharacter/mright2.png");
		origimage2 = UtilityMethods.getImageFromFile(this, "/maincharacter/mright3.png");
		animation[3] = UtilityMethods.addImage(origimage0,origimage1,origimage2);
		character =  new MCharacter(animation,playerstats,weapon);
		//character = new SampleMCharacter(animation,100,100,100,100,100,100);
	}
	public void Enemy(){
		/**
		 * Chieh-Huang Chen
		 */
		BufferedImage [][] animation = new BufferedImage [4][3];
		BufferedImage origimage0 = UtilityMethods.getImageFromFile(this, "/enemy/eback1.png");
		BufferedImage origimage1 = UtilityMethods.getImageFromFile(this, "/enemy/eback2.png");
		BufferedImage origimage2 = UtilityMethods.getImageFromFile(this, "/enemy/eback3.png");
		animation[0] = UtilityMethods.addImage(origimage0,origimage1,origimage2);
		origimage0 = UtilityMethods.getImageFromFile(this, "/enemy/efront1.png");
		origimage1 = UtilityMethods.getImageFromFile(this, "/enemy/efront2.png");
		origimage2 = UtilityMethods.getImageFromFile(this, "/enemy/efront3.png");
		animation[1] = UtilityMethods.addImage(origimage0,origimage1,origimage2);
		origimage0 = UtilityMethods.getImageFromFile(this, "/enemy/eleft1.png");
		origimage1 = UtilityMethods.getImageFromFile(this, "/enemy/eleft2.png");
		origimage2 = UtilityMethods.getImageFromFile(this, "/enemy/eleft3.png");
		animation[2] = UtilityMethods.addImage(origimage0,origimage1,origimage2);
		origimage0 = UtilityMethods.getImageFromFile(this, "/enemy/eright1.png");
		origimage1 = UtilityMethods.getImageFromFile(this, "/enemy/eright2.png");
		origimage2 = UtilityMethods.getImageFromFile(this, "/enemy/eright3.png");
		animation[3] = UtilityMethods.addImage(origimage0,origimage1,origimage2);
		//enemy1 = new SampleKEnemy(animation,enemyG, new SampleWeapon(), KE_X, KE_Y);
		enemy1 = new KEnemy(animation,enemyK,visionK,weapon1);
//		enemy1.GeneralEnemyAI();
		enemy2 = new GEnemy(animation,enemyG, visionG,weapon2);
	}
	@Override
	public void paintScreen(Graphics2D g2) {
		/**
		 * Chieh-Huang Chen
		 */
		// TODO Auto-generated method stub
		checkMotion();
		enemy1.GeneralEnemyAI();
		enemy2.GeneralEnemyAI();
		checkProjectileRange();
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.black);
		try{
			g2.drawString("Battles Team's Demo", 100, 100);
			g2.setColor(Color.green);
			timer.start();
			//System.out.println(char1.getPositionY());
			g2.drawImage(character.getImage(),character.getX(),character.getY(),null);
			g2.drawImage(bullet.getImage(), 100, 100, null);
			g2.drawImage(enemy1.getImage(),enemy1.getX(),enemy1.getY(),null);
			g2.drawImage(enemy2.getImage(),enemy2.getX(),enemy2.getY(),null);
			for(int i = 0; i < pBullets.size(); i++){
				g2.drawImage(pBullets.get(i).getImage(), pBullets.get(i).getX(), pBullets.get(i).getY(), null);
			}
			for(int i = 0; i < eBullets.size(); i++){
				g2.drawImage(eBullets.get(i).getImage(), eBullets.get(i).getX(), eBullets.get(i).getY(), null);
			}
		}
		catch(Exception e){
			
		}
	}
	private void checkProjectileRange() {
		/**
		 * Jason Lyan
		 */
		for(int i = pBullets.size() - 1 ; i > -1; i--){
			if(pBullets.get(i).isCollided()){
				pBullets.remove(i);
			}
		}
	}


	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		/**
		 * Chieh-Huang Chen
		 */
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
			if(!pressedKeys.contains(keyCode))
				pressedKeys.add(keyCode);
		}
		if(!pressedKeys.isEmpty()){
			character.setWalking(true);
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		/**
		 * Chieh-Huang Chen
		 */
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_UP){
			pressedKeys.remove(pressedKeys.indexOf(keyCode));
			character.setMoveUp(false);
		}
		if(keyCode == KeyEvent.VK_DOWN){
			pressedKeys.remove(pressedKeys.indexOf(keyCode));
			character.setMoveDown(false);
		}
		if(keyCode == KeyEvent.VK_LEFT){
			pressedKeys.remove(pressedKeys.indexOf(keyCode));
			character.setMoveLeft(false);
		}
		if(keyCode == KeyEvent.VK_RIGHT){
			pressedKeys.remove(pressedKeys.indexOf(keyCode));
			character.setMoveRight(false);
		}
		if(pressedKeys.isEmpty())
			character.setWalking(false);
	}
	public void checkMotion() {
		/**
		 * Chieh-Huang Chen
		 */
		Graphics2D g = null;
		if(pressedKeys == null)
			return;
		int proposedNewY=character.getY();
		int proposedNewX=character.getX();
		if(pressedKeys.contains(KeyEvent.VK_UP) && !pressedKeys.contains(KeyEvent.VK_DOWN)){
			proposedNewY-=P_SPEED;
			character.setY(proposedNewY);
			character.setMoveUp(true);
		}
		if(!pressedKeys.contains(KeyEvent.VK_UP) && pressedKeys.contains(KeyEvent.VK_DOWN)){
			proposedNewY+=P_SPEED;
			character.setY(proposedNewY);
			character.setMoveDown(true);
		}
		if(pressedKeys.contains(KeyEvent.VK_RIGHT) && !pressedKeys.contains(KeyEvent.VK_LEFT)){
			proposedNewX+=P_SPEED;
			character.setX(proposedNewX);
			character.setMoveRight(true);
		}
		if(!pressedKeys.contains(KeyEvent.VK_RIGHT) && pressedKeys.contains(KeyEvent.VK_LEFT)){
			proposedNewX-=P_SPEED;
			character.setX(proposedNewX);
			character.setMoveLeft(true);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	public int calculateVComponentPlayerToCursor(int velocityScalar, int cursorX, int cursorY, boolean isX){
		/**
		 * Melvin
		 */
		int x = character.getX();
		int y = character.getY();
		/*System.out.println("1: " + (Math.atan2(-193,372)));
		System.out.println("2: " + (int) (velocityScalar*(Math.cos(Math.atan2((y-cursorY),(cursorX - x))))));
		System.out.println("3: " + cursorX + " " + cursorY);
		System.out.println("4: " + x + " " + y);
		System.out.println("5: " + velocityScalar*(Math.cos(Math.atan2((y-cursorY),(cursorX - x)))));
		System.out.println("6: " + velocityScalar*(Math.sin(Math.atan2((y-cursorY),(cursorX - x)))));*/
		if(isX)return (int) (velocityScalar*(Math.cos(Math.atan2((cursorY-y),(cursorX - x)))));
		return (int) (velocityScalar*(Math.sin(Math.atan2((cursorY-y),(cursorX - x)))));
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Chieh-Huang Chen
		 */
		// TODO Auto-generated method stub/
		for(int i=0;i<pBullets.size();i++){
			pBullets.get(i).updateAndCheckAll();
		}
		for(int i=0;i<eBullets.size();i++){
			eBullets.get(i).updateAndCheckAll();
		}
		update();
	}

	@Override
	public void mousePressed(MouseEvent e) {//Jason Lyan
		if(e.getButton() == MouseEvent.BUTTON1){
			int cursorX = e.getX();
			int cursorY = e.getY();
			int vx = calculateVComponentPlayerToCursor(10, cursorX, cursorY, true);
			int vy = calculateVComponentPlayerToCursor(10, cursorX, cursorY, false);
			character.fire(character.getX(),character.getY(),vx,vy);//change it up
		}

	}
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
