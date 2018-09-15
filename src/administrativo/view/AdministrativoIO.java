package administrativo.view;

import java.util.Scanner;

import administrativo.entity.Administrativo;
import view.InputTypes;

public class AdministrativoIO {

public static Administrativo ingresar(Scanner scanner){
		
		int codigoAgencia = InputTypes.readInt(scanner, "Codigo de la Agencia a la cual pertenece: ");
		int ci = InputTypes.readInt(scanner, "Cedula de Identidad: ");
		int nroContacto = InputTypes.readInt(scanner, "Numero de contacto: ");
		return new Administrativo(codigoAgencia, ci,nroContacto);
	}
}
