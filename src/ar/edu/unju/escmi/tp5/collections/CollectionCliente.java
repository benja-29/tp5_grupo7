package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp5.dominio.Cliente;
import ar.edu.unju.escmi.tp5.dominio.ClienteMayorista;
import ar.edu.unju.escmi.tp5.dominio.ClienteMinorista;


public class CollectionCliente {

	public static List<Cliente> clientes = new ArrayList<>();

    public static void precargarClientes() {
        // Formato Mayorista: nombre, apellido, direccion, codigoCliente
        clientes.add(new ClienteMayorista("Juan", "Gomez", "San Martin 123", "M-1001"));
        
        // Formato Minorista: nombre, apellido, direccion, dni, tienePami
        clientes.add(new ClienteMinorista("Maria", "Perez", "Belgrano 456", 41234567, true));
        clientes.add(new ClienteMinorista("Carlos", "Lopez", "Alvear 789", 38987654, false));
    }
	
}
