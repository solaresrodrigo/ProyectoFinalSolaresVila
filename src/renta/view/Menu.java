package renta.view;

import java.util.Scanner;

import control.Conexion;
import view.InputTypes;

public class Menu {
	
	public static int encabezado(Scanner scanner) {
		int opcion;
		
		while(true) {
			System.out.println("1. Registrar nueva renta");
			System.out.println("2. Listar rentas");
			System.out.println("3. Eliminar renta");
			System.out.println("4. Actualizar renta");
			System.out.println("5. Monto de una renta");
			System.out.println("0. Salir.");
			System.out.println();
			
			opcion=InputTypes.readInt(scanner, "Ingrese su opcion: ");
			
			if(opcion >= 0 && opcion<= 5) {
				return opcion;
			}
		}
	}
	
	public static void menu(Scanner scanner, Conexion conexion) {
		boolean salir=false;
		RentasIO rentasView = new RentasIO(conexion, scanner);
		
		while(!salir) {
			switch(encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1: 
				rentasView.anadir();
				break;
			case 2:
				rentasView.listar();
				break;
			case 3:
				rentasView.eliminar();;
				break;
			case 4:
				rentasView.actualizar();;
				break;
			case 5:
				rentasView.calcularMonto();
				break;
			}
			
		}
	}

}
