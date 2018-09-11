package renta.view;

import java.util.Scanner;

import renta.entity.Renta;
import view.InputTypes;

public class RentaIO {
	
	public static Renta ingresar(Scanner scanner) {
		int codigoRenta = InputTypes.readInt(scanner, "Código de la renta: ");
		int codigoAutomovil = InputTypes.readInt(scanner, "Código del automóvil: ");
		int codigoCliente = InputTypes.readInt(scanner, "Código del cliente: ");
		int codigoAdministrativo = InputTypes.readInt(scanner, "Código del administrativo: ");
		int codigoServicio = InputTypes.readInt(scanner, "Código del servicio: ");
		int codigoAgencia = InputTypes.readInt(scanner, "Código de la agencia: ");
		int montoTotal = InputTypes.readInt(scanner, "Ingrese el monto total: ");
		//fecha inicio, fin
		
		

		return new Renta(codigoRenta, codigoAutomovil, codigoCliente, codigoAdministrativo,
				codigoServicio,codigoAgencia,montoTotal);

	}

}
