package com.thoughtworks.sneak.attack.main;

import com.thoughtworks.sneak.attack.implemtations.Coordinator;
import com.thoughtworks.sneak.attack.implemtations.Game;

public class SneakAttack {
	
	public static void main(String[] args) {
		
		Game game = new Game();
		int total_participants = game.getParticipantsCount();
		
		
		Coordinator host = new Coordinator(total_participants);
		
		//Participants 
	}

}
