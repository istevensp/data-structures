//Clase Base de la Lista Circular Doble:

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
            head.next = head.prev = head;
        } else {
            newNode.prev = tail;
            newNode.next = head;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }
    }

    public CircularDoublyLinkedListIterator iterator() {
        return new CircularDoublyLinkedListIterator();
    }

    public class CircularDoublyLinkedListIterator implements Iterator<T> {
        private Node<T> current = head;

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

        public T previous() {
            if (current == null || current.prev == null) throw new IllegalStateException("No previous element");
            current = current.prev;
            return current.data;
        }

        public void reset() {
            current = head;
        }
    }
}

//Uso del Iterador Personalizado:

public class Main {
    public static void main(String[] args) {
        CircularDoublyLinkedList<String> list = new CircularDoublyLinkedList<>();
        list.add("Alice");
        list.add("Bob");
        list.add("Charlie");

        CircularDoublyLinkedList<String>.CircularDoublyLinkedListIterator iterator = list.iterator();

        // Recorrer todos los elementos
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Retroceder un elemento
        System.out.println("\nRetroceder un elemento: " + iterator.previous());
    }
}
