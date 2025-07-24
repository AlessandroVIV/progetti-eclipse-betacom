package com.betacom.process;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import com.betacom.exception.AcademyException;
import com.betacom.utils.ReflactionManager;

public class ProcessReflection {

	private Object myClass = null;
	
	public boolean execute() {
		
		ReflactionManager manager = new ReflactionManager();

		System.out.println("Inizio di ProcessReflection\n");
		
		// Voglio capire se la classe esiste o no per caricare un oggetto "class"
		String packageName = "com.betacom.objects";
		String className = "MyClassReflection";
		
		// Prendo il costruttore con 3 parametri
		Integer selezionaCostruttore = 3;
		
		Object [] params = {20, "Test 2", 45};
		
		//Object [] params = {20, "Test 2", 45, "gigi"};
		
		//Object [] params = {20, "Test 2"};
		
		//Object [] params = {};
		
		try {
			
			Object myClass = retrieveConstructor(packageName + "." + className, params);
			
			String nomeMetodo = "toString";
			
			Method toString = myClass.getClass().getMethod(nomeMetodo);
			
			String msg = (String) manager.executeMethod(myClass, "toString", params);
			
			System.out.println(msg);
			
			return true;
								
		} catch (AcademyException e) {
			System.out.println(e.getMessage());
		} catch (NoSuchMethodException e) {
			System.out.println(e.getMessage());
		} catch (SecurityException e) {
			System.out.println(e.getMessage());
		} 
		
		return true;
	}
	
	private Object retrieveConstructor(String className, Object[] params) throws AcademyException {
		
		try {
			
			Object myClass = null;
			
			Class cl = Class.forName(className);
			
			Constructor [] costruttore = cl.getConstructors();
			
			Constructor costruttoreSelezionato = null;
			
			for(Constructor cstr1 : costruttore) {
				
				if(cstr1.getParameterCount() == params.length) {
					costruttoreSelezionato = cstr1;
					break;
				}
				
			}
			
			if(costruttoreSelezionato == null) {
				throw new AcademyException("Costruttore non trovato con questi parametri!");
			}
			
			return costruttoreSelezionato.newInstance(params);
						
		} catch (ClassNotFoundException e) {
			throw new AcademyException("Classe non trovata: " + e.getMessage());
		} catch (InstantiationException e) {
			throw new AcademyException("InstantiationException: " + e.getMessage());
		} catch (IllegalAccessException e) {
			throw new AcademyException("IllegalAccessException: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			throw new AcademyException("IllegalArgumentException: " + e.getMessage());
		} catch (InvocationTargetException e) {
			throw new AcademyException("InvocationTargetException: " + e.getMessage());

		}
			
	}
	
	/*
		try {
			
			// Cerca classe
			Class cl = Class.forName(packageName + "." + className);
			System.out.println("Classe: " + packageName + "." + className + " trovata!");
			
			// Cerca costruttore
			Object myClass = null;
			Constructor [] costruttore = cl.getConstructors();
			
			// Seleziono uno specifico
			Constructor costruttoreSelezionato = null;
			
			System.out.println("\nIl numero di costruttori trovati è: " + costruttore.length); // Stampa 2 
			
			// Introspezione construttori, per ogni costruttore istanzato...
			for(Constructor cstr : costruttore) {
				
				// Cerco tramite parametri number per tutti i costruttori. Il primo è vuoto, il secondo ne ha 3
				System.out.println("\nNumeri di parametri per costruttore: " + cstr.getParameterCount());
				
				// Mi prendo il costruttore interessato
				if(cstr.getParameterCount() == selezionaCostruttore) {
					costruttoreSelezionato = cstr;
				}
				
				// Cerco tipo di parametro vedendone il tipo
				Type [] tipo = cstr.getGenericParameterTypes();
				
				for(Type t : tipo) {
					System.out.println("Tipo di parametro: " + t);
				}
				
				// Nuova istanza
				if(selezionaCostruttore == 0) {
					myClass = costruttoreSelezionato.newInstance();
				}
				
				if(selezionaCostruttore == 2) {
					myClass = costruttoreSelezionato.newInstance(10, "Test");
				}
				
				if(selezionaCostruttore == 3) {
					myClass = costruttoreSelezionato.newInstance(20, "Test 2", 45);
				}
				
				System.out.println("Dopo la nuova istanza");
				
				// Introspezione dei metodi, prendo la classe e i suoi metodi disponibili
				Method [] metodi = myClass.getClass().getMethods();
				
				// Stampo tutti i metodi disponibili
				for(Method m : metodi) {
					
					System.out.println("\nMetodo trovato: " + m.getName());
					
					// Invoco il metodo
					if("setId".equalsIgnoreCase(m.getName())) {
						m.invoke(myClass, 20);
					}
					
					if("setDesc".equalsIgnoreCase(m.getName())) {
						m.invoke(myClass, "Test reflection");
					}
					
					if("setP1".equalsIgnoreCase(m.getName())) {
						m.invoke(myClass, 99);
					}
					
				}
				
				// Metodo di accesso diretto
				String nomeMetodo = "toString";
				
				Method toString = myClass.getClass().getMethod(nomeMetodo);
				
				String messaggio = (String) toString.invoke(myClass);
				
				System.out.println("\n" + messaggio);
				
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found: " + e.getMessage());
			return false;
		} catch (InstantiationException e) {
			System.out.println("InstantiationException: " + e.getMessage());
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("IllegalAccessException: " + e.getMessage());
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException: " + e.getMessage());
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			System.out.println("InvocationTargetException: " + e.getMessage());
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println("NoSuchMethodException: " + e.getMessage());
			e.printStackTrace();
		} catch (SecurityException e) {
			System.out.println("SecurityException: " + e.getMessage());
			e.printStackTrace();
		}
		
		return true;
	}
	
	*/
	
}
