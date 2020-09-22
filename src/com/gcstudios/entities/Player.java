package com.gcstudios.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;
import com.gcstudios.main.Sound;
import com.gcstudios.world.World;


public class Player extends Entity{
	
	public  static boolean isPressed = false;
	public static boolean gravity =false;
	
	private int frames = 0,maxFrames = 10,index = 0, maxIndex = 3;
	
	private BufferedImage[] upPlayer;
	private BufferedImage[] downPlayer;
	
	public Player(int x, double y, int width, int height,double speed,BufferedImage sprite) {
		super(x, y, width, height,speed,sprite);
		
		downPlayer = new BufferedImage[4];
		upPlayer = new BufferedImage[4];
		
		for(int i = 0; i < 4; i++) {       
			downPlayer[i] = Game.spritesheet.getSprite(48 - (i*16) , 0, 16, 32 );
			} 
		for(int i = 0; i < 4 ;i++) {
			upPlayer[i] = Game.spritesheet.getSprite(0+ (i*16), 0, 16, 32);
			}
	}
	
	public void tick(){
	depth = 2;
		
		if(!isPressed) {
			gravity = true;
			if(gravity)
			y+=0.8   ;
		}else {
			y-=1.8;
			//gravity = false;
		}
		if ((y+12) >= Game.HEIGHT) {
			Sound.hurt.play();
			World.restartGame();
			return;
			
		}else if (y <= 0) {
			Sound.hurt.play();
			World.restartGame();
			return;
		}
		
		for(int i =0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			
				if(e != this)
				{
						if(Entity.isColidding(this, e)){
							Sound.hurt.play();
							World.restartGame();
							return;
						}
				}
			
		}
		
		
			frames++;
			if (frames == maxFrames) {
				frames = 0;
				index++;
				if (index > maxIndex) {
					index =0;
				}
			}
		
		
		
	}

	public void render(Graphics g) {
		
			g.drawImage(upPlayer[index], this.getX(),this.getY(), null);
			
			
			
		}

	


}
