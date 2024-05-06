package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFabricacion;

public class main {

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();

        Producto producto1 = new Producto("COD1", "Producto 1", 10.0, OrigenFabricacion.ARGENTINA, Categoria.TELEFONIA);
        producto1.setEstado(true);
        productos.add(producto1);

        Producto producto2 = new Producto("COD2", "Producto 2", 20.0, OrigenFabricacion.CHINA, Categoria.INFORMATICA);
        producto2.setEstado(false);
        productos.add(producto2);
        
        Producto producto3 = new Producto("COD3", "Producto 3", 15.0, OrigenFabricacion.ESPAÑA, Categoria.ROPA);
        producto3.setEstado(true);
        productos.add(producto3);

        Producto producto4 = new Producto("COD4", "Producto 4", 25.0, OrigenFabricacion.ITALIA, Categoria.CALZADO);
        producto4.setEstado(false);
        productos.add(producto4);

        Producto producto5 = new Producto("COD5", "Producto 5", 30.0, OrigenFabricacion.FRANCIA, Categoria.JOYERIA);
        producto5.setEstado(false);
        productos.add(producto5);

        Producto producto6 = new Producto("COD6", "Producto 6", 40.0, OrigenFabricacion.ALEMANIA, Categoria.ELECTRODOMESTICOS);
        producto6.setEstado(true);
        productos.add(producto6);

        Producto producto7 = new Producto("COD7", "Producto 7", 50.0, OrigenFabricacion.JAPON, Categoria.TECNOLOGIA);
        producto7.setEstado(true);
        productos.add(producto7);

        Producto producto8 = new Producto("COD8", "Producto 8", 20.0, OrigenFabricacion.CHINA, Categoria.HOGAR);
        producto8.setEstado(true);
        productos.add(producto8);

        Producto producto9 = new Producto("COD9", "Producto 9", 10.0, OrigenFabricacion.ARGENTINA, Categoria.DEPORTE);
        producto9.setEstado(true);
        productos.add(producto9);

        Producto producto10 = new Producto("COD10", "Producto 10", 35.0, OrigenFabricacion.ITALIA, Categoria.MODA);
        producto10.setEstado(true);
        productos.add(producto10);

        Producto producto11 = new Producto("COD11", "Producto 11", 45.0, OrigenFabricacion.ESPAÑA, Categoria.COCINA);
        producto11.setEstado(true);
        productos.add(producto11);

        Producto producto12 = new Producto("COD12", "Producto 12", 55.0, OrigenFabricacion.FRANCIA, Categoria.BELLEZA);
        producto12.setEstado(false);
        productos.add(producto12);

        Producto producto13 = new Producto("COD13", "Producto 13", 25.0, OrigenFabricacion.ALEMANIA, Categoria.LIBROS);
        producto13.setEstado(true);
        productos.add(producto13);
        
        Producto producto14 = new Producto("COD14", "Producto 14", 60.0, OrigenFabricacion.CHINA, Categoria.JUGUETES);
        producto14.setEstado(true);
        productos.add(producto14);

        Producto producto15 = new Producto("COD15", "Producto 15", 70.0, OrigenFabricacion.JAPON, Categoria.ACCESORIOS);
        producto15.setEstado(false);
        productos.add(producto15);

        boolean salir = false;
        Scanner scanner = new Scanner(System.in);
        while (!salir) {
            System.out.println("Menú de opciones:");
            System.out.println("1 - Mostrar productos (solo se muestran los productos con estado true)");
            System.out.println("2 - Mostrar los productos faltantes (muestra productos con estado false)");
            System.out.println("3 - Incrementar los precios de los productos en un 20%");
            System.out.println("4 - Mostrar los productos que corresponden a la categoría Electrohogar y estén disponibles para la venta");
            System.out.println("5 - Ordenar los productos por precio de forma descendente");
            System.out.println("6 - Mostrar los productos con los nombres en mayúsculas");
            System.out.println("7 - Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Consumer<Producto> consumer = p -> {
                        if (p.isEstado()) {
                            System.out.println(p);
                        }
                    };
                    productos.forEach(consumer);
                    break;
                case 2:
                    Predicate<Producto> predicate = p -> !p.isEstado();
                    List<Producto> productosFaltantes = productos.stream().filter(predicate).collect(Collectors.toList());
                    for (Producto p : productosFaltantes) {
                        System.out.println(p);
                    }
                    break;
                case 3:
                    Function<Producto, Producto> incrementarPrecio = p -> {
                        p.setPrecioUnitario(p.getPrecioUnitario() * 1.20);
                        return p;
                    };
                    ArrayList<Producto> productosIncrementados = productos.stream().map(incrementarPrecio).collect(Collectors.toCollection(ArrayList::new));
                    for (Producto p : productosIncrementados) {
                        System.out.println(p);
                    }
                    break;
                case 4:
                    Predicate<Producto> electroHogarPredicate = p -> p.getCategoria() == Producto.Categoria.ELECTRODOMESTICOS && p.isEstado();
                    List<Producto> electroHogarProductos = productos.stream().filter(electroHogarPredicate).collect(Collectors.toList());
                    for (Producto p : electroHogarProductos) {
                        System.out.println(p);
                    }
                    break;
                case 5:
                    Comparator<Producto> precioComparator = Comparator.comparing(Producto::getPrecioUnitario).reversed();
                    Collections.sort(productos, precioComparator);
                    for (Producto p : productos) {
                        System.out.println(p);
                    }
                    break;
                case 6:
                    Function<Producto, Producto> nombresMayusculas = p -> {
                        p.setDescripcion(p.getDescripcion().toUpperCase());
                        return p;
                    };
                    ArrayList<Producto> productosMayusculas = productos.stream().map(nombresMayusculas).collect(Collectors.toCollection(ArrayList::new));
                    for (Producto p : productosMayusculas) {
                        System.out.println(p);
                    }
                    break;
                case 7:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        }
    }
}