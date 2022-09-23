package com.prueba.andres.rangel.editar.activo.ms.service;

import com.prueba.andres.rangel.editar.activo.ms.exception.PruebaException;
import com.prueba.andres.rangel.editar.activo.ms.model.dto.CrearActivoRequest;
import com.prueba.andres.rangel.editar.activo.ms.model.dto.CrearActivoResponse;

public interface EditarActivoService {

	public CrearActivoResponse editarActivo(CrearActivoRequest request) throws PruebaException;
	
}
