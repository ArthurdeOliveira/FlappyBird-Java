package com.gcstudios.graficos;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.gcstudios.main.Game;

public class UI {

	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.setFont(new Font("arial",Font.BOLD,18));
		g.drawString("Score: " + (Game.score/2),20,20);
	}
	
}
