import java.util.Random;
import java.util.Scanner;

public class Matriz {

    private static final int FILAS = 10;
    private static final int COLUMNAS = 5;
    private static final int PUNTOS_A_DESHABILITAR = 5;

    private static boolean[][] matriz = new boolean[FILAS][COLUMNAS];
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarMatriz();
        deshabilitarPuntosAleatorios();
        mostrarMatriz();

        while (true) {
            System.out.print("Ingrese fila (1-" + FILAS + "): ");
            int fila = scanner.nextInt();
            System.out.print("Ingrese columna (1-" + COLUMNAS + "): ");
            int columna = scanner.nextInt();

            if (fila < 1 || fila > FILAS || columna < 1 || columna > COLUMNAS) {
                System.out.println("Posición fuera de la matriz");
                continue;
            }

            if (matriz[fila - 1][columna - 1]) {
                System.out.println("Punto ya deshabilitado");
                continue;
            }

            deshabilitarPunto(fila - 1, columna - 1);
        

            if (puntosDeshabilitados() == PUNTOS_A_DESHABILITAR) {
                break;
            }
        }

        System.out.println("¡Felicidades! Ha deshabilitado todos los puntos");
    }

    private static void inicializarMatriz() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                matriz[i][j] = true;
            }
        }
    }

    private static void deshabilitarPuntosAleatorios() {
        for (int i = 0; i < PUNTOS_A_DESHABILITAR; i++) {
            int fila = random.nextInt(FILAS);
            int columna = random.nextInt(COLUMNAS);

            while (!matriz[fila][columna]) {
                fila = random.nextInt(FILAS);
                columna = random.nextInt(COLUMNAS);
            }

            deshabilitarPunto(fila, columna);
        }
    }

    private static void deshabilitarPunto(int fila, int columna) {
        matriz[fila][columna] = false;
    }

    private static void mostrarMatriz() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(matriz[i][j] ? "X " : "O ");
            }
            System.out.println();
        }
    }

    private static int puntosDeshabilitados() {
        int count = 0;
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (!matriz[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}