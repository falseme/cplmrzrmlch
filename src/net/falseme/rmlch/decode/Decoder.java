package net.falseme.rmlch.decode;

import java.util.HashMap;

public class Decoder {

	public static final int TYPE0 = 0, TYPE1 = 1, TYPE2 = 2;

	private static HashMap<Character, Character> cesarChars = new HashMap<Character, Character>();
	private static final int cesarCharLimit = 'k';
	private static final int cesarCharUpperLimit = 'K';

	// EXECUTE THIS ON MAIN
	public static void load() {

		// CESAR CODEC // TYPE0
		for (int i = 97; i <= 122; i++) {
			cesarChars.put((char) i, getCesarChar(cesarCharLimit + (i - 97), 122));
		}

		for (int i = 65; i <= 90; i++) {
			cesarChars.put((char) i, getCesarChar(cesarCharUpperLimit + (i - 65), 90));
		}

	}

	private static char getCesarChar(int c, int max) {
		if (c > max)
			return (char) (c - 26);
		return (char) c;
	}

	public static String decode(String input, int type) {

		String output = "";

		switch (type) {
		case TYPE0:

			for (int i = 0; i < input.length(); i++) {
				if (cesarChars.containsKey(input.charAt(i)))
					output = output.concat("" + cesarChars.get(input.charAt(i)));
				else
					output = output.concat("" + input.charAt(i));
			}

			break;
		case TYPE1:

			break;
		case TYPE2:

			break;
		default:
			output = "NULL";
			break;
		}

		if (output.isEmpty())
			return "No decodificable";
		return output;

	}

}
