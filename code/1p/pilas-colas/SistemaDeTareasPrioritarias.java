import java.util.PriorityQueue;

/**
Simular un sistema de tareas donde cada tarea tiene una prioridad. 
Las tareas con menor valor numérico tienen mayor prioridad (por ejemplo, prioridad 1 es más urgente que 5).
**/

class Tarea implements Comparable<Tarea> {
    private String descripcion;
    private int prioridad; // 1 = más urgente, 10 = menos urgente

    public Tarea(String descripcion, int prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(Tarea otra) {
        // Orden ascendente: menor prioridad numérica primero
        return Integer.compare(this.prioridad, otra.prioridad);
    }

    @Override
    public String toString() {
        return "Tarea: " + descripcion + " (Prioridad: " + prioridad + ")";
    }
}

public class SistemaDeTareasPrioritarias {
    public static void main(String[] args) {
        PriorityQueue<Tarea> tareas = new PriorityQueue<>();

        // Agregar tareas con diferentes prioridades
        tareas.add(new Tarea("Enviar correo al cliente", 2));
        tareas.add(new Tarea("Revisar informe", 4));
        tareas.add(new Tarea("Llamar al proveedor", 1));
        tareas.add(new Tarea("Actualizar base de datos", 3));

        // Mostrar y atender tareas según prioridad
        System.out.println("Atendiendo tareas según prioridad:");
        while (!tareas.isEmpty()) {
            Tarea siguiente = tareas.poll(); // obtiene y elimina la más prioritaria
            System.out.println(siguiente);
        }
    }
}
