package com.example.tiendajpa.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private Double precio;
	private String descripcion;
	private String oferta;
	private String descuento;
	private Double preciocondescuento;
    private String imagen="no-image.png";
	private Integer disponible;
	private Date fecha;
	private String detalles;
	//@Transient
	private Integer nuevo;
	//@Transient
	@OneToOne
	@JoinColumn(name="idCategoria")
	private Categoria categoria;
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
	public Double getPreciocondescuento() {
		return preciocondescuento;
	}
	public void setPreciocondescuento(Double preciocondescuento) {
		this.preciocondescuento = preciocondescuento;
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
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	public Integer getNuevo() {
		return nuevo;
	}
	public void setNuevo(Integer nuevo) {
		this.nuevo = nuevo;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descripcion=" + descripcion
				+ ", oferta=" + oferta + ", descuento=" + descuento + ", preciocondescuento=" + preciocondescuento
				+ ", imagen=" + imagen + ", disponible=" + disponible + ", fecha=" + fecha + ", detalles=" + detalles
				+ ", nuevo=" + nuevo + ", categoria=" + categoria + "]";
	}
	
	
}
