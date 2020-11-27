package com.thoughtworks.sneak.attack.implemtations;

import com.thoughtworks.sneak.attack.util.SneakUtil;

public class Play {
	
	Participants[] participants;
	String killerName;
	
	public Play(Participants[] participants) {
		this.participants = participants;
		killerName = Participants.killer.getName();
	}

	public void killEveryOne() {
		
		int randomNumber = SneakUtil.getInstance().getRandomNumber(participants.length);
		int killCount = 0;
		
		if (!(killerName.equals(participants[randomNumber].getName()))) {
			participants[randomNumber].isKilled= true;
			
		}
	}
}
