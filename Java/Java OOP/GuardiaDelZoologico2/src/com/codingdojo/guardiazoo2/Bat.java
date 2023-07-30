package com.codingdojo.guardiazoo2;

class Bat extends Mammal { 
	
	public Bat() {
		
	}
	
	public void fly() {
		setEnergyLevel(getEnergyLevel() - 50);
		System.out.println("*Aleteo de murciélago* Su energía actual es: " + getEnergyLevel());
	}
	
	public void eatHumans() {
		setEnergyLevel(getEnergyLevel() + 25);
		System.out.println("Bueno, no importa. Su energía actual es: " + getEnergyLevel());
	}
	
	public void attackTown() {
		setEnergyLevel(getEnergyLevel() - 100);
		System.out.println("*Ciudad quemándose* Su energía actual es: " + getEnergyLevel());
	}
	
}
