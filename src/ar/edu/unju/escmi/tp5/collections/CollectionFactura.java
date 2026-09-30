package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.DetalleFactura;
import ar.edu.unju.escmi.tp5.dominio.Factura;

public class CollectionFactura {

	public static List<Factura> collection =
			new ArrayList<>();

	public static void guardarFactura(
			Factura factura) {

		if (factura != null) {

			collection.add(factura);
		}
	}

	public static void mostrarVentas() {

		if (collection.isEmpty()) {

			System.out.println(
					"No hay ventas registradas.");

			return;
		}

		System.out.println();
		System.out.println(
				"===== TODAS LAS VENTAS =====");

		for (Factura factura : collection) {

			mostrarFactura(factura);

			System.out.println(
					"------------------------------");
		}
	}

	public static double calcularTotalVentas() {

		double total = 0;

		for (Factura factura : collection) {

			total += factura.getTotal();
		}

		return total;
	}

	public static Factura buscarFacturaPorNumero(
			int numeroFactura) {

		for (Factura factura : collection) {

			if (factura.getNumeroFactura()
					== numeroFactura) {

				return factura;
			}
		}

		return null;
	}

	public static int siguienteNumeroFactura() {

		int mayorNumero = 0;

		for (Factura factura : collection) {

			if (factura.getNumeroFactura()
					> mayorNumero) {

				mayorNumero =
						factura.getNumeroFactura();
			}
		}

		return mayorNumero + 1;
	}

	public static void mostrarFactura(
			Factura factura) {

		if (factura == null) {
			return;
		}

		System.out.println();
		System.out.println(
				"===== FACTURA =====");

		System.out.println(
				"Numero: "
				+ factura.getNumeroFactura());

		System.out.println(
				"Fecha: "
				+ factura.getFecha());

		System.out.println(
				"Cliente: "
				+ factura.getCliente());

		System.out.println();
		System.out.println(
				"--- DETALLE ---");

		for (DetalleFactura detalle
				: factura.getDetalleFactura()) {

			System.out.println(
					"Producto: "
					+ detalle.getProducto()
							.getDescripcion());

			System.out.println(
					"Cantidad: "
					+ detalle.getCantidad());

			System.out.printf(
					"Precio unitario: $%.2f%n",
					detalle.getPrecioUnitario());

			System.out.printf(
					"Descuento producto: %.0f%%%n",
					detalle.getProducto()
							.getDescuento());

			System.out.printf(
					"Importe: $%.2f%n",
					detalle.getImporte());

			System.out.println();
		}

		System.out.printf(
				"TOTAL: $%.2f%n",
				factura.getTotal());
	}
}