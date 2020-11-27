package com.thoughtworks.sneak.attack.implemtations;

import java.util.ArrayList;

import com.thoughtworks.sneak.attack.util.SneakUtil;

public class Coordinator {
	
	int total_participants;
	ArrayList<Participants> innocentList = new ArrayList<Participants>();
	ArrayList<Participants> killedList = new ArrayList<Participants>();
	
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
				System.out.println("P"+participants[i].getName()+" is Killer");
				Participants.killer = participants[i];
			}
			else {
				System.out.println("P"+participants[i].getName()+" is innocent");
			}
		}
		
	}
	
	public ArrayList<Participants> getInnocents(Participants[] participants) {
		for (int i = 0 ; i < participants.length; i++) {
			if (!participants[i].isKiller() && !participants[i].isKilled) {
				innocentList.add(participants[i]);
			}
		}
		return innocentList;
	}

	public Participants getSuspetedParticipant() {
		for (int i = 0 ; i <  innocentList.size(); i++) {
			int randomIndex;
			while(true) {
				 randomIndex = SneakUtil.getInstance().getRandomNumber(innocentList.size());
				 if(randomIndex != innocentList.get(i).getName()) {
					 int suspectedCount = innocentList.get(randomIndex).Suspected+1;
				 }
			}
			
			
		}
		return null;
	}


	public boolean KillSuspected(Participants suspectedParticipant) {
		// TODO Auto-generated method stub
		return false;
	}

}
