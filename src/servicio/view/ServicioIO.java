package servicio.view;

import java.util.Scanner;

import servicio.entity.Servicio;
import view.InputTypes;

public class ServicioIO {
	
	public static Servicio ingresar(Scanner scanner) {
		int codigoServicio = InputTypes.readInt(scanner, "Código del servicio: ");
		String gps = InputTypes.readString(scanner, "¿Incluye gps?: ");
		String seguro = InputTypes.readString(scanner, "¿Incluye seguro?: ");
		String asistenciaRemolque = InputTypes.readString(scanner, "¿Incluye asistencia de remolque?: ");
		
		return new Servicio(codigoServicio, gps, seguro, asistenciaRemolque);

	}

}
