package com.thoughtworks.sneak.attack.implemtations;

public class Participants {
	
	String name;
	boolean isKiller;
	boolean isKilled;
	
	Participants(String name) {
		this.name = name;
	}
	
	
	public Participants[] getParticipants(int count) {
		
		Participants[] particiapants = new Participants[count];
		
		for (int i = 0; i < count; i++) {
			String prefix = "P";
			Participants participant = new Participants(prefix+i);
			particiapants[i] = participant;
			
		}
		return particiapants;	
	}
	
}
