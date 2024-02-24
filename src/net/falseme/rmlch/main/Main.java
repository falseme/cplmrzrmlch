package net.falseme.rmlch.main;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.decode.Decoder;
import net.falseme.rmlch.ui.Screen;

/*
 * Author @Falseme
 * NO LO MIRES POR FAVOR, ESTÁ MAL HECHO NO LO MIRES. LO HICE RÁPIDO. PERDÓN...
 */
public class Main {

	public static void main(String[] args) {

		System.out.println("LOADING...");

		// LOAD ASSETS
		Assets.load();

		// DIRECTORIES
		Directories.load();

		// DECODER
		Decoder.load();

		// INIT FULLSCREEN APP
		Screen screen = new Screen();
		screen.setVisible(true);

	}

}
