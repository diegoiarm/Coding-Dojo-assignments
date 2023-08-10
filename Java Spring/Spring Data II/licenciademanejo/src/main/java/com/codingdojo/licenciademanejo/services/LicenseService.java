package com.codingdojo.licenciademanejo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.licenciademanejo.models.License;
import com.codingdojo.licenciademanejo.repositories.LicenseRepository;

@Service
public class LicenseService {
	// Agregando la licencia al repositorio como una dependencia.
	private final LicenseRepository licenseRepository;

	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}

	// Devolviendo todos los lenguajes.
	public List<License> allLicenses() {
		return licenseRepository.findAll();
	}

	// Creando una licencia.
	public License createLicense(License l) {
		// Obtener el número del último registro en la base de datos
		Integer maxNumber = licenseRepository.getMaxLicenseNumber();

		// Verificar si el número es nulo o es el primer registro
		if (maxNumber == null) {
			l.setNumber("000000");
		} else {
			maxNumber++; // Incrementar el número en uno
			String licenseNumberFinal = String.format("%06d", maxNumber); // Formato con ceros a la izquierda
			l.setNumber(licenseNumberFinal);
		}

		return licenseRepository.save(l);
	}

	// Obteniendo la información de una licencia.
	public License findLicense(Long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		if (optionalLicense.isPresent()) {
			return optionalLicense.get();
		} else {
			return null;
		}
	}

	// Eliminar una licencia.

	public void deleteLicense(Long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);

		if (optionalLicense.isPresent()) {
			License license = optionalLicense.get();
			license.getId();
			licenseRepository.deleteById(id);
		} else {
			throw new IllegalArgumentException("No se ha encontrado ninguna licencia con el ID entregado.");
		}
	}
}
