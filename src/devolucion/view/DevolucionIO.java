package devolucion.view;

import java.util.Scanner;

import devolucion.entity.Devolucion;
import view.InputTypes;

public class DevolucionIO {

	public static Devolucion ingresar(Scanner scanner) {
		int codDevolucion = InputTypes.readInt(scanner, "Código de la Devolución: ");
		String daños = InputTypes.readString(scanner, "Daños en el automovil: ");
		int codTaller = InputTypes.readInt(scanner, "Código del Taller: ");

		return new Devolucion(codDevolucion, codTaller, daños);

	}

}
