package com.thoughtworks.sneak.attack.implemtations;

public class Coordinator {
	
	int total_participants; 
	
	static int randomNumber = 1;
	
	public Coordinator(int total_participants) {
		this.total_participants = total_participants;
	}
	
	public int getRandomNumber() {
		
		if (randomNumber+1 < total_participants) {
			return randomNumber+1;
		}
		else {
			return randomNumber-1;
		}	
	}
	 
}
