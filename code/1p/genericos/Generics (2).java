/** Ejemplo Simple de Clase Genéricajava **/

public class Caja<T> {
    private T objeto;
    
    public void set(T objeto) {
        this.objeto = objeto;
    }
    
    public T get() {
        return objeto;
    }
}

/**T es el parámetro de tipo que representa cualquier tipo de dato.
Al crear una instancia de la clase, se define el tipo real.**/





/**4: Ejemplo de Uso de Clase Genérica java **/
public class Main {
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



/** Beneficios: Seguridad de tipo en tiempo de compilación.
Sin necesidad de casting al recuperar el valor.**/

/**5: Genéricos vs. Object Sin Genéricos (Usando Object)java **/
public class Caja {
    private Object objeto;
    
    public void set(Object objeto) {
        this.objeto = objeto;
    }

    public Object get() {
        return objeto;
    }
}

/** Problemas: Necesitas hacer casting cuando recuperas el valor.
Riesgo de errores en tiempo de ejecución.**/




/**7: Métodos Genéricos java **/

public class Utilidad {
    public static <T> void imprimir(T objeto) {
        System.out.println(objeto);
    }
}

/** Los métodos también pueden ser genéricos.
<T> indica el tipo genérico que se pasa cuando llamas al método.**/


/**8: Ejemplo de Método Genérico java **/
public class Main {
    public static void main(String[] args) {
        Utilidad.imprimir("Hola Mundo");
        Utilidad.imprimir(123);
        Utilidad.imprimir(99.99);
    }
}
/** El método imprimir puede manejar cualquier tipo de dato (String, Integer, Double).**/


/**9: Interfaces Genéricas java **/

public interface Comparador<T> {
    boolean comparar(T a, T b);
}

/** Las interfaces también pueden ser genéricas.
Permiten que las clases que las implementen trabajen con tipos parametrizados.


/**10: Ejemplo de Interface Genérica java **/
public class ComparadorEnteros implements Comparador<Integer> {
    public boolean comparar(Integer a, Integer b) {
        return a > b;
    }
}
/** Comparador<Integer> compara dos enteros.**/


/**11: Uso de Wildcards (Comodines)
Comodines (?): permiten mayor flexibilidad en el uso de tipos genéricos.
Tipos de comodines:
Sin restricción: ?
Con límite superior: ? extends T
Con límite inferior: ? super T


/**12: Ejemplo de Wildcard Sin Restricción java **/
public class Utilidad {
    public static void imprimirLista(List<?> lista) {
        for (Object obj : lista) {
            System.out.println(obj);
        }
    }
}
/** List<?> acepta una lista de cualquier tipo de objeto.**/

/**13: Ejemplo de Wildcard con Límite Superior java**/
public class Utilidad {
    public static void imprimirNumeros(List<? extends Number> lista) {
        for (Number numero : lista) {
            System.out.println(numero);
        }
    }
}
/** List<? extends Number> acepta listas de números (ej: Integer, Double, etc.).**/


/**Ejercicio: Crea una clase genérica llamada Par que almacene dos elementos.
Usa esta clase para almacenar pares de valores como Par<String, Integer>.
java**/
public class Par<K, V> {
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




/**1. E - Element (Elemento)
Este parámetro es comúnmente utilizado en el contexto de colecciones que manejan elementos, como List, Set, etc. En el siguiente ejemplo, se utiliza E para representar un elemento de una lista genérica.**/


// Clase genérica que representa una caja de elementos
public class CajaElementos<E> {
    private E elemento;

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    public E getElemento() {
        return elemento;
    }
}

public class Main {
    public static void main(String[] args) {
        // Caja que almacena un elemento de tipo String
        CajaElementos<String> cajaDeString = new CajaElementos<>();
        cajaDeString.setElemento("Elemento en la caja");
        System.out.println("Elemento: " + cajaDeString.getElemento());
    }
}



/**2. K - Key (Clave)
Se usa principalmente en estructuras que tienen pares clave-valor, como un Map. Aquí, K representa la clave (key).**/


// Clase Par que representa un par clave-valor
public class Par<K, V> {
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

public class Main {
    public static void main(String[] args) {
        // Crear un par con una clave Integer y un valor String
        Par<Integer, String> par = new Par<>(1, "Valor asociado a la clave 1");
        System.out.println("Clave: " + par.getClave() + ", Valor: " + par.getValor());
    }
}
/**3. N - Number (Número)
Este parámetro se utiliza cuando trabajas con clases o métodos genéricos que operan con tipos numéricos (como Integer, Double, etc.).**/



// Clase genérica que acepta solo números
public class Calculadora<N extends Number> {
    public double sumar(N numero1, N numero2) {
        return numero1.doubleValue() + numero2.doubleValue();
    }
}

public class Main {
    public static void main(String[] args) {
        // Calculadora que opera con números Integer
        Calculadora<Integer> calculadora = new Calculadora<>();
        System.out.println("Suma: " + calculadora.sumar(10, 20));

        // Calculadora que opera con números Double
        Calculadora<Double> calculadoraDouble = new Calculadora<>();
        System.out.println("Suma: " + calculadoraDouble.sumar(15.5, 4.5));
    }
}
/**4. T - Type (Tipo)
Este es uno de los nombres más comunes para representar cualquier tipo genérico en clases o métodos.**/


// Clase genérica que acepta cualquier tipo de dato
public class Contenedor<T> {
    private T contenido;

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public T getContenido() {
        return contenido;
    }
}

public class Main {
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
/**5. V - Value (Valor)
Este parámetro es comúnmente utilizado en estructuras que tienen pares clave-valor, como un Map. Aquí, V representa el valor asociado a la clave.**/


// Usando un Par genérico con clave K y valor V
public class ParClaveValor<K, V> {
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

public class Main {
    public static void main(String[] args) {
        // Crear un Par con clave String y valor Integer
        ParClaveValor<String, Integer> par = new ParClaveValor<>("Clave1", 100);
        System.out.println("Clave: " + par.getClave() + ", Valor: " + par.getValor());
    }
}
/**6. S, U, V, etc. - 2nd, 3rd, 4th Types
Estos parámetros se utilizan cuando necesitas manejar múltiples tipos en una clase o método genérico. Por ejemplo, T puede ser el primer tipo, y U o V pueden representar otros tipos adicionales.**/

// Clase genérica con tres tipos T, U y V**/
public class Triple<T, U, V> {
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
/**Resumen de las Convenciones:
E: Elemento (usado en colecciones).
K: Clave.
N: Número.
T: Tipo (Type).
V: Valor.
S, U, V: Representan segundos, terceros o cuartos tipos.
Cada convención tiene un uso específico para hacer que los nombres de los parámetros de tipo sean más descriptivos y fáciles de entender. **/