package com.betacom.process.interfaces.implementations;

import com.betacom.process.interfaces.Preda;
import com.betacom.process.interfaces.Predatore;

public class Gazella implements Preda, Predatore {
	
    @Override
    public void sonoUnaPreda() {
        System.out.println("Sono la Gazella preda");
    }

	@Override
	public void sonoUnPredatore() {
		System.out.println("Sono la Gazella predatrice");		
	}
    
    
    
}


