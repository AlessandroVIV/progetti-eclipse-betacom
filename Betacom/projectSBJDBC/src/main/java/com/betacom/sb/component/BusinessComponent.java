package com.betacom.sb.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.betacom.sb.dao.UfficiDAO;
import com.betacom.sb.models.Uffici;

@Component

public class BusinessComponent {

	@Autowired
	private UfficiDAO uDao;

	public void listUffici() {
		
		System.out.println("Inizia ListaUffici");
		
		System.out.println("\nSelect degli uffici: ");
		List<Uffici> lU = uDao.getUffici();
		lU.forEach(u -> System.out.println(u));
		
		System.out.println("\nSelect per id = 3: ");
		lU = uDao.getUfficioById(3);
		lU.forEach(u -> System.out.println(u));
		
		Integer id = uDao.addUfficio("Prova");
		System.out.println("\nRecord inseriti dopo addUfficio: " + id + "\n");
		
		System.out.println("Numero record aggiornati: " + uDao.updateUfficio(2, "Nome aggiornato") + "\n");
		
		System.out.println("Numero record cancellati: " + uDao.deleteUfficio(10) + "\n");		
	}
	
}