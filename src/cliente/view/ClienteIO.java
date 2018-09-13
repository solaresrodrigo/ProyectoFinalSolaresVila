package cliente.view;

import java.util.Scanner;

import cliente.entity.Cliente;
import view.InputTypes;

public class ClienteIO {

	public static Cliente ingresar(Scanner scanner) {
		
		int nroContacto = InputTypes.readInt(scanner, "Numero de contacto del Cliente: ");
		int CI = InputTypes.readInt(scanner, "Cedula de Identidad: ");
		String direccion = InputTypes.readString(scanner, "Direccion del Cliente: ");
		
		return new Cliente(nroContacto, CI, direccion);
	}
}
