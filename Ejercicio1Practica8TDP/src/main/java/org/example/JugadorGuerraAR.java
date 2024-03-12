package org.example;
import java.util.Random;
import java.util.Scanner;
class JugadorGuerraAR {
    private int fichas = 10;
    private String nombre;
    private static Random random = new Random();


    public JugadorGuerraAR(String nombre) {
        this.nombre = nombre;
    }


    public int lanzarDado() {
        return random.nextInt(6) + 1;
    }


    public void actualizarFichas(boolean esGanador) {
        if (esGanador) {
            fichas++;
            System.out.println(nombre + " gana 1 ficha.");
        } else {
            fichas--;
            System.out.println(nombre + " pierde 1 ficha.");
        }
    }


    public int getFichas() {
        return fichas;
    }

    public String getNombre() {
        return nombre;
    }
}