package automovil.view;

import java.util.Scanner;

import automovil.entity.Auto;
import view.InputTypes;

public class AutoIO {

	public static Auto ingresar(Scanner scanner){
		
		int placa = InputTypes.readInt(scanner,"Numero de placa: ");
		String tipo = InputTypes.readString(scanner, "Tipo de Automovil: ");
		int capacidad= InputTypes.readInt(scanner, "Capacidad: ");
		int modelo = InputTypes.readInt(scanner,"Modelo: ");
		String estado = InputTypes.readString(scanner, "Estado de Renta: ");
		int precio = InputTypes.readInt(scanner,"Precio por día: ");
		
		return new Auto(placa, tipo, capacidad, modelo, estado, precio);
	}
	
	
}
