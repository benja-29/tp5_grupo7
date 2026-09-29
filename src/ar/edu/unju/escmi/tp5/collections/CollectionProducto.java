package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp5.dominio.Producto;


public class CollectionProducto {

	public static List<Producto> productos = new ArrayList<>();

    public static void precargarProductos() {
        // Códigos, descripciones, precios unitarios y descuentos (0, 25 o 30)
        productos.add(new Producto(101, "Fideo Spaghetti 500g", 1200.0, 25.0));
        productos.add(new Producto(102, "Arroz Largo Fino 1kg", 1500.0, 0));
        productos.add(new Producto(103, "Leche Entera 1L", 1800.0, 30.0));
    }
	
	
}
