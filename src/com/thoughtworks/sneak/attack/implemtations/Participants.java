package com.thoughtworks.sneak.attack.implemtations;

import java.util.HashMap;

import com.thoughtworks.sneak.attack.interfaces.Role;

public class Participants extends Role{
	
	private String name;
	//boolean isKiller;
	boolean isKilled;
	static Participants killer;
	
	public Participants() {
		
	}
	Participants(String name) {
		this.name = name;
		//this.isKiller = false;
		this.isKilled = false;
		initializeRole();
	}
	
	public String getName() {
		return name;
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
