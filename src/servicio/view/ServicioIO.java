package servicio.view;

import java.util.Scanner;

import servicio.entity.Servicio;
import view.InputTypes;

public class ServicioIO {
	
public static Servicio ingresar(Scanner scanner){
		
		int precio = InputTypes.readInt(scanner,"Precio del servicio: ");
		String tipo = InputTypes.readString(scanner, "Tipo de servicio: ");
		
		return new Servicio(precio, tipo);
	}

}
