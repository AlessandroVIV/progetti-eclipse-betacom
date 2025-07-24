package com.betacom.process;

import com.betacom.objects.Impiegati;
import com.betacom.process.interfaces.IDisplaySalary;
import com.betacom.process.interfaces.ISalaryInsert;
import com.betacom.process.interfaces.implementations.ImpiegatiProcess;
import com.betacom.singleton.MySingleton;

public class ProcessInterface {

	public boolean execute() {
		
		System.out.println("Inizia ProcessInterface\n");
		
		// Provo a lanciare il singleton
		Integer idx = MySingleton.getInstance().computeIndice();
		System.out.println("Valore di idx col singleton: " + idx + "\n");
		
		Impiegati i = new Impiegati("Giulio", "Pernacchia", true, 2000L);
		System.out.println(i);
		
		Object o = new ImpiegatiProcess();
		// Object o = new ProcessData();

		if(o instanceof ISalaryInsert) {
			ISalaryInsert s = (ISalaryInsert) o;
			s.insertNewSalary(i);
			System.out.println("Salario dopo l'interface: " + i.getSalary());
		}
		else {
			System.out.println("Oggetto non compatibile");
		}
		
		if(o instanceof IDisplaySalary) {
			IDisplaySalary d = (IDisplaySalary) o;
			d.formatSalary(i);
		}
		else {
			System.out.println("Oggetto non compatibile");
		}
		
		if(o instanceof ImpiegatiProcess) {
			ImpiegatiProcess p = (ImpiegatiProcess) o;
			p.cambioSalary(i, 2500);
			System.out.println("Dopo cambioSalary(): " + i);
		}
		else {
			System.out.println("Oggetto non compatibile");
		}
	
		return true;
		
	}
	
}
