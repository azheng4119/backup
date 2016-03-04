package project.mainmenudemo;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import project.ChoiceMenuDemo.ChoiceDemo;
import project.ChoiceMenuDemo.GridToSee;
import project.directors.Game;
import project.directors.Screen;
import project.menus.ChoiceMenuDemo;
import project.tooltipdemo.TestScreen;

import java.awt.*;
import java.applet.*;

import java.awt.*;
import java.applet.*;

public class MainMenuScreen extends Screen implements KeyListener{
	
	String[] options; 
	String[] pics;
	Color[] colors;
	// I will add the pictures of the characters once the
	//character group has chosen them
	
	private int selected;
	
	public MainMenuScreen(Game game, String[] names, String[] pictures,  Color[] col, String backgroundmusic) {
		super(game);
		
		playSound(new File(backgroundmusic));
		
		selected=1;
		
		options=names;
		pics=pictures;
		colors=col;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()== KeyEvent.VK_DOWN){
			playSound(new File("resources/button-19.wav"));
			selected ++;
			if(selected>4) selected=1;
			update();
		}
		if(e.getKeyCode()== KeyEvent.VK_UP){
			playSound(new File("resources/button-19.wav"));
			selected --;
			if(selected<1) selected=4;
			update();
			
		}
		if(e.getKeyCode()== KeyEvent.VK_SPACE){
			if(selected ==1)
			this.game.setScreen(new GridToSee(this.game));
			if(selected==2)
				this.game.setScreen(new TestScreen(this.game));
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
			//this.game.setScreen(new MainMenuScreen(this.game));
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		g2.setColor(colors[0]);
		g2.fillRect(0, 0, width, height);
		g2.setColor(colors[1]);
		
		BufferedImage leftImage = null;
		try {
		    leftImage = ImageIO.read(new File(pics[0]));
		} catch (IOException e) {
		}
		BufferedImage rightImage = null;
		try {
		    rightImage = ImageIO.read(new File(pics[1]));
		} catch (IOException e) {
		}
		g2.drawImage(rightImage, 10, 330, 290, 412, null);
		g2.drawImage(leftImage, 700, 330, 290, 412, null);
		
		g2.fillRect(125,50, 750,200);
		
//		g2.fillRect(312, 280, 375,100);
//		g2.fillRect(312, 400, 375,100);
//		g2.fillRect(312, 520, 375,100);
//		g2.fillRect(312, 640, 375,100);
		int y=280;
		for(int i=0;i<options.length-1;i++){
			g2.fillRect(312, y, 375,100);
			y+=120;
		}
		// You really should use an array here
		// yPos[n] array, with n being (selected - 1) -Wilson W.
		int[] yPos={276,396,516,636};
		y=yPos[selected-1];
		g2.setColor(colors[2]);
		g2.fillRect(308,y,383,108);
		
		
		Font times = new Font ("TimesRoman", Font.CENTER_BASELINE, 60);
		Font subTimes = new Font ("TimesRoman", Font.ROMAN_BASELINE, 50);
		g2.setFont(times);
		g2.setColor(Color.white);
		g2.drawString(options[0], 310,165);
		g2.setFont(subTimes);
		g2.drawString(options[1], 395, 350);
		g2.drawString(options[2], 390, 470);
		g2.drawString(options[3], 420, 590);
		g2.drawString(options[4], 450, 710);
		
	}
	
	 public void playSound(File soundName)
	    {
	      try 
	      {
	       AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundName.getAbsoluteFile( ));
	       Clip clip = AudioSystem.getClip( );
	       clip.open(audioInputStream);
	       clip.start( );
	      }
	      catch(Exception ex)
	      {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace( );
	      }
	    }

}