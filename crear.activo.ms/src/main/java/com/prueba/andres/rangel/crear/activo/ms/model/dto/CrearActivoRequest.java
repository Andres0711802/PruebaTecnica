package com.prueba.andres.rangel.crear.activo.ms.model.dto;

public class CrearActivoRequest {

	private String nombre;
	private String descripcion;
	private String serial;
	private String numInventario;
	private Double peso;
	private Double largo;
	private Double alto;
	private Double ancho;
	private Double valorCompra;
	private String fechaCompra;
	private String tipo;
	
	public CrearActivoRequest(String nombre, String descripcion, String serial, String numInventario, Double peso,
			Double largo, Double alto, Double ancho, Double valorCompra, String fechaCompra, String tipo) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.serial = serial;
		this.numInventario = numInventario;
		this.peso = peso;
		this.largo = largo;
		this.alto = alto;
		this.ancho = ancho;
		this.valorCompra = valorCompra;
		this.fechaCompra = fechaCompra;
		this.tipo = tipo;
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
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Double getLargo() {
		return largo;
	}
	public void setLargo(Double largo) {
		this.largo = largo;
	}
	public Double getAlto() {
		return alto;
	}
	public void setAlto(Double alto) {
		this.alto = alto;
	}
	public Double getAncho() {
		return ancho;
	}
	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}
	public Double getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}
	public String getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
