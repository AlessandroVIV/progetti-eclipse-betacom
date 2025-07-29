package com.betacom.jpa.services.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.betacom.jpa.models.MessageId;
import com.betacom.jpa.models.Messaggi;
import com.betacom.jpa.repositories.IMessaggioRepository;
import com.betacom.jpa.services.interfaces.IMessaggioServices;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class MessaggioImpl implements IMessaggioServices{

	@Autowired
	private IMessaggioRepository messaggioRepository;
	
	@Value("${lang}")
	private String lang;
	
	@Override
	public String getMessaggio(String code) {
		
		log.debug("getMessaggio: " + code);
		
		String r = null;
		
		Optional<Messaggi> m = messaggioRepository.findById(new MessageId(lang, code));
		
		if(m.isEmpty()) r = code;
		
		else r = m.get().getMessaggio();
		
		return r;
		
	}

}
