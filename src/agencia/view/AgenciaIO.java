package agencia.view;

import java.util.Scanner;

import agencia.entity.Agencia;
import view.InputTypes;


public class AgenciaIO {

	public static Agencia ingresar(Scanner scanner) {
		int codigoAgencia = InputTypes.readInt(scanner, "Código de la agencia: ");
		String direccion = InputTypes.readString(scanner, "Dirección: ");
		String ciudad = InputTypes.readString(scanner, "Ciudad: ");


		return new Agencia(codigoAgencia, direccion, ciudad);

	}


}
