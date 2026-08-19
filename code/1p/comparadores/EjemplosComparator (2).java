// Seis formas de comparar/ordenar la misma clase Persona, de la más
// explícita (clase separada) a la más concisa (lambda, referencia a
// método, Comparator.comparing encadenado) — y su uso dentro de otras
// estructuras (TreeSet) que dependen de un orden para funcionar.

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

//////////////////////////////////////////////////////////////
//1. Clase Persona para Ejemplos
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
//2. Implementación Básica de Comparator como Clase Separada
//Comparar Personas por Nombre
//////////////////////////////////////////////////////////////

class ComparadorPorNombre implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        return p1.nombre.compareTo(p2.nombre);
    }
}

class DemoOrdenPorNombre {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Alice", 30));
        personas.add(new Persona("Bob", 25));
        personas.add(new Persona("Charlie", 35));

        // Ordenar usando un Comparator por nombre
        personas.sort(new ComparadorPorNombre());
        System.out.println("Orden por nombre: " + personas);
    }
}
//Salida:
//Orden por nombre: [Persona{nombre='Alice', edad=30}, Persona{nombre='Bob', edad=25}, Persona{nombre='Charlie', edad=35}]


//////////////////////////////////////////////////////////////
//3. Uso de Lambdas para Simplificar Comparadores
//Comparar Personas por Edad Descendente
//////////////////////////////////////////////////////////////

class DemoOrdenPorEdadDescendente {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Alice", 30));
        personas.add(new Persona("Bob", 25));
        personas.add(new Persona("Charlie", 35));

        // Ordenar por edad descendente usando lambda
        personas.sort((p1, p2) -> Integer.compare(p2.edad, p1.edad));
        System.out.println("Orden por edad descendente: " + personas);
    }
}


//Salida:
//Orden por edad descendente: [Persona{nombre='Charlie', edad=35}, Persona{nombre='Alice', edad=30}, Persona{nombre='Bob', edad=25}]


//////////////////////////////////////////////////////////////
//4. Comparar por Múltiples Criterios con Comparator
//Ordenar Primero por Edad y Luego por Nombre
//////////////////////////////////////////////////////////////

class DemoOrdenPorEdadYNombre {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Charlie", 35));
        personas.add(new Persona("Alice", 35));
        personas.add(new Persona("Bob", 25));

        // Ordenar por edad y luego por nombre: thenComparing solo se usa
        // para desempatar cuando comparingInt ya dio 0 (misma edad).
        personas.sort(Comparator.comparingInt((Persona p) -> p.edad)
                                .thenComparing(p -> p.nombre));
        System.out.println("Orden por edad y luego por nombre: " + personas);
    }
}

//Salida:
//Orden por edad y luego por nombre: [Persona{nombre='Bob', edad=25}, Persona{nombre='Alice', edad=35}, Persona{nombre='Charlie', edad=35}]


//////////////////////////////////////////////////////////////
//5. Comparadores con Referencias a Métodos
//Comparar Personas por Longitud del Nombre
//////////////////////////////////////////////////////////////

class DemoOrdenPorLongitudDeNombre {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Alice", 30));
        personas.add(new Persona("Bob", 25));
        personas.add(new Persona("Charlie", 35));

        // Ordenar por longitud del nombre
        personas.sort(Comparator.comparingInt(p -> p.nombre.length()));
        System.out.println("Orden por longitud del nombre: " + personas);
    }
}


//Salida:
//Orden por longitud del nombre: [Persona{nombre='Bob', edad=25}, Persona{nombre='Alice', edad=30}, Persona{nombre='Charlie', edad=35}]


//////////////////////////////////////////////////////////////
//6. Usar Comparadores en Estructuras de Datos
//Usar un TreeSet con un Comparator
//////////////////////////////////////////////////////////////

class DemoTreeSetConComparator {
    public static void main(String[] args) {
        // Un TreeSet necesita saber cómo ordenar sus elementos para poder
        // ubicarlos en el árbol — sin este Comparator, Persona tendría que
        // implementar Comparable<Persona> para poder entrar en un TreeSet.
        TreeSet<Persona> personas = new TreeSet<>(
            Comparator.comparingInt(p -> p.edad) // Comparador por edad
        );

        personas.add(new Persona("Alice", 30));
        personas.add(new Persona("Bob", 25));
        personas.add(new Persona("Charlie", 35));

        System.out.println("Personas en TreeSet ordenadas por edad: " + personas);
    }
}


//Salida:
//Personas en TreeSet ordenadas por edad: [Persona{nombre='Bob', edad=25}, Persona{nombre='Alice', edad=30}, Persona{nombre='Charlie', edad=35}]
