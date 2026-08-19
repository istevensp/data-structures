//////////////////////////////////////////////////////////////
// Clase Base de la Lista Circular Doble
//////////////////////////////////////////////////////////////

import java.util.Iterator;

class CircularDoublyLinkedList<T> {
    private Node<T> head, tail;

    // Nodo interno
    private static class Node<T> {
        T data;
        Node<T> next, prev;

        Node(T data) {
            this.data = data;
        }
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
            head.next = head.prev = head; // único nodo: se enlaza consigo mismo
        } else {
            newNode.prev = tail;
            newNode.next = head; // cierra el ciclo: el nuevo último apunta al primero
            tail.next = newNode;
            head.prev = newNode; // y el primero apunta de vuelta al nuevo último
            tail = newNode;
        }
    }

    public CircularDoublyLinkedListIterator iterator() {
        return new CircularDoublyLinkedListIterator();
    }

    public class CircularDoublyLinkedListIterator implements Iterator<T> {
        private Node<T> current = head;
        private boolean initialIteration = true;

        // En una lista circular, 'current' nunca llega a null (siempre hay
        // un "siguiente"): hasNext() basado solo en != null nunca sería
        // false, y el while(hasNext()) de main() correría para siempre. Se
        // necesita distinguir "recién empezado" de "ya di la vuelta
        // completa y volví a head" con un flag aparte.
        @Override
        public boolean hasNext() {
            return head != null && (current != head || initialIteration);
        }

        @Override
        public T next() {
            if (!hasNext()) throw new IllegalStateException("No more elements");
            T data = current.data;
            current = current.next;
            initialIteration = false;
            return data;
        }

        // Retrocede al elemento anterior — posible porque cada nodo también
        // guarda una referencia a 'prev', a diferencia de la versión simple.
        public T previous() {
            if (current == null || current.prev == null) throw new IllegalStateException("No previous element");
            current = current.prev;
            initialIteration = false;
            return current.data;
        }

        public void reset() {
            current = head;
            initialIteration = true;
        }
    }
}

//////////////////////////////////////////////////////////////
// Uso del Iterador Personalizado
//////////////////////////////////////////////////////////////

public class Main {
    public static void main(String[] args) {
        CircularDoublyLinkedList<String> list = new CircularDoublyLinkedList<>();
        list.add("Alice");
        list.add("Bob");
        list.add("Charlie");

        CircularDoublyLinkedList<String>.CircularDoublyLinkedListIterator iterator = list.iterator();

        // Recorrer todos los elementos hacia adelante
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Retroceder un elemento — solo posible porque la lista es doblemente enlazada
        System.out.println("\nRetroceder un elemento: " + iterator.previous());
    }
}
