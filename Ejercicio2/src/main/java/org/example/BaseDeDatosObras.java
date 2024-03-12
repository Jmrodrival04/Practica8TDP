package org.example;
import java.util.List;
import java.util.ArrayList;

class BaseDeDatosObras {
    public static List<Obra> obrasDisponibles = new ArrayList<>();

    static {
        obrasDisponibles.add(new Libro("1984", "George Orwell", 250, "Ciencia Ficción", 328));
        obrasDisponibles.add(new Libro("Cien años de soledad", "Gabriel García Márquez", 300, "Realismo mágico", 471));
        obrasDisponibles.add(new Video("Interstellar", "Christopher Nolan", 350, 169, "Blu-ray"));
        obrasDisponibles.add(new Video("La La Land", "Damien Chazelle", 300, 128, "DVD"));
    }
    public static void mostrarObrasDisponibles() {
        System.out.println("Obras disponibles:");
        for (Obra obra : obrasDisponibles) {
            obra.mostrarDetalles();
        }
    }
}
