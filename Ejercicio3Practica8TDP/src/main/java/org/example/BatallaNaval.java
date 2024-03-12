package org.example;
import java.util.Random;
import java.util.Scanner;

public class BatallaNaval {
    public static void main(String[] args) {
        CuadriculaIA cuadriculaIA = new CuadriculaIA();
        Cuadricula cuadriculaJugador = new Cuadricula();
        Scanner scanner = new Scanner(System.in);

        cuadriculaIA.colocarBarcosAleatoriamente();
        cuadriculaJugador.colocarBarcosAleatoriamente();

        boolean turnoJugador = true;
        while (!cuadriculaIA.verificarFinJuego() && !cuadriculaJugador.verificarFinJuego()) {
            cuadriculaIA.actualizarCondicionMarina();
            cuadriculaJugador.imprimirTablero(true);
            cuadriculaIA.imprimirTablero(false);

            if (turnoJugador) {
                System.out.println("Tu turno de atacar. Ingresa coordenadas (x y):");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                boolean hit = cuadriculaIA.realizarAtaque(x, y);
                System.out.println(hit ? "¡Impacto!" : "Fallaste.");
            } else {
                System.out.println("Turno de la IA...");
                cuadriculaIA.realizarAtaqueIA(cuadriculaJugador);
            }

            turnoJugador = !turnoJugador;
        }

        if (cuadriculaIA.verificarFinJuego()) System.out.println("¡Felicidades, has ganado!");
        else System.out.println("La IA ha ganado. ¡Mejor suerte la próxima vez!");
    }
}