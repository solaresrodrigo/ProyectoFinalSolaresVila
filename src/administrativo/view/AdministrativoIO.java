package administrativo.view;

import java.util.Scanner;

import administrativo.entity.Administrativo;
import view.InputTypes;

public class AdministrativoIO {

	
	public static Administrativo ingresar(Scanner scanner) {
		int codAdministrativo=InputTypes.readInt(scanner, "C�digo Administrativo: ");
		int codAgencia=InputTypes.readInt(scanner, "C�digo Agencia: ");
		int CI=InputTypes.readInt(scanner, "Numero de Carnet: ");
		int nroContacto= InputTypes.readInt(scanner, "N�mero de Contacto: ");
		
		return new Administrativo(codAdministrativo, codAgencia,CI,nroContacto);
	}
}
