package com.prueba.andres.rangel.crear.activo.ms.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="PJ_TIPO")
public class Tipo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3113474464961682925L;

	@Id
	@Column(name="ID")
	private Long id;

	@Column(name="NOMBRE")
    private String nombre;
	
	@Column(name="DESCRIPCION")
    private String descripcion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
