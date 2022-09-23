package com.prueba.andres.rangel.buscar.activo.ms.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="PJ_BIENES")
public class Bien implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3113474464861682915L;

	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="NOMBRE")
    private String nombre;

	@Column(name="DESCRIPCION")
    private String descripcion;
	
	@Column(name="SERIAL")
    private String serial;
	
	@Column(name="NUM_INVE")
    private String numInventario;
	
	@Column(name="PESO")
    private String peso;
	
	@Column(name="ALTO")
    private String alto;
	
	@Column(name="ANCHO")
    private String ancho;
	
	@Column(name="LARGO")
    private String largo;        
	
	@Column(name="VALOR_COMPRA")
    private String valorCompra;
	
	@Column(name="FECHA_COMPRA")
	@Temporal(TemporalType.TIMESTAMP)
    private Date fechaCompra;
	
	/*@ManyToOne()
    @JoinColumn(name = "ID_TIPO")
    private Tipo idTipo;*/
	@Column(name="ID_TIPO")
    private Long idTipo;  

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

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getNumInventario() {
		return numInventario;
	}

	public void setNumInventario(String numInventario) {
		this.numInventario = numInventario;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getAlto() {
		return alto;
	}

	public void setAlto(String alto) {
		this.alto = alto;
	}

	public String getAncho() {
		return ancho;
	}

	public void setAncho(String ancho) {
		this.ancho = ancho;
	}

	public String getLargo() {
		return largo;
	}

	public void setLargo(String largo) {
		this.largo = largo;
	}

	public String getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(String valorCompra) {
		this.valorCompra = valorCompra;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Long getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}
	
	
}
