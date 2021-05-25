# SW2-Rest
**Las diferentes URL para trabajar en la aplicación son las siguientes:**

 	Sirve para obtener todas las marcas que tengas guardadas.

~~~~http
GET localhost:8080/practica-3/marcas
~~~~

Sirve para postear la marca que quieras guardar. 

~~~~http
POST localhost:8080/practica-3/marcas 	
~~~~

Se haría con el siguiente JSON:

~~~~json
{
    "nombre": "marca"
}
~~~~

Sirve para obtener la marca por su ID.

~~~~http
GET localhost:8080/practica-3/marcas/{id}
~~~~

Sirve para modificar la marca por su ID. 

~~~~~http
PUT localhost:8080/practica-3/marcas/{id}
~~~~~


Se haría con el siguiente JSON:

```json
{
    "nombre": "marca"
}
```

Sirve para eliminar la marca por su ID.

~~~~http
DELETE localhost:8080/practica-3/marcas/{id}
~~~~

Sirve para obtener todos los productos que tengas guardados.

~~~~http
GET localhost:8080/practica-3/productos		
~~~~

Sirve para postear el producto que quieras guardar. 

~~~~http
POST localhost:8080/practica-3/productos	
~~~~

Se haría con el siguiente JSON **(Para que funcione debes asignarlo a una marca que ya exista)**:

```json
{
    "nombre": "prueba",
    "tipo": "prueba",
    "fechaDePublicacion": "22-05-2021",
    "precio": 66.7,
    "descripcion": "prueba",
    "marca": {
         "id": 1,
        "nombre": "Vostok"
    }
}
```

Sirve para obtener el producto por su ID.

~~~~http
GET localhost:8080/practica-3/productos/{id}	
~~~~

Sirve para modificar el producto por su ID. 

~~~~http
PUT localhost:8080/practica-3/productos/{id}	
~~~~

Se haría con el siguiente JSON:

```json
{
    "nombre": "prueba2",
    "tipo": "prueba2",
    "fechaDePublicacion": "22-05-2021",
    "precio": 66.7,
    "descripcion": "Creo que se llama prueba2 ",
    "marca": {
         "id": 1,
        "nombre": "Vostok"
    }
}
```

Sirve para eliminar la marca por su ID.

~~~~http
DELETE localhost:8080/practica-3/productos/{id}		
~~~~

Sirve para obtener el listado de productos que tiene una marca por su ID.

~~~~http
GET localhost:8080/practica-3/productos-marca/{id}
~~~~

**El diagrama Entidad-Relación está en la carpeta archivos, como png y el archivo para poder abrirlo en draw.io por si se necesita modificar.**



### Lanzamiento de aplicación

Para lanzar la aplicación se necesita abrir el proyecto en Eclipse, y click derecho en la clase MarcaApplication.java y darle  RUN. 

Para realizar las llamadas de prueba se ha utilizado POSTMAN.

