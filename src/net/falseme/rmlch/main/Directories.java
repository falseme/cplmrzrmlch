package net.falseme.rmlch.main;

import java.util.TreeMap;

import net.falseme.rmlch.ui.Screen;
import net.falseme.rmlch.ui.window.DecodecWindow;
import net.falseme.rmlch.ui.window.SecretWindow;
import net.falseme.rmlch.ui.window.Window;

public class Directories {

	private static TreeMap<String, String[]> dirs = new TreeMap<String, String[]>();
	private static final String[] secretKeys = new String[] { "comotanmuchacho?", "patas", "paracuandolatercera?HDP!",
			"Remolacha", "Warden", "Uvas", "nigger" };
	private static final String[] secretMessages = new String[] { "# # # # # # # # # # #", "# # # # # # # # # # #",
			"# # # # # # # # # # #", "# # # # # # # # # # #", "# # # # # # # # # # #", "# # # # # # # # # # #",
			"# # # # # # # # # # #" };

	// EXECUTE ON MAIN
	public static void load() {

		dirs.put("C:/", new String[] { "Equipo/" });
		dirs.put("C:/Equipo/",
				new String[] { "Documentos/", "Imágenes/", "Videos/", "Música/", "Secret7.exe", "Decodec.exe" });

		dirs.put("C:/Equipo/Documentos/", new String[] { "m7B/", "DW4/", "EdW/", "z0/" });
		dirs.put("C:/Equipo/Imágenes/",
				new String[] { "6D6F.png", "6E6D.png", "cuatro.png", "6861.png", "6F3F.png", "Secret1.exe" });
		dirs.put("C:/Equipo/Videos/", new String[] { "tres.png" });
		dirs.put("C:/Equipo/Música/", new String[] {});

		dirs.put("C:/Equipo/Documentos/m7B/",
				new String[] { "todas.png", "moon.png", "spring.png", "night.png", "winter.png", "Secret3.exe" });
		dirs.put("C:/Equipo/Documentos/DW4/", new String[] { "apw.png", "Secret4.exe" });
		dirs.put("C:/Equipo/Documentos/EdW/", new String[] { "wither.png", "warden.png", "Secret5.exe" });
		dirs.put("C:/Equipo/Documentos/z0/", new String[] { "perdido.png", "Secret6.exe" });

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
