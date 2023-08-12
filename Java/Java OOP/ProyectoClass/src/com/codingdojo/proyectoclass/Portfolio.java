package com.codingdojo.proyectoclass;

import java.util.ArrayList;


public class Portfolio {

	/* Creación del ArrayList para organizar y almacenar el portafolio. */
	
	private ArrayList<Proyecto> proyectos;
	
	public Portfolio() {
		proyectos = new ArrayList<>();
		
	}
	

	public Portfolio(ArrayList<Proyecto> proyectos) {
		super();
		this.proyectos = proyectos;
	}

	
	public ArrayList<Proyecto> getProyectos() {
		return proyectos;
	}


	public void setProyectos(ArrayList<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	/* Métodos para añadir y remover proyectos del portafolio, respectivamente. */

	public void addProyecto(Proyecto proyecto) {
		proyectos.add(proyecto);
	}

	public void removeProyecto(Proyecto proyecto) {
		proyectos.remove(proyecto);
	}

	/* Método que recopila la información de cada proyecto, para luego retornar el valor total del portafolio. */
	
	public double getPortfolioCost() {
		double totalCost = 0;
		for (Proyecto proyecto : proyectos) {
			totalCost = totalCost + proyecto.getInitialCost();
		}
		return totalCost;
	}
	
	/* Método que recopila la información de cada proyecto, para luego retornar el valor total del portafolio. */
	
	public String showPortfolio() {
	    StringBuilder portfolioInfo = new StringBuilder();
	    for (Proyecto proyecto : proyectos) {
	        portfolioInfo.append(proyecto.elevatorPitch()).append("\n");
	    }
	    portfolioInfo.append("Costo total del portafolio: ").append(getPortfolioCost());
	    return portfolioInfo.toString();
	}

}
