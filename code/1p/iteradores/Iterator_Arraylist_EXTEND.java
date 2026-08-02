
//////////////////////////////////////////////////////////////
//Clase Base del ArrayList:
//////////////////////////////////////////////////////////////

import java.util.Iterator;

class CustomArrayList<T> {
    private T[] array;
    private int size;

    // Constructor inicializa el arreglo con capacidad 10
    @SuppressWarnings("unchecked")
    public CustomArrayList() {
        array = (T[]) new Object[10];
        size = 0;
    }

    // Agrega un elemento al final de la lista
    public void add(T element) {
        if (size == array.length) {
            resize(); // Incrementa el tamaño del arreglo si está lleno
        }
        array[size++] = element;
    }

    // Devuelve un elemento en una posición específica
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return array[index];
    }

    // Devuelve el tamaño actual de la lista
    public int size() {
        return size;
    }

    // Incrementa la capacidad del arreglo
    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newArray = (T[]) new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    // Devuelve un iterador personalizado
    public CustomArrayListIterator iterator() {
        return new CustomArrayListIterator();
    }

    // Clase interna que implementa el iterador personalizado
    public class CustomArrayListIterator implements Iterator<T> {
        private int currentIndex = 0;

        // Devuelve true si hay más elementos por iterar
        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        // Devuelve el siguiente elemento
        @Override
        public T next() {
            if (!hasNext()) throw new IllegalStateException("No more elements");
            return array[currentIndex++];
        }

        // Elimina el elemento actual
        @Override
        public void remove() {
            if (currentIndex <= 0) throw new IllegalStateException("No current element to remove");
            for (int i = currentIndex - 1; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[--size] = null;
            currentIndex--;
        }

        // Reinicia el iterador al inicio de la lista
        public void reset() {
            currentIndex = 0;
        }

        // Devuelve el próximo elemento sin avanzar
        public T peek() {
            if (!hasNext()) throw new IllegalStateException("No more elements to peek");
            return array[currentIndex];
        }

        // Salta n elementos
        public void skip(int n) {
            currentIndex += n;
            if (currentIndex > size) currentIndex = size; // No salirse del límite
        }

        // Devuelve el número de elementos restantes
        public int countRemaining() {
            return size - currentIndex;
        }

        // Verifica si está en el primer elemento
        public boolean isFirst() {
            return currentIndex == 0;
        }

        // Verifica si está en el último elemento
        public boolean isLast() {
            return currentIndex == size - 1;
        }
    }
}



//////////////////////////////////////////////////////////////
//Uso del Iterador Personalizado:
//////////////////////////////////////////////////////////////
public class Main {
    public static void main(String[] args) {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Alice");
        list.add("Bob");
        list.add("Charlie");

        CustomArrayList<String>.CustomArrayListIterator iterator = list.iterator();

        // Recorrer todos los elementos
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Reiniciar el iterador
        iterator.reset();
        System.out.println("\nPrimer elemento (peek): " + iterator.peek());

        // Saltar 1 elemento
        iterator.skip(1);
        System.out.println("Siguiente elemento después de saltar 1: " + iterator.next());

        // Mostrar elementos restantes
        System.out.println("Elementos restantes: " + iterator.countRemaining());

        // Eliminar un elemento
        iterator.reset();
        iterator.next(); // Avanzar al primer elemento
        iterator.remove(); // Eliminar el primer elemento
        System.out.println("\nDespués de eliminar el primer elemento:");
        iterator.reset(); // Reiniciar para imprimir
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
