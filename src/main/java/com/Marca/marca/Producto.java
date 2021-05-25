package com.Marca.marca;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;

@Entity
public class Producto {

    @Id
    @GeneratedValue
    private long id;
    
    @Column(nullable=false)
    private String nombre;
    
    @Column(nullable=false)
    private String tipo;
    
    @Column(nullable=false)
    private String fechaDePublicacion;
    
    @Column(nullable=false)
    private double precio;
    
    @Column(nullable=false)
    private String descripcion;
    
    @ManyToOne 
    @JoinColumn(name="Marca_id")
    private Marca marca;
    
    public Producto() {}
    
    public Producto(String nombre, String tipo, String fechaDePublicacion, double precio, String descripcion, Marca marca) {
        super();
        this.nombre = nombre;
        this.tipo = tipo;
        this.fechaDePublicacion = fechaDePublicacion;
        this.precio = precio;
        this.descripcion = descripcion;
        this.marca = marca;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFechaDePublicacion() {
		return fechaDePublicacion;
	}

	public void setFechaDePublicacion(String fechaDePublicacion) {
		this.fechaDePublicacion = fechaDePublicacion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
    
    @Override
    public boolean equals(Object o) {

      if (this == o)
        return true;
      if (!(o instanceof Producto))
        return false;
      Producto producto = (Producto) o;
      return Objects.equals(this.id, producto.id);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.id, this.nombre);
    }
    
        
    
}
