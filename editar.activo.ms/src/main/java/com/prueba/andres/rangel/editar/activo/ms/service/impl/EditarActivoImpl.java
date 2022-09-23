package com.prueba.andres.rangel.editar.activo.ms.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.andres.rangel.editar.activo.ms.exception.PruebaException;
import com.prueba.andres.rangel.editar.activo.ms.model.dto.CrearActivoRequest;
import com.prueba.andres.rangel.editar.activo.ms.model.dto.CrearActivoResponse;
import com.prueba.andres.rangel.editar.activo.ms.model.dto.error.ErrorDto;
import com.prueba.andres.rangel.editar.activo.ms.model.entity.Bien;
import com.prueba.andres.rangel.editar.activo.ms.model.entity.Tipo;
import com.prueba.andres.rangel.editar.activo.ms.model.repository.BienRepository;
import com.prueba.andres.rangel.editar.activo.ms.model.repository.TipoRepository;
import com.prueba.andres.rangel.editar.activo.ms.service.EditarActivoService;

@Service
public class EditarActivoImpl implements EditarActivoService {

	@Autowired
	private BienRepository bienRepository;

	@Autowired
	private TipoRepository tipoRrepository;

	@Override
	public CrearActivoResponse editarActivo(CrearActivoRequest request) throws PruebaException {
		
		Bien bienE = bienRepository.findById(request.getId()).orElse(null);
		
		if(bienE == null) {
			ErrorDto error = new ErrorDto();

			error.setHttpCode("404");
			error.setHttpMessage("Bad Request");
			error.setMoreInformation("El id del activo enviado no existe. por favor verificar he intentar nuevamente.");

			throw new PruebaException(error);
		}
		
		Bien bien = convertRequestToBien(request ,bienE);

		bienRepository.save(bien);

		CrearActivoResponse response = new CrearActivoResponse();
		response.setMensaje("Bien(Activo) editado con exito");

		return response;
	}

	private Bien convertRequestToBien(CrearActivoRequest request, Bien bien) throws PruebaException {

		if (request.getAlto() == null && request.getAlto() == null && request.getAncho() == null
				&& (request.getDescripcion() == null || request.getDescripcion().equals(""))
				&& (request.getFechaCompra() == null || request.getFechaCompra().equals(""))
				&& request.getLargo() == null && request.getNombre() == null
				|| request.getNombre().equals("")
						&& (request.getNumInventario() == null || request.getNumInventario().equals(""))
						&& request.getPeso() == null && (request.getSerial() == null || request.getSerial().equals(""))
						&& request.getValorCompra() == null) {
			ErrorDto error = new ErrorDto();

			error.setHttpCode("400");
			error.setHttpMessage("Bad Request");
			error.setMoreInformation("Debe enviar minímo un dato para actualizar.");

			throw new PruebaException(error);
		}

		if (request.getAlto() != null) {
			bien.setAlto(request.getAlto().toString());
		}
		if (request.getAncho() != null) {
			bien.setAncho(request.getAncho().toString());
		}
		if (request.getDescripcion() != null && !request.getDescripcion().equals("")) {
			bien.setDescripcion(request.getDescripcion());
		}

		if (request.getFechaCompra() != null && !request.getFechaCompra().equals("")) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date fechaC = null;
			try {
				fechaC = formatter.parse(request.getFechaCompra());
			} catch (Exception e) {
				ErrorDto error = new ErrorDto();

				error.setHttpCode("400");
				error.setHttpMessage("Bad Request");
				error.setMoreInformation(
						"El formato de la fecha ingresado esta errado. el formato debe ser dd-MM-yyyy.");

				throw new PruebaException(error);
			}
			bien.setFechaCompra(fechaC);
		}

		if (request.getTipo() != null && !request.getTipo().equals("")) {
			Tipo t = tipoRrepository.findByNombre(request.getTipo());

			if (t == null) {
				ErrorDto error = new ErrorDto();

				error.setHttpCode("404");
				error.setHttpMessage("Bad Request");
				error.setMoreInformation("El tipo ingresado no existe.");

				throw new PruebaException(error);
			}
			bien.setIdTipo(t.getId());
		}

		if(request.getLargo() != null && !request.getLargo().equals("")) {
			bien.setLargo(request.getLargo().toString());
		}

		if(request.getNombre() != null && !request.getNombre().equals("")) {
			bien.setNombre(request.getNombre());
		}

		if(request.getNumInventario() != null) {
			bien.setNumInventario(request.getNumInventario());
		}

		if(request.getPeso() != null) {
			bien.setPeso(request.getPeso().toString());
		}

		if(request.getSerial() != null) {
			bien.setSerial(request.getSerial());
		}

		if(request.getValorCompra() != null) {
			bien.setValorCompra(request.getValorCompra().toString());
		}

		return bien;
	}

}
