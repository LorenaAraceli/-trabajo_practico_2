package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Efemeride> efemerides = new ArrayList<>();

        int opcion = 0;
        while (opcion != 5) {
            System.out.println("1 - Crear efeméride");
            System.out.println("2 - Mostrar efemérides");
            System.out.println("3 - Eliminar efeméride");
            System.out.println("4 - Modificar efeméride");
            System.out.println("5 - Salir");

            opcion = scanner.nextInt();

            switch (opcion) {
            case 1:
                System.out.println("Ingresa el código de la efeméride:");
                int codigo = scanner.nextInt();

                System.out.println("Ingresa el mes de la efeméride (1-12):");
                int numMes = scanner.nextInt();
                while (numMes < 1 || numMes > 12) {
                    System.out.println("Mes inválido. Ingresa un número entre 1 y 12:");
                    numMes = scanner.nextInt();
                }
                Mes mes = Mes.values()[numMes - 1];

                System.out.println("Ingresa el día de la efeméride:");
                int dia = scanner.nextInt();

                System.out.println("Ingresa el detalle de la efeméride:");
                scanner.nextLine(); 
                String detalle = scanner.nextLine();

                Efemeride nuevaEfemeride = new Efemeride(codigo, mes, dia, detalle);
                efemerides.add(nuevaEfemeride);
                System.out.println("Efeméride creada exitosamente.");
                break;
                
            case 2:
                if (efemerides.isEmpty()) {
                    System.out.println("No hay efemérides almacenadas.");
                } else {
                    System.out.println("Efemérides almacenadas:");
                    for (Efemeride efemeride : efemerides) {
                        System.out.println("Código: " + efemeride.getCodigo());
                        System.out.println("Mes: " + efemeride.getMes());
                        System.out.println("Día: " + efemeride.getDia());
                        System.out.println("Detalle: " + efemeride.getDetalle());
                        System.out.println("--------------------");
                    }
                }
                break;
            case 3:
                System.out.println("Ingresa el código de la efeméride que deseas eliminar:");
                int codigoEliminar = scanner.nextInt();

                boolean efemerideEncontrada = false;
                for (Efemeride efemeride : efemerides) {
                    if (efemeride.getCodigo() == codigoEliminar) {
                        efemerides.remove(efemeride);
                        efemerideEncontrada = true;
                        System.out.println("Efeméride eliminada exitosamente.");
                        break;
                    }
                }

                if (!efemerideEncontrada) {
                    System.out.println("No se encontró una efeméride con ese código.");
                }
                break;
            case 4:
                System.out.println("Ingresa el código de la efeméride que deseas buscar:");
                int codigoBuscar = scanner.nextInt();

                boolean efemerideEncontrada1 = false;
                for (Efemeride efemeride : efemerides) {
                    if (efemeride.getCodigo() == codigoBuscar) {
                        System.out.println("Efeméride encontrada:");
                        System.out.println("Código: " + efemeride.getCodigo());
                        System.out.println("Mes: " + efemeride.getMes());
                        System.out.println("Día: " + efemeride.getDia());
                        System.out.println("Detalle: " + efemeride.getDetalle());
                        efemerideEncontrada1 = true;
                        break;
                    }
                }

                if (!efemerideEncontrada1) {
                    System.out.println("No se encontró una efeméride con ese código.");
                }
                break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }
    }
}
