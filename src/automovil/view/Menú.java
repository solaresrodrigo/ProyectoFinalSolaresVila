package automovil.view;

import java.util.Scanner;

import view.InputTypes;

public class Menú {
	
	public static int encabezado(Scanner scanner) {
		int opcion;
		
		while(true) {
			System.out.println("Ingrese una opci�n: ");
			System.out.println("1. Registrar Nuevo Auto");
			System.out.println("2. Listar Autos");
			System.out.println("3. ");
			System.out.println();
			
			opcion=InputTypes.readInt(scanner, "�Su Opci�n?");
			
			if(opcion >= 0 && opcion<= 3) {
				return opcion;
			}
		}
		
	}
	
	
}
