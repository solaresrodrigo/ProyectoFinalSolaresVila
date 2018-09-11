package taller.view;

import java.util.Scanner;

import taller.entity.Taller;
import view.InputTypes;

public class TallerIO {

	public static Taller ingresar(Scanner scanner) {
		int codTaller = InputTypes.readInt(scanner, "C�digo del Taller: ");
		String direccion = InputTypes.readString(scanner, "Direcci�n: ");
		String servicio = InputTypes.readString(scanner, "Servicios: ");
		int capacidad = InputTypes.readInt(scanner, "Capacidad: ");

		return new Taller(codTaller, direccion, servicio,capacidad);

	}

}
