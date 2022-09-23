package com.prueba.andres.rangel.buscar.activo.ms.service;

import java.util.List;
import com.prueba.andres.rangel.buscar.activo.ms.exception.PruebaException;
import com.prueba.andres.rangel.buscar.activo.ms.model.entity.Bien;

public interface BienService {
	
	public List<Bien> buscarBien(String tipo, String fechacompra, String serial) throws PruebaException;
}
