package com.prueba.andres.rangel.crear.activo.ms.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.andres.rangel.crear.activo.ms.model.entity.Tipo;

@Repository
public interface TipoRrepository extends JpaRepository<Tipo, Long> {

	Tipo findByNombre(String nombre);
	
}
