package mecanico.view;

import java.util.Scanner;

import mecanico.entity.Mecanico;
import view.InputTypes;

public class MecanicoIO {

	public static Mecanico ingresar(Scanner scanner){
		
		int codigoTaller = InputTypes.readInt(scanner, "Codigo del Taller al cual pertenece: ");
		int ci = InputTypes.readInt(scanner, "Cedula de Identidad: ");
		int nroContacto = InputTypes.readInt(scanner, "Numero de contacto: ");
		return new Mecanico(codigoTaller, ci,nroContacto);
	}
}
