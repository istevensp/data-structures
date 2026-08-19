// Un ejemplo ejecutable por cada complejidad común, de O(1) a O(n!) — cada
// clase es independiente (su propio main), para poder compilarlas y
// correrlas una por una y ver la complejidad de cada TDA/algoritmo en la
// práctica, no solo en la tabla de Big(O).

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

/** 1. Arreglos (Arrays)
En un arreglo en Java, los elementos están almacenados en posiciones contiguas, por lo
que puedes acceder a cualquier elemento directamente por su índice.

Complejidad de Operaciones
Acceso: O(1) - Acceder a un elemento por su índice toma tiempo constante.
Búsqueda: O(n) - En el peor de los casos, necesitas recorrer todo el arreglo para encontrar un elemento.
Inserción/Eliminación: O(n) - Si insertas o eliminas elementos al principio o en medio del arreglo, todos los elementos deben ser desplazados. **/


public class ArregloEjemplo {
    public static void main(String[] args) {
        // Crear un arreglo de 5 elementos
        int[] arreglo = {10, 20, 30, 40, 50};

        // Acceder a un elemento (complejidad O(1))
        System.out.println("Elemento en el índice 2: " + arreglo[2]);  // Resultado: 30

        // Búsqueda de un elemento (complejidad O(n))
        int buscar = 40;
        boolean encontrado = false;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == buscar) {
                encontrado = true;
                System.out.println("Elemento encontrado en el índice " + i);
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Elemento no encontrado");
        }

        // Inserción de un nuevo elemento (complejidad O(n))
        // Para insertar 25 en el índice 2, los elementos después de 30 deben desplazarse
        int[] nuevoArreglo = new int[arreglo.length + 1];
        for (int i = 0; i < 2; i++) {
            nuevoArreglo[i] = arreglo[i];
        }
        nuevoArreglo[2] = 25;
        for (int i = 2; i < arreglo.length; i++) {
            nuevoArreglo[i + 1] = arreglo[i];
        }
        System.out.println("Arreglo con 25 insertado en el índice 2: " + Arrays.toString(nuevoArreglo));
    }
}



/** 2. Listas Enlazadas (Linked Lists)
En una lista enlazada, los elementos no están almacenados en posiciones contiguas, sino que cada elemento (nodo) contiene una referencia al siguiente nodo.

Complejidad de Operaciones
Acceso: O(n) - Para acceder a un elemento necesitas recorrer la lista desde el principio.
Búsqueda: O(n) - Debes recorrer la lista nodo por nodo hasta encontrar el elemento.
Inserción/Eliminación:
Al inicio: O(1) - Puedes insertar o eliminar rápidamente en el comienzo de la lista.
En el medio o al final: O(n) - Debes recorrer hasta el nodo donde quieres insertar o eliminar.**/


class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

class ListaEnlazada {
    Nodo cabeza;

    // Método para agregar al inicio (complejidad O(1))
    public void agregarInicio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    // Método para buscar un elemento (complejidad O(n))
    public boolean buscar(int dato) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato == dato) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // Método para mostrar los elementos (complejidad O(n))
    public void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();

        // Agregar elementos al inicio
        lista.agregarInicio(10);  // Complejidad O(1)
        lista.agregarInicio(20);  // Complejidad O(1)
        lista.agregarInicio(30);  // Complejidad O(1)

        // Mostrar la lista
        lista.mostrar();  // 30 -> 20 -> 10 -> null

        // Buscar un elemento
        System.out.println("¿Elemento 20 encontrado? " + lista.buscar(20));  // true
    }
}

/** 3. Pilas (Stacks)
Una pila (stack) sigue el principio LIFO (Last In, First Out). Las operaciones se realizan en la parte superior de la pila.

Complejidad de Operaciones
Acceso: O(n) - Si quieres acceder a un elemento que no está en la parte superior, debes recorrer la pila.
Push (inserción): O(1) - Insertar en la parte superior es constante.
Pop (eliminación): O(1) - Eliminar el elemento superior es constante.**/


class PilaEjemplo {
    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<>();

        // Insertar elementos en la pila (complejidad O(1))
        pila.push(10);
        pila.push(20);
        pila.push(30);

        // Eliminar elemento de la pila (complejidad O(1))
        System.out.println("Elemento eliminado: " + pila.pop());  // Elimina 30

        // Acceder al elemento superior sin eliminarlo (complejidad O(1))
        System.out.println("Elemento superior: " + pila.peek());  // Muestra 20
    }
}


/**4. Colas (Queues)
Una cola (queue) sigue el principio FIFO (First In, First Out), donde los elementos se insertan al final y se eliminan desde el frente.

Complejidad de Operaciones
Enqueue (inserción): O(1) - Insertar al final de la cola es constante.
Dequeue (eliminación): O(1) - Eliminar desde el frente de la cola es constante.
Acceso: O(n) - Para acceder a un elemento que no está en el frente, debes recorrer la cola.**/


class ColaEjemplo {
    public static void main(String[] args) {
        // Ver el tópico Pilas y Colas para por qué se prefiere ArrayDeque
        // sobre LinkedList como implementación de Queue.
        Queue<Integer> cola = new ArrayDeque<>();

        // Insertar elementos en la cola (complejidad O(1))
        cola.add(10);
        cola.add(20);
        cola.add(30);

        // Eliminar el elemento del frente (complejidad O(1))
        System.out.println("Elemento eliminado: " + cola.poll());  // Elimina 10

        // Mostrar el frente de la cola (complejidad O(1))
        System.out.println("Elemento en el frente: " + cola.peek());  // Muestra 20
    }
}


/** 5. Tablas Hash (HashMap)
Un HashMap en Java es una estructura de datos que utiliza una función hash para mapear claves a valores. Ofrece acceso rápido a los elementos.

Complejidad de Operaciones
Acceso: O(1) en promedio, pero O(n) en el peor de los casos si hay muchas colisiones.
Inserción: O(1) en promedio.
Eliminación: O(1) en promedio. **/


class HashMapEjemplo {
    public static void main(String[] args) {
        HashMap<String, Integer> mapa = new HashMap<>();

        // Insertar elementos en el HashMap (complejidad O(1) en promedio)
        mapa.put("Juan", 30);
        mapa.put("Ana", 25);
        mapa.put("Luis", 28);

        // Acceder a un elemento (complejidad O(1) en promedio)
        System.out.println("Edad de Ana: " + mapa.get("Ana"));  // 25

        // Eliminar un elemento (complejidad O(1) en promedio)
        mapa.remove("Luis");
        System.out.println("¿Sigue Luis? " + mapa.containsKey("Luis"));  // false
    }
}


/** O(n log n) - Logarítmico Lineal
Este tipo de complejidad es común en algoritmos de ordenamiento eficientes como Merge Sort o Quick Sort. Estos algoritmos dividen el problema en partes más pequeñas y luego combinan los resultados.

Ejemplo: Quick Sort **/

class QuickSortExample {

    // Método para realizar Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Encontrar el índice de partición
            int pi = partition(arr, low, high);

            // Recursivamente ordenar las subpartes
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Método para encontrar el punto de partición
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);  // Índice del elemento más pequeño

        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (arr[j] <= pivot) {
                i++;
                // Intercambiar arr[i] y arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Intercambiar arr[i + 1] con el pivote (arr[high])
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};

        System.out.println("Array original:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        // Llamar a Quick Sort
        quickSort(arr, 0, arr.length - 1);

        System.out.println("\nArray ordenado:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
/* Explicación: el algoritmo Quick Sort tiene una complejidad promedio de O(n log n),
pero en el peor de los casos puede ser O(n²) si el pivote no se elige correctamente
(por ejemplo, si siempre cae en el elemento más pequeño o más grande). El código
divide el arreglo en partes alrededor de un pivote y luego combina los resultados
recursivamente hasta ordenar el arreglo completo. */

/** O(n²) - Cuadrática
Esta complejidad es común en algoritmos ineficientes como el Bubble Sort o el Insertion Sort, donde cada elemento debe compararse con todos los demás elementos.

Ejemplo: Bubble Sort**/

class BubbleSortExample {

    // Método para realizar Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Intercambiar si el elemento actual es mayor que el siguiente
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Array original:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        // Llamar a Bubble Sort
        bubbleSort(arr);

        System.out.println("\nArray ordenado:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
/* Explicación: el algoritmo Bubble Sort compara cada par de elementos adyacentes y
los intercambia si están en el orden incorrecto. Tiene una complejidad de O(n²), ya
que cada elemento se compara con los demás en cada pasada, lo que lo hace ineficiente
para entradas grandes. */


/** O(2^n) - Exponencial
Este tipo de complejidad se observa en problemas que requieren calcular muchas combinaciones posibles, como en el caso de resolver el problema de la mochila o problemas de fuerza bruta.

Ejemplo: Problema de la Mochila**/

class MochilaEjemplo {

    // Método para resolver el problema de la mochila de manera recursiva
    public static int knapSack(int capacidad, int pesos[], int valores[], int n) {
        // Caso base: si no hay más artículos o la capacidad es 0
        if (n == 0 || capacidad == 0) {
            return 0;
        }

        // Si el peso del n-ésimo artículo es mayor que la capacidad de la mochila
        if (pesos[n - 1] > capacidad) {
            return knapSack(capacidad, pesos, valores, n - 1);  // Ignorar el artículo
        } else {
            // Retorna el máximo valor entre tomar o no tomar el artículo — esta
            // rama doble por cada artículo es lo que produce las 2^n llamadas.
            return Math.max(valores[n - 1] + knapSack(capacidad - pesos[n - 1], pesos, valores, n - 1),
                            knapSack(capacidad, pesos, valores, n - 1));
        }
    }

    public static void main(String[] args) {
        int valores[] = {60, 100, 120};
        int pesos[] = {10, 20, 30};
        int capacidad = 50;
        int n = valores.length;

        System.out.println("Valor máximo en la mochila: " + knapSack(capacidad, pesos, valores, n));
    }
}
/* Explicación: este código resuelve el problema de la mochila usando fuerza bruta,
donde se consideran todas las posibles combinaciones de artículos (tomarlo o no
tomarlo). Esto lleva a una complejidad de O(2^n), ya que cada uno de los n artículos
duplica el número de combinaciones a explorar. */

/** O(n!) - Factorial
Este tipo de complejidad ocurre en problemas donde hay que calcular todas las permutaciones posibles, como el problema del viajante, en el cual se necesita visitar todas las ciudades y calcular el costo de cada ruta posible.

Ejemplo: Problema del Viajante por Fuerza Bruta (ver también AgenteViajero.java, en
este mismo tópico, para una versión con reconstrucción de la mejor ruta). **/

class ViajanteEjemplo {

    // Método para calcular la distancia mínima de todas las permutaciones posibles (complejidad O(n!))
    public static int calcularCosto(int[][] grafo, int[] ruta) {
        int costo = 0;
        for (int i = 0; i < ruta.length - 1; i++) {
            costo += grafo[ruta[i]][ruta[i + 1]];
        }
        return costo;
    }

    // Método para permutar rutas y encontrar la mínima (fuerza bruta)
    public static void permutar(int[] ruta, int l, int r, int[][] grafo) {
        if (l == r) {
            System.out.println("Costo de la ruta: " + calcularCosto(grafo, ruta));
        } else {
            for (int i = l; i <= r; i++) {
                // Intercambiar elementos
                int temp = ruta[l];
                ruta[l] = ruta[i];
                ruta[i] = temp;

                // Recursivamente permutar los elementos restantes
                permutar(ruta, l + 1, r, grafo);

                // Volver al estado original
                temp = ruta[l];
                ruta[l] = ruta[i];
                ruta[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] grafo = {{0, 10, 15, 20},
                         {10, 0, 35, 25},
                         {15, 35, 0, 30},
                         {20, 25, 30, 0}};

        int[] ruta = {0, 1, 2, 3};

        // Encontrar todas las permutaciones de la ruta y calcular el costo
        permutar(ruta, 0, ruta.length - 1, grafo);
    }
}
/* Explicación: este código resuelve el problema del viajante calculando el costo de
todas las permutaciones posibles de las ciudades (a diferencia de AgenteViajero.java,
aquí se imprime el costo de cada ruta en vez de guardar solo la mejor). Este enfoque
tiene una complejidad de O(n!), ya que debe generar y evaluar todas las rutas
posibles. */
