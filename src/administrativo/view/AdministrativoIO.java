package administrativo.view;

import java.util.Scanner;

import administrativo.entity.Administrativo;
import view.InputTypes;

public class AdministrativoIO {

	
	public static Administrativo ingresar(Scanner scanner) {
		int codAdministrativo=InputTypes.readInt(scanner, "Código Administrativo: ");
		int codAgencia=InputTypes.readInt(scanner, "Código Agencia: ");
		int CI=InputTypes.readInt(scanner, "Numero de Carnet: ");
		int nroContacto= InputTypes.readInt(scanner, "Número de Contacto: ");
		
		return new Administrativo(codAdministrativo, codAgencia,CI,nroContacto);
	}
}
