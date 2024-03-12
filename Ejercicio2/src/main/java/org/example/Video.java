package org.example;

class Video extends Obra {
    private int duracion; // En minutos
    private String formato;

    public Video(String titulo, String autor, double precio, int duracion, String formato) {
        super(titulo, autor, precio);
        this.duracion = duracion;
        this.formato = formato;
    }

    public String getFormato() {
        return formato;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Video: " + titulo + ", Autor: " + autor + ", Precio: " + precio + ", Duración: " + duracion + " minutos, Formato: " + formato);
    }
}