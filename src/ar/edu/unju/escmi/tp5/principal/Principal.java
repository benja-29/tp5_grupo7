package ar.edu.unju.escmi.tp5.principal;

import java.time.LocalDate;
import java.util.Scanner;

import ar.edu.unju.escmi.tp5.collections.CollectionCliente;
import ar.edu.unju.escmi.tp5.collections.CollectionFactura;
import ar.edu.unju.escmi.tp5.collections.CollectionProducto;
import ar.edu.unju.escmi.tp5.collections.CollectionStock;
import ar.edu.unju.escmi.tp5.dominio.Cliente;
import ar.edu.unju.escmi.tp5.dominio.ClienteMayorista;
import ar.edu.unju.escmi.tp5.dominio.ClienteMinorista;
import ar.edu.unju.escmi.tp5.dominio.DetalleFactura;
import ar.edu.unju.escmi.tp5.dominio.Factura;
import ar.edu.unju.escmi.tp5.dominio.Producto;

public class Principal {

	private static Scanner scanner =
			new Scanner(System.in);

	public static void main(String[] args) {

		CollectionCliente.precargarClientes();
		CollectionProducto.precargarProductos();
		CollectionStock.precargarStock();

		int opcion;

		do {

			System.out.println();
			System.out.println(
					"===== SISTEMA DE VENTAS =====");

			System.out.println(
					"1 - Agente Administrativo");

			System.out.println(
					"2 - Encargado de Ventas");

			System.out.println(
					"3 - Cliente");

			System.out.println(
					"4 - Salir");

			opcion =
					leerEntero(
							"Seleccione un perfil: ");

			switch (opcion) {

			case 1:
				menuAgenteAdministrativo();
				break;

			case 2:
				menuEncargadoVentas();
				break;

			case 3:
				menuCliente();
				break;

			case 4:

				System.out.println(
						"Programa finalizado.");

				break;

			default:

				System.out.println(
						"Opcion incorrecta.");
			}

		} while (opcion != 4);

		scanner.close();
	}


	private static void menuAgenteAdministrativo() {

		int opcion;

		do {

			System.out.println();
			System.out.println(
					"===== AGENTE ADMINISTRATIVO =====");

			System.out.println(
					"1 - Alta de producto");

			System.out.println(
					"2 - Realizar venta");

			System.out.println(
					"3 - Volver");

			opcion =
					leerEntero(
							"Seleccione una opcion: ");

			switch (opcion) {

			case 1:
				altaProducto();
				break;

			case 2:
				realizarVenta();
				break;

			case 3:

				System.out.println(
						"Volviendo al menu principal...");

				break;

			default:

				System.out.println(
						"Opcion incorrecta.");
			}

		} while (opcion != 3);
	}


	private static void menuEncargadoVentas() {

		int opcion;

		do {

			System.out.println();
			System.out.println(
					"===== ENCARGADO DE VENTAS =====");

			System.out.println(
					"1 - Mostrar todas las ventas");

			System.out.println(
					"2 - Mostrar total de todas las ventas");

			System.out.println(
					"3 - Verificar stock de un producto");

			System.out.println(
					"4 - Volver");

			opcion =
					leerEntero(
							"Seleccione una opcion: ");

			switch (opcion) {

			case 1:
				mostrarVentas();
				break;

			case 2:
				mostrarTotalVentas();
				break;

			case 3:
				verificarStock();
				break;

			case 4:

				System.out.println(
						"Volviendo al menu principal...");

				break;

			default:

				System.out.println(
						"Opcion incorrecta.");
			}

		} while (opcion != 4);
	}


	private static void menuCliente() {

		int opcion;

		do {

			System.out.println();
			System.out.println(
					"===== CLIENTE =====");

			System.out.println(
					"1 - Buscar factura por numero");

			System.out.println(
					"2 - Volver");

			opcion =
					leerEntero(
							"Seleccione una opcion: ");

			switch (opcion) {

			case 1:
				buscarFactura();
				break;

			case 2:

				System.out.println(
						"Volviendo al menu principal...");

				break;

			default:

				System.out.println(
						"Opcion incorrecta.");
			}

		} while (opcion != 2);
	}


	private static void altaProducto() {

		System.out.println();
		System.out.println(
				"===== ALTA DE PRODUCTO =====");

		int codigo =
				leerEnteroPositivo(
						"Ingrese codigo: ");

		if (CollectionProducto.buscarProducto(codigo)
				!= null) {

			System.out.println(
					"Ya existe un producto con ese codigo.");

			return;
		}

		String descripcion =
				leerTexto(
						"Ingrese descripcion: ");

		double precio =
				leerDoublePositivo(
						"Ingrese precio unitario: ");

		double descuento =
				leerDescuento();

		int cantidadInicial =
				leerEnteroNoNegativo(
						"Ingrese stock inicial: ");

		Producto producto =
				new Producto(
						codigo,
						descripcion,
						precio,
						descuento,
						cantidadInicial);

		boolean agregado =
				CollectionProducto
						.altaProducto(producto);

		if (agregado) {

			System.out.println(
					"Producto agregado correctamente.");

		} else {

			System.out.println(
					"No se pudo agregar el producto.");
		}
	}


	private static void realizarVenta() {

		System.out.println();
		System.out.println(
				"===== REALIZAR VENTA =====");

		Cliente cliente =
				seleccionarCliente();

		if (cliente == null) {

			System.out.println(
					"No se encontro el cliente.");

			return;
		}

		int numeroFactura =
				CollectionFactura
						.siguienteNumeroFactura();

		Factura factura =
				new Factura(
						numeroFactura,
						LocalDate.now(),
						cliente);

		boolean continuar;

		do {

			mostrarProductosDisponibles();

			int codigo =
					leerEnteroPositivo(
							"Ingrese codigo del producto: ");

			Producto producto =
					CollectionProducto
							.buscarProducto(codigo);

			if (producto == null) {

				System.out.println(
						"Producto no encontrado.");

				continuar =
						leerSiNo(
								"Desea intentar con otro producto");

				continue;
			}

			int unidades;
			double precioVenta;

			if (cliente
					instanceof ClienteMayorista) {

				int bultos =
						leerEnteroPositivo(
								"Ingrese cantidad de bultos: ");

				unidades =
						bultos * 10;

				precioVenta =
						producto
								.getPrecioUnitario()
						/ 2;

				System.out.println(
						"Unidades a vender: "
						+ unidades);

			} else {

				unidades =
						leerEnteroPositivo(
								"Ingrese cantidad de unidades: ");

				precioVenta =
						producto
								.getPrecioUnitario();
			}

			if (!CollectionStock.hayStock(
					codigo,
					unidades)) {

				System.out.println(
						"Stock insuficiente.");

				System.out.println(
						"Stock actual: "
						+ CollectionStock
								.verificarStock(codigo));

				continuar =
						leerSiNo(
								"Desea intentar con otro producto");

				continue;
			}

			DetalleFactura detalle =
					new DetalleFactura(
							unidades,
							precioVenta,
							producto);

			factura.agregarDetalle(
					detalle);

			CollectionStock.actualizarStock(
					codigo,
					unidades);

			System.out.printf(
					"Producto agregado. Importe: $%.2f%n",
					detalle.getImporte());

			continuar =
					leerSiNo(
							"Desea agregar otro producto");

		} while (continuar);


		if (factura.getDetalleFactura().isEmpty()) {

			System.out.println(
					"La venta no contiene productos.");

			System.out.println(
					"No se genero factura.");

			return;
		}


		if (cliente
				instanceof ClienteMinorista) {

			ClienteMinorista minorista =
					(ClienteMinorista) cliente;

			if (minorista.isTienePami()) {

				double totalConPami =
						factura.getTotal()
						* 0.90;

				factura.setTotal(
						totalConPami);

				System.out.println(
						"Se aplico descuento PAMI del 10%.");
			}
		}

		CollectionFactura
				.guardarFactura(factura);

		System.out.println();
		System.out.println(
				"Venta realizada correctamente.");

		CollectionFactura
				.mostrarFactura(factura);
	}


	private static Cliente seleccionarCliente() {

		while (true) {

			System.out.println();
			System.out.println(
					"Tipo de cliente:");

			System.out.println(
					"1 - Mayorista");

			System.out.println(
					"2 - Minorista");

			int tipo =
					leerEntero(
							"Seleccione tipo: ");

			if (tipo == 1) {

				String codigo =
						leerTexto(
								"Ingrese codigo de cliente mayorista: ");

				return CollectionCliente
						.buscarMayoristaPorCodigo(
								codigo);
			}

			if (tipo == 2) {

				int dni =
						leerEnteroPositivo(
								"Ingrese DNI: ");

				return CollectionCliente
						.buscarMinoristaPorDni(
								dni);
			}

			System.out.println(
					"Opcion incorrecta.");
		}
	}


	private static void mostrarProductosDisponibles() {

		System.out.println();
		System.out.println(
				"===== PRODUCTOS =====");

		for (Producto producto
				: CollectionProducto.collection) {

			System.out.println(
					"Codigo: "
					+ producto.getCodigo());

			System.out.println(
					"Descripcion: "
					+ producto.getDescripcion());

			System.out.printf(
					"Precio: $%.2f%n",
					producto.getPrecioUnitario());

			System.out.printf(
					"Descuento: %.0f%%%n",
					producto.getDescuento());

			System.out.println(
					"Stock: "
					+ producto.getCantidadTotal());

			System.out.println(
					"-------------------------");
		}
	}


	private static void mostrarVentas() {

		CollectionFactura
				.mostrarVentas();
	}


	private static void mostrarTotalVentas() {

		double total =
				CollectionFactura
						.calcularTotalVentas();

		System.out.printf(
				"Total de todas las ventas: $%.2f%n",
				total);
	}


	private static void verificarStock() {

		System.out.println();
		System.out.println(
				"===== VERIFICAR STOCK =====");

		int codigo =
				leerEnteroPositivo(
						"Ingrese codigo de producto: ");

		Producto producto =
				CollectionProducto
						.buscarProducto(codigo);

		if (producto == null) {

			System.out.println(
					"Producto no encontrado.");

			return;
		}

		int stock =
				CollectionStock
						.verificarStock(codigo);

		System.out.println(
				"Producto: "
				+ producto.getDescripcion());

		System.out.println(
				"Stock disponible: "
				+ stock);
	}


	private static void buscarFactura() {

		System.out.println();
		System.out.println(
				"===== BUSCAR FACTURA =====");

		int numero =
				leerEnteroPositivo(
						"Ingrese numero de factura: ");

		Factura factura =
				CollectionFactura
						.buscarFacturaPorNumero(
								numero);

		if (factura == null) {

			System.out.println(
					"Factura no encontrada.");

			return;
		}

		CollectionFactura
				.mostrarFactura(factura);
	}


	private static int leerEntero(
			String mensaje) {

		while (true) {

			System.out.print(mensaje);

			String entrada =
					scanner.nextLine().trim();

			try {

				return Integer
						.parseInt(entrada);

			} catch (NumberFormatException e) {

				System.out.println(
						"Debe ingresar un numero entero.");
			}
		}
	}


	private static int leerEnteroPositivo(
			String mensaje) {

		while (true) {

			int numero =
					leerEntero(mensaje);

			if (numero > 0) {
				return numero;
			}

			System.out.println(
					"El numero debe ser mayor que cero.");
		}
	}


	private static int leerEnteroNoNegativo(
			String mensaje) {

		while (true) {

			int numero =
					leerEntero(mensaje);

			if (numero >= 0) {
				return numero;
			}

			System.out.println(
					"El numero no puede ser negativo.");
		}
	}


	private static double leerDoublePositivo(
			String mensaje) {

		while (true) {

			System.out.print(mensaje);

			String entrada =
					scanner.nextLine()
							.trim()
							.replace(",", ".");

			try {

				double numero =
						Double.parseDouble(
								entrada);

				if (numero > 0) {
					return numero;
				}

				System.out.println(
						"El valor debe ser mayor que cero.");

			} catch (NumberFormatException e) {

				System.out.println(
						"Debe ingresar un numero valido.");
			}
		}
	}


	private static double leerDescuento() {

		while (true) {

			System.out.print(
					"Ingrese descuento (0, 25 o 30): ");

			String entrada =
					scanner.nextLine()
							.trim()
							.replace(",", ".");

			try {

				double descuento =
						Double.parseDouble(
								entrada);

				if (descuento == 0
						|| descuento == 25
						|| descuento == 30) {

					return descuento;
				}

				System.out.println(
						"El descuento debe ser 0, 25 o 30.");

			} catch (NumberFormatException e) {

				System.out.println(
						"Debe ingresar un numero valido.");
			}
		}
	}


	private static String leerTexto(
			String mensaje) {

		while (true) {

			System.out.print(mensaje);

			String texto =
					scanner.nextLine()
							.trim();

			if (!texto.isEmpty()) {

				return texto;
			}

			System.out.println(
					"El dato no puede estar vacio.");
		}
	}


	private static boolean leerSiNo(
			String mensaje) {

		while (true) {

			System.out.print(
					mensaje + " (S/N): ");

			String respuesta =
					scanner.nextLine()
							.trim();

			if (respuesta
					.equalsIgnoreCase("S")) {

				return true;
			}

			if (respuesta
					.equalsIgnoreCase("N")) {

				return false;
			}

			System.out.println(
					"Ingrese solamente S o N.");
		}
	}
}