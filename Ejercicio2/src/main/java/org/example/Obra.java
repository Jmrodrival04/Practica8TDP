package org.example;

abstract class Obra {
    protected String titulo;
    protected String autor;
    protected double precio;

    public Obra(String titulo, String autor, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
    }

    public abstract void mostrarDetalles();
}