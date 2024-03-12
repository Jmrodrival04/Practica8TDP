package org.example;
import java.util.Random;
import java.util.Scanner;
public class BatallaNaval {
    private Cuadricula cuadriculaJugador;
    private Cuadricula cuadriculaIA;
    private Scanner scanner;
    private String nombreJugador;
    private boolean[][] ataquesRealizados;
public BatallaNaval() {
    cuadriculaJugador = new Cuadricula();
    cuadriculaIA = new Cuadricula();
    cuadriculaIA.colocarBarcosAleatoriamente();
    scanner = new Scanner(System.in);
    solicitarNombreUsuario();
}

private void solicitarNombreUsuario() {
    System.out.print("Introduce tu nombre de usuario: ");
    nombreJugador = scanner.nextLine();
    System.out.println("Bienvenido(a) a la Guerra de Barcos Avanzada, " + nombreJugador + ".");
}

private void turnoJugador() {
    System.out.println("Tu turno, " + nombreJugador + ". Introduce coordenadas para atacar (formato: x y):");
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    boolean resultado = cuadriculaIA.realizarAtaque(x, y);
    if (!resultado) {
        System.out.println("Ya has atacado estas coordenadas. Pierdes tu turno.");
    }
}

    private void turnoIA() {
        Random rand = new Random();
        int x, y;
        boolean resultado;
        do {
            x = rand.nextInt(10);
            y = rand.nextInt(10);

            resultado = cuadriculaJugador.ataquesRealizados[x][y];
        } while (resultado);


        resultado = cuadriculaJugador.realizarAtaque(x, y);
        System.out.println("La IA ataca en: (" + x + ", " + y + ")");
        if (resultado) {
            System.out.println("¡Un barco ha sido golpeado!");
        } else {
            System.out.println("La IA falló.");
        }
    }

public void ejecutar() {
    cuadriculaJugador.colocarBarcosAleatoriamente();
    while (true) {
        System.out.println("\nTablero del Jugador:");
        cuadriculaJugador.imprimirTablero(true);
        System.out.println("Tablero de la IA (visión del jugador):");
        cuadriculaIA.imprimirTablero(false);

        turnoJugador();

        if (!cuadriculaIA.quedanBarcos()) {
            System.out.println("¡Felicidades " + nombreJugador + ", has ganado!");
            break;
        }

        turnoIA();

        if (!cuadriculaJugador.quedanBarcos()) {
            System.out.println("La IA ha ganado. Mejor suerte la próxima vez, " + nombreJugador + ".");
            break;
        }
    }
}

public static void main(String[] args) {
    BatallaNaval juego = new BatallaNaval();
    juego.ejecutar();
}
}
