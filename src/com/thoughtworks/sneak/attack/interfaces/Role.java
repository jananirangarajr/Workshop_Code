package com.thoughtworks.sneak.attack.interfaces;

import java.util.HashMap;

public class Role {
	
	 HashMap<String, Boolean> roles = new HashMap<>(); 
	  
     public Role() {
    	 roles.put("killer", false);
    	 roles.put("innocnet", true);
    	 roles.put("healer", false);
    	 roles.put("sherlock", false); //#6
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
     
     public void setSherLock() {
    	 roles.put("sherlock", true);
     }
     public boolean isSherLock() {
    	 return roles.get("sherlock");
     }
}
