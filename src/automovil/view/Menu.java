package automovil.view;

import java.util.Scanner;

import control.Conexion;
import view.InputTypes;

public class Menu {
	
	public static int encabezado(Scanner scanner) {
		int opcion;
		
		while(true) {
			System.out.println("1. Registrar Nuevo Auto");
			System.out.println("2. Listar Autos");
			System.out.println("3. Eliminar auto");
			System.out.println("4. Actualizar auto");
			System.out.println("5. Actualizar el estado del automovil.");
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
		boolean salirListado=false;
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
				autosView.eliminar();
				break;
			case 3:
				while(!salirListado) {
					switch(encabezadoListado(scanner)) {
					case 0:
						salirListado = true;
						break;
					case 1:
						autosView.listar();
						break;
					case 2:
						autosView.listarPorCodigo();
						break;
					case 3:
						autosView.listarPorTipo();
						break;
					case 4:
						autosView.listarPorCapacidad();
						break;
					case 5:
						autosView.listarPorModelo();
						break;
					case 6:
						autosView.listarPorEstado();
						break;
					case 7:
						autosView.listarPorPrecio();
						break;
					}
				}
				break;
			case 4:
				autosView.actualizar();
				break;
			case 5:
				autosView.rentar();
				break;
			
			}
		}
	}

	private static int encabezadoListado(Scanner scanner) {
		int opcion;
		while(true) {
			System.out.println("-----Listado de automoviles: ");
			System.out.println("1. Listado general.");
			System.out.println("2. Por codigo");
			System.out.println("3. Por tipo");
			System.out.println("4. Por capacidad");
			System.out.println("5. Por modelo.");
			System.out.println("6. Por estado.");
			System.out.println("7. Por precio/dia.");
			System.out.println("0. Salir.");

			System.out.println();

			opcion=InputTypes.readInt(scanner, "Ingrese una opcion:");

			if(opcion >= 0 && opcion<= 7) {
				return opcion;
			}

		}
	}
	
	
}
