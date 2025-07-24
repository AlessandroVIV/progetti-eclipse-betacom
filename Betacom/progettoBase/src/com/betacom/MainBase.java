package com.betacom;

import java.util.ArrayList;
import java.util.Scanner;

import com.betacom.objects.User;
import com.betacom.utils.PromozioneAutomatica;

public class MainBase {

	public static void main(String[] args) {
		
		// Tipi di variabile primitiva
		byte b = 127;
		int a = 127;
		long l = 1234567;
		short s = 3276;
		float f = 3.14f;
		double d = 3.12312414543532423;
		char c = 'p';
		boolean o = false;
		
		// Variabili non primitive
		String str = "Sono una stringa";
		
		// La stampo
		System.out.println(str);
		
		// Aggiungo uno "a capo"
		System.out.println(str + "\n");
		
		// La scrive in caps lock
		System.out.println(str.toUpperCase());
		
		//Scanner scanner = new Scanner(System.in);

		//System.out.println("Nome:");
		
		//String nome = scanner.nextLine();
				
		//System.out.println("Il nome è: " + nome);
		
		/* Gli operatori logici
		 * 
		 * && AND
		 * || or
		 * <> > <= >=
		 * 
		 */

		//boolean risultato = (18 < 6) && (n != "a");
		//System.out.println("La risposta: " + risultato);
		
		String rs = "";
		
		String nome = "Gigi";
		
		int eta = 23;
		
		if(eta < 58) {
			rs = "sono under 50";
		}
		else {
			rs = "sono over 58";
		}
		
		System.out.println("Ciao, sono " + nome + " e " + rs);
		
		// Operatore ternario
		String rs2 = (eta < 50) ? "sono under 50" : "sono over 50";
		
		System.out.println("Ciao, sono " + nome + " e " + rs2);
		
		// Operatori aritmetici (-, +, /, *, %)
		int j;
		int i;
		
		i = 20;
		// j = i + 1;
		i++;
		System.out.println(i);
		
		int jj = 3;
		int res = i + jj;
		int div = res / 2;
		int rest = res % 2;
		
		System.out.println("Valore di jj: " + i + i*jj + res + ". res/2: " + div + " resto:" + rest);
		
		String pars = "1234";
		div = Integer.parseInt(pars) / 2;
		
		System.out.println(div);
		
		String testo = "lsdkjflkafjldskfjalsdkfjd";
		System.out.println("Lunghezza del testo: " + testo.length() + " caratteri " + testo.substring(4, 8));
		
		// Il metodo ".trim()"
		testo = "          Inizio corso di Java";
		System.out.println("Il testo senza spazi è: " + testo.trim());
		
		String cerca = "corso";
		
		if(testo.trim().contains(cerca))
			System.out.println("Trovata la stringa: " + cerca);
		else
			System.out.println("NON trovata la stringa: " + cerca);
		
		if(testo.startsWith("Inizio"))
			System.out.println("Prefisso trovato");
		else
			System.out.println("Prefisso NON trovato");
		
		// Array
		String[] array = new String[3];
		
		array[0] = "Primo";
		array[1] = "Secondo";
		array[2] = "Terzo";
		// Elemento di troppo. Va in errore.
		// array[3] = "Quarto";
				
		for (int idx = 0; idx < array.length; idx++) {
			System.out.println("idx: " + idx + " " + array[idx]);
		}
		
		for (String it: array) {
			System.out.println(it);
		}
		
		// Array dinamico
		ArrayList<String> dinamica = new ArrayList<String>();
		
		dinamica.add("Primo dinamico");
		dinamica.add("Secondo dinamico");
		dinamica.add("Terzo dinamico");
		dinamica.add("Quarto dinamico");
		dinamica.add("Quinto dinamico");
		dinamica.add("Sesto dinamico");
		dinamica.add("Settimo dinamico");
		dinamica.add("Ottavo dinamico");
		dinamica.add("Nono dinamico");
		dinamica.add("Decimo dinamico");
		dinamica.add("Undicesimo dinamico");
		
		System.out.println("Lunghezza dell'arrayList: " + dinamica.size() + " elementi");
		
		for(String it: dinamica) {
			
			System.out.println(it);
			
			if(it.equals("Settimo dinamico")) 
				break;

		}
		
		int[] numeri = {10, 20, 30, 40, 50};
		
		numeri[4] = 180;
		
		for(int numero: numeri) {
			System.out.println(numero);
		}
		
		// Array 2D
		String[][] classi = new String[3][2];
		
		classi[0][0] = "Elemento 0, Classe 0";
		classi[0][1] = "Elemento 1, Classe 0";
		
		classi[1][0] = "Elemento 0, Classe 1";
		classi[1][1] = "Elemento 1, Classe 1";
		
		classi[2][0] = "Elemento 0, Classe 2";
		classi[2][1] = "Elemento 1, Classe 2";
		
		String extract = "Classe 1";
		
        for (int m = 0; m < classi.length; m++) {
            for (int n = 0; n < classi[m].length; n++) {
            	if(classi[m][n].contains(extract)) {
                    System.out.println("classi[" + m + "][" + n + "]: " + classi[m][n]);
            	}
            }
        }
        
       // Le classi "Wrapped" 
        Integer numero;
        Boolean frase;
        Double doppio;
        Character carattere;
        Float fl;
        Long lon;

        //User nuovoUser = new User();
        
        // Ho messo public ed ora mette disponibile la proprietà "nome"
        // nuovoUser.nome
        
        // Prendo l'elemento "user" tramite getter
        //User user = new User();
        
        // Sfrutto i setter per riassegnare il valore alle variabili
        //user.setNome("Pippo");
        //user.setCognome("Paolo");
        
        // Costruttore pre-compilato
        User usr = new User("Paolo", "Verde");
        
        // Costruttore vuoto
        //User u = new User();
        //u.setCognome("Verde");
        //u.setNome("Paolo");
        
        System.out.println(usr);
        
        ArrayList<User> lUsers = new ArrayList<User>();
        
        lUsers.add(new User("Pietro", "Uno"));
        lUsers.add(new User("Paolo", "Due"));
        lUsers.add(new User("Anna", "Tre"));
        lUsers.add(new User("Carmen", "Quattro"));
        lUsers.add(new User("Giuseppe", "Cinque"));
        
        //System.out.println(lUsers);
        
        for(User u: lUsers) {
        	System.out.println(u);
        }
        
        
        // Sfrutto l'overload dei costruttori per avere lo stesso metodo, ma con parametri diversi
        PromozioneAutomatica pA = new PromozioneAutomatica();
        
        // Metodo Int
        pA.metodo(10);
        
        // Metodo double
        pA.metodo(2.0);
        
        // Metodo Object
        pA.metodo("Parametro String");

        // Dipende tutto da come lo casto
		
	}

}
