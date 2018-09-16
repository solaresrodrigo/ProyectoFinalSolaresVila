package view;

import java.util.Scanner;

import control.Conexion;


public class Menu {

	public static int encabezado(Scanner scanner) {
		int opcion;

		while(true) {
			System.out.println("-----Servicio de Renta-----");
			System.out.println("1. Menu Administrativos.");
			System.out.println("2. Menu Agencias.");
			System.out.println("3. Menu Autos.");
			System.out.println("4. Menu Clientes.");
			System.out.println("5. Menu Servicios.");
			System.out.println("0. Salir.");

			opcion = InputTypes.readInt(scanner, "Ingrese la opcion deseada: ");

			if(opcion>=0 && opcion<=5) {
				return opcion;
			}
		}
	}

	public static void menu(Scanner scanner, Conexion conexion) {
		boolean salir=false;





		while(!salir) {
			switch(encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1: 
				administrativo.view.Menu.menu(scanner, conexion);
				break;
			case 2:
				agencia.view.Menu.menu(scanner, conexion);
				break;
			case 3:
				automovil.view.Menu.menu(scanner, conexion);
				break;
			case 4:
				cliente.view.Menu.menu(scanner, conexion);
				break;
			case 5:
				servicio.view.Menu.menu(scanner, conexion);
				break;
			}
		}
	}

}
