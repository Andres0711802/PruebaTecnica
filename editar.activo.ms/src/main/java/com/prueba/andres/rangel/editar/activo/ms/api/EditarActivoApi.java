package com.prueba.andres.rangel.editar.activo.ms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.andres.rangel.editar.activo.ms.exception.PruebaException;
import com.prueba.andres.rangel.editar.activo.ms.model.dto.CrearActivoRequest;
import com.prueba.andres.rangel.editar.activo.ms.service.EditarActivoService;

@CrossOrigin(origins = "*")
@RequestMapping("${app.context-api}/ms")
@RestController
public class EditarActivoApi {

	
	@Autowired
	private EditarActivoService editarActivoService;

	@PutMapping("editar")
	public ResponseEntity<?> getById(@RequestBody CrearActivoRequest crearActivoRequest){
		try {    
            return new ResponseEntity<>(editarActivoService.editarActivo(crearActivoRequest), HttpStatus.OK); 
		} catch (PruebaException e) {
			return new ResponseEntity<>(e.getDescripcion() , e.getCodigo());
		} catch (Exception e) {
			return new ResponseEntity<>("Ha ocurido algo inesperado. Por favor intentar mas tarde", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
