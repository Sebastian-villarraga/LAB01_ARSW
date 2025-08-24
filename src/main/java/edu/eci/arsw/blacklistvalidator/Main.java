package edu.eci.arsw.blacklistvalidator;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HostBlackListsValidator hblv = new HostBlackListsValidator();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Evaluación de Desempeño ===");
            System.out.println("1. Ejecutar con 1 hilo");
            System.out.println("2. Ejecutar con 8 hilos (núcleos físicos)");
            System.out.println("3. Ejecutar con 16 hilos (doble de núcleos)");
            System.out.println("4. Ejecutar con 50 hilos");
            System.out.println("5. Ejecutar con 100 hilos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            int numHilos = 0;

            switch (opcion) {
                case 1: numHilos = 1; break;
                case 2: numHilos = 8; break;
                case 3: numHilos = 16; break;
                case 4: numHilos = 50; break;
                case 5: numHilos = 100; break;
                case 6:
                    continuar = false;
                    System.out.println("Saliendo...");
                    continue;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    continue;
            }

            System.out.println("\n>>> Ejecutando prueba con " + numHilos + " hilos...");
            long inicio = System.currentTimeMillis();

            // Aquí se hace la búsqueda real
            List<Integer> blackListOcurrences = hblv.checkHost("202.24.34.55", numHilos);

            long fin = System.currentTimeMillis();

            System.out.println("El host fue encontrado en las listas negras: " + blackListOcurrences);
            System.out.println("Tiempo total con " + numHilos + " hilos: " + (fin - inicio) + " ms");
        }

        scanner.close();
    }
}
