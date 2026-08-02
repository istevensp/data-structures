//Clase Base de la LinkedList:


import java.util.Iterator;

class DoublyLinkedList<T> {
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
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public DoublyLinkedListIterator iterator() {
        return new DoublyLinkedListIterator();
    }

    public class DoublyLinkedListIterator implements Iterator<T> {
        private Node<T> current = head;

        // Reinicia el iterador al inicio
        public void reset() {
            current = head;
        }

        // Devuelve el siguiente elemento sin avanzar
        public T peek() {
            if (!hasNext()) throw new IllegalStateException("No more elements to peek");
            return current.data;
        }

        // Retrocede al elemento anterior
        public T previous() {
            if (current == null || current.prev == null) throw new IllegalStateException("No previous element");
            current = current.prev;
            return current.data;
        }

        // Cuenta los elementos restantes
        public int countRemaining() {
            Node<T> temp = current;
            int count = 0;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            return count;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new IllegalStateException("No more elements");
            T data = current.data;
            current = current.next;
            return data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove not supported");
        }
    }
}

//Uso del Iterador Personalizado:

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add("Alice");
        list.add("Bob");
        list.add("Charlie");

        DoublyLinkedList<String>.DoublyLinkedListIterator iterator = list.iterator();

        // Recorrer todos los elementos
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Retroceder un elemento
        System.out.println("\nRetroceder un elemento: " + iterator.previous());

        // Mostrar elementos restantes
        System.out.println("Elementos restantes: " + iterator.countRemaining());
    }
}
