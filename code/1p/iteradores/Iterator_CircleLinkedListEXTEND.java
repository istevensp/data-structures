//////////////////////////////////////////////////////////////
// Clase Base de la Lista Circular Simple
//////////////////////////////////////////////////////////////

import java.util.Iterator;

// Solo guarda 'tail' (no 'head'): en una lista circular, tail.next
// siempre apunta al primer nodo, así que head se deriva de ahí en vez
// de guardarse por separado.
class CircularSinglyLinkedList<T> {
    private Node<T> tail;

    // Nodo interno
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            tail = newNode;
            tail.next = tail; // único nodo: se apunta a sí mismo, cerrando el ciclo
        } else {
            newNode.next = tail.next; // el nuevo nodo apunta al antiguo primero
            tail.next = newNode;      // el antiguo último ahora apunta al nuevo
            tail = newNode;           // el nuevo nodo pasa a ser el último
        }
    }

    public CircularSinglyLinkedListIterator iterator() {
        return new CircularSinglyLinkedListIterator();
    }

    // Iterador personalizado: a diferencia de una lista lineal, hasNext() no
    // puede preguntar "¿current == null?" porque en un ciclo nunca se llega a
    // null. En su lugar, usa hasLooped para detectar que ya se dio la vuelta
    // completa y se volvió al punto de partida.
    public class CircularSinglyLinkedListIterator implements Iterator<T> {
        private Node<T> current = (tail != null) ? tail.next : null; // primer nodo
        private Node<T> start = current;
        private boolean hasLooped = false;

        @Override
        public boolean hasNext() {
            return current != null && (!hasLooped || current != start);
        }

        @Override
        public T next() {
            if (!hasNext()) throw new IllegalStateException("No more elements");
            T data = current.data;
            current = current.next;
            if (current == start) hasLooped = true; // ya completó una vuelta
            return data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove not supported");
        }

        // Reinicia el iterador para recorrer el ciclo de nuevo desde el inicio.
        public void reset() {
            current = (tail != null) ? tail.next : null;
            hasLooped = false;
        }
    }
}

//////////////////////////////////////////////////////////////
// Uso del Iterador Personalizado
//////////////////////////////////////////////////////////////

public class Main {
    public static void main(String[] args) {
        CircularSinglyLinkedList<Integer> list = new CircularSinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        CircularSinglyLinkedList<Integer>.CircularSinglyLinkedListIterator iterator = list.iterator();

        // Recorrer una vez: hasNext() se vuelve false al completar la vuelta
        System.out.println("Recorrer una vez:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // reset() permite recorrer el mismo ciclo de nuevo — a diferencia de
        // una lista lineal, aquí "llegar al final" no es un estado permanente.
        iterator.reset();
        System.out.println("\nRecorrer de nuevo:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
