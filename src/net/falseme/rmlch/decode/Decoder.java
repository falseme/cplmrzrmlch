package net.falseme.rmlch.decode;

import java.util.Base64;
import java.util.HashMap;

public class Decoder {

	public static final int TYPE0 = 0, TYPE1 = 1, TYPE2 = 2;

	private static HashMap<Character, Character> cesarChars = new HashMap<Character, Character>();
	private static final int cesarCharLimit = 'k';
	private static final int cesarCharUpperLimit = 'K';

	private static HashMap<Character, Integer> hex2decimal = new HashMap<Character, Integer>();

	// EXECUTE THIS ON MAIN
	public static void load() {

		// CESAR CODEC // TYPE0
		for (int i = 97; i <= 122; i++) {
			cesarChars.put((char) i, getCesarChar(cesarCharLimit + (i - 97), 122));
		}

		for (int i = 65; i <= 90; i++) {
			cesarChars.put((char) i, getCesarChar(cesarCharUpperLimit + (i - 65), 90));
		}

		char[] cs = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		for (int i = 0; i < cs.length; i++) {
			hex2decimal.put(cs[i], i);
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
		case TYPE0: // CESAR SIMPLE (K)

			for (int i = 0; i < input.length(); i++) {
				if (cesarChars.containsKey(input.charAt(i))) {
					output = output.concat("" + cesarChars.get(input.charAt(i)));
				} else {
					output = "";
					break;
				}
			}

			break;
		case TYPE1: // BASE 64

			try {
				byte[] bytes = Base64.getDecoder().decode(input);
				output = new String(bytes);
			} catch (Throwable t) {
				output = "";
			}

			break;
		case TYPE2: // HEX 2 ASCII

			input = input.toUpperCase();
			String ss[] = input.split(" ");
			for (String s : ss) {
				if (s.length() < 2 || !hex2decimal.containsKey(s.charAt(0)) || !hex2decimal.containsKey(s.charAt(1))) {
					output = "";
					break;
				}
				int c = hex2decimal.get(s.charAt(0)) * 16 + hex2decimal.get(s.charAt(1));
				output = output.concat("" + (char) c);
			}

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
