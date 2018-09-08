package cliente.view;

import java.util.Scanner;

import cliente.entity.Cliente;
import view.InputTypes;

public class ClienteIO {

	public static Cliente ingresar(Scanner scanner) {
		int codigoCliente = InputTypes.readInt(scanner, "Código del cliente: ");
		int nroContacto = InputTypes.readInt(scanner, "Número de contacto: ");
		int ci = InputTypes.readInt(scanner, "Número de carnet de identidad: ");
		String direccion = InputTypes.readString(scanner, "Dirección: ");


		return new Cliente(codigoCliente, nroContacto, ci, direccion);

	}

}
