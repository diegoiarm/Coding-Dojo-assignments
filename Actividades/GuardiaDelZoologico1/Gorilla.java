package com.codingdojo.guardiazoo1;




class Gorilla extends Mammal { 
	
	public Gorilla() {
		
	}
	
	public void throwSomething() {
		setEnergyLevel(getEnergyLevel() - 5);
		System.out.println("El gorila ha lanzado algo! Su nivel de energía disminuyó en -5. Su energía actual es: " + getEnergyLevel());
	}
	
	public void eatBananas() {
		setEnergyLevel(getEnergyLevel() + 10);
		System.out.println("Guatita llena, corazón contento! El gorila está feliz. Su energía actual es: " + getEnergyLevel());
	}
	
	public void climb() {
		setEnergyLevel(getEnergyLevel() - 10);
		System.out.println("El gorila trepó el arbol hasta la cima. Su energía actual es: " + getEnergyLevel());
	}
	
}








