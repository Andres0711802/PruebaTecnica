package com.prueba.andres.rangel.crear.activo.ms.exception;

import org.springframework.http.HttpStatus;

import com.prueba.andres.rangel.crear.activo.ms.model.dto.error.ErrorDto;

public class PruebaException extends Exception {

	private static final long serialVersionUID = 1L;

	private final HttpStatus codigo;
	private final String mensaje;
	private final String descripcion;
	
	public PruebaException(HttpStatus codigo, String mensaje, String descripcion) {
		super(mensaje);
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.descripcion = descripcion;
	}
	
	public PruebaException(ErrorDto error) {

		this.codigo = hetttpStatus(error.getHttpCode());
		this.mensaje = error.getHttpMessage();
		this.descripcion = error.getMoreInformation();
	}


	public HttpStatus getCodigo() {
		return codigo;
	}

	public String getMensaje() {
		return mensaje;
	}
	public String getDescripcion() {
		return descripcion;
	}
	
	private HttpStatus hetttpStatus(String code) {
		
		if(code.equalsIgnoreCase("500")) {
			return HttpStatus.INTERNAL_SERVER_ERROR;	
		} else if(code.equalsIgnoreCase("404")) {
			return HttpStatus.NOT_FOUND;
		} else {
			return HttpStatus.BAD_REQUEST;
		}
		
	}

}
