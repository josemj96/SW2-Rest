package com.Marca.marca;


class MarcaNotFoundException extends RuntimeException {

	  MarcaNotFoundException(Long id) {
	    super("Could not find Marca " + id);
	  }
}
