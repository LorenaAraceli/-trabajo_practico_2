package ar.edu.unju.fi.main;


import ar.edu.unju.fi.model.Producto;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 - Crear Producto");
            System.out.println("2 - Mostrar productos");
            System.out.println("3 - Modificar producto");
            System.out.println("4 - Salir");
            System.out.println("Elija una opción:");

            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
               
                case 1:
                    System.out.println("Creando nuevo producto...");
                    System.out.println("Ingrese el código del producto:");
                    String codigo = scanner.nextLine();

                    System.out.println("Ingrese la descripción del producto:");
                    String descripcion = scanner.nextLine();

                    double precioUnitario = 0;
                    boolean precioValido = false;
                    do {
                        try {
                            System.out.println("Ingrese el precio unitario del producto:");
                            precioUnitario = scanner.nextDouble();
                            scanner.nextLine(); 
                            precioValido = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor ingrese un valor numérico para el precio.");
                            scanner.nextLine(); 
                        }
                    } while (!precioValido);

                    System.out.println("------ Origen de fabricación ------");
                    System.out.println("1 - Argentina");
                    System.out.println("2 - China");
                    System.out.println("3 - Brasil");
                    System.out.println("4 - Uruguay");
                    System.out.println("Elija una opción:");
                    int opcionOrigen = scanner.nextInt();
                    scanner.nextLine(); 
                    Producto.OrigenFabricacion origen = null;
                    switch (opcionOrigen) {
                        case 1:
                            origen = Producto.OrigenFabricacion.ARGENTINA;
                            break;
                        case 2:
                            origen = Producto.OrigenFabricacion.CHINA;
                            break;
                        case 3:
                            origen = Producto.OrigenFabricacion.BRASIL;
                            break;
                        case 4:
                            origen = Producto.OrigenFabricacion.URUGUAY;
                            break;
                        default:
                            System.out.println("Opción no válida. Se asignará origen Argentina por defecto.");
                            origen = Producto.OrigenFabricacion.ARGENTINA;
                    }

                    System.out.println("------ Categoría ------");
                    System.out.println("1 - Telefonía");
                    System.out.println("2 - Informática");
                    System.out.println("3 - Electro hogar");
                    System.out.println("4 - Herramientas");
                    System.out.println("Elija una opción:");
                    int opcionCategoria = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    Producto.Categoria categoria = null;
                    switch (opcionCategoria) {
                        case 1:
                            categoria = Producto.Categoria.TELEFONIA;
                            break;
                        case 2:
                            categoria = Producto.Categoria.INFORMATICA;
                            break;
                        case 3:
                            categoria = Producto.Categoria.ELECTROHOGAR;
                            break;
                        case 4:
                            categoria = Producto.Categoria.HERRAMIENTAS;
                            break;
                        default:
                            System.out.println("Opción no válida. Se asignará categoría Telefonía por defecto.");
                            categoria = Producto.Categoria.TELEFONIA;
                    }

                    Producto nuevoProducto = new Producto(codigo, descripcion, precioUnitario, origen, categoria);
                    productos.add(nuevoProducto);
                    System.out.println("Producto creado exitosamente.");
                    break;
                case 2:
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos para mostrar.");
                    } else {
                        System.out.println("Lista de productos:");
                        for (Producto producto : productos) {
                            System.out.println(producto);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el código del producto a buscar:");
                    String codigoBusqueda = scanner.nextLine();
                    boolean productoEncontrado = false;

                    for (Producto producto : productos) {
                        if (producto.getCodigo().equals(codigoBusqueda)) {
                            System.out.println("Producto encontrado:");
                            System.out.println(producto);
                            productoEncontrado = true;
                            break;
                        }
                    }

                    if (!productoEncontrado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 4);
    }
}