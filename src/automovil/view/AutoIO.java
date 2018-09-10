package automovil.view;

import java.util.Scanner;

import automovil.entity.Auto;
import view.InputTypes;

public class AutoIO {

	public static Auto ingresar(Scanner scanner){
		int codAuto= InputTypes.readInt(scanner,"Código del Automovil: ");
		int codAgencia= InputTypes.readInt(scanner,"Código de la Agencia: ");
		int codTaller= InputTypes.readInt(scanner, "Código del Taller: ");
		String placa = InputTypes.readString(scanner,"Número de placa: ");
		String tipo = InputTypes.readString(scanner, "Tipo de Automovil: ");
		int capacidad= InputTypes.readInt(scanner, "Capacidad: ");
		int nroPuertas= InputTypes.readInt(scanner,"Número de Puertas: ");
		String modelo = InputTypes.readString(scanner,"Modelo: ");
		int kilometraje= InputTypes.readInt(scanner, "Kilometraje: ");
		String estado = InputTypes.readString(scanner, "Estado de Renta: ");
		
		return new Auto(codAuto, codAgencia, codTaller, placa, tipo, capacidad,
									nroPuertas, modelo, kilometraje, estado);
	}
	
	
}
