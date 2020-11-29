package com.thoughtworks.sneak.attack.implemtations;

import java.util.ArrayList;

import com.thoughtworks.sneak.attack.util.SneakUtil;

public class Killer extends Participant{
	
	static Participant killer;
	
	//Interation 3
	//Method to kill one person
	
	public static void setKiller(Participant killerObj) {
		killer = killerObj;
	}
	public void kill(ArrayList<Participant> innocentList) {
		
		ArrayList<Participant> killerList = (ArrayList<Participant>) innocentList.clone();
		killerList.remove(killer);
		
		int randomNumber = SneakUtil.getInstance().getRandomNumber(killerList.size()-1);
		if (!killerList.get(randomNumber).isSaved) {
			System.out.println("P"+killer.getName()+" killed P"+innocentList.get(randomNumber).getName());
			innocentList.get(innocentList.indexOf(killerList.get(randomNumber))).isKilled=true;
			innocentList.remove(innocentList.indexOf(killerList.get(randomNumber)));
		}
	}
	
	//Iteration 2
	//Method to killEveryOne in iteration
	public void killEveryOne(ArrayList<Participant> innocents) {
		int round =1;
		while (innocents.size() > 1) {
			System.out.println("Round "+round);
			int randomNumber = SneakUtil.getInstance().getRandomNumber(innocents.size()-1); 
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
