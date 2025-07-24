package com.betacom.jpa.services.interfaces;

import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.requests.AbbonamentoRequest;

public interface IAbbonamentoServices {

	void create(AbbonamentoRequest req) throws AcademyException;
	
	
}
