package com.codingdojo.licenciademanejo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.licenciademanejo.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
	// Este método recupera todas las licencias de la base de datos
	List<License> findAll();

	// Este método encuentra una licencia por la identidad de quién le pertenece.
	List<License> findByPersonContaining(String search);
	
	// Este método consulta por la licencia con el valor más alto (
    @Query("SELECT MAX(CAST(l.number AS int)) FROM License l")
    Integer getMaxLicenseNumber();
}
