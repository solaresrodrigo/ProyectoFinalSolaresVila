package agencia.view;

import java.util.Scanner;

import agencia.entity.Agencia;
import view.InputTypes;

public class AgenciaIO {

	public static Agencia ingresar(Scanner scanner){
		
		String direccion = InputTypes.readString(scanner, "Direccion de la Agencia: ");
		String ciudad = InputTypes.readString(scanner, "Ciudad de la agencia: ");
		
		return new Agencia(direccion, ciudad);
	}
}
