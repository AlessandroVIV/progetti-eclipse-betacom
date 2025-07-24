package com.betacom;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.print.attribute.standard.MediaSize;

import static com.betacom.utils.Utilities.mostraData;
import static com.betacom.utils.Utilities.stringToDate;

import com.betacom.exception.AcademyException;
import com.betacom.objects.User;
import com.betacom.process.ProcessData;

public class MainDate {
		
	public static void main(String[] args) {
		
		// Ho ridotto al minimo il Main spostando i metodi su un altro file
		
		// String input = "01/06/2025";
	
		System.out.println("Inizia MainDate: " + args[0]);
		
		// Passo gli argomenti specificati durante la "run" del programma tramite "Run Configuration"
		String input = args[0];
		
		if(new ProcessData().execute(input)) {
			System.out.println("Fine normale del processo");
		}else {
			System.out.println("Errore nel processo");
		}
		
	}
	
}
