package mecanico.view;

import java.util.Scanner;

import control.Conexion;
import view.InputTypes;

public class Menu {
	public static int encabezado(Scanner scanner) {
		int opcion;
		
		while(true) {
			System.out.println("1. Registrar nuevo Mecanico");
			System.out.println("2. Listar Mecanicos");
			System.out.println("3. Eliminar Mecanico");
			System.out.println("4. Actualizar Mecanico");
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
		MecanicosIO mecanicoView = new MecanicosIO(conexion, scanner);
		
		while(!salir) {
			switch(encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1: 
				mecanicoView.anadir();
				break;
			case 2:
				mecanicoView.listar();
				break;
			case 3:
				mecanicoView.eliminar();;
				break;
			case 4:
				mecanicoView.actualizar();;
				break;
			}
			
		}
	}

}
