// Este archivo reúne dos bloques de ejemplos sobre genéricos en Java:
//
//   Parte 1 (líneas de abajo hasta el resumen intermedio): clase genérica
//   básica, su contraste con la versión sin genéricos (Object + casting),
//   métodos e interfaces genéricas, y wildcards.
//
//   Parte 2: un recorrido por la convención de nombres de parámetros de
//   tipo (E, K, N, T, V, y S/U/V para tipos adicionales), cada letra con
//   su propia clase de ejemplo.
//
// Cada demo es una clase con su propio main() — cópiala junto con las
// clases que usa para probarla de forma aislada.

import java.util.List;

//////////////////////////////////////////////////////////////
// PARTE 1
//////////////////////////////////////////////////////////////

/** Ejemplo simple de clase genérica **/

class Caja<T> {
    private T objeto;

    public void set(T objeto) {
        this.objeto = objeto;
    }

    public T get() {
        return objeto;
    }
}

/** T es el parámetro de tipo que representa cualquier tipo de dato.
Al crear una instancia de la clase, se define el tipo real. **/

class DemoCajaGenerica {
    public static void main(String[] args) {

        // Caja que almacena String
        Caja<String> cajaDeString = new Caja<>();
        cajaDeString.set("Hola Mundo");
        String mensaje = cajaDeString.get(); // Sin casting
        System.out.println(mensaje);

        // Caja que almacena Integer
        Caja<Integer> cajaDeEntero = new Caja<>();
        cajaDeEntero.set(123);
        Integer numero = cajaDeEntero.get(); // Sin casting
        System.out.println(numero);
    }
}

/** Beneficios de Caja<T> sobre usar Object: seguridad de tipo en tiempo de
compilación, sin necesidad de casting al recuperar el valor. **/

/** Contraste — Genéricos vs. Object sin genéricos. Misma idea que Caja<T>,
pero sin parámetro de tipo: el campo es Object, así que hay que castear al
recuperar el valor, y ese cast puede fallar en tiempo de ejecución si se
guardó un tipo distinto al esperado (algo que el compilador no detecta). **/

class CajaSinGenericos {
    private Object objeto;

    public void set(Object objeto) {
        this.objeto = objeto;
    }

    public Object get() {
        return objeto;
    }
}

/** Problemas de esta versión: hay que castear al recuperar el valor, con
riesgo de ClassCastException en tiempo de ejecución. **/


/** Métodos genéricos: no solo las clases pueden ser genéricas — un método
puede declarar su propio parámetro de tipo <T>, independiente de la clase
que lo contiene. **/

class Utilidad {
    // <T> antes del tipo de retorno indica el parámetro de tipo del método
    public static <T> void imprimir(T objeto) {
        System.out.println(objeto);
    }

    // List<?> acepta una lista de cualquier tipo de objeto (wildcard sin restricción)
    public static void imprimirLista(List<?> lista) {
        for (Object obj : lista) {
            System.out.println(obj);
        }
    }

    // List<? extends Number> acepta listas de Integer, Double, o cualquier
    // subtipo de Number (wildcard con límite superior)
    public static void imprimirNumeros(List<? extends Number> lista) {
        for (Number numero : lista) {
            System.out.println(numero);
        }
    }
}

class DemoMetodoGenerico {
    public static void main(String[] args) {
        // El método imprimir puede manejar cualquier tipo de dato (String, Integer, Double).
        Utilidad.imprimir("Hola Mundo");
        Utilidad.imprimir(123);
        Utilidad.imprimir(99.99);
    }
}


/** Interfaces genéricas: también pueden serlo, y permiten que las clases
que las implementen trabajen con el tipo parametrizado que elijan. **/

interface Comparador<T> {
    boolean comparar(T a, T b);
}

class ComparadorEnteros implements Comparador<Integer> {
    public boolean comparar(Integer a, Integer b) {
        return a > b;
    }
}

/** Comparador<Integer> compara dos enteros. **/


/**
Wildcards (comodines): permiten mayor flexibilidad en el uso de tipos genéricos.
Tipos de comodines:
  Sin restricción: ?
  Con límite superior: ? extends T
  Con límite inferior: ? super T
**/

class DemoWildcards {
    public static void main(String[] args) {
        List<Object> mixta = List.of("texto", 1, 2.5);
        Utilidad.imprimirLista(mixta); // wildcard sin restricción: acepta cualquier tipo

        List<Integer> enteros = List.of(10, 20, 30);
        Utilidad.imprimirNumeros(enteros); // wildcard con límite superior: solo Number y subtipos
    }
}


/** Ejercicio: crea una clase genérica llamada Par que almacene dos elementos.
Úsala para almacenar pares de valores como Par<String, Integer>. **/

class Par<K, V> {
    private K clave;
    private V valor;

    public Par(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public K getClave() {
        return clave;
    }

    public V getValor() {
        return valor;
    }
}

class DemoParEjercicio {
    public static void main(String[] args) {
        Par<String, Integer> par = new Par<>("edad", 25);
        System.out.println("Clave: " + par.getClave() + ", Valor: " + par.getValor());
    }
}


//////////////////////////////////////////////////////////////
// PARTE 2 — Convenciones de nombres de parámetros de tipo
//////////////////////////////////////////////////////////////

/** 1. E - Element (Elemento)
Este parámetro es comúnmente utilizado en el contexto de colecciones que manejan
elementos, como List, Set, etc. **/

// Clase genérica que representa una caja de elementos
class CajaElementos<E> {
    private E elemento;

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    public E getElemento() {
        return elemento;
    }
}

class DemoConvencionE {
    public static void main(String[] args) {
        // Caja que almacena un elemento de tipo String
        CajaElementos<String> cajaDeString = new CajaElementos<>();
        cajaDeString.setElemento("Elemento en la caja");
        System.out.println("Elemento: " + cajaDeString.getElemento());
    }
}


/** 2. K - Key (Clave)
Se usa principalmente en estructuras que tienen pares clave-valor, como un Map.
Reutiliza la misma clase Par<K, V> del ejercicio de la Parte 1 — aquí el foco no es
la clase en sí, sino la convención de nombre: K para la clave. **/

class DemoConvencionK {
    public static void main(String[] args) {
        // Crear un par con una clave Integer y un valor String
        Par<Integer, String> par = new Par<>(1, "Valor asociado a la clave 1");
        System.out.println("Clave: " + par.getClave() + ", Valor: " + par.getValor());
    }
}

/** 3. N - Number (Número)
Este parámetro se utiliza cuando trabajas con clases o métodos genéricos que operan
con tipos numéricos (como Integer, Double, etc.). **/

// Clase genérica que acepta solo números — "N extends Number" es un límite
// superior: no cualquier tipo sirve, solo Number y sus subtipos, porque el
// cuerpo necesita llamar a doubleValue().
class Calculadora<N extends Number> {
    public double sumar(N numero1, N numero2) {
        return numero1.doubleValue() + numero2.doubleValue();
    }
}

class DemoConvencionN {
    public static void main(String[] args) {
        // Calculadora que opera con números Integer
        Calculadora<Integer> calculadora = new Calculadora<>();
        System.out.println("Suma: " + calculadora.sumar(10, 20));

        // Calculadora que opera con números Double
        Calculadora<Double> calculadoraDouble = new Calculadora<>();
        System.out.println("Suma: " + calculadoraDouble.sumar(15.5, 4.5));
    }
}

/** 4. T - Type (Tipo)
Este es uno de los nombres más comunes para representar cualquier tipo genérico en
clases o métodos. **/

// Clase genérica que acepta cualquier tipo de dato
class Contenedor<T> {
    private T contenido;

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public T getContenido() {
        return contenido;
    }
}

class DemoConvencionT {
    public static void main(String[] args) {
        // Contenedor de tipo String
        Contenedor<String> contenedorDeString = new Contenedor<>();
        contenedorDeString.setContenido("Texto genérico");
        System.out.println("Contenido: " + contenedorDeString.getContenido());

        // Contenedor de tipo Integer
        Contenedor<Integer> contenedorDeInteger = new Contenedor<>();
        contenedorDeInteger.setContenido(123);
        System.out.println("Contenido: " + contenedorDeInteger.getContenido());
    }
}

/** 5. V - Value (Valor)
Este parámetro es comúnmente utilizado en estructuras que tienen pares clave-valor,
como un Map. Aquí, V representa el valor asociado a la clave. **/

// Un Par genérico con clave K y valor V, con nombre propio para distinguirlo
// del Par<K,V> del ejercicio de la Parte 1 (misma idea, clase separada).
class ParClaveValor<K, V> {
    private K clave;
    private V valor;

    public ParClaveValor(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public K getClave() {
        return clave;
    }

    public V getValor() {
        return valor;
    }
}

class DemoConvencionV {
    public static void main(String[] args) {
        // Crear un Par con clave String y valor Integer
        ParClaveValor<String, Integer> par = new ParClaveValor<>("Clave1", 100);
        System.out.println("Clave: " + par.getClave() + ", Valor: " + par.getValor());
    }
}

/** 6. S, U, V, etc. - 2do, 3er, 4to tipo
Estos parámetros se utilizan cuando necesitas manejar múltiples tipos en una clase o
método genérico. Por ejemplo, T puede ser el primer tipo, y U o V pueden representar
otros tipos adicionales. **/

// Clase genérica con tres tipos T, U y V
class Triple<T, U, V> {
    private T primerElemento;
    private U segundoElemento;
    private V tercerElemento;

    public Triple(T primerElemento, U segundoElemento, V tercerElemento) {
        this.primerElemento = primerElemento;
        this.segundoElemento = segundoElemento;
        this.tercerElemento = tercerElemento;
    }

    public T getPrimerElemento() {
        return primerElemento;
    }

    public U getSegundoElemento() {
        return segundoElemento;
    }

    public V getTercerElemento() {
        return tercerElemento;
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear un Triple con diferentes tipos
        Triple<String, Integer, Double> triple = new Triple<>("Texto", 100, 99.99);
        System.out.println("Primer Elemento: " + triple.getPrimerElemento());
        System.out.println("Segundo Elemento: " + triple.getSegundoElemento());
        System.out.println("Tercer Elemento: " + triple.getTercerElemento());
    }
}

/**
Resumen de las convenciones:
  E: Elemento (usado en colecciones).
  K: Clave.
  N: Número.
  T: Tipo (Type).
  V: Valor.
  S, U, V: representan un segundo, tercer o cuarto tipo cuando una clase o método
  necesita más de uno (V se reutiliza aquí con otro sentido — "N-ésimo tipo extra" en
  vez de "Value" — según cuál de las dos convenciones aplique al caso).
Cada convención existe para hacer que los nombres de los parámetros de tipo sean más
descriptivos y fáciles de entender — el compilador acepta cualquier nombre válido de
identificador, estas letras son solo una costumbre ampliamente seguida.
**/
