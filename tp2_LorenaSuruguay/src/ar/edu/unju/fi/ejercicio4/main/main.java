package ar.edu.unju.fi.ejercicio4.main;

import ar.edu.unju.fi.ejercicio4.model.Jugador;
import ar.edu.unju.ejercicio4.constantes.Posicion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

       try {
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 - Alta de jugador");
            System.out.println("2 - Mostrar todos los jugadores");
            System.out.println("3 - Modificar la posición de un jugador");
            System.out.println("4 - Eliminar un jugador");
            System.out.println("5 - Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
            case 1:
                System.out.println("Ingrese los datos del jugador:");
                System.out.print("Nombre: ");
                String nombre = scanner.next();
                System.out.print("Apellido: ");
                String apellido = scanner.next();
                System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
                String fechaNacimientoStr = scanner.next();
                LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
                System.out.print("Nacionalidad: ");
                String nacionalidad = scanner.next();
                System.out.print("Estatura: ");
                double estatura = scanner.nextDouble();
                System.out.print("Peso: ");
                double peso = scanner.nextDouble();
                
                System.out.println("Posiciones:");
                for (Posicion pos : Posicion.values()) {
                    System.out.println(pos.ordinal() + 1 + " - " + pos);
                }
                System.out.print("Seleccione la posición del jugador: ");
                int posicionIndex = scanner.nextInt();
                Posicion posicion = Posicion.values()[posicionIndex - 1];
                
                Jugador nuevoJugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
                jugadores.add(nuevoJugador);
                System.out.println("Jugador agregado correctamente.");
                break;
                   
            case 2:
                if (jugadores.isEmpty()) {
                    System.out.println("No hay jugadores registrados.");
                } else {
                    System.out.println("Lista de jugadores:");
                    for (Jugador jugador : jugadores) {
                        System.out.println("Nombre: " + jugador.getNombre() + " " + jugador.getApellido());
                        System.out.println("Edad: " + jugador.calcularEdad() + " años");
                        System.out.println("Nacionalidad: " + jugador.getNacionalidad());
                        System.out.println("Estatura: " + jugador.getEstatura() + " m");
                        System.out.println("Peso: " + jugador.getPeso() + " kg");
                        System.out.println("Posición: " + jugador.getPosicion());
                        System.out.println("---------------------");
                    }
                }
                break;
                
            case 3:
                if (jugadores.isEmpty()) {
                    System.out.println("No hay jugadores registrados.");
                } else {
                    System.out.println("Lista de jugadores:");
                    for (int i = 0; i < jugadores.size(); i++) {
                        System.out.println((i + 1) + ". " + jugadores.get(i).getNombre() + " " + jugadores.get(i).getApellido());
                    }
                    System.out.print("Seleccione el jugador que desea modificar (ingrese el número): ");
                    int jugadorIndex = scanner.nextInt();
                    
                    if (jugadorIndex < 1 || jugadorIndex > jugadores.size()) {
                        System.out.println("Número de jugador inválido.");
                    } else {
                        Jugador jugadorAModificar = jugadores.get(jugadorIndex - 1);
                        
                        System.out.println("Posiciones:");
                        for (Posicion pos : Posicion.values()) {
                            System.out.println(pos.ordinal() + 1 + " - " + pos);
                        }
                        System.out.print("Seleccione la nueva posición del jugador: ");
                        int nuevaPosicionIndex = scanner.nextInt();
                        Posicion nuevaPosicion = Posicion.values()[nuevaPosicionIndex - 1];
                        
                        jugadorAModificar.setPosicion(nuevaPosicion);
                        System.out.println("Posición modificada correctamente.");
                    }
                }
                break;
                
            case 4:
                if (jugadores.isEmpty()) {
                    System.out.println("No hay jugadores registrados.");
                } else {
                    System.out.println("Lista de jugadores:");
                    for (int i = 0; i < jugadores.size(); i++) {
                        System.out.println((i + 1) + ". " + jugadores.get(i).getNombre() + " " + jugadores.get(i).getApellido());
                    }
                    System.out.print("Seleccione el jugador que desea eliminar (ingrese el número): ");
                    int jugadorIndex = scanner.nextInt();
                    
                    if (jugadorIndex < 1 || jugadorIndex > jugadores.size()) {
                        System.out.println("Número de jugador inválido.");
                    } else {
                        Jugador jugadorAEliminar = jugadores.get(jugadorIndex - 1);
                        jugadores.remove(jugadorAEliminar);
                        System.out.println("Jugador eliminado correctamente.");
                    }
                }
                break;
                
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
            
        	 } while (opcion != 5);
        	 
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine(); 
        } finally {
            
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
