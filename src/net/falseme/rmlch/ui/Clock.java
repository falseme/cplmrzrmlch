package net.falseme.rmlch.ui;

import java.awt.Color;
import java.awt.Graphics;

import net.falseme.rmlch.assets.Assets;

public class Clock extends ScreenComponent {
	private static final long serialVersionUID = 1l;

	public Clock() {
		super(2, Assets.INNER);
		

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
//		g.fillRect(0, 0, getWidth(), getHeight());
		
	}

}
