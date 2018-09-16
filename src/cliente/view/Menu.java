package cliente.view;

import java.util.Scanner;

import control.Conexion;
import view.InputTypes;

public class Menu {
	public static int encabezado(Scanner scanner) {
		int opcion;
		
		while(true) {
			System.out.println("1. Registrar nuevo Cliente");
			System.out.println("2. Listar Clientes");
			System.out.println("3. Eliminar Cliente");
			System.out.println("4. Actualizar Cliente");
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
		ClientesIO clientesView = new ClientesIO(conexion, scanner);
		
		while(!salir) {
			switch(encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1: 
				clientesView.anadir();
				break;
			case 2:
				clientesView.listar();
				break;
			case 3:
				clientesView.eliminar();;
				break;
			case 4:
				clientesView.actualizar();;
				break;
			}
			
		}
	}

}
