package com.prueba.andres.rangel.editar.activo.ms.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.andres.rangel.editar.activo.ms.model.entity.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Long>{

	Tipo findByNombre(String nombre);
	
}
