package com.Marca.marca;


class ProductoNotFoundException extends RuntimeException {

	  ProductoNotFoundException(Long id) {
	    super("Could not find producto " + id);
	  }
}
