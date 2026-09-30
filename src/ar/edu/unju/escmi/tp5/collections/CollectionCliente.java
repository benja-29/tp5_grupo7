package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.Cliente;
import ar.edu.unju.escmi.tp5.dominio.ClienteMayorista;
import ar.edu.unju.escmi.tp5.dominio.ClienteMinorista;

public class CollectionCliente {

	public static List<Cliente> collection = new ArrayList<>();

	public static void precargarClientes() {

		if (!collection.isEmpty()) {
			return;
		}

		collection.add(
				new ClienteMayorista(
						"Juan",
						"Gomez",
						"San Martin 123",
						"M-1001"));

		collection.add(
				new ClienteMinorista(
						"Maria",
						"Perez",
						"Belgrano 456",
						41234567,
						true));

		collection.add(
				new ClienteMinorista(
						"Carlos",
						"Lopez",
						"Alvear 789",
						38987654,
						false));
	}

	public static ClienteMayorista buscarMayoristaPorCodigo(
			String codigoCliente) {

		for (Cliente cliente : collection) {

			if (cliente instanceof ClienteMayorista) {

				ClienteMayorista mayorista =
						(ClienteMayorista) cliente;

				if (mayorista.getCodigoCliente()
						.equalsIgnoreCase(codigoCliente)) {

					return mayorista;
				}
			}
		}

		return null;
	}

	public static ClienteMinorista buscarMinoristaPorDni(
			int dni) {

		for (Cliente cliente : collection) {

			if (cliente instanceof ClienteMinorista) {

				ClienteMinorista minorista =
						(ClienteMinorista) cliente;

				if (minorista.getDni() == dni) {

					return minorista;
				}
			}
		}

		return null;
	}
}