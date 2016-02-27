package project.battles;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import project.directors.UtilityMethods;

public class Melee extends Collision{
	protected int width;
	protected int height;
	protected Rectangle hitBox;
	protected double rotation;
	protected int frames;//out of 30, e.g. 15/30fps = .5 seconds
	
	public Melee(int x, int y, int damage, int width, int height, int frames, BufferedImage image, double rotation){
		super(x, y, damage);
		this.width = width;
		this.height = height;
		this.hitBox = new Rectangle(x,y,width,height);
		this.frames = frames;
		this.image = image;
		this.rotation = rotation;
		collided = false;
		paintImage();
	}
	
	public void updateTime(){
		if(--frames <= 0)collided = true;
	}
	@Override
	public void updateAndCheckAll() {
		updateTime();
	}

	@Override
	public void collideWith(Character c) {
		// TODO Auto-generated method stub
		collided = true;
	}

	@Override
	public boolean canPassThrough() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void paintImage() {
		BufferedImage slashImage = image;
		slashImage = UtilityMethods.getScaledImage(slashImage, width, height);
		Graphics2D g = slashImage.createGraphics();
		AffineTransform oldtrans = new AffineTransform();
	    AffineTransform trans = new AffineTransform();
	    trans.setToIdentity();
	    trans.rotate(Math.toRadians(rotation), width/2, height/2);
	    trans.translate((width/2), (height/2));
	    g.setTransform(trans);
	    g.drawImage(this.getImage(), 0, 0, width, height, null);
	    trans.setToIdentity();
	    g.setTransform(oldtrans);
	    image = slashImage;
		
	}

}
