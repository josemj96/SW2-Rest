package com.Marca.marca;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    /**
    @Bean
    CommandLineRunner initDatabase(AddressRepository addRepo, LibraryRepository libRepo, BookRepository bookRepo, AuthorRepository authRepo) {

        return args -> {
            Address address = new Address("Avenida de Burgos 123");
            addRepo.save(address);
            Library library = new Library("La gran biblioteca");
            libRepo.save(library);
            library.setAddress(address);
            address.setLibrary(library);
            addRepo.save(address);
            libRepo.save(library);
            Book book = new Book("El señor de los anillos");
            book.setLibrary(library);
            library.addBook(book);
            libRepo.save(library);
            bookRepo.save(book);
            Author author = new Author("J.R.R. Tolkien");
            authRepo.save(author);
            author.addBook(book);
            book.addAuthor(author);
            bookRepo.save(book);
            log.info("Preloading " + authRepo.save(author));
            
            Address address2 = new Address("Avenida de Ciudad de Barcelona 123");
            addRepo.save(address2);
            Library library2 = new Library("Otra gran biblioteca");
            libRepo.save(library2);
            Book book2 = new Book("Mistborn");
            bookRepo.save(book2);
            Author author2 = new Author("Brandon Sanderson");
            authRepo.save(author2);
        };**/
        
        @Bean
        CommandLineRunner initDatabase(MarcaRepository marRepo, ProductoRepository proRepo) {

            return args -> {
            	Marca marca = new Marca("Vostok");
            	marRepo.save(marca);
            	Producto producto = new Producto("Komandirskie","reloj", "22-05-2021", 66.70, "Da la hora to juapa", marca);
            	producto.setMarca(marca);
            	proRepo.save(producto);
             	marca.addProducto(producto);
            	marRepo.save(marca);     	
             	log.info("Base de datos cargada");
             	

            };
    }
}