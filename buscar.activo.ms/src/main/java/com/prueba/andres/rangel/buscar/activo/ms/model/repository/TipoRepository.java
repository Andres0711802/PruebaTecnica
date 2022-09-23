package com.prueba.andres.rangel.buscar.activo.ms.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.andres.rangel.buscar.activo.ms.model.entity.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long>{

	Tipo findByNombre(String nombre);
	
}
