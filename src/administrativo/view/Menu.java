package administrativo.view;

import java.util.Scanner;

import control.Conexion;
import view.InputTypes;

public class Menu {
	public static int encabezado(Scanner scanner) {
		int opcion;
		
		while(true) {
			System.out.println("1. Registrar nuevo Administrativo");
			System.out.println("2. Listar Administrativos");
			System.out.println("3. Eliminar Administrativo");
			System.out.println("4. Actualizar Administrativo");
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
		AdministrativosIO adminView = new AdministrativosIO(conexion, scanner);
		
		while(!salir) {
			switch(encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1: 
				adminView.anadir();
				break;
			case 2:
				adminView.listar();
				break;
			case 3:
				adminView.eliminar();
				break;
			case 4:
				adminView.actualizar();
				break;
			}
			
		}
	}

}
