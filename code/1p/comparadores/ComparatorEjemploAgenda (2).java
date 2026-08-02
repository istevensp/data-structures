//////////////////////////////////////////////////////////////
//Clase Contacto 
//////////////////////////////////////////////////////////////
import java.time.LocalDate;
import java.util.List;

class Contacto {
    String nombreCompleto; // Nombre completo del contacto
    List<String> telefonos; // Lista de números telefónicos
    List<String> emails; // Lista de direcciones de correo electrónico
    LocalDate fechaNacimiento; // Fecha de nacimiento
    String empresa; // Nombre de la empresa o "Persona Natural"
    String direccion; // Dirección principal
    String paisResidencia; // País de residencia
    List<String> atributosAdicionales; // Otros atributos, como redes sociales, fotos, etc.

    public Contacto(String nombreCompleto, List<String> telefonos, List<String> emails, LocalDate fechaNacimiento,
                    String empresa, String direccion, String paisResidencia, List<String> atributosAdicionales) {
        this.nombreCompleto = nombreCompleto;
        this.telefonos = telefonos;
        this.emails = emails;
        this.fechaNacimiento = fechaNacimiento;
        this.empresa = empresa;
        this.direccion = direccion;
        this.paisResidencia = paisResidencia;
        this.atributosAdicionales = atributosAdicionales;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", telefonos=" + telefonos +
                ", emails=" + emails +
                ", fechaNacimiento=" + fechaNacimiento +
                ", empresa='" + empresa + '\'' +
                ", direccion='" + direccion + '\'' +
                ", paisResidencia='" + paisResidencia + '\'' +
                ", atributosAdicionales=" + atributosAdicionales +
                '}';
    }
}

//////////////////////////////////////////////////////////////
//Comparators Personalizados
//////////////////////////////////////////////////////////////

///////////////////			Ordenar por Nombre Completo:


import java.util.Comparator;

class ComparadorPorNombreCompleto implements Comparator<Contacto> {
    @Override
    public int compare(Contacto c1, Contacto c2) {
        return c1.nombreCompleto.compareToIgnoreCase(c2.nombreCompleto);
    }
}


///////////////////			Ordenar por Cantidad de Teléfonos:

class ComparadorPorCantidadDeTelefonos implements Comparator<Contacto> {
    @Override
    public int compare(Contacto c1, Contacto c2) {
        return Integer.compare(c2.telefonos.size(), c1.telefonos.size()); // Más teléfonos primero
    }
}

///////////////////			Ordenar por Cantidad de Atributos Adicionales:

class ComparadorPorAtributosAdicionales implements Comparator<Contacto> {
    @Override
    public int compare(Contacto c1, Contacto c2) {
        return Integer.compare(c2.atributosAdicionales.size(), c1.atributosAdicionales.size());
    }
}

///////////////////			Ordenar por Fecha de Cumpleaños más Cercana:

import java.time.LocalDate;
import java.time.MonthDay;

class ComparadorPorCumpleanos implements Comparator<Contacto> {
    @Override
    public int compare(Contacto c1, Contacto c2) {
        MonthDay hoy = MonthDay.now(); // Fecha actual
        MonthDay cumple1 = MonthDay.from(c1.fechaNacimiento);
        MonthDay cumple2 = MonthDay.from(c2.fechaNacimiento);

        // Calcular días restantes para cada cumpleaños
        int diasRestantes1 = (cumple1.isBefore(hoy) ? cumple1.plusYears(1) : cumple1).compareTo(hoy);
        int diasRestantes2 = (cumple2.isBefore(hoy) ? cumple2.plusYears(1) : cumple2).compareTo(hoy);

        return Integer.compare(diasRestantes1, diasRestantes2);
    }
}

///////////////////			Ordenar por País de Residencia:

class ComparadorPorPaisResidencia implements Comparator<Contacto> {
    @Override
    public int compare(Contacto c1, Contacto c2) {
        return c1.paisResidencia.compareToIgnoreCase(c2.paisResidencia);
    }
}

///////////////////			Ordenar por Tipo de Contacto (Empresa o Persona Natural):

class ComparadorPorTipoDeContacto implements Comparator<Contacto> {
    @Override
    public int compare(Contacto c1, Contacto c2) {
        return c1.empresa.compareToIgnoreCase(c2.empresa); // Primero las empresas
    }
}




///////////////////			USO			///////////////////

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Contacto> contactos = new ArrayList<>();

        contactos.add(new Contacto("Alice Johnson", Arrays.asList("123456789"), Arrays.asList("alice@example.com"),
                LocalDate.of(1995, 5, 20), "Persona Natural", "123 Main St", "Ecuador", Arrays.asList("Foto1", "Foto2")));
        contactos.add(new Contacto("Bob Smith", Arrays.asList("987654321", "112233445"), Arrays.asList("bob@work.com"),
                LocalDate.of(1988, 11, 15), "Empresa", "456 Business Rd", "Perú", Arrays.asList("Foto1")));
        contactos.add(new Contacto("Charlie Brown", Arrays.asList("456789123"), Arrays.asList("charlie@example.com"),
                LocalDate.of(2000, 3, 10), "Persona Natural", "789 Park Ave", "Ecuador", Arrays.asList("Foto1", "Foto2", "Foto3")));

        // Ordenar por nombre completo
        Collections.sort(contactos, new ComparadorPorNombreCompleto());
        System.out.println("Contactos ordenados por nombre completo:");
        imprimirLista(contactos);

        // Ordenar por cantidad de teléfonos
        Collections.sort(contactos, new ComparadorPorCantidadDeTelefonos());
        System.out.println("\nContactos ordenados por cantidad de teléfonos:");
        imprimirLista(contactos);

        // Ordenar por cantidad de atributos adicionales
        Collections.sort(contactos, new ComparadorPorAtributosAdicionales());
        System.out.println("\nContactos ordenados por cantidad de atributos adicionales:");
        imprimirLista(contactos);

        // Ordenar por cumpleaños más cercano
        Collections.sort(contactos, new ComparadorPorCumpleanos());
        System.out.println("\nContactos ordenados por cumpleaños más cercano:");
        imprimirLista(contactos);

        // Ordenar por país de residencia
        Collections.sort(contactos, new ComparadorPorPaisResidencia());
        System.out.println("\nContactos ordenados por país de residencia:");
        imprimirLista(contactos);

        // Ordenar por tipo de contacto
        Collections.sort(contactos, new ComparadorPorTipoDeContacto());
        System.out.println("\nContactos ordenados por tipo de contacto:");
        imprimirLista(contactos);
    }

    private static void imprimirLista(List<Contacto> contactos) {
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }
}
