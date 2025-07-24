package com.betacom.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import com.betacom.exception.AcademyException;

public class ReflactionManager {

	public Object executeMethod(Object myClass, String methodName, Object[] params) throws AcademyException {
		
	    try {
	    	
	        Method methodToExecute = Arrays.stream(myClass.getClass().getMethods())
	                .filter(m -> methodName.equalsIgnoreCase(m.getName()))
	                .findFirst()
	                .orElseThrow(() -> new AcademyException("Method not found: " + methodName));

	        return methodToExecute.invoke(myClass, params);

	    } catch (SecurityException e) {
	        throw new AcademyException("SecurityException: " + e.getMessage());
	    } catch (IllegalAccessException e) {
	        throw new AcademyException("IllegalAccessException: " + e.getMessage());
	    } catch (InvocationTargetException e) {
	        throw new AcademyException("InvocationTargetException: " + e.getMessage());
	    }
	}

	public Object executeMethodOld(Object myClass, String methodName, Object[] params) throws AcademyException {
		
	    try {
	    	
	        Method[] methods = myClass.getClass().getMethods();
	        
	        Method metodoDaEseguire = null;

	        for (Method metodo : methods) {
	        	
	            if (methodName.equalsIgnoreCase(metodo.getName())) {
	                metodoDaEseguire = metodo;
	                break;
	            }
	            
	        }

	        if (metodoDaEseguire == null) {
	            throw new AcademyException("Method not found: " + methodName);
	        }

	        return metodoDaEseguire.invoke(myClass, params);

	    } catch (SecurityException e) {
	        throw new AcademyException("SecurityException: " + e.getMessage());
	    } catch (IllegalAccessException e) {
	        throw new AcademyException("IllegalAccessException: " + e.getMessage());
	    } catch (InvocationTargetException e) {
	        throw new AcademyException("InvocationTargetException: " + e.getMessage());
	    }
	}

}
