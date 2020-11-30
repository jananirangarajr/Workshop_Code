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
		
		int randomIndex = SneakUtil.getInstance().getRandomNumber(total_participants-1);
		participants[randomIndex].role.setKiller();
		Killer.setKiller(participants[randomIndex]);	
	}
	
	//Method to select SherLock
	public void selectSherLock() {
		
		ArrayList<Participant> sherLockList = (ArrayList<Participant>) innocentList.clone();
		sherLockList.remove(sherLockList.indexOf(Healer.healer));
		
		int randomIndex = SneakUtil.getInstance().getRandomNumber(sherLockList.size()-1);
		
		innocentList.get(innocentList.indexOf(sherLockList.get(randomIndex))).role.setSherLock();
		Sherlock.setSherlock(sherLockList.get(randomIndex));

	}
	

	//Method to selectHealer
	public void selectHealer() {
		int randomIndex = SneakUtil.getInstance().getRandomNumber(innocentList.size()-1);
		participants[randomIndex].role.setHealer();
		Healer.setHealer(participants[randomIndex]);
	}
	
	//Method to add innocents
	public void addInnocents() {
		innocentList.removeAll(innocentList);
		for (int i = 0 ; i < participants.length; i++) {
			if (!participants[i].role.isKiller() && !participants[i].isKilled) {
				innocentList.add(participants[i]);
			}
		}
		setSuspectAndSaved(); // iteration 6
	}

	private void setSuspectAndSaved() {
		for (int i = 0 ; i < innocentList.size(); i++) {
			innocentList.get(i).isSaved=false;
			innocentList.get(i).Suspected=-1;
		}
		
	}

	//Method to get Innocents
	
	public ArrayList<Participant> getInnocents() {
		return innocentList;
	}
	
	//Method to get alive players with killer
	public ArrayList<Participant> getAllPlayers() {
		ArrayList<Participant> returnList = (ArrayList<Participant>) innocentList.clone();
		if (!Killer.killer.isKilled) {
			returnList.add(Killer.killer);
		}
		return returnList;
	}
	
	//method to print innocent/healer/killer
	public void printStatus() {
		
		for (int i = 0 ; i < participants.length; i++) {
			if (participants[i].role.isKiller()) {
				System.out.println("P"+participants[i].getName()+" is Killer");
			}
			else if(participants[i].role.isHealer()) {
				System.out.println("P"+participants[i].getName()+" is Healer");
			}
			else if(participants[i].role.isSherLock()) {
				System.out.println("P"+participants[i].getName()+" is Sherlock");
			}
			else {
				System.out.println("P"+participants[i].getName()+" is innocent");
			}
		}
		
	}

	public void getSuspetedParticipant() {
		
		Innocent innocent = new Innocent();
		innocentList = innocent.SuspectOne(getAllPlayers());
		innocentList.remove(Killer.killer);
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
			if (participants[killPersonIndex].role.isKiller() && !participants[killPersonIndex].isSaved) {
				System.out.println("Killer Killed. Match Ends.");
				isAlive = false;
			}
			else if(!participants[killPersonIndex].isKilled && !participants[killPersonIndex].isSaved) {
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
				killParticipants.removeAll(killParticipants);
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
		System.out.println("Remaining List");
		for (int i = 0; i < participants.length; i++) {
			if (!participants[i].isKilled) {
				System.out.print("P"+participants[i].getName()+",");
			}
		}
		System.out.println();
	}

	public void clearHealer() {
		
		for (int i = 0; i < participants.length; i++) {
			if(participants[i].isSaved) {
				participants[i].isSaved = false;
			}
		}
		
	}

	public boolean checkIsGameAlive(ArrayList<Participant> allPlayers) {
		
		if (allPlayers.size() <= 2) {
			if (allPlayers.size() == 1 && allPlayers.get(0).role.isKiller() == true) {
				System.out.println("Killer wins");
			}
			else if (allPlayers.size() == 2 && allPlayers.indexOf(Killer.killer) >= 0 && allPlayers.indexOf(Healer.healer) >=0 ) {
				System.out.print("Withdraw");
			}
			else {
				System.out.println("Killer wins");
			}
			return false;
		}
		
		return true;
	}

}
