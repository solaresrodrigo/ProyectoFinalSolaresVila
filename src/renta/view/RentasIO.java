package renta.view;

import java.util.Iterator;
import java.util.Scanner;

import entity.InexistenteException;
import renta.control.Rentas;
import renta.entity.Renta;
import view.InputTypes;

public class RentasIO {
	
	private Rentas rentas;
	private Scanner scanner;


	public RentasIO(Rentas rentas, Scanner scanner) {
		this.rentas = rentas;
		this.scanner = scanner;
	}

	public void añadir() {
		Renta renta = RentaIO.ingresar(scanner);
		rentas.añadir(renta);
	}

	public void eliminar() throws InexistenteException{
		int codigoRenta;
		codigoRenta = InputTypes.readInt(scanner, "Código de la renta: ");
		rentas.eliminar(codigoRenta);
	}

	public void listar() {
		Renta renta;

		for(Iterator<Renta> iterator = rentas.getRentas().iterator(); iterator.hasNext();) {
			renta = iterator.next();
			System.out.println(renta);
		}
	}

	public Rentas getRentas() {
		return rentas;
	}

}
