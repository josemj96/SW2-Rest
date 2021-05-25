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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;





@Entity
public class Marca {
	
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false)
    private String nombre;
    
    /**
    @OneToMany(mappedBy = "marca")
    private List<Producto> productos;
    **/
    public Marca() {
       // productos = new ArrayList<>();
    }
    
    public Marca(String name) {
        super();
        this.nombre = name;
        //productos = new ArrayList<>();
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

    public void setNombre(String name) {
        this.nombre = name;
    }

    public void addProducto(Producto producto) {
        //productos.add(producto);        
    }
    
    /**
    public List<Producto> getProductos() {
		return productos;
    }
    **/
    
    @Override
    public boolean equals(Object o) {

      if (this == o)
        return true;
      if (!(o instanceof Marca))
        return false;
      Marca marca = (Marca) o;
      return Objects.equals(this.id, marca.id);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.id, this.nombre);
    }
    
    @Override
    public String toString() {
        return "Marca [id=" + id + ", nombre=" + nombre + " ]";
    }
}
