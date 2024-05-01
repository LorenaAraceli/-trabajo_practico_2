package ar.edu.unju.fi.ejercicio5.model;

import java.util.ArrayList;

import ar.edu.unju.fi.model.Producto.Categoria;
import ar.edu.unju.fi.model.Producto.OrigenFabricacion;

public class Producto {
    private String codigo;
    private String descripcion;
    private double precioUnitario;
    private OrigenFabricacion origenFabricacion;
    private Categoria categoria;
    private boolean estado;
	private int stock;

    public Producto(String codigo, String descripcion, double precioUnitario, OrigenFabricacion origenFabricacion, Categoria categoria) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.origenFabricacion = origenFabricacion;
        this.categoria = categoria;
    }

   
    public enum OrigenFabricacion {
        NACIONAL,
        IMPORTADO,
        ARGENTINA,
        CHINA, 
        ESPAÑA, 
        ITALIA, 
        FRANCIA, 
        ALEMANIA, 
        JAPON
    }

    
    public enum Categoria {
        ELECTRONICA,
        ROPA,
        ALIMENTOS,
        HOGAR, 
        TELEFONIA, 
        INFORMATICA, 
        CALZADO, 
        JOYERIA, 
        ELECTRODOMESTICOS, 
        DEPORTE, 
        TECNOLOGIA, 
        MODA, 
        COCINA, 
        BELLEZA, 
        LIBROS, 
        JUGUETES, 
        ACCESORIOS
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public OrigenFabricacion getOrigenFabricacion() {
        return origenFabricacion;
    }

    public void setOrigenFabricacion(OrigenFabricacion origenFabricacion) {
        this.origenFabricacion = origenFabricacion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", origenFabricacion=" + origenFabricacion +
                ", categoria=" + categoria +
                ", estado=" + estado +
                '}';
    }


	public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();

        
        Producto producto1 = new Producto("COD1", "Producto 1", 10.0, OrigenFabricacion.ARGENTINA, Categoria.TELEFONIA);
        producto1.setEstado(true);
        productos.add(producto1);

        Producto producto2 = new Producto("COD2", "Producto 2", 20.0, OrigenFabricacion.CHINA, Categoria.INFORMATICA);
        producto2.setEstado(true);
        productos.add(producto2);
        
        Producto producto3 = new Producto("COD3", "Producto 3", 15.0, OrigenFabricacion.ESPAÑA, Categoria.ROPA);
        producto3.setEstado(true);
        productos.add(producto3);

        Producto producto4 = new Producto("COD4", "Producto 4", 25.0, OrigenFabricacion.ITALIA, Categoria.CALZADO);
        producto4.setEstado(true);
        productos.add(producto4);

        Producto producto5 = new Producto("COD5", "Producto 5", 30.0, OrigenFabricacion.FRANCIA, Categoria.JOYERIA);
        producto5.setEstado(true);
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
        producto12.setEstado(true);
        productos.add(producto12);

        Producto producto13 = new Producto("COD13", "Producto 13", 25.0, OrigenFabricacion.ALEMANIA, Categoria.LIBROS);
        producto13.setEstado(true);
        productos.add(producto13);
        
        Producto producto14 = new Producto("COD14", "Producto 14", 60.0, OrigenFabricacion.CHINA, Categoria.JUGUETES);
        producto14.setEstado(true);
        productos.add(producto14);

        Producto producto15 = new Producto("COD15", "Producto 15", 70.0, OrigenFabricacion.JAPON, Categoria.ACCESORIOS);
        producto15.setEstado(true);
        productos.add(producto15);

        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

	public int getStock() {
	    return this.getStock();
	}

	public void setStock(int stock) {
	    this.stock = stock;
	}

}
