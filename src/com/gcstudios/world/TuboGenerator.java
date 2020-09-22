package com.gcstudios.world;

import com.gcstudios.entities.Entity;
import com.gcstudios.entities.Tubo;
import com.gcstudios.main.Game;

public class TuboGenerator {

	public int time = 0;
	public  int curTime = 60;
	public  static int altura1, altura2;
	
	public void tick() {
		time ++;
		if(time == curTime) {
			time = 0;
			altura1 = Entity.rand.nextInt(60 -30)+30;
			Tubo tubo1 = new Tubo(Game.WIDTH,0,20,altura1,1,Game.spritesheet.getSprite(112, 0, 26, 128));
			Game.entities.add(tubo1);
			     
			         
			altura2 = Entity.rand.nextInt(60 - 40)+30;
			Tubo tubo2 = new Tubo(Game.WIDTH,Game.HEIGHT - altura2,20,altura2,1,Game.spritesheet.getSprite(144, 16, 26, 121));
			Game.entities.add(tubo2);
		}
	}
	
	
	
}
