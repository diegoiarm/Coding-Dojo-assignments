package com.codingdojo.guardiazoo1;

public class Mammal {	 
	private int energyLevel = 100;

	public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	public void displayEnergy() {
		System.out.println("El nivel de energía es: " + energyLevel);
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

	public Mammal() {
	}
	
	
	

}

