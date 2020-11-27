package com.thoughtworks.sneak.attack.implemtations;

import com.thoughtworks.sneak.attack.util.SneakUtil;

public class Coordinator {
	
	int total_participants; 
	
	static int randomNumber = 0;
	
	public Coordinator(int total_participants) {
		this.total_participants = total_participants;
	}
	

	public void selectKiller(Participants[] participants) {
		
		int random = SneakUtil.getInstance().getRandomNumber(total_participants);
		participants[random].setKiller();
		//participants[random].isKiller=true;	
	}

	public void printStatus(Participants[] participants) {
		
		for (int i = 0 ; i < participants.length; i++) {
			if (participants[i].isKiller() == Boolean.TRUE) {
				System.out.println(participants[i].getName()+" is Killer");
				Participants.killer = participants[i];
			}
			else {
				System.out.println(participants[i].getName()+" is innocent");
			}
		}
		
	} 
}
