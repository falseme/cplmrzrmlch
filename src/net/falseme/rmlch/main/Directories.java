package net.falseme.rmlch.main;

import java.util.TreeMap;

import net.falseme.rmlch.ui.Screen;
import net.falseme.rmlch.ui.window.DecodecWindow;
import net.falseme.rmlch.ui.window.SecretWindow;
import net.falseme.rmlch.ui.window.Window;

public class Directories {

	private static TreeMap<String, String[]> dirs = new TreeMap<String, String[]>();
	private static final String[] secretKeys = new String[] { "", "1234", "", "", "", "", "12" };
	private static final String[] secretMessages = new String[] { "• • • • • • • • • • •", "• • • • • • • • • • •",
			"• • • • • • • • • • •", "• • • • • • • • • • •", "• • • • • • • • • • •", "• • • • • • • • • • •",
			"• • • • • • • • • • •" };

	// EXECUTE ON MAIN
	public static void load() {

		dirs.put("C:/", new String[] { "Equipo/" });
		dirs.put("C:/Equipo/",
				new String[] { "Documentos/", "Imágenes/", "Videos/", "Música/", "Secret7.exe", "Decodec.exe" });

		dirs.put("C:/Equipo/Documentos/",
				new String[] { "Folder0/", "Folder1/", "Folder2/", "Folder3/" });
		dirs.put("C:/Equipo/Imágenes/", new String[] { "img0.png", "img1.png", "img2.png", "img3.png", "img4.png" });
		dirs.put("C:/Equipo/Videos/", new String[] {});
		dirs.put("C:/Equipo/Música/", new String[] {});

		dirs.put("C:/Equipo/Documentos/Folder0/", new String[] {});
		dirs.put("C:/Equipo/Documentos/Folder1/", new String[] {});
		dirs.put("C:/Equipo/Documentos/Folder2/", new String[] {});
		dirs.put("C:/Equipo/Documentos/Folder3/", new String[] {});

	}

	public static String[] get(String path) {
		if (dirs.containsKey(path))
			return dirs.get(path);
		return null;
	}

	public static Window application(String name, Screen screen) {
		System.out.println("OPEN APP: " + name);
		if (name.toLowerCase().startsWith("secret")) {
			int n = Integer.parseInt(name.substring(6, 7)) - 1;
			return new SecretWindow(name.substring(0, name.length() - 4), secretKeys[n], secretMessages[n], screen);
		}
		if (name.toLowerCase().startsWith("decodec")) {
			return new DecodecWindow(screen);
		}
		return null;
	}

}
