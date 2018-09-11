package devolucion.view;

import java.util.Iterator;
import java.util.Scanner;

import devolucion.control.Devoluciones;
import devolucion.entity.Devolucion;
import entity.InexistenteException;
import view.InputTypes;

public class DevolucionesIO {

	private Devoluciones devoluciones;
	private Scanner scanner;


	public DevolucionesIO(Devoluciones devoluciones, Scanner scanner) {
		this.devoluciones = devoluciones;
		this.scanner = scanner;
	}

	public void a�adir() {
		Devolucion devolucion = DevolucionIO.ingresar(scanner);
		devoluciones.a�adir(devolucion);
	}

	public void eliminar() throws InexistenteException{
		int codDevolucion;
		codDevolucion = InputTypes.readInt(scanner, "C�digo de la Devoluci�n: ");
		devoluciones.eliminar(codDevolucion);
	}

	public void listar() {
		Devolucion devolucion;

		for(Iterator<Devolucion> iterator = devoluciones.getDevoluciones().iterator(); 
				iterator.hasNext();) {
			devolucion= iterator.next();
			System.out.println(devolucion);
		}
	}

	public Devoluciones getDevoluciones() {
		return devoluciones;
	}
}
