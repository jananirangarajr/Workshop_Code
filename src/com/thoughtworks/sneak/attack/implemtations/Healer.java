package com.thoughtworks.sneak.attack.implemtations;

import java.util.ArrayList;

import com.thoughtworks.sneak.attack.util.SneakUtil;

public class Healer extends Participant {
	
	static Participant healer; //#4
	
	public static void setHealer(Participant healerObj) {
		healer = healerObj;
	}

	public void save(ArrayList<Participant> innocents) {
		
		if(!healer.isKilled) {

			int randomNumber = SneakUtil.getInstance().getRandomNumber(innocents.size()-1);
			innocents.get(randomNumber).isSaved = true;
			System.out.println("P"+healer.getName()+" heales P"+innocents.get(randomNumber).getName());
		}
	}

}
