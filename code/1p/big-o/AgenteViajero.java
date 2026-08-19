/**
Código para la Fuerza Bruta del Problema del Agente Viajero con Complejidad O(n!)

A continuación se muestra un ejemplo en código que implementa la solución de fuerza
bruta para el problema del agente viajero. Este código calcula todas las rutas
posibles y selecciona la de menor distancia: la multiplicación combinatoria ocurre
en permutar() (cada nivel de recursión multiplica el número de rutas a explorar
por una ciudad menos), y la suma ocurre en calcularDistancia() (sumando el costo
de cada tramo de una ruta ya fija). **/

import java.util.Arrays;

public class AgenteViajero {

    // Método para calcular la distancia total de una ruta
    public static int calcularDistancia(int[][] distancias, int[] ruta) {
        int distanciaTotal = 0;
        // Sumar las distancias entre ciudades consecutivas en la ruta
        for (int i = 0; i < ruta.length - 1; i++) {
            distanciaTotal += distancias[ruta[i]][ruta[i + 1]];
        }
        // Agregar la distancia de regreso a la ciudad de origen
        distanciaTotal += distancias[ruta[ruta.length - 1]][ruta[0]];
        return distanciaTotal;
    }

    // Método para generar todas las permutaciones posibles de la ruta
    // (fuerza bruta: por cada ciudad libre se prueban todas las posiciones
    // restantes, multiplicando el número de rutas a evaluar — de ahí O(n!)).
    public static void permutar(int[] ruta, int l, int r, int[][] distancias, int[] mejorRuta, int[] minDistancia) {
        if (l == r) {
            // Ruta completa: calcular su distancia total
            int distanciaActual = calcularDistancia(distancias, ruta);
            // Actualizar si encontramos una mejor ruta
            if (distanciaActual < minDistancia[0]) {
                minDistancia[0] = distanciaActual;
                System.arraycopy(ruta, 0, mejorRuta, 0, ruta.length);
            }
        } else {
            for (int i = l; i <= r; i++) {
                intercambiar(ruta, l, i);  // Fija una ciudad en la posición l
                permutar(ruta, l + 1, r, distancias, mejorRuta, minDistancia);  // Recursión sobre el resto
                intercambiar(ruta, l, i);  // Volver al estado original (backtrack)
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
        // Matriz de distancias entre ciudades (distancias[i][j] = distancia de i a j)
        int[][] distancias = {
            {0, 10, 15, 20},  // Distancias desde la ciudad A
            {10, 0, 35, 25},  // Distancias desde la ciudad B
            {15, 35, 0, 30},  // Distancias desde la ciudad C
            {20, 25, 30, 0}   // Distancias desde la ciudad D
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
