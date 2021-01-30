package me.berkeozgen.bday;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Generate {

	private static Scanner scanner;
	private static String content;

	static {
		try {
			InputStream stream = Generate.class.getClassLoader().getResourceAsStream("bday.html"); 
			if (stream == null) {
				throw new FileNotFoundException("bday.html not found.");
			}
			scanner = new Scanner(stream);
			content = "";
			while (scanner.hasNextLine()) {
				content += scanner.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static String generate(String to, String bdaymsg, String msg) {
		if (content == null) {
			return null;
		} else {
			bdaymsg = bdaymsg.substring(0, bdaymsg.length() - 1) +
				" " + to + bdaymsg.substring(bdaymsg.length() - 1);
			return content
				.replaceAll("__bdaymsg__", bdaymsg)
				.replaceAll("__msg__", msg);
		}
	}

}
