package com.codingdojo.proyectoclass;

public class ProyectoClass {

	private String nombre;
	private String descripcion;
	private double initialCost;

	public ProyectoClass() {

	}

	public ProyectoClass(String nombre) {
		this.nombre = nombre;
	}

	public ProyectoClass(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
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

	public void elevatorPitch() {
		System.out.println(nombre + (initialCost) + " : " + descripcion);
	}
}
