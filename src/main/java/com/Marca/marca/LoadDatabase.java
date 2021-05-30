package com.Marca.marca;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    
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
            	
            	Marca marca2 = new Marca("Opel");
            	marRepo.save(marca2);
            	Producto producto2 = new Producto("Corsa","coche", "25-05-2021", 9560.70, "Vendo Opel Corsa", marca2);
            	producto.setMarca(marca2);
            	proRepo.save(producto2);
             	marca.addProducto(producto2);
            	marRepo.save(marca2); 
            	
             	log.info("Base de datos cargada");
             	

            };
    }
}