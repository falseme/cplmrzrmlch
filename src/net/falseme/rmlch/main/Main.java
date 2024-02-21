package net.falseme.rmlch.main;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.ui.Screen;

public class Main {

	public static void main(String[] args) {

		// LOAD ASSETS
		Assets.load();

		// INIT FULLSCREEN APP
		Screen screen = new Screen();
		screen.setVisible(true);

	}

}
