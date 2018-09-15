package detalle.view;

import java.util.Scanner;

import detalle.entity.Detalle;
import view.InputTypes;

public class DetalleIO {
	
	public static Detalle ingresar(Scanner scanner){

		int codigoRenta = InputTypes.readInt(scanner,"Codigo de la renta: ");
		int codigoServicio = InputTypes.readInt(scanner,"Codigo del servicio: ");

		return new Detalle(codigoRenta, codigoServicio);
	}
	

}
