package com.Marca.marca;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.*;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ProductoController {

  private final ProductoRepository repository;

  ProductoController(ProductoRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/productos")
  CollectionModel<EntityModel<Producto>> all() {

    List<EntityModel<Producto>> productos = repository.findAll().stream()
        .map(producto -> EntityModel.of(producto,
        		WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductoController.class).one(producto.getId())).withSelfRel(),
        		WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductoController.class).all()).withRel("productos")))
        .collect(Collectors.toList());

    return CollectionModel.of(productos, WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductoController.class).all()).withSelfRel());
  }
  // end::get-aggregate-root[]

  @PostMapping("/productos")
  Producto newProducto(@RequestBody Producto newProducto) {
    return repository.save(newProducto);
  }

  // Porductos by Marca_id
  @GetMapping("/productos-marca/{id}")
  CollectionModel<EntityModel<Producto>> byid(@PathVariable Long id) {

    List<EntityModel<Producto>> productos = repository.findAll().stream().filter(producto -> producto.getMarca().getId()==id)
        .map(producto -> EntityModel.of(producto,
        		WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductoController.class).one(producto.getId())).withSelfRel(),
        		WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductoController.class).all()).withRel("productos")))
        .collect(Collectors.toList());

    return CollectionModel.of(productos, WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductoController.class).all()).withSelfRel());
  }
  
  
  // Single item
  
  @GetMapping("/productos/{id}")
  EntityModel<Producto> one(@PathVariable Long id) {

    Producto producto = repository.findById(id) //
        .orElseThrow(() -> new ProductoNotFoundException(id));

    return EntityModel.of(producto, //
        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductoController.class).one(id)).withSelfRel(),
        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductoController.class).all()).withRel("productos"));
  }

  @PutMapping("/productos/{id}")
  Producto replaceProducto(@RequestBody Producto newProducto, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(producto -> {
        producto.setNombre(newProducto.getNombre());
        producto.setTipo(newProducto.getTipo());
        producto.setFechaDePublicacion(newProducto.getFechaDePublicacion());
        producto.setPrecio(newProducto.getPrecio());
        producto.setDescripcion(newProducto.getDescripcion());
        return repository.save(producto);
      })
      .orElseGet(() -> {
        newProducto.setId(id);
        return repository.save(newProducto);
      });
  }

  @DeleteMapping("/productos/{id}")
  void deleteProducto(@PathVariable Long id) {
    repository.deleteById(id);
  }
}