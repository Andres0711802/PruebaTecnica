package com.prueba.andres.rangel.crear.activo.ms.service;

import com.prueba.andres.rangel.crear.activo.ms.exception.PruebaException;
import com.prueba.andres.rangel.crear.activo.ms.model.dto.CrearActivoRequest;
import com.prueba.andres.rangel.crear.activo.ms.model.dto.CrearActivoResponse;

public interface CrearActivoService {
	
	public CrearActivoResponse crearActivo(CrearActivoRequest request) throws PruebaException;

}
