// Implementación general de búsqueda binaria, seguida por 5 demos que
// muestran cómo se comporta con distintas posiciones del valor buscado y
// distintos tamaños de arreglo (par/impar) — todas usan exactamente el
// mismo algoritmo, solo cambian los datos de entrada.

/**
Ejemplo en Java
A continuación, se muestra un ejemplo de cómo implementar la búsqueda binaria en Java.
**/

public class BusquedaBinaria {

    // Método para realizar la búsqueda binaria
    public static int busquedaBinaria(int[] arr, int valorBuscado) {
        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;  // Encontrar el índice medio

            // Verificar si el valor buscado está en el medio
            if (arr[medio] == valorBuscado) {
                return medio;  // Elemento encontrado
            }

            // Si el valor buscado es mayor, ignorar la mitad izquierda
            if (arr[medio] < valorBuscado) {
                inicio = medio + 1;
            } else {
                // Si el valor buscado es menor, ignorar la mitad derecha
                fin = medio - 1;
            }
        }

        // El valor no está presente en el arreglo
        return -1;
    }

    public static void main(String[] args) {
        int[] arreglo = {2, 3, 4, 10, 40};  // El arreglo debe estar ordenado
        int valorBuscado = 10;

        // Llamar al método de búsqueda binaria
        int resultado = busquedaBinaria(arreglo, valorBuscado);

        if (resultado == -1) {
            System.out.println("Elemento no encontrado");
        } else {
            System.out.println("Elemento encontrado en el índice: " + resultado);
        }
    }
}


/** Casos de Búsqueda Binaria

Caso 1: Valor en el Medio
Este caso muestra cómo se comporta la búsqueda binaria cuando el valor buscado está
justo en el medio del arreglo **/


class BusquedaBinariaCaso1 {
    public static int busquedaBinaria(int[] arr, int valorBuscado) {
        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;  // Encontrar el valor medio

            if (arr[medio] == valorBuscado) {
                return medio;  // Valor encontrado en el medio
            }

            if (arr[medio] < valorBuscado) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return -1;  // Valor no encontrado
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5};  // Tamaño impar, el valor buscado está en el medio
        int valorBuscado = 3;

        int resultado = busquedaBinaria(arreglo, valorBuscado);

        if (resultado == -1) {
            System.out.println("Valor no encontrado");
        } else {
            System.out.println("Valor encontrado en el índice: " + resultado);
        }
    }
}


/** Caso 2: Valor en la Mitad Derecha
En este caso, el valor buscado está en la mitad derecha del arreglo. **/


class BusquedaBinariaCaso2 {
    public static int busquedaBinaria(int[] arr, int valorBuscado) {
        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;  // Encontrar el valor medio

            if (arr[medio] == valorBuscado) {
                return medio;  // Valor encontrado
            }

            if (arr[medio] < valorBuscado) {
                inicio = medio + 1;  // Buscar en la mitad derecha
            } else {
                fin = medio - 1;  // Buscar en la mitad izquierda
            }
        }

        return -1;  // Valor no encontrado
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5, 6, 7, 8, 9};  // Tamaño impar, el valor está en la mitad derecha
        int valorBuscado = 7;

        int resultado = busquedaBinaria(arreglo, valorBuscado);

        if (resultado == -1) {
            System.out.println("Valor no encontrado");
        } else {
            System.out.println("Valor encontrado en el índice: " + resultado);
        }
    }
}


/**Caso 3: Valor en la Mitad Izquierda
En este caso, el valor buscado está en la mitad izquierda del arreglo. **/


class BusquedaBinariaCaso3 {
    public static int busquedaBinaria(int[] arr, int valorBuscado) {
        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;  // Encontrar el valor medio

            if (arr[medio] == valorBuscado) {
                return medio;  // Valor encontrado
            }

            if (arr[medio] < valorBuscado) {
                inicio = medio + 1;  // Buscar en la mitad derecha
            } else {
                fin = medio - 1;  // Buscar en la mitad izquierda
            }
        }

        return -1;  // Valor no encontrado
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5, 6, 7, 8, 9};  // Tamaño impar, el valor está en la mitad izquierda
        int valorBuscado = 2;

        int resultado = busquedaBinaria(arreglo, valorBuscado);

        if (resultado == -1) {
            System.out.println("Valor no encontrado");
        } else {
            System.out.println("Valor encontrado en el índice: " + resultado);
        }
    }
}

/**Caso general: tamaño par e impar
Ejemplos para un arreglo con tamaño par y otro con tamaño impar, para ver cómo se
comporta la búsqueda binaria en cada uno.

Arreglo de tamaño impar**/

class BusquedaBinariaTamañoImpar {
    public static int busquedaBinaria(int[] arr, int valorBuscado) {
        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (arr[medio] == valorBuscado) {
                return medio;  // Valor encontrado
            }

            if (arr[medio] < valorBuscado) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5, 6, 7};  // Tamaño impar
        int valorBuscado = 5;

        int resultado = busquedaBinaria(arreglo, valorBuscado);

        if (resultado == -1) {
            System.out.println("Valor no encontrado");
        } else {
            System.out.println("Valor encontrado en el índice: " + resultado);
        }
    }
}


/**Arreglo de tamaño par**/

class BusquedaBinariaTamañoPar {
    public static int busquedaBinaria(int[] arr, int valorBuscado) {
        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (arr[medio] == valorBuscado) {
                return medio;  // Valor encontrado
            }

            if (arr[medio] < valorBuscado) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5, 6, 7, 8};  // Tamaño par
        int valorBuscado = 6;

        int resultado = busquedaBinaria(arreglo, valorBuscado);

        if (resultado == -1) {
            System.out.println("Valor no encontrado");
        } else {
            System.out.println("Valor encontrado en el índice: " + resultado);
        }
    }
}


/**Código general para búsqueda binaria (incluyendo todos los casos)**/

class BusquedaBinariaGeneral {

    // Método general de búsqueda binaria que cubre todos los casos
    public static int busquedaBinaria(int[] arr, int valorBuscado) {
        int inicio = 0;
        int fin = arr.length - 1;

        // Bucle que sigue dividiendo la lista hasta encontrar el valor o agotar la búsqueda
        while (inicio <= fin) {
            // Calcular el índice del valor medio
            int medio = inicio + (fin - inicio) / 2;

            // Caso 1: Valor encontrado en el medio
            if (arr[medio] == valorBuscado) {
                return medio;  // Valor encontrado, retornar el índice
            }

            // Caso 2: El valor buscado es mayor que el valor medio
            if (arr[medio] < valorBuscado) {
                inicio = medio + 1;  // Buscar en la mitad derecha
            } else {
                // Caso 3: El valor buscado es menor que el valor medio
                fin = medio - 1;  // Buscar en la mitad izquierda
            }
        }

        // Si el valor no se encuentra en el arreglo, retorna -1
        return -1;
    }

    public static void main(String[] args) {
        // Ejemplos de arreglos de diferentes tamaños (par e impar)
        int[] arregloImpar = {1, 2, 3, 4, 5, 6, 7};  // Tamaño impar
        int[] arregloPar = {1, 2, 3, 4, 5, 6, 7, 8};  // Tamaño par

        // Probar el caso 1: valor en el medio del arreglo impar
        int resultado1 = busquedaBinaria(arregloImpar, 4);
        if (resultado1 != -1) {
            System.out.println("Valor encontrado en el índice (Caso 1): " + resultado1);
        } else {
            System.out.println("Valor no encontrado (Caso 1)");
        }

        // Probar el caso 2: valor en la mitad derecha del arreglo impar
        int resultado2 = busquedaBinaria(arregloImpar, 7);
        if (resultado2 != -1) {
            System.out.println("Valor encontrado en el índice (Caso 2): " + resultado2);
        } else {
            System.out.println("Valor no encontrado (Caso 2)");
        }

        // Probar el caso 3: valor en la mitad izquierda del arreglo impar
        int resultado3 = busquedaBinaria(arregloImpar, 2);
        if (resultado3 != -1) {
            System.out.println("Valor encontrado en el índice (Caso 3): " + resultado3);
        } else {
            System.out.println("Valor no encontrado (Caso 3)");
        }

        // Probar el caso general: valor en el arreglo par
        int resultado4 = busquedaBinaria(arregloPar, 6);
        if (resultado4 != -1) {
            System.out.println("Valor encontrado en el índice (Arreglo Par): " + resultado4);
        } else {
            System.out.println("Valor no encontrado (Arreglo Par)");
        }
    }
}
