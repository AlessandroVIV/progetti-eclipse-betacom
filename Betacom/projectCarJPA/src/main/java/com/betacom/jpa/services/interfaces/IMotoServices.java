package com.betacom.jpa.services.interfaces;

import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.requests.MotoRequest;

public interface IMotoServices {

	void create(MotoRequest req) throws AcademyException;
	
}
