package com.thoughtworks.sneak.attack.implemtations;

import java.util.ArrayList;

import com.thoughtworks.sneak.attack.util.SneakUtil;

public class Innocent {

	public ArrayList<Participant> SuspectOne(ArrayList<Participant> innocentList) {
		
		ArrayList<Participant> suspectedList = (ArrayList<Participant>) innocentList.clone();
		for (int i = 0; i < innocentList.size() && innocentList.size() > 1;i++) {
			suspectedList.remove(i);
			int randomInt = SneakUtil.getInstance().getRandomNumber(suspectedList.size());
			int suspectedName = suspectedList.get(randomInt) .getName();
			
			if (suspectedList.get(randomInt).Suspected != -1) {
				innocentList.get(i).Suspected = suspectedName;
				suspectedList = (ArrayList<Participant>) innocentList.clone();
			}
		}
		return innocentList;
	}
}
