//Clase Base de la Lista Circular Simple:

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
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public CircularSinglyLinkedListIterator iterator() {
        return new CircularSinglyLinkedListIterator();
    }

    public class CircularSinglyLinkedListIterator implements Iterator<T> {
        private Node<T> current = (tail != null) ? tail.next : null;
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
            if (current == start) hasLooped = true;
            return data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove not supported");
        }

        public void reset() {
            current = (tail != null) ? tail.next : null;
            hasLooped = false;
        }
    }
}

//Uso del Iterador Personalizado:

public class Main {
    public static void main(String[] args) {
        CircularSinglyLinkedList<Integer> list = new CircularSinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        CircularSinglyLinkedList<Integer>.CircularSinglyLinkedListIterator iterator = list.iterator();

        // Imprimir los elementos en ciclo
        System.out.println("Recorrer una vez:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Reiniciar el iterador y recorrer de nuevo
        iterator.reset();
        System.out.println("\nRecorrer de nuevo:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
