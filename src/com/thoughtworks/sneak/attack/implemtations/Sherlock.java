package com.thoughtworks.sneak.attack.implemtations;

import java.util.ArrayList;

import com.thoughtworks.sneak.attack.util.SneakUtil;

public class Sherlock extends Participant{
	
	static Participant sherlock;
	
	public static void setSherlock(Participant sherlockRef) {
		sherlock = sherlockRef;
	}
	
	public void check(ArrayList<Participant> innocentList) {
		
		if(!sherlock.isKilled) {
			
			ArrayList<Participant> sherLockList = (ArrayList<Participant>) innocentList.clone();
			sherLockList.remove(sherlock);

			int randomIndex = SneakUtil.getInstance().getRandomNumber(innocentList.size()-1);

			System.out.println("P"+sherlock.getName()+" checks "+"P"+innocentList.get(randomIndex).getName());
			if (sherLockList.get(randomIndex).role.isKiller()) {
				sherlock.Suspected = sherLockList.get(randomIndex).getName();
			}
		}
	}
}
