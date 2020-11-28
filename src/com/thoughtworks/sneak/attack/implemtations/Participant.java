package com.thoughtworks.sneak.attack.implemtations;


import com.thoughtworks.sneak.attack.interfaces.Role;

public class Participant extends Role{
	
	private int name;
	//boolean isKiller;
	boolean isKilled;
	static Participant killer; //#2
	static Participant healer; //#4
	static Participant sherlock; // #6
	int Suspected = -1;
	boolean isSaved = false;
	
	public Participant() {
		
	}
	Participant(int name) {
		this.name = name;
		//this.isKiller = false;
		this.isKilled = false;
		initializeRole();
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
