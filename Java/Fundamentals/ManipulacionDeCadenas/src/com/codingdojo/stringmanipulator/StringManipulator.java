package com.codingdojo.stringmanipulator;

public class StringManipulator {
	
	public String trimAndConcat(String cadena1, String cadena2) {
		return cadena1.trim() + cadena2.trim();
		
	}
	
	public int getIndexOrNull(String cadena1, char caracter1) {
		return cadena1.indexOf(caracter1);
	}
	
	public int getIndexOrNull(String cadena1, String cadena2) {
		return cadena1.indexOf(cadena2);
	}
	
	public String concatSubstring(String cadena1, int index1, int index2, String cadena2) {
		return cadena1.substring(index1, index2) + cadena2;
	}

}
