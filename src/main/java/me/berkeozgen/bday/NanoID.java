package me.berkeozgen.bday;

import static com.aventrix.jnanoid.jnanoid.NanoIdUtils.randomNanoId;

import java.util.Random;

public class NanoID {

	private static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private static Random random = new Random();

	public static String generate(int size) {
		return randomNanoId(random, alphabet, size);
	}

}
