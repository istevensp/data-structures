// Tres ejercicios resueltos que usan un Iterator para recorrer una lista una
// sola vez (O(n)) y repartir sus elementos en varias listas de salida según
// su posición dentro de un ciclo fijo (cada 3 elementos, cada 4, etc.) — el
// mismo patrón ("cíclico módulo k") con tres enunciados distintos.

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EjerciciosIteradores {

    /**
     * Ejercicio 1: Dividir una lista de ventas diarias por sucursal.
     *
     * Dada una lista que representa las ventas diarias de tres sucursales,
     * con el siguiente formato: [s1, s2, s3, s1, s2, s3, ...]. Por ejemplo,
     * para la lista [100, 200, 150, 120, 210, 180], el primer elemento
     * corresponde a la sucursal s1, el segundo a s2 y el tercero a s3. El
     * cuarto elemento (120) corresponde nuevamente a s1, y así sucesivamente.
     *
     * Organiza los resultados en tres listas separadas, cada una
     * correspondiente a una sucursal, en O(n).
     *
     * @param lista Lista de ventas diarias en formato [s1, s2, s3, s1, s2, s3, ...].
     * @return Un arreglo de tres LinkedLists, donde cada lista contiene
     *         las ventas de una sucursal.
     */
    private static LinkedList<Integer>[] dividirVentas(List<Integer> lista) {
        // Crear un arreglo de tres LinkedLists para almacenar las ventas por sucursal
        LinkedList<Integer>[] resultado = new LinkedList[3];
        resultado[0] = new LinkedList<>(); // Ventas de la sucursal 1
        resultado[1] = new LinkedList<>(); // Ventas de la sucursal 2
        resultado[2] = new LinkedList<>(); // Ventas de la sucursal 3

        // Un Iterator (en vez de recorrer por índice) porque el algoritmo
        // solo necesita avanzar una vez de principio a fin — no acceso
        // aleatorio — y así funciona igual sobre cualquier List, incluida
        // una LinkedList donde el acceso por índice sería O(n) por elemento.
        Iterator<Integer> iterador = lista.iterator();
        int sucursalActual = 0; // Indica la sucursal a la que se asignará la venta

        while (iterador.hasNext()) {
            resultado[sucursalActual].add(iterador.next());
            sucursalActual = (sucursalActual + 1) % 3; // cicla entre 0, 1, 2
        }

        return resultado;
    }

    /**
     * Ejercicio 2: Clasificar temperaturas por estación.
     *
     * Lista de temperaturas medidas cada día durante un ciclo de 4 estaciones
     * (Primavera, Verano, Otoño, Invierno) en formato [p, v, o, i, p, v, o, i, ...].
     * Por ejemplo, [15, 30, 10, 5, 18, 33, 12, 6]. El primer elemento
     * corresponde a Primavera, el segundo a Verano, y así sucesivamente.
     *
     * Clasifica las temperaturas en 4 listas (una por estación) en O(n).
     *
     * @param lista Lista de temperaturas en formato [p, v, o, i, p, v, o, i, ...].
     * @return Un arreglo de cuatro LinkedLists, donde cada lista contiene
     *         las temperaturas de una estación.
     */
    private static LinkedList<Integer>[] clasificarTemperaturas(List<Integer> lista) {
        LinkedList<Integer>[] resultado = new LinkedList[4];
        for (int i = 0; i < 4; i++) {
            resultado[i] = new LinkedList<>();
        }

        Iterator<Integer> iterador = lista.iterator();
        int estacionActual = 0; // Primavera, Verano, Otoño, Invierno

        while (iterador.hasNext()) {
            resultado[estacionActual].add(iterador.next());
            estacionActual = (estacionActual + 1) % 4; // cicla entre 0, 1, 2, 3
        }

        return resultado;
    }

    /**
     * Ejercicio 3: Separar puntajes por categoría de un examen.
     *
     * Puntajes obtenidos por estudiantes, organizados por categoría de
     * dificultad (Fácil, Intermedio, Difícil), en formato [f, i, d, f, i, d, ...].
     * Por ejemplo, [20, 30, 50, 15, 35, 45]. El primer elemento corresponde a
     * Fácil, el segundo a Intermedio, y el tercero a Difícil.
     *
     * Divide los puntajes en tres listas (una por categoría) en O(n).
     *
     * @param lista Lista de puntajes en formato [f, i, d, f, i, d, ...].
     * @return Un arreglo de tres LinkedLists, donde cada lista contiene
     *         los puntajes de una categoría.
     */
    private static LinkedList<Integer>[] separarPuntajesPorCategoria(List<Integer> lista) {
        LinkedList<Integer>[] resultado = new LinkedList[3];
        resultado[0] = new LinkedList<>(); // Puntajes de la categoría Fácil
        resultado[1] = new LinkedList<>(); // Puntajes de la categoría Intermedio
        resultado[2] = new LinkedList<>(); // Puntajes de la categoría Difícil

        Iterator<Integer> iterador = lista.iterator();
        int categoriaActual = 0; // Fácil, Intermedio, Difícil

        while (iterador.hasNext()) {
            resultado[categoriaActual].add(iterador.next());
            categoriaActual = (categoriaActual + 1) % 3;
        }

        return resultado;
    }

    public static void main(String[] args) {
        List<Integer> ventas = List.of(100, 200, 150, 120, 210, 180);
        LinkedList<Integer>[] porSucursal = dividirVentas(ventas);
        System.out.println("Ventas sucursal 1: " + porSucursal[0]);
        System.out.println("Ventas sucursal 2: " + porSucursal[1]);
        System.out.println("Ventas sucursal 3: " + porSucursal[2]);

        List<Integer> temperaturas = List.of(15, 30, 10, 5, 18, 33, 12, 6);
        LinkedList<Integer>[] porEstacion = clasificarTemperaturas(temperaturas);
        System.out.println("\nPrimavera: " + porEstacion[0]);
        System.out.println("Verano: " + porEstacion[1]);
        System.out.println("Otoño: " + porEstacion[2]);
        System.out.println("Invierno: " + porEstacion[3]);

        List<Integer> puntajes = List.of(20, 30, 50, 15, 35, 45);
        LinkedList<Integer>[] porCategoria = separarPuntajesPorCategoria(puntajes);
        System.out.println("\nFácil: " + porCategoria[0]);
        System.out.println("Intermedio: " + porCategoria[1]);
        System.out.println("Difícil: " + porCategoria[2]);
    }
}
