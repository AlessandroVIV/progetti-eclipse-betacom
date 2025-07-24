package com.betacom.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import com.betacom.exception.AcademyException;

public class Utilities {
	
	// La classe "utils" contiene metodi utili che devo richiamare più volte

	// Manipolo la data
	public static String mostraData(String pattern, LocalDate myData) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ITALIAN);
		return myData.format(formatter);
	}
	
	public static LocalDate stringToDate (String pattern, String myData) throws AcademyException {
		
		LocalDate r = null;
		
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ITALIAN);
			r =  LocalDate.parse(myData, formatter);
		} catch (DateTimeParseException e) {
			throw new AcademyException("Formato della data non valido");
		}
		
		return r;
		
	}
	
}
