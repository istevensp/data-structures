///////////////////////////////////////////////////////////////////////////////
//Clase Base: Lista Circular Doblemente Enlazada
///////////////////////////////////////////////////////////////////////////////

class CircularDoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Nodo interno
    private static class Node<T> {
        T data;
        Node<T> next, prev;

        Node(T data) {
            this.data = data;
        }
    }

    // Agrega un elemento al final de la lista
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
            head.next = head.prev = head; // Conexión circular
        } else {
            newNode.prev = tail;
            newNode.next = head;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }
        size++;
    }

    // Devuelve un iterador personalizado
    public CircularDoublyLinkedListIterator iterator() {
        return new CircularDoublyLinkedListIterator();
    }

    // Clase interna para el iterador personalizado
    public class CircularDoublyLinkedListIterator implements Iterator<T> {
        private Node<T> current = head;
        private boolean initialIteration = true;

        // Devuelve si hay más elementos por recorrer
        @Override
        public boolean hasNext() {
            return size > 0 && (current != head || initialIteration);
        }

        // Devuelve el siguiente elemento
        @Override
        public T next() {
            if (!hasNext()) throw new IllegalStateException("No more elements");
            T data = current.data;
            current = current.next;
            initialIteration = false;
            return data;
        }

        // Retrocede al elemento anterior
        public T previous() {
            if (current == null) throw new IllegalStateException("No elements to traverse");
            current = current.prev;
            return current.data;
        }

        // Reinicia el iterador al inicio
        public void reset() {
            current = head;
            initialIteration = true;
        }

        // Devuelve el próximo elemento sin avanzar
        public T peek() {
            if (!hasNext()) throw new IllegalStateException("No elements to peek");
            return current.data;
        }

        // Elimina el elemento actual
        @Override
        public void remove() {
            if (current == null) throw new IllegalStateException("No current element to remove");
            Node<T> nextNode = current.next;
            Node<T> prevNode = current.prev;

            // Desconectar el nodo actual
            if (current == head) head = nextNode;
            if (current == tail) tail = prevNode;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;

            current = nextNode;
            size--;

            if (size == 0) head = tail = null; // Lista vacía
        }
    }
}

//Clase Contacto:

class Contacto {
    String nombre;
    String telefono;
    String email;

    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


//Uso del Iterador Personalizado:
public class Main {
    public static void main(String[] args) {
        // Crear lista de contactos
        CircularDoublyLinkedList<Contacto> listaContactos = new CircularDoublyLinkedList<>();
        listaContactos.add(new Contacto("Alice", "123456789", "alice@example.com"));
        listaContactos.add(new Contacto("Bob", "987654321", "bob@example.com"));
        listaContactos.add(new Contacto("Charlie", "456789123", "charlie@example.com"));

        // Obtener iterador
        CircularDoublyLinkedList<Contacto>.CircularDoublyLinkedListIterator iterador = listaContactos.iterator();

        // Recorrer contactos hacia adelante
        System.out.println("Contactos hacia adelante:");
        while (iterador.hasNext()) {
            System.out.println(iterador.next());
        }

        // Retroceder un contacto
        System.out.println("\nRetroceder un contacto:");
        System.out.println(iterador.previous());

        // Ver el siguiente contacto sin avanzar
        System.out.println("\nPróximo contacto (peekNext):");
        System.out.println(iterador.peekNext());

        // Buscar un contacto específico
        System.out.println("\nBuscar contacto por nombre:");
        Contacto encontrado = iterador.find(c -> c.nombre.equals("Bob"));
        System.out.println(encontrado != null ? encontrado : "Contacto no encontrado");

        // Reiniciar iterador y recorrer de nuevo
        iterador.reset();
        System.out.println("\nRecorrer contactos después de reset:");
        while (iterador.hasNext()) {
            System.out.println(iterador.next());
        }
    }
}

