package com.thoughtworks.sneak.attack.implemtations;

import java.util.ArrayList;

import com.thoughtworks.sneak.attack.util.SneakUtil;

public class Killer {
	
	Participant killer = Participant.killer;
	
	//Interation 3
	//Method to kill one person
	public void kill(ArrayList<Participant> innocentList) {
		int randomNumber = SneakUtil.getInstance().getRandomNumber(innocentList.size());
		System.out.println("P"+killer.getName()+" killed P"+innocentList.get(randomNumber).getName());
		innocentList.remove(randomNumber);
	}
	
	//Iteration 2
	//Method to killEveryOne in iteration
	public void killEveryOne(ArrayList<Participant> innocents) {
		int round =1;
		while (innocents.size() > 1) {
			System.out.println("Round "+round);
			int randomNumber = SneakUtil.getInstance().getRandomNumber(innocents.size()); 
			System.out.println("P"+killer.getName()+" killed P"+innocents.get(randomNumber).getName());
			innocents.remove(randomNumber);
			round++;
			printRemaining(innocents);
		}
		
	}

	private void printRemaining(ArrayList<Participant> innocents) {
		System.out.println("Remaining participants");
		for (int i = 0 ;i < innocents.size(); i++) {
			System.out.print("P"+innocents.get(i).getName()+",");
		}
		System.out.println();
		
	}
	
	
}
