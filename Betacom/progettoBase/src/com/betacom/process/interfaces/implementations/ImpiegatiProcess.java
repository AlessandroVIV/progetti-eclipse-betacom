package com.betacom.process.interfaces.implementations;

import java.text.NumberFormat;
import java.util.Locale;

import com.betacom.objects.Impiegati;
import com.betacom.process.interfaces.IDisplaySalary;
import com.betacom.process.interfaces.ISalaryInsert;

public class ImpiegatiProcess implements ISalaryInsert, IDisplaySalary{

	@Override
	public void insertNewSalary(Impiegati imp) {

		long quota = 0;
		
		if(imp.getSesso()) {
			quota = 2;
			imp.setSalary((long) imp.getSalary() * quota);
		} else {
			quota = (long) 1.5;
			imp.setSalary((long) imp.getSalary() * quota);
		}
		
	}
	
	@Override
	public void formatSalary(Impiegati imp) {
		// Metto il salario italiano
		System.out.println("Salario: " + NumberFormat.getCurrencyInstance(Locale.ITALY).format(imp.getSalary()));
	}
	
	// Metodo fuori interface
	public void cambioSalary(Impiegati imp, long salary) {
		imp.setSalary(salary);
	}

}
