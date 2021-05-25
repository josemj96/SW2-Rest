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
class MarcaController {

  private final MarcaRepository repository;

  MarcaController(MarcaRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/marcas")
  CollectionModel<EntityModel<Marca>> all() {

    List<EntityModel<Marca>> marcas = repository.findAll().stream()
        .map(marca -> EntityModel.of(marca,
        		WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MarcaController.class).one(marca.getId())).withSelfRel(),
        		WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MarcaController.class).all()).withRel("marcas")))
        .collect(Collectors.toList());

    return CollectionModel.of(marcas, WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MarcaController.class).all()).withSelfRel());
  }
  // end::get-aggregate-root[]

  @PostMapping("/marcas")
  Marca newMarca(@RequestBody Marca newMarca) {
    return repository.save(newMarca);
  }

  // Single item
  
  @GetMapping("/marcas/{id}")
  EntityModel<Marca> one(@PathVariable Long id) {

    Marca marca = repository.findById(id) //
        .orElseThrow(() -> new MarcaNotFoundException(id));

    return EntityModel.of(marca, //
        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MarcaController.class).one(id)).withSelfRel(),
        //WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductoController.class).one(id)).withRel("marcas"));
        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MarcaController.class).all()).withRel("marcas"));
  }

  @PutMapping("/marcas/{id}")
  Marca replaceMarca(@RequestBody Marca newMarca, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(marca -> {
        marca.setNombre(newMarca.getNombre());
        return repository.save(marca);
      })
      .orElseGet(() -> {
        newMarca.setId(id);
        return repository.save(newMarca);
      });
  }

  @DeleteMapping("/marcas/{id}")
  void deleteMarca(@PathVariable Long id) {
    repository.deleteById(id);
  }
}