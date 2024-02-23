package net.falseme.rmlch.assets;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage BUTTON;
	public static BufferedImage BUTTON_HOVER;
	public static BufferedImage BUTTON_PRESSED;
	public static BufferedImage INNER;
	public static BufferedImage ICON;
	public static BufferedImage SEPARATOR;
	public static BufferedImage TOGGLE_ACTIVE;
	public static BufferedImage RADIO;
	public static BufferedImage RADIO_ACTIVE;

	public static BufferedImage[] FOLDER = new BufferedImage[2];
	public static BufferedImage[] LOCKED = new BufferedImage[2];
	public static BufferedImage[] DOCUMENTS = new BufferedImage[2];
	public static BufferedImage[] MYPC = new BufferedImage[2];
	public static BufferedImage[] EXE = new BufferedImage[2];

	public static BufferedImage WINDOW;
	public static BufferedImage CLOSE;
	public static BufferedImage MIN;
	
	public static BufferedImage CHECK;

	public static Font w98;

	public static void load() {

		BUTTON = Loader.loadPng("/assets/gui/button.png");
		BUTTON_HOVER = Loader.loadPng("/assets/gui/button_hover.png");
		BUTTON_PRESSED = Loader.loadPng("/assets/gui/button_pressed.png");
		INNER = Loader.loadPng("/assets/gui/inner.png");
		ICON = Loader.loadPng("/assets/gui/icon.png");
		SEPARATOR = Loader.loadPng("/assets/gui/separator.png");
		TOGGLE_ACTIVE = Loader.loadPng("/assets/gui/toggle_active.png");
		RADIO = Loader.loadPng("/assets/gui/radio.png");
		RADIO_ACTIVE = Loader.loadPng("/assets/gui/radio_selected.png");

		FOLDER = Loader.loadDesktopIcon("/assets/gui/win/folder");
		LOCKED = Loader.loadDesktopIcon("/assets/gui/win/document_locked");
		DOCUMENTS = Loader.loadDesktopIcon("/assets/gui/win/documents");
		MYPC = Loader.loadDesktopIcon("/assets/gui/win/my_pc");
		EXE = Loader.loadDesktopIcon("/assets/gui/win/program");

		WINDOW = Loader.loadPng("/assets/gui/window.png");
		CLOSE = Loader.loadPng("/assets/gui/icons/close.png");
		MIN = Loader.loadPng("/assets/gui/icons/min.png");
		
		CHECK = Loader.loadPng("/assets/gui/icons/check.png");

		w98 = Loader.loadFont("/assets/font/w98.ttf", Font.BOLD, 20);

	}

}
