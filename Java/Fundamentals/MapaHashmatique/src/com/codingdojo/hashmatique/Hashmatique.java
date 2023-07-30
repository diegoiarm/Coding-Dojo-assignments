package com.codingdojo.hashmatique;

import java.util.HashMap;
import java.util.Set;

public class Hashmatique {
	HashMap<String, String> mapa;
	
	public Hashmatique() {
		this.mapa =new HashMap<String, String>();
	}


	// Agregando claves y valores al mapa.

	void agregarTracks() {
		mapa.put("Canción 1", "La la la ");
		mapa.put("Canción 2", "Le le le");
		mapa.put("Canción 3", "Li li li");
		mapa.put("Canción 4", "Lo lo lo");
	}

	// Imprimiendo un valor específico entregando su key.

	void mostrarTrack() {

		System.out.println(mapa.get("Canción 4"));
	}
	// Obteniendo el set de claves del mapa y mostrando sus valores.

	void mostrarTracklist() {
		Set<String> claves = mapa.keySet();

		for (String clave : claves) {
			System.out.println(clave + ": " + mapa.get(clave));

		}
	}
}

