package com.thoughtworks.sneak.attack.main;

import java.util.ArrayList;

import com.thoughtworks.sneak.attack.implemtations.Coordinator;
import com.thoughtworks.sneak.attack.implemtations.Game;
import com.thoughtworks.sneak.attack.implemtations.Healer;
import com.thoughtworks.sneak.attack.implemtations.Killer;
import com.thoughtworks.sneak.attack.implemtations.Participant;
import com.thoughtworks.sneak.attack.implemtations.Sherlock;

public class SneakAttack {
	
	public static void main(String[] args) {
		
		Game game = new Game();
		int total_participants = game.getParticipantsCount();

		Coordinator host = new Coordinator(total_participants);
		
		// version 1
		host.createParticipants();
		host.selectKiller();
		host.addInnocents();
		host.selectHealer(); // iteration #4
		host.selectSherLock(); // iteration #5
		host.printStatus();
		
		System.out.println("-----------------------------------------------------------------------");
		
		//version 2
		Killer killer = new Killer();
		killer.killEveryOne(host.getInnocents());
		
		System.out.println("-----------------------------------------------------------------------");
		
		//version 4
		Healer healer = new Healer();
		
		//version 6
		Sherlock sherlock = new Sherlock();
		
		//Version 3
		int i = 1;
		while(true) {
			host.addInnocents();
			System.out.println("Round "+(i++));
			ArrayList<Participant> allPlayers = host.getAllPlayers();
			
			if (!host.checkIsGameAlive(allPlayers)) {
				break;
			}
			
			healer.save(allPlayers); //iteration #4
			
			killer.kill(host.getInnocents()); //# iteration 3
			
			sherlock.check(allPlayers); // iteration 6
			
			//# iteration 3
			host.getSuspetedParticipant();
			host.printSuspected();
			boolean isGameAlive = host.KillSuspected();
			if(!isGameAlive) {
				break;
			}
			host.printRemaining();
		}
		
		System.out.println("-----------------------------------------------------------------------");
		
		
		
	}

}
