package ar.edu.unju.fi.ejercicio5.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.Producto;

public class main {
    private static List<Producto> productos;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        productos = new ArrayList<>();

        int opcion = 0;
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 - Mostrar productos");
            System.out.println("2 - Realizar compra");
            System.out.println("3 - Salir");
            System.out.println("Seleccione una opción:");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                
                    case 1:
                        if (productos.isEmpty()) {
                            System.out.println("No hay productos disponibles.");
                        } else {
                            System.out.println("Listado de productos:");
                            for (Producto producto : productos) {
                                System.out.println("Código: " + producto.getCodigo());
                                System.out.println("Descripción: " + producto.getDescripcion());
                                System.out.println("Precio: " + producto.getPrecioUnitario());
                                System.out.println("Origen de fabricación: " + producto.getOrigenFabricacion());
                                System.out.println("Categoría: " + producto.getCategoria());
                                System.out.println("Stock disponible: " + producto.getStock());
                                System.out.println("--------------------");
                            }
                        }
                        break;
                    case 2:
                        if (productos.isEmpty()) {
                            System.out.println("No hay productos disponibles para comprar.");
                        } else {
                            System.out.println("Seleccione el producto que desea comprar:");
                            for (int i = 0; i < productos.size(); i++) {
                                System.out.println((i + 1) + ". " + productos.get(i).getCodigo() + " - Precio: " + productos.get(i).getPrecioUnitario());
                            }

                            System.out.println("Ingrese el número de producto que desea comprar:");
                            int numProducto = Integer.parseInt(scanner.nextLine());

                            if (numProducto < 1 || numProducto > productos.size()) {
                                System.out.println("Número de producto inválido.");
                            } else {
                                Producto productoSeleccionado = productos.get(numProducto - 1);

                                System.out.println("Ingrese la cantidad que desea comprar:");
                                int cantidad = Integer.parseInt(scanner.nextLine());

                                if (cantidad > productoSeleccionado.getStock()) {
                                    System.out.println("Cantidad solicitada supera el stock disponible.");
                                } else {
                                    double totalCompra = cantidad * productoSeleccionado.getPrecioUnitario();
                                    productoSeleccionado.setStock(productoSeleccionado.getStock() - cantidad);
                                    System.out.println("Compra realizada con éxito. Total a pagar: " + totalCompra);
                                }
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida, por favor seleccione una opción válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }

        } while (opcion != 3);

        scanner.close();
    }

    public static void mostrarProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            System.out.println("Listado de productos:");
            for (Producto producto : productos) {
                System.out.println("ID: " + producto.getCodigo());
                System.out.println("Descripcion: " + producto.getDescripcion());
                System.out.println("Precio: " + producto.getPrecioUnitario());
                System.out.println("Fabricacion: " + producto.getOrigenFabricacion());
                System.out.println("Categoria: " + producto.getCategoria());
                System.out.println("--------------------");
            }
        }
    }

    public static void realizarCompra(List<Producto> productos, Scanner scanner) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles para comprar.");
        } else {
            System.out.println("Seleccione el producto que desea comprar:");
            for (int i = 0; i < productos.size(); i++) {
                System.out.println((i + 1) + ". " + productos.get(i).getCodigo() + " - Precio: " + productos.get(i).getPrecioUnitario());
            }

            System.out.println("Ingrese el número de producto que desea comprar:");
            int numProducto = Integer.parseInt(scanner.nextLine());

            if (numProducto < 1 || numProducto > productos.size()) {
                System.out.println("Número de producto inválido.");
            } else {
                Producto productoSeleccionado = productos.get(numProducto - 1);

                System.out.println("Ingrese la cantidad que desea comprar:");
                int cantidad = Integer.parseInt(scanner.nextLine());

                if (cantidad > productoSeleccionado.getStock()) {
                    System.out.println("Cantidad solicitada supera el stock disponible.");
                } else {
                    double totalCompra = cantidad * productoSeleccionado.getPrecioUnitario();
                    productoSeleccionado.setStock(productoSeleccionado.getStock() - cantidad);
                    System.out.println("Compra realizada con éxito. Total a pagar: " + totalCompra);
                }
            }
        }
    }
}