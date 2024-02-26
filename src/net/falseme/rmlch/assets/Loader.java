package net.falseme.rmlch.assets;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;

public class Loader {

	public static BufferedImage loadPng(String path) {

		BufferedImage png = null;

		try {

			URL url = Loader.class.getResource(path);
			png = ImageIO.read(url);

		} catch (Exception e) {
			System.out.println("ERROR: COULD NOT LOAD PNG:" + path);
		}

		return png;

	}

	public static BufferedImage[] loadDesktopIcon(String path) {

		BufferedImage[] icons = new BufferedImage[2];

		try {

			icons[0] = ImageIO.read(Loader.class.getResource(path + ".png"));
			icons[1] = ImageIO.read(Loader.class.getResource(path + "_focus.png"));

		} catch (Exception e) {
			System.out.println("ERROR: COULD NOT DESKTOP ICON PNG:" + path);
		}

		return icons;

	}

	public static Font loadFont(String path, int style, int size) {

		Font font;

		try {

			InputStream is = Loader.class.getResourceAsStream(path);
			font = Font.createFont(Font.TRUETYPE_FONT, is);

		} catch (FontFormatException | IOException e) {
			System.out.println("ERROR: COULD NOT LOAD FONT:" + path);
			font = new Font("Console", Font.PLAIN, 12);
		}

		return font.deriveFont(style, size);

	}

	public static AudioFile loadAudioFile(String path) {

		AudioFile audioFile = null;

		try {

			InputStream in = Loader.class.getResourceAsStream(path);
			if (in == null)
				return null;

			System.out.println(in.hashCode());
			File tempFile = File.createTempFile(String.valueOf(in.hashCode()), ".mp3");
			tempFile.deleteOnExit();

			try (FileOutputStream out = new FileOutputStream(tempFile)) {
				// copy stream
				byte[] buffer = new byte[1024];
				int bytesRead;
				while ((bytesRead = in.read(buffer)) != -1) {
					out.write(buffer, 0, bytesRead);
				}
			}

			audioFile = AudioFileIO.read(tempFile);

		} catch (Exception e) {

			System.out.println("ERROR: COULD NOT LOAD AUDIOFILE");
			e.printStackTrace();

		}

		return audioFile;

	}

}
