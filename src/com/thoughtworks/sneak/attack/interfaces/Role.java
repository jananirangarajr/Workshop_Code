package com.thoughtworks.sneak.attack.interfaces;

import java.util.HashMap;

public abstract class Role {
	
	 HashMap<String, Boolean> roles = new HashMap<>(); 
	  
     public void initializeRole() {
    	 roles.put("killer", false);
    	 roles.put("innocnet", true);
     }
     
     public void setKiller() {
    	 roles.put("killer", true);
    	 roles.put("innocent",false);
     }
     
     public boolean isKiller() {
    	 return roles.get("killer");
     }
}
