package view;

import java.util.Scanner;

import control.Conexion;


public class Menu {

	public static int encabezado(Scanner scanner) {
		int opcion;

		while(true) {
			System.out.println("-----Servicio de Renta-----");
			System.out.println("1. Menu autos.");
			System.out.println("2. Menu servicios.");
			System.out.println("0. Salir.");

			opcion = InputTypes.readInt(scanner, "Ingrese la opcion deseada: ");

			if(opcion>=0 && opcion<=3) {
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
				automovil.view.Menu.menu(scanner, conexion);
				break;
			case 2:
				servicio.view.Menu.menu(scanner, conexion);
				break;
			}
		}
	}

}
