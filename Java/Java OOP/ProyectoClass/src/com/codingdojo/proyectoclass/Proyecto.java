package com.codingdojo.proyectoclass;

public class Proyecto {

	private String nombre;
	private String descripcion;
	private double initialCost;

	public Proyecto() {

	}

	public Proyecto(String nombre) {
		this.nombre = nombre;
	}

	public Proyecto(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public Proyecto(String nombre, String descripcion, double initialCost) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.initialCost = initialCost;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

	public double getInitialCost() {
		return initialCost;
	}

	public void setInitialCost(double initialCost) {
		this.initialCost = initialCost;
	}

	public String elevatorPitch() {
		return nombre + " (" + (initialCost) + "): " + descripcion;
	}
}
