package com.codingdojo.fizzbuzz;

public class FizzBuzz {

	public String fizzBuzz(int numero) {

//		Escribir un programa que tomará un entero y mostrará en pantalla
//		Fizz si el número es divisible por 3,
//		Buzz si el número es divisible por 5,
//		FizzBuzz si el número es divisible por 3 y 5
//		y para el resto de los casos mostrará el número que se ingresó.

		if (numero % 15 == 0) {
			return "FizzBuzz";
		}

		if (numero % 3 == 0) {
			return "Fizz";
		}

		if (numero % 5 == 0) {
			return "Buzz";
		}
		
		else {
			return ""+numero;
		}

	}

}
