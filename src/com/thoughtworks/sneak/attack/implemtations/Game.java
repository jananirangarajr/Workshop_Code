package com.thoughtworks.sneak.attack.implemtations;

public class Game {
	
	int no_of_participants = 6;
	boolean isAlive = true;
	
	/*public void setParticipants(int count) {
		no_of_participants = count;
	}*/
	
	public int getParticipantsCount() {
		return no_of_participants;
	}
	
	public void setIsAlive() {
		isAlive = false;
	}
	
	public boolean isGameAlive() {
		return isAlive;
	}
}
