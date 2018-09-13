package taller.view;

import java.util.Scanner;

import control.Conexion;
import view.InputTypes;

public class Menu {
	
	public static int encabezado(Scanner scanner) {
		int opcion;
		
		while(true) {
			System.out.println("1. Registrar nuevo taller");
			System.out.println("2. Listar talleres");
			System.out.println("3. Eliminar taller");
			System.out.println("4. Actualizar taller");
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
		TalleresIO talleresView = new TalleresIO(conexion, scanner);
		
		while(!salir) {
			switch(encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1: 
				talleresView.anadir();
				break;
			case 2:
				talleresView.listar();
				break;
			case 3:
				talleresView.eliminar();;
				break;
			case 4:
				talleresView.actualizar();;
				break;
			}
			
		}
	}

}
