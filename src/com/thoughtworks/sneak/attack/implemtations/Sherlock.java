package com.thoughtworks.sneak.attack.implemtations;

import java.util.ArrayList;

import com.thoughtworks.sneak.attack.util.SneakUtil;

public class Sherlock extends Participant{
	
	//Participant sherlock = Participant.sherlock;

	public void check(ArrayList<Participant> innocentList) {
		
		if(!sherlock.isKilled) {

			int randomIndex = SneakUtil.getInstance().getRandomNumber(innocentList.size());

			System.out.println("P"+sherlock.getName()+" checks "+"P"+innocentList.get(randomIndex).getName());
			if (innocentList.get(randomIndex).isKiller()) {
				sherlock.Suspected = innocentList.get(randomIndex).getName();
			}
		}
	}
}
