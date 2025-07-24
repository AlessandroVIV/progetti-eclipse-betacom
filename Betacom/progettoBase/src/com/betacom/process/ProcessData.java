package com.betacom.process;

import static com.betacom.utils.Utilities.mostraData;
import static com.betacom.utils.Utilities.stringToDate;

import java.time.LocalDate;

import com.betacom.exception.AcademyException;
import com.betacom.objects.User;

public class ProcessData {
	
	private final static String PATTERN_DATE = "dd/MM/yyyy";
	private final static String PATTERN_DATE_ESTESO = "EEEE dd MMMM yyyy";

	public boolean execute(String input) {
		
		User user = new User("Alessandro", "Vivaldi", true, 2002, 6, 22);
		
		// Provo il metodo strinToDate e gestisco le eccezioni
		
		User user2 = null;
				
		try {
			user2 = new User("Luigi", "Delle Bicocche", true, 1992, 2, 12, stringToDate(PATTERN_DATE, input), 6);
			
			// Prendo la data del giorno
			System.out.println("Il giorno della nascita è il: " + user.getNascita().getDayOfMonth());
			
			// Prendo la data di oggi
			LocalDate adesso = LocalDate.now();
			System.out.println("La data attuale è: " + mostraData(PATTERN_DATE, adesso));
			
			// Stampo la data per esteso con tanto di giorno della settimana e mese
			System.out.println("La data attuale è: " + mostraData(PATTERN_DATE_ESTESO, adesso));
			
			// Stampo la data di nascita col formato da me deciso
			System.out.println("La data di nascita è: " + mostraData(PATTERN_DATE_ESTESO, user.getNascita()));
			
			// Stampo il numero del giorno della nascita inteso su 365
			System.out.println("Giorno dell'anno: " + user.getNascita().getDayOfYear());
			
			//int aumentaGiorni = 25;
			//user.setNascita(user.getNascita().plusDays(aumentaGiorni));
			
			// Stampo la data aumentata di 25 giorni
			System.out.println("Data di nascita modificata: " + mostraData(PATTERN_DATE, user.getNascita()));
			
			// Data di oggi
			user.setCertificatoMedico(adesso);
			
			// Specifico i mesi di validità
			user.setMesiDiValidita(6);
			
			// Calcolo la scadenza e la assegno alla variabile
			LocalDate dataDiScadenza;
			dataDiScadenza = user.getCertificatoMedico().plusMonths(user.getMesiDiValidita());
			user.setDataScadenza(dataDiScadenza);

			return true;
			
		} catch (AcademyException e) {
			
			System.out.println("Errore nella creazione dell'utente: " + e.getMessage());
			System.exit(9);
			
			return false;
		}

	}
	
}
