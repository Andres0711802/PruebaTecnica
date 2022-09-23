package com.prueba.andres.rangel.buscar.activo.ms.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.andres.rangel.buscar.activo.ms.model.entity.Bien;

@Repository
public interface BienRepository extends JpaRepository<Bien, Long>{

}
