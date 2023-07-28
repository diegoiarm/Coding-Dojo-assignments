package test1;

public class Ejemplo1 {

	String saludar(String nombre) {
		return "Hola " + nombre;
	}

	public static void main(String[] args) {
		System.out.println("Hola");
//		var num = 10; let cadena = "Jorge"; var arreglo = [];
		int num = 10;
		String cadena = "Jorge";
		int[] edades = { 45, 23, 11, 9 };
		System.out.println("num=" + num);
		System.out.println("cadena=" + cadena);
		for (int i = 0; i < edades.length; i++) {
			System.out.println(edades[i]);
		}
		
		
		if (num == 10) {
			System.out.println("num es igual a 10");
		}

		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		int i = 0;
		while (i < 10) {
			System.out.println(i);
			i++;
		}
	
		
		class Objeto {
			String nombre = "Renzo";
		}
		
		Objeto persona = new Objeto();
		System.out.println(persona.nombre);

	}

}
