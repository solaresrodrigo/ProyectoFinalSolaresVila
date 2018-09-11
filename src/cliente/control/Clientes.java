package cliente.control;

import java.util.HashSet;
import java.util.Iterator;

import cliente.entity.Cliente;
import entity.InexistenteException;

public class Clientes {
	
	private HashSet<Cliente> clientes;
	
	public Clientes() {
		clientes = new HashSet<Cliente>();
	}
	
	public void añadir(Cliente cliente) {

		clientes.add(cliente);
	}
	
	public void eliminar(int codigoCliente) throws InexistenteException {
		Cliente cliente = buscar(codigoCliente);
		clientes.remove(cliente);
	}

	
	public Cliente buscar(int codigoCliente) throws InexistenteException{
		Cliente buscado=null;
		Cliente cliente;

		for(Iterator<Cliente> iterator = clientes.iterator(); iterator.hasNext();) {
			cliente = iterator.next();
			if( cliente.getCodigoCliente().equals(codigoCliente) ) { 
				buscado=cliente;
			}
		}
		if(buscado==null) {
			throw new InexistenteException();
		}
		return buscado;
	}
	
	public HashSet<Cliente> getClientes() {
		return clientes;
	}

}
