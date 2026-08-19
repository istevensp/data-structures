// Cuatro casos de uso reales de Comparator con la API moderna
// (Comparator.comparingX + lambdas), uno por cada demo separada abajo — el
// mismo criterio (envejecer un objeto con .sort(...)) aplicado a cuatro
// dominios distintos (inventario, notas, vuelos, fechas de registro) para
// mostrar que la técnica no cambia, solo el campo que se compara.

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//////////////////////////////////////////////////////////////
//1. Sistemas de Gestión de Inventarios
//Contexto: En un sistema de inventarios, los productos pueden necesitar ser ordenados por diferentes criterios, como:

//Precio (ascendente o descendente).
//Cantidad en stock.
//Popularidad o calificación del producto.
//Ejemplo: Ordenar Productos por Precio
//////////////////////////////////////////////////////////////

class Producto {
    String nombre;
    double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{nombre='" + nombre + "', precio=" + precio + "}";
    }
}

class DemoOrdenarProductosPorPrecio {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Laptop", 1200.50));
        productos.add(new Producto("Mouse", 25.99));
        productos.add(new Producto("Teclado", 49.99));

        // Ordenar por precio ascendente
        productos.sort(Comparator.comparingDouble(p -> p.precio));
        System.out.println("Productos ordenados por precio: " + productos);
    }
}

//Salida:
//Productos ordenados por precio: [Producto{nombre='Mouse', precio=25.99}, Producto{nombre='Teclado', precio=49.99}, Producto{nombre='Laptop', precio=1200.5}]



//////////////////////////////////////////////////////////////
//2. Sistemas Académicos
//Contexto: En un sistema académico, los estudiantes pueden ser ordenados según:

//Calificaciones.
//Nombre alfabético.
//Número de matrícula.
//Ejemplo: Ordenar Estudiantes por Calificación
//////////////////////////////////////////////////////////////

class Estudiante {
    String nombre;
    double calificacion;

    public Estudiante(String nombre, double calificacion) {
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Estudiante{nombre='" + nombre + "', calificacion=" + calificacion + "}";
    }
}

class DemoOrdenarEstudiantesPorCalificacion {
    public static void main(String[] args) {
        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Alice", 85.5));
        estudiantes.add(new Estudiante("Bob", 92.0));
        estudiantes.add(new Estudiante("Charlie", 78.3));

        // Ordenar por calificación descendente: e2 antes que e1 invierte
        // el signo del resultado, así el mayor queda primero.
        estudiantes.sort((e1, e2) -> Double.compare(e2.calificacion, e1.calificacion));
        System.out.println("Estudiantes ordenados por calificación: " + estudiantes);
    }
}

//Salida:
//Estudiantes ordenados por calificación: [Estudiante{nombre='Bob', calificacion=92.0}, Estudiante{nombre='Alice', calificacion=85.5}, Estudiante{nombre='Charlie', calificacion=78.3}]



//////////////////////////////////////////////////////////////
//Aplicaciones de Reservas
//Contexto: En una aplicación de reservas (como vuelos, hoteles o transporte), los datos pueden ser ordenados por:

//Precio.
//Duración del trayecto.
//Cantidad de escalas.
//Ejemplo: Ordenar Vuelos por Duración
//////////////////////////////////////////////////////////////

class Vuelo {
    String codigo;
    int duracion; // En minutos

    public Vuelo(String codigo, int duracion) {
        this.codigo = codigo;
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Vuelo{codigo='" + codigo + "', duracion=" + duracion + " minutos}";
    }
}

class DemoOrdenarVuelosPorDuracion {
    public static void main(String[] args) {
        List<Vuelo> vuelos = new ArrayList<>();
        vuelos.add(new Vuelo("AM123", 180));
        vuelos.add(new Vuelo("DL456", 120));
        vuelos.add(new Vuelo("UA789", 240));

        // Ordenar por duración ascendente
        vuelos.sort(Comparator.comparingInt(v -> v.duracion));
        System.out.println("Vuelos ordenados por duración: " + vuelos);
    }
}


//Salida:
//Vuelos ordenados por duración: [Vuelo{codigo='DL456', duracion=120 minutos}, Vuelo{codigo='AM123', duracion=180 minutos}, Vuelo{codigo='UA789', duracion=240 minutos}]


//////////////////////////////////////////////////////////////
//4. Procesamiento de Datos
//Contexto: Al manejar grandes conjuntos de datos, es común ordenar registros por:

//Fechas.
//Campos alfanuméricos.
//Longitud de un campo.
//Ejemplo: Ordenar Registros por Fecha
//////////////////////////////////////////////////////////////

class Registro {
    String descripcion;
    LocalDate fecha;

    public Registro(String descripcion, LocalDate fecha) {
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Registro{descripcion='" + descripcion + "', fecha=" + fecha + "}";
    }
}

class DemoOrdenarRegistrosPorFecha {
    public static void main(String[] args) {
        List<Registro> registros = new ArrayList<>();
        registros.add(new Registro("Evento A", LocalDate.of(2023, 5, 20)));
        registros.add(new Registro("Evento B", LocalDate.of(2022, 11, 15)));
        registros.add(new Registro("Evento C", LocalDate.of(2024, 3, 10)));

        // Ordenar por fecha ascendente — LocalDate ya implementa Comparable,
        // así que Comparator.comparing() lo usa directamente sin necesitar
        // comparingInt/comparingDouble.
        registros.sort(Comparator.comparing(r -> r.fecha));
        System.out.println("Registros ordenados por fecha: " + registros);
    }
}


//Salida:
//Registros ordenados por fecha: [Registro{descripcion='Evento B', fecha=2022-11-15}, Registro{descripcion='Evento A', fecha=2023-05-20}, Registro{descripcion='Evento C', fecha=2024-03-10}]
