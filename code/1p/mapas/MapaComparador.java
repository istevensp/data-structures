import java.util.*;

public class AgendaHashMap {
    public static void main(String[] args) {
        Map<String, String> agenda = new HashMap<>();
        agenda.put("Carlos", "0991234567");
        agenda.put("Ana", "0987654321");
        agenda.put("Pedro", "0971122334");

        // Convertimos a lista de entradas
        List<Map.Entry<String, String>> lista = new ArrayList<>(agenda.entrySet());

        // Comparator por clave (nombre)
        Comparator<Map.Entry<String, String>> comparadorPorNombre =
                new Comparator<Map.Entry<String, String>>() {
                    @Override
                    public int compare(Map.Entry<String, String> e1, Map.Entry<String, String> e2) {
                        return e1.getKey().compareTo(e2.getKey());
                    }
                };

        lista.sort(comparadorPorNombre);

        System.out.println("Agenda ordenada por nombre (Comparator):");
        for (Map.Entry<String, String> entry : lista) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}


import java.util.*;

public class AgendaHashMap {
    public static void main(String[] args) {
        Map<String, String> agenda = new HashMap<>();
        agenda.put("Carlos", "0991234567");
        agenda.put("Ana", "0987654321");
        agenda.put("Pedro", "0971122334");

        List<Map.Entry<String, String>> lista = new ArrayList<>(agenda.entrySet());

        // Comparator por valor (número)
        Comparator<Map.Entry<String, String>> comparadorPorNumero =
                new Comparator<Map.Entry<String, String>>() {
                    @Override
                    public int compare(Map.Entry<String, String> e1, Map.Entry<String, String> e2) {
                        return e1.getValue().compareTo(e2.getValue());
                    }
                };

        Collections.sort(lista, comparadorPorNumero);

        System.out.println("Agenda ordenada por número (Comparator):");
        for (Map.Entry<String, String> entry : lista) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
