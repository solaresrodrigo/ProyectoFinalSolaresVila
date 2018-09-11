package taller.view;

import java.util.Iterator;
import java.util.Scanner;

import entity.InexistenteException;
import taller.control.Talleres;
import taller.entity.Taller;
import view.InputTypes;

public class TalleresIO {

	private Talleres talleres;
	private Scanner scanner;


	public TalleresIO(Talleres talleres, Scanner scanner) {
		this.talleres = talleres;
		this.scanner = scanner;
	}

	public void añadir() {
		Taller taller = TallerIO.ingresar(scanner);
		talleres.añadir(taller);
	}

	public void eliminar() throws InexistenteException{
		int codTaller;
		codTaller = InputTypes.readInt(scanner, "Código del taller: ");
		talleres.eliminar(codTaller);
	}

	public void listar() {
		Taller taller;

		for(Iterator<Taller> iterator = talleres.getTalleres().iterator(); iterator.hasNext();) {
			taller = iterator.next();
			System.out.println(taller);
		}
	}

	public Talleres getTalleres() {
		return talleres;
	}

}
