package com.thoughtworks.sneak.attack.main;

import java.util.ArrayList;

import com.thoughtworks.sneak.attack.implemtations.Coordinator;
import com.thoughtworks.sneak.attack.implemtations.Game;
import com.thoughtworks.sneak.attack.implemtations.Killer;
import com.thoughtworks.sneak.attack.implemtations.Participants;

public class SneakAttack {
	
	public static void main(String[] args) {
		
		Game game = new Game();
		int total_participants = game.getParticipantsCount();
		
		Participants participant = new Participants();
		Participants[] participants = participant.getParticipants(total_participants);
		
		Coordinator host = new Coordinator(total_participants);
		host.selectKiller(participants);
		host.printStatus(participants);
		//version 2
		//host.killEveryOne(participants);
		//Version 3
		Killer killer = new Killer();
		for (int i = 0; i < total_participants; i++) {
			
			ArrayList<Participants> innocentList = host.getInnocents(participants);
			killer.kill(innocentList);
			
			Participants suspectedParticipant = host.getSuspetedParticipant();
			boolean isGameAlive = host.KillSuspected(suspectedParticipant);
			if(!isGameAlive) {
				break;
			}
		}
		
	}

}
