
//////////////////////////////////////////////////////////////
//Clase Contacto
//////////////////////////////////////////////////////////////
import java.time.LocalDate;

class Contacto {
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;
    private LocalDate fechaNacimiento;

    public Contacto(String nombre, String telefono, String email, String direccion, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}



//////////////////////////////////////////////////////////////
//Comparadores Personalizados
//////////////////////////////////////////////////////////////


import java.util.Comparator;

class ComparadoresContacto {

    // Comparador por nombre
    public static Comparator<Contacto> porNombre() {
        return (c1, c2) -> c1.getNombre().compareToIgnoreCase(c2.getNombre());
    }

    // Comparador por teléfono
    public static Comparator<Contacto> porTelefono() {
        return (c1, c2) -> c1.getTelefono().compareTo(c2.getTelefono());
    }

    // Comparador por email
    public static Comparator<Contacto> porEmail() {
        return (c1, c2) -> c1.getEmail().compareToIgnoreCase(c2.getEmail());
    }
}


public void ordenarContactos(Comparator<Contacto> comparador) {
    // Crear una lista auxiliar para ordenar los contactos
    List<Contacto> listaOrdenada = new ArrayList<>();
    for (Contacto c : contactos) {
        listaOrdenada.add(c);
    }

    // Ordenar usando el comparador proporcionado
    listaOrdenada.sort(comparador);

    // Mostrar contactos ordenados
    System.out.println("Contactos ordenados:");
    for (Contacto c : listaOrdenada) {
        System.out.println(c);
    }
}


//////////////////////////////////////////////////////////////
//Clase Lista Doblemente Enlazada
//////////////////////////////////////////////////////////////

import java.util.Iterator;

class ListaCircularDobleEnlazada<T> {
    private Nodo<T> head; // Nodo inicial
    private int size;     // Tamaño de la lista

    // Clase interna Nodo
    private static class Nodo<T> {
        T data;
        Nodo<T> next;
        Nodo<T> prev;

        public Nodo(T data) {
            this.data = data;
        }
    }

    public ListaCircularDobleEnlazada() {
        head = null;
        size = 0;
    }

    // Método para agregar un elemento al final
    public void agregar(T data) {
        Nodo<T> nuevo = new Nodo<>(data);
        if (head == null) { // Lista vacía
            head = nuevo;
            head.next = head;
            head.prev = head;
        } else {
            Nodo<T> tail = head.prev;
            tail.next = nuevo;
            nuevo.prev = tail;
            nuevo.next = head;
            head.prev = nuevo;
        }
        size++;
    }

    // Método para eliminar un elemento
    public void eliminar(T data, Comparator<T> comparador) {
        if (head == null) return;

        Nodo<T> actual = head;
        int count = 0;

        do {
            if (comparador.compare(actual.data, data) == 0) { // Usar comparador
                if (actual == head && size == 1) {
                    head = null; // Lista queda vacía
                } else {
                    Nodo<T> prev = actual.prev;
                    Nodo<T> next = actual.next;
                    prev.next = next;
                    next.prev = prev;
                    if (actual == head) {
                        head = next; // Cambiar cabeza si es el primer nodo
                    }
                }
                size--;
                return;
            }
            actual = actual.next;
            count++;
        } while (actual != head && count < size);
    }

    // Obtener el último elemento
    public T obtenerUltimo() {
        if (head == null) throw new IllegalStateException("La lista está vacía.");
        return head.prev.data; // Elemento previo a la cabeza es el último
    }

    // Obtener el tamaño
    public int size() {
        return size;
    }

    // Verificar si está vacía
    public boolean isEmpty() {
        return size == 0;
    }

    // Método para obtener un iterador
    public IteradorLista iterador() {
        return new IteradorLista();
    }

    // Clase interna Iterador
    public class IteradorLista implements Iterator<T> {
        private Nodo<T> current = head;
        private int count = 0;

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public T next() {
            T data = current.data;
            current = current.next;
            count++;
            return data;
        }
    }
}



//////////////////////////////////////////////////////////////
//Clase STACK Personalizada
//////////////////////////////////////////////////////////////

class Stack<T> {
    private ListaCircularDobleEnlazada<T> lista; // La lista circular doblemente enlazada que actúa como base de la pila

    public Stack() {
        lista = new ListaCircularDobleEnlazada<>(); // Inicializamos la lista
    }

    // Agregar elemento a la pila
    public void push(T data) {
        // Agrega un elemento al final de la lista, que en este caso actúa como el tope de la pila
        lista.agregar(data);
    }

    // Eliminar y devolver el elemento en el tope
    public T pop() {
        if (lista.isEmpty()) {
            throw new IllegalStateException("La pila está vacía."); // Validación para evitar errores
        }
        // Obtener el último elemento de la lista (tope de la pila)
        T data = lista.obtenerUltimo();
        // Eliminar el último elemento de la lista, simulando la operación de desapilar
        lista.eliminar(data, (a, b) -> 0); // Usamos un comparador trivial ya que ya tenemos la referencia del dato
        return data;
    }

    // Consultar el elemento en el tope sin eliminarlo
    public T peek() {
        if (lista.isEmpty()) {
            throw new IllegalStateException("La pila está vacía."); // Validación para evitar errores
        }
        // Devolvemos el último elemento de la lista sin eliminarlo
        return lista.obtenerUltimo();
    }

    // Verificar si la pila está vacía
    public boolean isEmpty() {
        return lista.isEmpty(); // La pila está vacía si la lista también lo está
    }

    // Obtener el tamaño
    public int size() {
        return lista.size(); // El tamaño de la pila es igual al tamaño de la lista
    }

    // Iterador para recorrer la pila
    public ListaCircularDobleEnlazada<T>.IteradorLista iterator() {
        // Devolvemos un iterador que permite recorrer la pila desde el primer elemento
        return lista.iterador();
    }
}


//////////////////////////////////////////////////////////////
//Clase Agenda 
//////////////////////////////////////////////////////////////


import java.time.LocalDate;

class Agenda {
    private ListaCircularDobleEnlazada<Contacto> contactos; // Lista circular doblemente enlazada para gestionar los contactos
    private Stack<String> historialAcciones; // Pila para registrar acciones realizadas (deshacer)
    private Stack<String> redoAcciones;      // Pila para registrar acciones deshechas (rehacer)

    public Agenda() {
        contactos = new ListaCircularDobleEnlazada<>(); // Inicialización de la lista de contactos
        historialAcciones = new Stack<>(); // Inicialización de la pila de historial
        redoAcciones = new Stack<>();     // Inicialización de la pila de rehacer
    }

    // Método para agregar un contacto
    public void agregarContacto(Contacto contacto) {
        contactos.agregar(contacto); // Se agrega el contacto a la lista circular
        historialAcciones.push("ADD:" + contacto.getNombre()); // Registramos la acción de agregar en la pila de historial
        redoAcciones = new Stack<>(); // Limpiamos la pila de rehacer porque hemos realizado una nueva acción
        System.out.println("Contacto agregado: " + contacto);
    }

    // Método para eliminar un contacto
    public void eliminarContacto(String nombre) {
        Contacto contacto = buscarPorNombre(nombre); // Buscar el contacto por nombre
        if (contacto != null) {
            contactos.eliminar(contacto, (c1, c2) -> c1.getNombre().compareTo(c2.getNombre())); // Eliminamos el contacto usando el comparador
            historialAcciones.push("DELETE:" + nombre); // Registramos la acción de eliminar en la pila de historial
            redoAcciones = new Stack<>(); // Limpiamos la pila de rehacer porque hemos realizado una nueva acción
            System.out.println("Contacto eliminado: " + nombre);
        } else {
            System.out.println("Contacto no encontrado: " + nombre);
        }
    }

    // Método para buscar un contacto usando un comparador
    public Contacto buscarContacto(Contacto referencia, Comparator<Contacto> comparador) {
        for (Contacto contacto : contactos) {
            // Usa el comparador para evaluar si el contacto cumple el criterio
            if (comparador.compare(contacto, referencia) == 0) {
                return contacto; // Retorna el contacto encontrado
            }
        }
        return null; // Si no se encuentra, retorna null
    }
	
    // Método para deshacer la última acción
    public void deshacer() {
        if (historialAcciones.isEmpty()) {
            System.out.println("No hay acciones para deshacer."); // Validación: No podemos deshacer si no hay historial
            return;
        }

        String accion = historialAcciones.pop(); // Recuperamos y eliminamos la última acción de la pila
        redoAcciones.push(accion); // Registramos la acción en la pila de rehacer

        String[] partes = accion.split(":");
        String tipo = partes[0];
        String nombre = partes[1];

        if (tipo.equals("ADD")) {
            // Si la acción fue agregar, revertimos eliminando el contacto
            eliminarContacto(nombre);
            System.out.println("Deshacer agregar: " + nombre);
        } else if (tipo.equals("DELETE")) {
            // Si la acción fue eliminar, revertimos agregando el contacto (requiere información adicional en un caso real)
            Contacto restaurado = new Contacto(nombre, "000-000", "email@ejemplo.com", "Dirección", LocalDate.now());
            agregarContacto(restaurado);
            System.out.println("Deshacer eliminar: " + nombre);
        }
    }

    // Método para rehacer la última acción deshecha
    public void rehacer() {
        if (redoAcciones.isEmpty()) {
            System.out.println("No hay acciones para rehacer."); // Validación: No podemos rehacer si no hay acciones deshechas
            return;
        }

        String accion = redoAcciones.pop(); // Recuperamos y eliminamos la última acción de rehacer
        historialAcciones.push(accion); // Registramos la acción en la pila de historial

        String[] partes = accion.split(":");
        String tipo = partes[0];
        String nombre = partes[1];

        if (tipo.equals("ADD")) {
            // Si la acción fue agregar, volvemos a agregar el contacto
            Contacto restaurado = new Contacto(nombre, "000-000", "email@ejemplo.com", "Dirección", LocalDate.now());
            agregarContacto(restaurado);
            System.out.println("Rehacer agregar: " + nombre);
        } else if (tipo.equals("DELETE")) {
            // Si la acción fue eliminar, volvemos a eliminar el contacto
            eliminarContacto(nombre);
            System.out.println("Rehacer eliminar: " + nombre);
        }
    }

    // Mostrar contactos
    public void mostrarContactos() {
        System.out.println("Contactos:");
        for (Contacto contacto : contactos) {
            System.out.println(contacto); // Iteramos y mostramos cada contacto
        }
    }
}
