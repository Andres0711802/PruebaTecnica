package com.prueba.andres.rangel.buscar.activo.ms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.andres.rangel.buscar.activo.ms.exception.PruebaException;
import com.prueba.andres.rangel.buscar.activo.ms.service.BienService;

@CrossOrigin(origins = "*")
@RequestMapping("${app.context-api}/ms")
@RestController
public class Api {

	
	@Autowired
	private BienService bienService;

	@GetMapping("buscar")
	public ResponseEntity<?> getById(@RequestParam (required = false) String tipo,
			@RequestParam (required = false) String fecha,
			@RequestParam (required = false) String serial){
		try {    
            return new ResponseEntity<>(bienService.buscarBien(tipo,fecha,serial), HttpStatus.OK); 
		} catch (PruebaException e) {
			return new ResponseEntity<>(e.getDescripcion(), e.getCodigo());
		} catch (Exception e) {
			return new ResponseEntity<>("Ha ocurido algo inesperado. Por favor intentar mas tarde", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
