package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.Producto;

public class CollectionProducto {

	public static List<Producto> collection =
			new ArrayList<>();

	public static void precargarProductos() {

		if (!collection.isEmpty()) {
			return;
		}

		collection.add(
				new Producto(
						101,
						"Fideo Spaghetti 500g",
						1200.0,
						25.0,
						5000));

		collection.add(
				new Producto(
						102,
						"Arroz Largo Fino 1kg",
						1500.0,
						0.0,
						3000));

		collection.add(
				new Producto(
						103,
						"Leche Entera 1L",
						1800.0,
						30.0,
						2000));
	}

	public static boolean altaProducto(
			Producto producto) {

		if (producto == null) {
			return false;
		}

		if (buscarProducto(producto.getCodigo()) != null) {
			return false;
		}

		collection.add(producto);

		return true;
	}

	public static Producto buscarProducto(
			int codigo) {

		for (Producto producto : collection) {

			if (producto.getCodigo() == codigo) {

				return producto;
			}
		}

		return null;
	}
}