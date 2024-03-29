package net.falseme.rmlch.assets;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage BUTTON;
	public static BufferedImage BUTTON_HOVER;
	public static BufferedImage BUTTON_INACTIVE;
	public static BufferedImage BUTTON_PRESSED;
	public static BufferedImage BUTTON_ERROR;
	public static BufferedImage INNER;
	public static BufferedImage ICON;
	public static BufferedImage SEPARATOR;
	public static BufferedImage TOGGLE_ACTIVE;
	public static BufferedImage RADIO;
	public static BufferedImage RADIO_ACTIVE;
	public static BufferedImage SLIDER_BACKGROUND;
	public static BufferedImage SLIDER_HANDLER;
	public static BufferedImage SLIDER_HANDLER_SQUARE;

	public static BufferedImage[] FOLDER = new BufferedImage[2];
	public static BufferedImage[] LOCKED = new BufferedImage[2];
	public static BufferedImage[] DOCUMENTS = new BufferedImage[2];
	public static BufferedImage[] MYPC = new BufferedImage[2];
	public static BufferedImage[] EXE = new BufferedImage[2];
	public static BufferedImage[] PICTURE = new BufferedImage[2];
	public static BufferedImage[] MUSIC = new BufferedImage[2];

	public static BufferedImage WINMINE;
	public static BufferedImage HELP;
	public static BufferedImage TURNOFF;
	public static BufferedImage SETTINGS;
	public static BufferedImage IMAGE;

	public static BufferedImage WINDOW;
	public static BufferedImage CLOSE;
	public static BufferedImage MIN;
	public static BufferedImage BACK;
	public static BufferedImage NEXT;

	public static BufferedImage PLAY;
	public static BufferedImage PAUSE;
	public static BufferedImage STOP;

	public static BufferedImage CHECK;

	public static BufferedImage DESKTOP_SECRET;

	public static Font w98;

	public static void load() {

		BUTTON = Loader.loadPng("/assets/gui/button.png");
		BUTTON_HOVER = Loader.loadPng("/assets/gui/button_hover.png");
		BUTTON_INACTIVE = Loader.loadPng("/assets/gui/button_inactive.png");
		BUTTON_PRESSED = Loader.loadPng("/assets/gui/button_pressed.png");
		BUTTON_ERROR = Loader.loadPng("/assets/gui/button_error.png");
		INNER = Loader.loadPng("/assets/gui/inner.png");
		ICON = Loader.loadPng("/assets/gui/icon.png");
		SEPARATOR = Loader.loadPng("/assets/gui/separator.png");
		TOGGLE_ACTIVE = Loader.loadPng("/assets/gui/toggle_active.png");
		RADIO = Loader.loadPng("/assets/gui/radio.png");
		RADIO_ACTIVE = Loader.loadPng("/assets/gui/radio_selected.png");
		SLIDER_BACKGROUND = Loader.loadPng("/assets/gui/slider_background.png");
		SLIDER_HANDLER = Loader.loadPng("/assets/gui/slider_handler.png");
		SLIDER_HANDLER_SQUARE = Loader.loadPng("/assets/gui/slider_handler_square.png");

		FOLDER = Loader.loadDesktopIcon("/assets/gui/win/folder");
		LOCKED = Loader.loadDesktopIcon("/assets/gui/win/document_locked");
		DOCUMENTS = Loader.loadDesktopIcon("/assets/gui/win/documents");
		MYPC = Loader.loadDesktopIcon("/assets/gui/win/my_pc");
		EXE = Loader.loadDesktopIcon("/assets/gui/win/program");
		PICTURE = Loader.loadDesktopIcon("/assets/gui/win/image");
		MUSIC = Loader.loadDesktopIcon("/assets/gui/win/music");

		WINMINE = Loader.loadPng("/assets/gui/icons/winmine.png");
		HELP = Loader.loadPng("/assets/gui/icons/help.png");
		TURNOFF = Loader.loadPng("/assets/gui/icons/turnoff.png");
		SETTINGS = Loader.loadPng("/assets/gui/icons/settings.png");
		IMAGE = Loader.loadPng("/assets/gui/icons/image.png");

		WINDOW = Loader.loadPng("/assets/gui/window.png");
		CLOSE = Loader.loadPng("/assets/gui/icons/close.png");
		MIN = Loader.loadPng("/assets/gui/icons/min.png");
		BACK = Loader.loadPng("/assets/gui/icons/back.png");
		NEXT = Loader.loadPng("/assets/gui/icons/next.png");
		
		PLAY = Loader.loadPng("/assets/gui/icons/play.png");
		PAUSE = Loader.loadPng("/assets/gui/icons/pause.png");
		STOP = Loader.loadPng("/assets/gui/icons/stop.png");

		CHECK = Loader.loadPng("/assets/gui/icons/check.png");

		DESKTOP_SECRET = Loader.loadPng("/assets/images/desktop_secret.png");

		w98 = Loader.loadFont("/assets/font/w98.ttf", Font.BOLD, 20);

	}

	public static BufferedImage getImage(String title) {
		return Loader.loadPng("/assets/images/" + title);
	}

}
