package automovil.view;

import java.util.Scanner;

import control.Conexion;
import view.InputTypes;

public class Menu {
	
	public static int encabezado(Scanner scanner) {
		int opcion;
		
		while(true) {
			System.out.println("Ingrese una opci�n: ");
			System.out.println("1. Registrar Nuevo Auto");
			System.out.println("2. Listar Autos");
			System.out.println("3. Eliminar auto");
			System.out.println("4. Salir.");
			System.out.println();
			
			opcion=InputTypes.readInt(scanner, "�Su Opci�n?");
			
			if(opcion >= 0 && opcion<= 4) {
				return opcion;
			}
		}
		
	}
	
	public static void menu(Scanner scanner, Conexion conexion) {
		boolean salir=false;

		AutosIO autosView = new AutosIO(conexion, scanner);
		
		while(!salir) {
			switch(encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1: 
				autosView.anadir();
				break;
			case 2:
				break;
			}
		}
	}
	
	
}
