package taller.view;

import java.util.Scanner;

import taller.entity.Taller;
import view.InputTypes;

public class TallerIO {
	
public static Taller ingresar(Scanner scanner){
		
		String direccion = InputTypes.readString(scanner,"Direccion del taller: ");
		int capacidad = InputTypes.readInt(scanner, "Capacidad del taller: ");
		
		return new Taller(direccion, capacidad);
	}

}
