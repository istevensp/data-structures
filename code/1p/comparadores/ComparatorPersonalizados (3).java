//////////////////////////////////////////////////////////////
//Clase Base para los Ejemplos
//////////////////////////////////////////////////////////////

class Persona {
    String nombre;
    int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "', edad=" + edad + "}";
    }
}


//////////////////////////////////////////////////////////////
//Ejemplo 1: Comparator para Ordenar por Edad
//////////////////////////////////////////////////////////////
import java.util.Comparator;

// Comparator personalizado para ordenar por edad
class ComparadorPorEdad implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        // Comparar las edades usando Integer.compare para evitar errores con valores nulos
        return Integer.compare(p1.edad, p2.edad);
    }
}

///////////////////			USO			///////////////////

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear lista de personas
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Alice", 30));
        personas.add(new Persona("Bob", 25));
        personas.add(new Persona("Charlie", 35));

        // Usar el Comparator para ordenar por edad
        Collections.sort(personas, new ComparadorPorEdad());

        // Imprimir la lista ordenada
        System.out.println("Personas ordenadas por edad:");
        for (Persona p : personas) {
            System.out.println(p);
        }
    }
}



//////////////////////////////////////////////////////////////
//Ejemplo 2: Comparator para Ordenar por Nombre (Ascendente y Descendente)
//////////////////////////////////////////////////////////////

//Comparator por Nombre Ascendente:

class ComparadorPorNombreAscendente implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        // Comparar nombres alfabéticamente
        return p1.nombre.compareTo(p2.nombre);
    }
}

//Comparator por Nombre Descendente:

class ComparadorPorNombreDescendente implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        // Comparar nombres en orden inverso
        return p2.nombre.compareTo(p1.nombre);
    }
}


///////////////////			USO			///////////////////
public class Main {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Alice", 30));
        personas.add(new Persona("Bob", 25));
        personas.add(new Persona("Charlie", 35));

        // Ordenar por nombre ascendente
        Collections.sort(personas, new ComparadorPorNombreAscendente());
        System.out.println("Personas ordenadas por nombre ascendente:");
        for (Persona p : personas) {
            System.out.println(p);
        }

        // Ordenar por nombre descendente
        Collections.sort(personas, new ComparadorPorNombreDescendente());
        System.out.println("\nPersonas ordenadas por nombre descendente:");
        for (Persona p : personas) {
            System.out.println(p);
        }
    }
}



//////////////////////////////////////////////////////////////
//Ejemplo 3: Comparator por Múltiples Criterios
//////////////////////////////////////////////////////////////

//Ordenar Primero por Edad y Luego por Nombre:

class ComparadorPorEdadYNombre implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        // Comparar por edad primero
        int resultado = Integer.compare(p1.edad, p2.edad);
        if (resultado == 0) {
            // Si las edades son iguales, comparar por nombre
            return p1.nombre.compareTo(p2.nombre);
        }
        return resultado;
    }
}


///////////////////			USO			///////////////////
public class Main {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Charlie", 30));
        personas.add(new Persona("Alice", 30));
        personas.add(new Persona("Bob", 25));

        // Ordenar por edad y luego por nombre
        Collections.sort(personas, new ComparadorPorEdadYNombre());
        System.out.println("Personas ordenadas por edad y luego por nombre:");
        for (Persona p : personas) {
            System.out.println(p);
        }
    }
}



//////////////////////////////////////////////////////////////
//Ejemplo 4: Comparator para Objetos con Más Atributos
//////////////////////////////////////////////////////////////

//Clase Producto (para un Inventario):
class Producto {
    String nombre;
    double precio;
    int cantidadEnStock;

    public Producto(String nombre, double precio, int cantidadEnStock) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
    }

    @Override
    public String toString() {
        return "Producto{nombre='" + nombre + "', precio=" + precio + ", cantidadEnStock=" + cantidadEnStock + "}";
    }
}

//Comparator para Ordenar por Precio:
class ComparadorPorPrecio implements Comparator<Producto> {
    @Override
    public int compare(Producto p1, Producto p2) {
        // Comparar por precio
        return Double.compare(p1.precio, p2.precio);
    }
}




///////////////////			USO			///////////////////
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Laptop", 1200.50, 10));
        productos.add(new Producto("Mouse", 25.99, 100));
        productos.add(new Producto("Teclado", 49.99, 50));

        // Ordenar por precio
        Collections.sort(productos, new ComparadorPorPrecio());
        System.out.println("Productos ordenados por precio:");
        for (Producto p : productos) {
            System.out.println(p);
        }
    }
}