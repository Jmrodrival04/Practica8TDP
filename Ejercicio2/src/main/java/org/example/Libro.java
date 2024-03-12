package org.example;

class Libro extends Obra {
    private String genero;
    private int numPaginas;

    public Libro(String titulo, String autor, double precio, String genero, int numPaginas) {
        super(titulo, autor, precio);
        this.genero = genero;
        this.numPaginas = numPaginas;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Libro: " + titulo + ", Autor: " + autor + ", Precio: " + precio + ", Género: " + genero + ", Páginas: " + numPaginas);
    }
}