package org.example;

import java.util.Random;
import java.util.Scanner;

class Cuadricula {
    protected final int TAMANO = 10;
    protected int[][] tablero = new int[TAMANO][TAMANO];
    protected Random rand = new Random();
    protected String condicionMarina = "calma";

    public Cuadricula() {
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                tablero[i][j] = 0; // Agua
            }
        }
    }

    public void colocarBarcosAleatoriamente() {
        for (int i = 0; i < 5; i++) { // Coloca 5 barcos con tamaños decrecientes
            colocarBarcoAleatoriamente(5 - i);
        }
    }

    private void colocarBarcoAleatoriamente(int longitud) {
        boolean colocado = false;
        while (!colocado) {
            int x = rand.nextInt(TAMANO);
            int y = rand.nextInt(TAMANO);
            boolean horizontal = rand.nextBoolean();
            colocado = puedeColocarBarco(x, y, longitud, horizontal);
            if (colocado) {
                for (int i = 0; i < longitud; i++) {
                    if (horizontal) tablero[x][y + i] = 1; // Barco
                    else tablero[x + i][y] = 1; // Barco
                }
            }
        }
    }

    private boolean puedeColocarBarco(int x, int y, int longitud, boolean horizontal) {
        for (int i = 0; i < longitud; i++) {
            if (horizontal) {
                if (y + i >= TAMANO || tablero[x][y + i] == 1) return false;
            } else {
                if (x + i >= TAMANO || tablero[x + i][y] == 1) return false;
            }
        }
        return true;
    }

    public boolean realizarAtaque(int x, int y) {
        if (x >= 0 && x < TAMANO && y >= 0 && y < TAMANO) {
            if (tablero[x][y] == 1) {
                tablero[x][y] = 2; // Hit
                return true;
            } else if (tablero[x][y] == 0) {
                tablero[x][y] = 3; // Miss
            }
        }
        return false;
    }

    public void imprimirTablero(boolean revelar) {
        System.out.println("\nTablero:");
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                if (tablero[i][j] == 0) System.out.print("~ "); // Agua
                else if (tablero[i][j] == 1) System.out.print(revelar ? "B " : "~ "); // Barco, oculto o revelado
                else if (tablero[i][j] == 2) System.out.print("X "); // Hit
                else System.out.print("o "); // Miss
            }
            System.out.println();
        }
    }

    public boolean verificarFinJuego() {
        for (int[] fila : tablero) {
            for (int celda : fila) {
                if (celda == 1) return false; // Aún quedan barcos
            }
        }
        return true; // Todos los barcos han sido hundidos
    }

    public void actualizarCondicionMarina() {
        int probabilidad = rand.nextInt(100);
        if (probabilidad < 50) {
            condicionMarina = "calma";
        } else if (probabilidad < 80) {
            condicionMarina = "lluvioso";
        } else {
            condicionMarina = "tormentoso";
        }
        System.out.println("La condición marina actual es: " + condicionMarina);
    }
}
