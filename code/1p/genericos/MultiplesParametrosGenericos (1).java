// Tres formas de usar más de un parámetro de tipo, comparando la
// convención habitual (T, U, V...) contra nombres alternativos — para
// mostrar que las letras son solo una convención de lectura, no una regla
// del compilador.

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/** Usando letras del abecedario como parámetros de tipo en lugar de S, T, U, V, etc. **/

class MultiComparator<A, B, C, D, E, F, G> {

    // Almacenamos las funciones de comparación
    private final Function<A, B> firstComparator;
    private final Function<B, C> secondComparator;
    private final Function<C, D> thirdComparator;
    private final Function<D, E> fourthComparator;
    private final Function<E, F> fifthComparator;
    private final Function<F, G> sixthComparator;
    private final Function<G, A> seventhComparator;

    // Constructor que acepta múltiples funciones de comparación
    public MultiComparator(Function<A, B> firstComparator,
                           Function<B, C> secondComparator,
                           Function<C, D> thirdComparator,
                           Function<D, E> fourthComparator,
                           Function<E, F> fifthComparator,
                           Function<F, G> sixthComparator,
                           Function<G, A> seventhComparator) {
        this.firstComparator = firstComparator;
        this.secondComparator = secondComparator;
        this.thirdComparator = thirdComparator;
        this.fourthComparator = fourthComparator;
        this.fifthComparator = fifthComparator;
        this.sixthComparator = sixthComparator;
        this.seventhComparator = seventhComparator;
    }

    // Encadena las 7 funciones: la salida de cada una es la entrada de la
    // siguiente (A->B->C->D->E->F->G->A), mostrando que el tipo de retorno
    // no tiene que ser el mismo que el de entrada en cada paso.
    public A applyAll(A input) {
        B result1 = firstComparator.apply(input);
        C result2 = secondComparator.apply(result1);
        D result3 = thirdComparator.apply(result2);
        E result4 = fourthComparator.apply(result3);
        F result5 = fifthComparator.apply(result4);
        G result6 = sixthComparator.apply(result5);
        return seventhComparator.apply(result6);
    }
}

class DemoMultiComparator {
    public static void main(String[] args) {
        // Crear una instancia de MultiComparator con 7 funciones diferentes
        MultiComparator<Integer, String, Integer, Double, String, Long, Integer> comparator = new MultiComparator<>(
                // Función 1: Convierte Integer a String
                input -> "Valor: " + input,
                // Función 2: Convierte String a Integer (número de caracteres)
                str -> str.length(),
                // Función 3: Convierte Integer a Double (multiplica por 2.5)
                length -> length * 2.5,
                // Función 4: Convierte Double a String
                result -> "Resultado: " + result,
                // Función 5: Convierte String a Long (longitud de nuevo string)
                result -> (long) result.length(),
                // Función 6: Convierte Long a Integer
                longResult -> longResult.intValue(),
                // Función 7: Devuelve Integer sumando 100 al resultado
                intResult -> intResult + 100
        );

        // Aplicar todas las funciones de comparación a un valor inicial
        Integer finalResult = comparator.applyAll(123);
        System.out.println("Resultado final: " + finalResult);
    }
}

/**
 * En este código, en lugar de usar S, T, U, V, se usan las letras A, B, C, D, E, F, G
 * como nombres de los parámetros de tipo. La lógica sigue siendo la misma: los tipos
 * A, B, C, D, E, F, G son placeholders que representan tipos de datos genéricos que
 * se pueden transformar de uno a otro usando las funciones definidas.
 */


/** Usamos "N" como parámetro de tipo genérico para una clase que trabaja con cadenas
de texto (String), aunque convencionalmente "N" se usa para números — el nombre de la
letra no restringe en nada qué tipo real se puede usar. **/

class GenericExample<N> {

    // Atributo de tipo genérico N
    private N value;

    // Constructor
    public GenericExample(N value) {
        this.value = value;
    }

    // Método para obtener el valor
    public N getValue() {
        return value;
    }

    // Método para establecer el valor
    public void setValue(N value) {
        this.value = value;
    }
}

class DemoGenericExample {
    public static void main(String[] args) {
        // Crear una instancia de GenericExample con String (no numérico)
        GenericExample<String> stringExample = new GenericExample<>("Hola Mundo");

        // Mostrar el valor
        System.out.println("Valor: " + stringExample.getValue());

        // Crear una instancia de GenericExample con Integer (numérico)
        GenericExample<Integer> integerExample = new GenericExample<>(123);

        // Mostrar el valor
        System.out.println("Valor: " + integerExample.getValue());
    }
}

/**
 * Aquí, "N" se utiliza como un parámetro de tipo genérico, pero no hay restricciones
 * sobre qué tipo puede ser. En el primer caso, el parámetro genérico "N" es String
 * (no numérico), mientras que en el segundo caso es Integer (numérico).
 */

/** Ejemplo usando "Z" para un tipo genérico y "O" para representar una Key en un mapa genérico **/

class CustomGenericExample<O, Z> {

    // Mapa genérico con clave de tipo O y valor de tipo Z
    private Map<O, Z> map;

    // Constructor
    public CustomGenericExample() {
        map = new HashMap<>();
    }

    // Método para agregar pares de clave-valor al mapa
    public void addItem(O key, Z value) {
        map.put(key, value);
    }

    // Método para obtener un valor dado una clave
    public Z getValue(O key) {
        return map.get(key);
    }

    // Método para mostrar el contenido del mapa
    public void printMap() {
        for (Map.Entry<O, Z> entry : map.entrySet()) {
            System.out.println("Clave (O): " + entry.getKey() + " - Valor (Z): " + entry.getValue());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear una instancia del mapa usando String como clave y Integer como valor
        CustomGenericExample<String, Integer> example = new CustomGenericExample<>();

        // Agregar elementos al mapa
        example.addItem("Uno", 1);
        example.addItem("Dos", 2);
        example.addItem("Tres", 3);

        // Obtener un valor del mapa
        System.out.println("Valor asociado a 'Dos': " + example.getValue("Dos"));

        // Mostrar todo el contenido del mapa
        example.printMap();
    }
}

/**
 * O y Z son los parámetros genéricos en la clase CustomGenericExample. O se usa para
 * la Key (clave) y Z se usa para el Value (valor). Creamos un mapa (HashMap) donde O
 * es el tipo de clave y Z es el tipo de valor. El ejemplo usa un mapa donde las claves
 * son String (representadas por O) y los valores son Integer (representados por Z).
 */
