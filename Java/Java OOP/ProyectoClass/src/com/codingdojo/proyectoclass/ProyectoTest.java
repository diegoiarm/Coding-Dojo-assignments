package com.codingdojo.proyectoclass;

public class ProyectoTest {

	public static void main(String[] args) {

		Proyecto proyecto = new Proyecto("Coding Dojo");
		proyecto.setDescripcion("El bootcamp por excelencia");
		proyecto.setInitialCost(9000.0);

		Proyecto proyecto2 = new Proyecto("Proyecto 2");
		proyecto2.setDescripcion("Esto es un proyecto de ejemplo.");
		proyecto2.setInitialCost(2000.0);

		Proyecto proyecto3 = new Proyecto("Proyecto 3", "Sobrecarga de metodos!");
		proyecto3.setInitialCost(3000.0);

		Proyecto proyecto4 = new Proyecto("Proyecto 4", "Hola buenas", 3000.0);

		Portfolio portafolio = new Portfolio();

		portafolio.addProyecto(proyecto); // Agregar proyecto al portafolio
		portafolio.addProyecto(proyecto2); // Agregar proyecto2 al portafolio
		portafolio.addProyecto(proyecto3); // Agregar proyecto3 al portafolio
		portafolio.addProyecto(proyecto4); // Agregar proyecto4 al portafolio

		System.out.println(portafolio.showPortfolio());
	}

}
