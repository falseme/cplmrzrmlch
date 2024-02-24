package net.falseme.rmlch.ui.window;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.ui.Screen;

public class ImageWindow extends Window {
	private static final long serialVersionUID = 1l;

	private BufferedImage img;

	public ImageWindow(String title, Screen parent) {
		super(title, null, Assets.IMAGE, parent, 0, 0);

		img = Assets.getImage(title);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(img, 3, header.getHeight(), getWidth() - 6, getHeight() - header.getHeight() - 3, null);

	}

}
