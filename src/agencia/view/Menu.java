package agencia.view;

import java.util.Scanner;

import control.Conexion;
import view.InputTypes;

public class Menu {

	public static int encabezado(Scanner scanner) {
		int opcion;
		
		while(true) {
			System.out.println("1. Registrar nueva Agencia");
			System.out.println("2. Listar Agencias");
			System.out.println("3. Eliminar Agencia");
			System.out.println("4. Actualizar Agencia");
			System.out.println("0. Salir.");
			System.out.println();
			
			opcion=InputTypes.readInt(scanner, "Ingrese su opcion: ");
			
			if(opcion >= 0 && opcion<= 4) {
				return opcion;
			}
		}
	}
	
	public static void menu(Scanner scanner, Conexion conexion) {
		boolean salir=false;
		AgenciasIO agenciasView = new AgenciasIO(conexion, scanner);
		
		while(!salir) {
			switch(encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1: 
				agenciasView.anadir();
				break;
			case 2:
				agenciasView.listar();
				break;
			case 3:
				agenciasView.eliminar();;
				break;
			case 4:
				agenciasView.actualizar();;
				break;
			}
			
		}
	}

}
