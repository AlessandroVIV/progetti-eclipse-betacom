package com.betacom.objects;

import java.io.Serializable;

public class Address implements Serializable{

	// Versione dell'oggetto
	private static final long serialVersionUID = 1L;
	
	private String street;
	private String city;
	private String name;
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", name=" + name + "]";
	}
	
}
