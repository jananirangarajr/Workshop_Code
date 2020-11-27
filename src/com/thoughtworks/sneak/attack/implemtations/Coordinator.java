package com.thoughtworks.sneak.attack.implemtations;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.sneak.attack.util.SneakUtil;

public class Coordinator {
	
	int total_participants;
	Participant[] participants;
	
	ArrayList<Participant> innocentList = new ArrayList<Participant>();
	
	static int randomNumber = 0;
	
	public Coordinator(int total_participants) {
		this.total_participants = total_participants;
	}
	
	public void createParticipants() {
		Participant participant = new Participant();
		participants = participant.getParticipants(total_participants);
	}
	
	//Method to select Killer

	public void selectKiller() {
		
		int randomIndex = SneakUtil.getInstance().getRandomNumber(total_participants);
		participants[randomIndex].setKiller();
		//participant[random].isKiller=true;	
	}
	
	//Method to add innocents
	public void addInnocents() {
		for (int i = 0 ; i < participants.length; i++) {
			if (!participants[i].isKiller() && !participants[i].isKilled) {
				innocentList.add(participants[i]);
			}
		}	
	}
	
	//Method to get Innocents
	public ArrayList<Participant> getInnocents() {
		return innocentList;
	}
	
	//Method to selectHealer
	public void selectHealer() {
		int randomIndex = SneakUtil.getInstance().getRandomNumber(innocentList.size());
		participants[randomIndex].setHealer();
	}
	
	//method to print innocent/healer/killer
	public void printStatus() {
		
		for (int i = 0 ; i < participants.length; i++) {
			if (participants[i].isKiller() == Boolean.TRUE) {
				System.out.println("P"+participants[i].getName()+" is Killer");
				Participant.killer = participants[i];
			}
			else if(participants[i].isHealer() == Boolean.TRUE) {
				System.out.println("P"+participants[i].getName()+" is Healer");
			}
			else {
				System.out.println("P"+participants[i].getName()+" is innocent");
			}
		}
		
	}

	public void getSuspetedParticipant() {
		ArrayList<Participant> suspectedList = (ArrayList<Participant>) innocentList.clone();
		for (int i = 0; i < innocentList.size();i++) {
			suspectedList.remove(i);
			int randomInt = SneakUtil.getInstance().getRandomNumber(suspectedList.size());
			int suspectedName = suspectedList.get(randomInt) .getName();
			innocentList.get(i).Suspected = suspectedName;
			suspectedList = (ArrayList<Participant>) innocentList.clone();
		}
	}


	public boolean KillSuspected() {
		int[] trackCount = new int[total_participants];
		boolean isAlive = true;
		for (int i = 0; i < innocentList.size(); i++) {
			int index = innocentList.get(i).Suspected;
			int count = trackCount[index];
			trackCount[index] = count+1;
		}
		ArrayList<Integer> killParticipants = getMaxIndexes(trackCount);
		
		for (int i = 0;  i < killParticipants.size(); i++) {
			int killPersonIndex = killParticipants.get(i);
			if (participants[killPersonIndex].isKiller()) {
				isAlive = false;
			}
			else if(!participants[killPersonIndex].isKilled) {
				participants[killPersonIndex].isKilled = true;
			}
		}
		return isAlive;
	}

	private ArrayList<Integer> getMaxIndexes(int[] trackCount) {
		ArrayList<Integer> killParticipants = new ArrayList<Integer>();
		int maxCount = 0;
		int maxIndex = 0;
		for (int i = 0; i < trackCount.length; i++) {
			if (maxCount < trackCount[i]) {
				maxCount = trackCount[i];
				maxIndex = i;
			}
			if (maxIndex < i && maxCount == trackCount[i]) {
				killParticipants.add(maxIndex);
				//killParticipants.add(i);
				maxIndex = i;
			}
		}
		killParticipants.add(maxIndex);
		return killParticipants;
	}

	public void printSuspected() {
		
		for (int i = 0; i < innocentList.size();i++) {
			System.out.println("P"+innocentList.get(i).getName()+" Suspects P"+innocentList.get(i).Suspected);
		}
		
	}

	public void printRemaining() {
//		for (int i = 0; i < innocentList.size(); i++) {
//			System.out.println("P"+innocentList.get(i).getName()+" is alive");
//		}
		for (int i = 0; i < participants.length; i++) {
			if (!participants[i].isKilled) {
				System.out.print("P"+participants[i].getName()+" is Alive");
			}
		}
		
	}

}
