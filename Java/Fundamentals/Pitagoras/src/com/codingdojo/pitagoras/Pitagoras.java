package com.codingdojo.pitagoras;

public class Pitagoras {
	public double calcularHipotenusa(int catetoA, int catetoB) {
		Integer sumaCatetos = catetoA*catetoA + catetoB*catetoB;
		double hipotenusa = Math.sqrt(sumaCatetos);
		return hipotenusa;
	    }
	}

