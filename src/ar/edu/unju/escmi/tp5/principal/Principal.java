package ar.edu.unju.escmi.tp5.principal;

import java.util.Scanner;

public class Principal {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int opcion;

		do {

			System.out.println();
			System.out.println("===== SISTEMA DE VENTAS =====");
			System.out.println("1 - Agente Administrativo");
			System.out.println("2 - Encargado de Ventas");
			System.out.println("3 - Cliente");
			System.out.println("4 - Salir");

			opcion = leerEntero("Seleccione un perfil: ");

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
				System.out.println("Programa finalizado.");
				break;

			default:
				System.out.println("Opcion incorrecta.");
			}

		} while (opcion != 4);

		scanner.close();
	}


	private static void menuAgenteAdministrativo() {

		int opcion;

		do {

			System.out.println();
			System.out.println("===== AGENTE ADMINISTRATIVO =====");
			System.out.println("1 - Alta de producto");
			System.out.println("2 - Realizar venta");
			System.out.println("3 - Volver");

			opcion = leerEntero("Seleccione una opcion: ");

			switch (opcion) {

			case 1:
				altaProducto();
				break;

			case 2:
				realizarVenta();
				break;

			case 3:
				System.out.println("Volviendo al menu principal...");
				break;

			default:
				System.out.println("Opcion incorrecta.");
			}

		} while (opcion != 3);
	}


	private static void menuEncargadoVentas() {

		int opcion;

		do {

			System.out.println();
			System.out.println("===== ENCARGADO DE VENTAS =====");
			System.out.println("1 - Mostrar todas las ventas");
			System.out.println("2 - Mostrar total de todas las ventas");
			System.out.println("3 - Verificar stock de un producto");
			System.out.println("4 - Volver");

			opcion = leerEntero("Seleccione una opcion: ");

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
				System.out.println("Volviendo al menu principal...");
				break;

			default:
				System.out.println("Opcion incorrecta.");
			}

		} while (opcion != 4);
	}


	private static void menuCliente() {

		int opcion;

		do {

			System.out.println();
			System.out.println("===== CLIENTE =====");
			System.out.println("1 - Buscar factura por numero");
			System.out.println("2 - Volver");

			opcion = leerEntero("Seleccione una opcion: ");

			switch (opcion) {

			case 1:
				buscarFactura();
				break;

			case 2:
				System.out.println("Volviendo al menu principal...");
				break;

			default:
				System.out.println("Opcion incorrecta.");
			}

		} while (opcion != 2);
	}


	private static int leerEntero(String mensaje) {

		while (true) {

			System.out.print(mensaje);
			String entrada = scanner.nextLine().trim();

			try {

				return Integer.parseInt(entrada);

			} catch (NumberFormatException e) {

				System.out.println(
						"Debe ingresar un numero entero.");
			}
		}
	}


	private static void altaProducto() {
		System.out.println("ALTA DE PRODUCTO");
	}


	private static void realizarVenta() {
		System.out.println("REALIZAR VENTA");
	}


	private static void mostrarVentas() {
		System.out.println("MOSTRAR VENTAS");
	}


	private static void mostrarTotalVentas() {
		System.out.println("TOTAL DE VENTAS");
	}


	private static void verificarStock() {
		System.out.println("VERIFICAR STOCK");
	}


	private static void buscarFactura() {
		System.out.println("BUSCAR FACTURA");
	}
}