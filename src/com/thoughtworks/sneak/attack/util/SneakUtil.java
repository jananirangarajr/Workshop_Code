package com.thoughtworks.sneak.attack.util;

import java.util.Random;

public class SneakUtil {
	
	static SneakUtil sneak = null;
	static int randomNumber = 0;
	
	public static SneakUtil getInstance() {
		if (sneak == null) {
			sneak = new SneakUtil();
		}
		return sneak;
	}

	public int getRandomNumber(int endIndex) {
		
		Random random = new Random(); 
		return random.nextInt(endIndex); 
	}
}
