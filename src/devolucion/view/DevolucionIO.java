package devolucion.view;

import java.util.Scanner;

import devolucion.entity.Devolucion;
import view.InputTypes;

public class DevolucionIO {

	public static Devolucion ingresar(Scanner scanner) {
		int codDevolucion = InputTypes.readInt(scanner, "C�digo de la Devoluci�n: ");
		String da�os = InputTypes.readString(scanner, "Da�os en el automovil: ");
		int codTaller = InputTypes.readInt(scanner, "C�digo del Taller: ");

		return new Devolucion(codDevolucion, codTaller, da�os);

	}

}
