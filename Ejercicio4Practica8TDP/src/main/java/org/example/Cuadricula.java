package org.example;
import java.util.Random;
import java.util.Scanner;


class Cuadricula {
    private final int TAMANO = 10;
    private final char AGUA = '.';
    private final char FALLO = 'X';
    private final char GOLPE = 'H';
    private char[][] tablero;
    boolean[][] ataquesRealizados;

    public Cuadricula() {
        tablero = new char[TAMANO][TAMANO];
        ataquesRealizados = new boolean[TAMANO][TAMANO];
        inicializarTablero();
    }

    private void inicializarTablero() {
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                tablero[i][j] = AGUA;
                ataquesRealizados[i][j] = false;
            }
        }
    }

    public void colocarBarcosAleatoriamente() {
        colocarBarco(5);
        colocarBarco(4);
        colocarBarco(3);
    }

    private void colocarBarco(int longitud) {
        Random rand = new Random();
        boolean colocado = false;

        while (!colocado) {
            int x = rand.nextInt(TAMANO);
            int y = rand.nextInt(TAMANO);
            boolean horizontal = rand.nextBoolean();

            if (puedeColocarBarco(x, y, longitud, horizontal)) {
                for (int i = 0; i < longitud; i++) {
                    if (horizontal) {
                        tablero[x][y + i] = 'B'; // 'B' solo para uso interno, no se imprimirá.
                    } else {
                        tablero[x + i][y] = 'B'; // 'B' solo para uso interno, no se imprimirá.
                    }
                    colocado = true;
                }
            }
        }
    }

    private boolean puedeColocarBarco(int x, int y, int longitud, boolean horizontal) {
        if (horizontal) {
            if (y + longitud > TAMANO) return false;
            for (int i = 0; i < longitud; i++) {
                if (y + i >= TAMANO || tablero[x][y + i] != AGUA) return false;
            }
        } else {
            if (x + longitud > TAMANO) return false;
            for (int i = 0; i < longitud; i++) {
                if (x + i >= TAMANO || tablero[x + i][y] != AGUA) return false;
            }
        }
        return true;
    }

    public boolean realizarAtaque(int x, int y) {
        if (x < 0 || x >= TAMANO || y < 0 || y >= TAMANO || ataquesRealizados[x][y]) {
            System.out.println("Ataque inválido o repetido.");
            return false; // Coordenadas inválidas o ataque repetido.
        }
        ataquesRealizados[x][y] = true;

        if (tablero[x][y] == 'B') {
            tablero[x][y] = GOLPE;
            System.out.println("¡Golpe!");
            return true;
        } else if (tablero[x][y] == AGUA) {
            tablero[x][y] = FALLO;
            System.out.println("Fallo.");
            return false;
        }
        return false;
    }

    public void imprimirTablero(boolean mostrarBarcos) {
        System.out.print("  ");
        for (int i = 0; i < TAMANO; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < TAMANO; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < TAMANO; j++) {
                if (!mostrarBarcos && tablero[i][j] == 'B') {
                    System.out.print(AGUA + " ");
                } else {
                    System.out.print(tablero[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean quedanBarcos() {
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                if (tablero[i][j] == 'B') {
                    return true;
                }
            }
        }
        return false;
    }
}
