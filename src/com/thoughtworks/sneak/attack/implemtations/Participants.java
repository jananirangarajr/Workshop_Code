package com.thoughtworks.sneak.attack.implemtations;

import java.util.HashMap;

import com.thoughtworks.sneak.attack.interfaces.Role;

public class Participants extends Role{
	
	private int name;
	//boolean isKiller;
	boolean isKilled;
	static Participants killer;
	int Suspected;
	
	public Participants() {
		
	}
	Participants(int name) {
		this.name = name;
		//this.isKiller = false;
		this.isKilled = false;
		initializeRole();
	}
	
	public int getName() {
		return name;
	}
	
	public Participants[] getParticipants(int count) {
		
		Participants[] particiapants = new Participants[count];
		
		for (int i = 0; i < count; i++) {
			//String prefix = "P";
			Participants participant = new Participants(+i);
			particiapants[i] = participant;
			
		}
		return particiapants;	
	}
	
	//public void suspectOther(ArrayList<Partici>)
	
}
