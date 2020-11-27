package com.thoughtworks.sneak.attack.interfaces;

import java.util.HashMap;

public abstract class Role {
	
	 HashMap<String, Boolean> roles = new HashMap<>(); 
	  
     public void initializeRole() {
    	 roles.put("killer", false);
    	 roles.put("innocnet", true);
    	 roles.put("healer", false);
     }
     
     public void setKiller() {
    	 roles.put("killer", true);
    	 roles.put("innocent",false);
     }
     
     public boolean isKiller() {
    	 return roles.get("killer");
     }
     
     public void setHealer() {
    	 roles.put("healer",true);
     }
     
     public boolean isHealer() {
    	return roles.get("healer");
     }
}
