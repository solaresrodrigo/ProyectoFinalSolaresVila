package cliente.view;

import java.util.Iterator;
import java.util.Scanner;

import cliente.control.Clientes;
import cliente.entity.Cliente;
import entity.InexistenteException;
import view.InputTypes;


public class ClientesIO {

	private Clientes clientes;
	private Scanner scanner;
	
	public ClientesIO(Clientes clientes, Scanner scanner) {
		this.clientes = clientes;
		this.scanner = scanner;
	}
	
	public void añadir() {
		Cliente cliente = ClienteIO.ingresar(scanner);
		clientes.añadir(cliente);
	}
	
	public void eliminar() throws InexistenteException{
		int codigoCliente;
		codigoCliente = InputTypes.readInt(scanner, "CÃ³digo del cliente: ");
		clientes.eliminar(codigoCliente);
	}

	public void listar() {
		Cliente cliente;

		for(Iterator<Cliente> iterator = clientes.getClientes().iterator(); iterator.hasNext();) {
			cliente = iterator.next();
			System.out.println(cliente);
		}
	}

	public Clientes getClientes() {
		return clientes;
	}
	
	
	
}
