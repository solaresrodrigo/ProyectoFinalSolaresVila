package automovil.view;

import java.util.Scanner;

import automovil.entity.Auto;
import view.InputTypes;

public class AutoIO {

	public static Auto ingresar(Scanner scanner){
		int codAuto= InputTypes.readInt(scanner,"C�digo del Automovil: ");
		int codAgencia= InputTypes.readInt(scanner,"C�digo de la Agencia: ");
		int codTaller= InputTypes.readInt(scanner, "C�digo del Taller: ");
		String placa = InputTypes.readString(scanner,"N�mero de placa: ");
		String tipo = InputTypes.readString(scanner, "Tipo de Automovil: ");
		int capacidad= InputTypes.readInt(scanner, "Capacidad: ");
		int nroPuertas= InputTypes.readInt(scanner,"N�mero de Puertas: ");
		String modelo = InputTypes.readString(scanner,"Modelo: ");
		int kilometraje= InputTypes.readInt(scanner, "Kilometraje: ");
		String estado = InputTypes.readString(scanner, "Estado de Renta: ");
		
		return new Auto(codAuto, codAgencia, codTaller, placa, tipo, capacidad,
									nroPuertas, modelo, kilometraje, estado);
	}
	
	
}
