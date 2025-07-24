package com.betacom.process;

import com.betacom.process.interfaces.Preda;
import com.betacom.process.interfaces.Predatore;
import com.betacom.process.interfaces.implementations.Gazella;
import com.betacom.process.interfaces.implementations.Leone;
import com.betacom.process.interfaces.implementations.Pesce;

public class ProcessInterface2 {

	public boolean execute() {
		
		System.out.println("Inizia ProcessInterface2\n");
		
		identificate(new Leone());
		identificate(new Gazella());
		identificate(new Pesce());
		
		return true;
		
	}
	
	private void identificate(Object o) {
		
		if(o instanceof Preda) {
			Preda p = (Preda) o;
			p.sonoUnaPreda();
		}
		
		if(o instanceof Predatore) {
			Predatore p1 = (Predatore) o;
			p1.sonoUnPredatore();
		}
		
	}
		
}
