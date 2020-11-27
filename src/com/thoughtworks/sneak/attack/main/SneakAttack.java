package com.thoughtworks.sneak.attack.main;

import com.thoughtworks.sneak.attack.implemtations.Coordinator;
import com.thoughtworks.sneak.attack.implemtations.Game;
import com.thoughtworks.sneak.attack.implemtations.Participants;
import com.thoughtworks.sneak.attack.implemtations.Play;

public class SneakAttack {
	
	public static void main(String[] args) {
		
		Game game = new Game();
		int total_participants = game.getParticipantsCount();
		
		Participants participant = new Participants();
		Participants[] participants = participant.getParticipants(total_participants);
		
		Coordinator host = new Coordinator(total_participants);
		host.selectKiller(participants);
		host.printStatus(participants);
		
		Play play = new Play(participants);
		play.killEveryOne();
		
	}

}
