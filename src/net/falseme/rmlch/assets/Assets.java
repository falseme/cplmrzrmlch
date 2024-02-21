package net.falseme.rmlch.assets;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage BUTTON;
	public static BufferedImage BUTTON_HOVER;
	public static BufferedImage BUTTON_PRESSED;
	public static BufferedImage ICON;
	
	public static Font w98;
	
	public static void load() {
		
		BUTTON = Loader.loadPng("/assets/gui/button.png");
		BUTTON_HOVER = Loader.loadPng("/assets/gui/button_hover.png");
		BUTTON_PRESSED = Loader.loadPng("/assets/gui/button_pressed.png");
		ICON = Loader.loadPng("/assets/gui/icon.png");
		
		w98 = Loader.loadFont("/assets/font/w98.ttf", Font.PLAIN, 12);
		
	}
	
}
