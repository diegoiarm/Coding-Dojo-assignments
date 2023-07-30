package com.codingdojo.maestrodeobjetos;

public class Human {

	private int strength = 3;
	private int stealth = 3;
	protected int intelligence = 3;
	protected int health = 100;
	

	public Human() {
		super();
	}

	public String attack(Human target) {
		int damage = strength;
		health -= damage;
		return "La salud ha disminuido en " + damage + ". Tu salud actual es de " + health + ".";
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getStealth() {
		return stealth;
	}

	public void setStealth(int stealth) {
		this.stealth = stealth;
	}

	protected int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getHealth() {
		return health;
	}

	protected void setHealth(int health) {
		this.health = health;
	}
	

}
