package com.prueba.andres.rangel.crear.activo.ms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prueba.andres.rangel.crear.activo.ms.exception.PruebaException;
import com.prueba.andres.rangel.crear.activo.ms.model.dto.CrearActivoRequest;
import com.prueba.andres.rangel.crear.activo.ms.service.CrearActivoService;

@CrossOrigin(origins = "*")
@RequestMapping("${app.context-api}/ms")
@RestController
public class CrearActivoApi {

	
	@Autowired
	private CrearActivoService crearActivoService;

	@PostMapping("crear")
	public ResponseEntity<?> getById(@RequestBody CrearActivoRequest crearActivoRequest){
		try {    
            return new ResponseEntity<>(crearActivoService.crearActivo(crearActivoRequest), HttpStatus.OK); 
		} catch (PruebaException e) {
			return new ResponseEntity<>(e.getDescripcion() , e.getCodigo());
		} catch (Exception e) {
			return new ResponseEntity<>("Ha ocurido algo inesperado. Por favor intentar mas tarde", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
