package core;

import java.util.Random;

public class MiscLib {
	public static int newRandom(int maxRange) {
		Random rand = new Random();
		int value = rand.nextInt(maxRange) + 1;
		return value;
	}
	
	public static Planet planetRandomizer() {
		
		return null;
	}
}
