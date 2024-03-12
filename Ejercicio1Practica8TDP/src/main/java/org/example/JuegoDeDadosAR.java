package org.example;
import java.util.Random;
import java.util.Scanner;

public class JuegoDeDadosAR {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre del Jugador 1: ");
        String nombreJugador1 = scanner.nextLine();
        JugadorGuerraAR jugador1 = new JugadorGuerraAR(nombreJugador1);

        System.out.print("Introduce el nombre del Jugador 2: ");
        String nombreJugador2 = scanner.nextLine();
        JugadorGuerraAR jugador2 = new JugadorGuerraAR(nombreJugador2);


        boolean seguirJugando = true;

        while (seguirJugando && jugador1.getFichas() > 0 && jugador2.getFichas() > 0) {
            int dadoJugador1 = jugador1.lanzarDado();
            int dadoJugador2 = jugador2.lanzarDado();

            // Lógica del juego...
            System.out.println(jugador1.getNombre() + " lanza un dado y obtiene: " + dadoJugador1);
            System.out.println(jugador2.getNombre() + " lanza un dado y obtiene: " + dadoJugador2);

            if (dadoJugador1 > dadoJugador2) {
                jugador1.actualizarFichas(true);
                jugador2.actualizarFichas(false);
            } else if (dadoJugador2 > dadoJugador1) {
                jugador2.actualizarFichas(true);
                jugador1.actualizarFichas(false);
            } else {
                System.out.println("Empate. Nadie gana o pierde fichas.");
            }

            System.out.println("¿Jugar otra ronda? (true para sí, false para no)");
            seguirJugando = scanner.nextBoolean();
        }


        scanner.close();
    }
}