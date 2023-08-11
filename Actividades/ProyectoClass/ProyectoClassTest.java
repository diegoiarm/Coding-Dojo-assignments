package com.codingdojo.proyectoclass;

public class ProyectoClassTest {

	public static void main(String[] args) {

		ProyectoClass proyecto1 = new ProyectoClass();
		proyecto1.elevatorPitch();

		ProyectoClass proyecto2 = new ProyectoClass("Coding Dojo");
		proyecto2.elevatorPitch();

		ProyectoClass proyecto3 = new ProyectoClass("Coding Dojo", "El bootcamp por excelencia");
		proyecto3.elevatorPitch();

	}

}
