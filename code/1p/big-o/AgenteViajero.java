/** 
Código para la Fuerza Bruta del Problema del Agente Viajero con Complejidad O(n!)

A continuación te muestro un ejemplo en código que implementa la solución de fuerza bruta para el problema del agente viajero. Este código calcula todas las rutas posibles y selecciona la de menor distancia. **/

import java.util.Arrays;

public class AgenteViajero {

    // Método para calcular la distancia total de una ruta
    public static int calcularDistancia(int[][] distancias, int[] ruta) {
        int distanciaTotal = 0;
        for (int i = 0; i < ruta.length - 1; i++) {
            distanciaTotal += distancias[ruta[i]][ruta[i + 1]];
        }
        // Agregar la distancia de regreso a la ciudad de origen
        distanciaTotal += distancias[ruta[ruta.length - 1]][ruta[0]];
        return distanciaTotal;
    }

    // Método para generar todas las permutaciones posibles de la ruta
    public static void permutar(int[] ruta, int l, int r, int[][] distancias, int[] mejorRuta, int[] minDistancia) {
        if (l == r) {
            // Calcular la distancia de la ruta actual
            int distanciaActual = calcularDistancia(distancias, ruta);
            // Actualizar si encontramos una mejor ruta
            if (distanciaActual < minDistancia[0]) {
                minDistancia[0] = distanciaActual;
                System.arraycopy(ruta, 0, mejorRuta, 0, ruta.length);
            }
        } else {
            for (int i = l; i <= r; i++) {
                intercambiar(ruta, l, i);
                permutar(ruta, l + 1, r, distancias, mejorRuta, minDistancia);
                intercambiar(ruta, l, i);  // Volver al estado original
            }
        }
    }

    // Método para intercambiar dos elementos en el arreglo
    public static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Matriz de distancias entre ciudades
        int[][] distancias = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        // Inicializar la ruta
        int[] ruta = {0, 1, 2, 3};  // Representa las ciudades A, B, C, D
        int[] mejorRuta = new int[ruta.length];
        int[] minDistancia = {Integer.MAX_VALUE};  // Almacena la distancia mínima

        // Generar todas las permutaciones de la ruta y calcular la distancia mínima
        permutar(ruta, 0, ruta.length - 1, distancias, mejorRuta, minDistancia);

        // Imprimir la mejor ruta y la distancia mínima
        System.out.println("Mejor ruta: " + Arrays.toString(mejorRuta));
        System.out.println("Distancia mínima: " + minDistancia[0]);
    }
}

/**Ejemplo modificado para que veas cómo la multiplicación ocurre en la selección de rutas, y la suma ocurre al calcular las distancias.**/
import java.util.Arrays;

public class AgenteViajeroExplicado {

    // Método para calcular la distancia total de una ruta
    public static int calcularDistancia(int[][] distancias, int[] ruta) {
        int distanciaTotal = 0;
        // Sumar las distancias entre ciudades en la ruta
        for (int i = 0; i < ruta.length - 1; i++) {
            distanciaTotal += distancias[ruta[i]][ruta[i + 1]];
        }
        // Agregar la distancia de regreso a la ciudad de origen
        distanciaTotal += distancias[ruta[ruta.length - 1]][ruta[0]];
        return distanciaTotal;
    }

    // Método para generar todas las rutas posibles (permuta las ciudades)
    public static void permutar(int[] ruta, int l, int r, int[][] distancias, int[] mejorRuta, int[] minDistancia) {
        if (l == r) {
            // Calcular la distancia de la ruta actual
            int distanciaActual = calcularDistancia(distancias, ruta);
            // Actualizar si encontramos una mejor ruta (distancia más corta)
            if (distanciaActual < minDistancia[0]) {
                minDistancia[0] = distanciaActual;
                System.arraycopy(ruta, 0, mejorRuta, 0, ruta.length);
            }
        } else {
            for (int i = l; i <= r; i++) {
                intercambiar(ruta, l, i);  // Intercambiar ciudades
                permutar(ruta, l + 1, r, distancias, mejorRuta, minDistancia);  // Recursión
                intercambiar(ruta, l, i);  // Volver al estado original
            }
        }
    }

    // Método para intercambiar dos ciudades
    public static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Matriz de distancias entre las ciudades
        int[][] distancias = {
            {0, 10, 15, 20},  // Distancias desde la ciudad A
            {10, 0, 35, 25},  // Distancias desde la ciudad B
            {15, 35, 0, 30},  // Distancias desde la ciudad C
            {20, 25, 30, 0}   // Distancias desde la ciudad D
        };

        // Inicializamos la ruta
        int[] ruta = {0, 1, 2, 3};  // Ciudades A, B, C, D
        int[] mejorRuta = new int[ruta.length];  // Para guardar la mejor ruta
        int[] minDistancia = {Integer.MAX_VALUE};  // Para guardar la distancia mínima

        // Generamos todas las permutaciones y calculamos la mejor ruta
        permutar(ruta, 0, ruta.length - 1, distancias, mejorRuta, minDistancia);

        // Imprimimos la mejor ruta y la distancia mínima
        System.out.println("Mejor ruta: " + Arrays.toString(mejorRuta));
        System.out.println("Distancia mínima: " + minDistancia[0]);
    }
}
