package ar.edu.unju.escmi.tp5.collections;

import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.Producto;

public class CollectionStock {

	public static List<Producto> collection =
			CollectionProducto.collection;

	public static void precargarStock() {

		collection =
				CollectionProducto.collection;
	}

	public static int verificarStock(
			int codigoProducto) {

		Producto producto =
				CollectionProducto
						.buscarProducto(codigoProducto);

		if (producto == null) {
			return -1;
		}

		return producto.getCantidadTotal();
	}

	public static boolean hayStock(
			int codigoProducto,
			int cantidad) {

		int stockActual =
				verificarStock(codigoProducto);

		return cantidad > 0
				&& stockActual >= cantidad;
	}

	public static boolean actualizarStock(
			int codigoProducto,
			int cantidadVendida) {

		Producto producto =
				CollectionProducto
						.buscarProducto(codigoProducto);

		if (producto == null) {
			return false;
		}

		if (!hayStock(
				codigoProducto,
				cantidadVendida)) {

			return false;
		}

		int nuevoStock =
				producto.getCantidadTotal()
				- cantidadVendida;

		producto.setCantidadTotal(
				nuevoStock);

		return true;
	}
}