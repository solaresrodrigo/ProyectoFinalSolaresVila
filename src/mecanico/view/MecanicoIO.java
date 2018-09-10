package mecanico.view;

import java.util.Scanner;

import mecanico.entity.Mecanico;
import view.InputTypes;

public class MecanicoIO {

	public static Mecanico ingresar(Scanner scanner) {
		int codigoMecanico = InputTypes.readInt(scanner, "Código del mecanico: ");
		int codigoTaller = InputTypes.readInt(scanner, "Código del taller: ");
		int ci = InputTypes.readInt(scanner, "Número de carnet de identidad: ");
		int nroContacto = InputTypes.readInt(scanner, "Número de contacto: ");


		return new Mecanico(codigoMecanico, codigoTaller, ci, nroContacto);

	}

}
