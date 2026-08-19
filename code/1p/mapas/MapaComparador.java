// Un HashMap no tiene orden de recorrido garantizado (ver el tópico
// Mapas). Para mostrarlo ordenado por un criterio, hay que sacar sus
// entradas a una lista y ordenar esa lista con un Comparator — el mapa en
// sí no se ordena. Dos variantes del mismo patrón: ordenar por clave
// (nombre) y ordenar por valor (número).

import java.util.*;

public class AgendaHashMap {
    public static void main(String[] args) {
        Map<String, String> agenda = new HashMap<>();
        agenda.put("Carlos", "0991234567");
        agenda.put("Ana", "0987654321");
        agenda.put("Pedro", "0971122334");

        // Convertimos a lista de entradas — HashMap por sí solo no se puede
        // ordenar in-place, pero una List<Map.Entry<...>> sí.
        List<Map.Entry<String, String>> porNombre = new ArrayList<>(agenda.entrySet());

        // Comparator por clave (nombre)
        Comparator<Map.Entry<String, String>> comparadorPorNombre =
                new Comparator<Map.Entry<String, String>>() {
                    @Override
                    public int compare(Map.Entry<String, String> e1, Map.Entry<String, String> e2) {
                        return e1.getKey().compareTo(e2.getKey());
                    }
                };

        porNombre.sort(comparadorPorNombre);

        System.out.println("Agenda ordenada por nombre (Comparator):");
        for (Map.Entry<String, String> entry : porNombre) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Segunda lista independiente, para no reordenar la primera —
        // mismo mapa, criterio de orden distinto.
        List<Map.Entry<String, String>> porNumero = new ArrayList<>(agenda.entrySet());

        // Comparator por valor (número)
        Comparator<Map.Entry<String, String>> comparadorPorNumero =
                new Comparator<Map.Entry<String, String>>() {
                    @Override
                    public int compare(Map.Entry<String, String> e1, Map.Entry<String, String> e2) {
                        return e1.getValue().compareTo(e2.getValue());
                    }
                };

        Collections.sort(porNumero, comparadorPorNumero);

        System.out.println("\nAgenda ordenada por número (Comparator):");
        for (Map.Entry<String, String> entry : porNumero) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
