package taller.view;

import java.util.Scanner;

import taller.entity.Taller;
import view.InputTypes;

public class TallerIO {

	public static Taller ingresar(Scanner scanner) {
		int codTaller = InputTypes.readInt(scanner, "Código del Taller: ");
		String direccion = InputTypes.readString(scanner, "Dirección: ");
		String servicio = InputTypes.readString(scanner, "Servicios: ");
		int capacidad = InputTypes.readInt(scanner, "Capacidad: ");

		return new Taller(codTaller, direccion, servicio,capacidad);

	}

}
