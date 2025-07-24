package com.betacom.objects;

public abstract class Car {
	
	private String model;
	private String colore;
	private int maxSpeed;
	
	public abstract void frena();
	public abstract void accelera();
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
		
}
