package com.betacom.jpa.services.interfaces;

import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.requests.MacchinaRequest;

public interface IMacchinaServices {

	void create(MacchinaRequest req) throws AcademyException;
	
	void deleteByMacchinaId(MacchinaRequest req) throws AcademyException;
	
}
