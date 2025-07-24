package com.betacom.car.singletone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidaParametri {
	
	private static ValidaParametri instance;
	
    private ValidaParametri() {
    	caricaParametri("C:\\Users\\Ho\\eclipse-workspace\\Betacom\\projectCar\\src\\parametri.txt");
    }

    public static ValidaParametri getInstance() {
        if (instance == null) {
            instance = new ValidaParametri();
        }
        return instance;
    }
    
    private Map<String, List<String>> parametri = new HashMap<>();

    private void caricaParametri(String path) {
    	
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {	
        	
            String line;
            
            while ((line = br.readLine()) != null) {
            	
                if (line.contains("=")) {
                	
                    String[] split = line.split("=", 2);
                    
                    String key = split[0].trim();
                    
                    List<String> listaPulita = Arrays.stream(split[1].split(","))
                            .map(String::trim)
                            .toList();

                    parametri.put(key, listaPulita);
             
                }
                
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isTipoValido(String tipo) {
        List<String> tipi = parametri.get("tipoVeicolo");
        return tipi != null && tipi.contains(tipo);
    }

    public boolean isRuotaValida(int n) {
        List<String> ruote = parametri.get("ruote");
        return ruote != null && ruote.contains(String.valueOf(n));
    }

    public boolean isAlimentazioneValida(String a) {
        List<String> alim = parametri.get("alimentazione");
        return alim != null && alim.contains(a.toLowerCase());
    }

    public boolean isCategoriaValida(String c) {
        List<String> cat = parametri.get("categoria");
        return cat != null && cat.contains(c.toLowerCase());
    }

    public boolean isColoreValido(String c) {
        List<String> colori = parametri.get("colore");
        return colori != null && colori.contains(c.toLowerCase());
    }

    public boolean isMarcaValida(String m) {
        List<String> marche = parametri.get("marca");
        return marche != null && marche.contains(m);
    }

    public boolean isAnnoValido(int y) {
        List<String> anni = parametri.get("anno");
        return anni != null && anni.contains(String.valueOf(y));
    }

    public boolean isModelloValido(String m) {
        List<String> modelli = parametri.get("modello");
        return modelli != null && modelli.contains(m);
    }

}