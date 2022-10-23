package com.example.tiendajpa.model;

import java.util.Date;

public class Producto {
	
	private Integer id;
	private String nombre;
	private Double precio;
	private String descripcion;
	private String oferta;
	private String descuento;
	private String categoria;
	private String imagen="no-image.png";
	private Integer disponible;
	private Date fecha;
	private Integer New;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getOferta() {
		return oferta;
	}
	public void setOferta(String oferta) {
		this.oferta = oferta;
	}
	public String getDescuento() {
		return descuento;
	}
	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Integer getDisponible() {
		return disponible;
	}
	public void setDisponible(Integer disponible) {
		this.disponible = disponible;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getNew() {
		return New;
	}
	public void setNew(Integer new1) {
		New = new1;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descripcion=" + descripcion
				+ ", oferta=" + oferta + ", descuento=" + descuento + ", categoria=" + categoria + ", imagen=" + imagen
				+ ", disponible=" + disponible + ", fecha=" + fecha + ", New=" + New + "]";
	}
	
	
	
}
