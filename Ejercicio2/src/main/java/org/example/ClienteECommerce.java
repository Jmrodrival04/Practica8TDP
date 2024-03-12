package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class ClienteECommerce {
    String nombre;
    private int numeroCliente;
    private List<Obra> historialCompras;
    private List<Obra> recomendaciones;

    public ClienteECommerce(String nombre, int numeroCliente) {
        this.nombre = nombre;
        this.numeroCliente = numeroCliente;
        this.historialCompras = new ArrayList<>();
        this.recomendaciones = new ArrayList<>();
    }

    public void agregarCompra(Obra obra) {
        historialCompras.add(obra);
        analizarPreferencias();
    }

    public void analizarPreferencias() {
        Map<String, Integer> frecuenciaGeneros = new HashMap<>();
        for (Obra obra : historialCompras) {
            if (obra instanceof Libro) {
                String genero = ((Libro) obra).getGenero();
                frecuenciaGeneros.put(genero, frecuenciaGeneros.getOrDefault(genero, 0) + 1);
            } else if (obra instanceof Video) {
                String formato = ((Video) obra).getFormato();
                frecuenciaGeneros.put(formato, frecuenciaGeneros.getOrDefault(formato, 0) + 1);
            }
        }
        if (!frecuenciaGeneros.isEmpty()) {

            String preferenciaPrincipal = Collections.max(frecuenciaGeneros.entrySet(), Map.Entry.comparingByValue()).getKey();
            generarRecomendaciones(preferenciaPrincipal);
        }
    }

    private void generarRecomendaciones(String preferencia) {
        recomendaciones.clear();
        for (Obra obra : BaseDeDatosObras.obrasDisponibles) {

            if (!historialCompras.contains(obra) &&
                    ((obra instanceof Libro && ((Libro) obra).getGenero().equals(preferencia)) ||
                            (obra instanceof Video && ((Video) obra).getFormato().equals(preferencia)))) {
                recomendaciones.add(obra);
            }
        }
    }
    public void mostrarRecomendaciones() {
        if (recomendaciones.isEmpty()) {
            System.out.println("No hay recomendaciones disponibles en este momento.");
        } else {
            System.out.println("Recomendaciones basadas en tus preferencias:");
            for (Obra obra : recomendaciones) {
                obra.mostrarDetalles();
            }
        }
    }
}