package com.thoughtworks.sneak.attack.implemtations;

import java.util.ArrayList;

import com.thoughtworks.sneak.attack.util.SneakUtil;

public class Killer {

	public void kill(ArrayList<Participants> innocentList) {
		int randomNumber = SneakUtil.getInstance().getRandomNumber(innocentList.size());
		
		innocentList.get(randomNumber).isKilled = true;
		innocentList.remove(randomNumber);
	}
	
	
}
