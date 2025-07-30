package com.betacom.jpa.services.interfaces;

import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.requests.BiciRequest;

public interface IBiciServices {

	void create(BiciRequest req) throws AcademyException;
	
}
