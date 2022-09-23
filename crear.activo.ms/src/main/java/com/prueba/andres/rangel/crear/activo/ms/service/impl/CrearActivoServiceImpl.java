package com.prueba.andres.rangel.crear.activo.ms.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.andres.rangel.crear.activo.ms.exception.PruebaException;
import com.prueba.andres.rangel.crear.activo.ms.model.dto.CrearActivoRequest;
import com.prueba.andres.rangel.crear.activo.ms.model.dto.CrearActivoResponse;
import com.prueba.andres.rangel.crear.activo.ms.model.dto.error.ErrorDto;
import com.prueba.andres.rangel.crear.activo.ms.model.entity.Bien;
import com.prueba.andres.rangel.crear.activo.ms.model.entity.Tipo;
import com.prueba.andres.rangel.crear.activo.ms.model.repository.BienRepository;
import com.prueba.andres.rangel.crear.activo.ms.model.repository.TipoRrepository;
import com.prueba.andres.rangel.crear.activo.ms.service.CrearActivoService;

@Service
public class CrearActivoServiceImpl implements CrearActivoService {

	@Autowired
	private BienRepository bienRepository;
	
	@Autowired
	private TipoRrepository tipoRrepository;
	
	@Override
	public CrearActivoResponse crearActivo(CrearActivoRequest request) throws PruebaException {
		
		Bien bien = convertRequestToBien(request);
		
		bienRepository.save(bien);
		
		CrearActivoResponse response = new CrearActivoResponse();
		response.setMensaje("Bien creado con exito");
		
		return response;
	}
	
	private Bien convertRequestToBien(CrearActivoRequest request) throws PruebaException {
		
		if(request.getAlto() == null ||
				request.getAlto() == null || 
				request.getAncho() == null || 
				request.getDescripcion() == null || request.getDescripcion().equals("") ||
				request.getFechaCompra() == null || request.getFechaCompra().equals("") ||
				request.getLargo() == null || 
				request.getNombre() == null || request.getNombre().equals("") ||
				request.getNumInventario() == null || request.getNumInventario().equals("") ||
				request.getPeso() == null || 
				request.getSerial() == null || request.getSerial().equals("") ||
				request.getValorCompra() == null ) {
			ErrorDto error = new ErrorDto();

			error.setHttpCode("400");
			error.setHttpMessage("Bad Request");
			error.setMoreInformation("Todos los campos deben estar llenos.");
			
			throw new PruebaException(error);
		}
		
		Bien bien = new Bien();

		bien.setAlto(request.getAlto().toString());
		
		bien.setAncho(request.getAncho().toString());
		
		bien.setDescripcion(request.getDescripcion());
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date fechaC = null;
		try {
			fechaC = formatter.parse(request.getFechaCompra());
		} catch (Exception e) {
			ErrorDto error = new ErrorDto();

			error.setHttpCode("400");
			error.setHttpMessage("Bad Request");
			error.setMoreInformation("El formato de la fecha ingresado esta errado. el formato debe ser dd-MM-yyyy.");
			
			throw new PruebaException(error);
		}
		bien.setFechaCompra(fechaC);
		
		
		Tipo t = tipoRrepository.findByNombre(request.getTipo());
		
		if(t== null) {
			ErrorDto error = new ErrorDto();

			error.setHttpCode("404");
			error.setHttpMessage("Bad Request");
			error.setMoreInformation("El tipo ingresado no existe.");
			
			throw new PruebaException(error);
		}
		
		bien.setIdTipo(t.getId());
		
		bien.setLargo(request.getLargo().toString());
		
		bien.setNombre(request.getNombre());
		
		bien.setNumInventario(request.getNumInventario());
		
		bien.setPeso(request.getPeso().toString());
		
		bien.setSerial(request.getSerial());
		
		bien.setValorCompra(request.getValorCompra().toString());
		
		return bien;
	}
	
}
