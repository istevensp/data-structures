/**

Ejercicio 1: Dividir una lista de ventas diarias por sucursal

Dada una lista que representa las ventas diarias de tres sucursales, con el siguiente formato: [s1, s2, s3, s1, s2, s3, ...]. Por ejemplo, para la lista: [100, 200, 150, 120, 210, 180], el primer elemento corresponde a la sucursal s1, el segundo a s2 y el tercero a s3. El cuarto elemento (120) corresponde nuevamente a s1, y así sucesivamente.

Instrucciones: Implementar el método dividirVentas, que organiza los resultados de las ventas en tres listas separadas, cada una correspondiente a una sucursal, y retorna un arreglo de listas (LinkedList<Integer>[]). 
La solución debe ser eficiente con un tiempo de ejecución 𝑂(𝑛)**/

/**
 * Método que divide los resultados de ventas diarias en tres listas, 
 * correspondientes a tres sucursales.
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

    // Crear un iterador para recorrer la lista
    Iterator<Integer> iterador = lista.iterator();
    int sucursalActual = 0; // Indica la sucursal a la que se asignará la venta

    // Recorrer la lista de ventas
    while (iterador.hasNext()) {
        // Agregar la venta actual a la lista correspondiente
        resultado[sucursalActual].add(iterador.next());

        // Actualizar el índice para la próxima sucursal (cicla entre 0, 1, 2)
        sucursalActual = (sucursalActual + 1) % 3;
    }

    // Retornar el arreglo de listas
    return resultado;
}



/**

Ejercicio 2: Clasificar temperaturas por estación

Se tiene una lista de temperaturas medidas cada día durante un ciclo de 4 estaciones (Primavera, Verano, Otoño, Invierno) en el siguiente formato: [p, v, o, i, p, v, o, i, ...]. Por ejemplo, [15, 30, 10, 5, 18, 33, 12, 6]. El primer elemento corresponde a Primavera, el segundo a Verano, y así sucesivamente.

Instrucciones: Escriba un método llamado clasificarTemperaturas que reciba una lista de temperaturas y clasifique las temperaturas en 4 listas diferentes (una por cada estación). El método debe retornar un arreglo de listas (LinkedList<Integer>[]) que contengan los valores separados por estación.

**/


/**
 * Método que clasifica las temperaturas en cuatro listas, 
 * correspondientes a cuatro estaciones (Primavera, Verano, Otoño, Invierno).
 * 
 * @param lista Lista de temperaturas en formato [p, v, o, i, p, v, o, i, ...].
 * @return Un arreglo de cuatro LinkedLists, donde cada lista contiene 
 *         las temperaturas de una estación.
 */
private static LinkedList<Integer>[] clasificarTemperaturas(List<Integer> lista) {
    // Crear un arreglo de cuatro LinkedLists para las estaciones
    LinkedList<Integer>[] resultado = new LinkedList[4];
    for (int i = 0; i < 4; i++) {
        resultado[i] = new LinkedList<>(); // Inicializar cada lista
    }

    // Crear un iterador para recorrer la lista
    Iterator<Integer> iterador = lista.iterator();
    int estacionActual = 0; // Indica la estación actual (Primavera, Verano, Otoño, Invierno)

    // Recorrer la lista de temperaturas
    while (iterador.hasNext()) {
        // Agregar la temperatura actual a la lista de la estación correspondiente
        resultado[estacionActual].add(iterador.next());

        // Actualizar el índice para la próxima estación (cicla entre 0, 1, 2, 3)
        estacionActual = (estacionActual + 1) % 4;
    }

    // Retornar el arreglo de listas
    return resultado;
}


/**
Ejercicio 3: Separar puntajes por categoría de un examen

Dada una lista que contiene los puntajes obtenidos por estudiantes en un examen, organizados por categoría de dificultad (Fácil, Intermedio, Difícil), en el siguiente formato: [f, i, d, f, i, d, ...]. Por ejemplo, [20, 30, 50, 15, 35, 45]. El primer elemento corresponde a la categoría Fácil, el segundo a Intermedio, y el tercero a Difícil.

Instrucciones: Escriba un método llamado separarPuntajesPorCategoria que divida los puntajes en tres listas separadas (una por categoría) y retorne un arreglo de listas (LinkedList<Integer>[]) que contengan los resultados correspondientes a cada categoría.

**/

/**
 * Método que separa los puntajes en tres listas, correspondientes 
 * a tres categorías de dificultad (Fácil, Intermedio, Difícil).
 * 
 * @param lista Lista de puntajes en formato [f, i, d, f, i, d, ...].
 * @return Un arreglo de tres LinkedLists, donde cada lista contiene 
 *         los puntajes de una categoría.
 */
private static LinkedList<Integer>[] separarPuntajesPorCategoria(List<Integer> lista) {
    // Crear un arreglo de tres LinkedLists para las categorías
    LinkedList<Integer>[] resultado = new LinkedList[3];
    resultado[0] = new LinkedList<>(); // Puntajes de la categoría Fácil
    resultado[1] = new LinkedList<>(); // Puntajes de la categoría Intermedio
    resultado[2] = new LinkedList<>(); // Puntajes de la categoría Difícil

    // Crear un iterador para recorrer la lista
    Iterator<Integer> iterador = lista.iterator();
    int categoriaActual = 0; // Indica la categoría actual (Fácil, Intermedio, Difícil)

    // Recorrer la lista de puntajes
    while (iterador.hasNext()) {
        // Agregar el puntaje actual a la lista de la categoría correspondiente
        resultado[categoriaActual].add(iterador.next());

        // Actualizar el índice para la próxima categoría (cicla entre 0, 1, 2)
        categoriaActual = (categoriaActual + 1) % 3;
    }

    // Retornar el arreglo de listas
    return resultado;
}