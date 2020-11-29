package com.thoughtworks.sneak.attack.implemtations;


import com.thoughtworks.sneak.attack.interfaces.Role;

public class Participant {
	
	private int name;
	boolean isKilled;
	Role role;
	int Suspected;
	boolean isSaved;
	
	public Participant() {
		
	}
	
	Participant(int name) {
		this.name = name;
		//this.isKiller = false;
		this.isKilled = false;
		role = new Role();
	}
	
	public int getName() {
		return name;
	}
	
	public Participant[] getParticipants(int count) {
		
		Participant[] particiapants = new Participant[count];
		
		for (int i = 0; i < count; i++) {
			//String prefix = "P";
			Participant participant = new Participant(+i);
			particiapants[i] = participant;
			
		}
		return particiapants;	
	}
	
}
