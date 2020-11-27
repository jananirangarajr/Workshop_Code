package com.thoughtworks.sneak.attack.implemtations;

import java.util.ArrayList;

import com.thoughtworks.sneak.attack.util.SneakUtil;

public class Healer {
	
	Participant healer = Participant.Healer;

	public void save(ArrayList<Participant> innocents) {
		
		int randomNumber = SneakUtil.getInstance().getRandomNumber(innocents.size());
		innocents.get(randomNumber).isSaved = true;
		
	}

}
