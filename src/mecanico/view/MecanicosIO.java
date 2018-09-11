package mecanico.view;

import java.util.Iterator;
import java.util.Scanner;

import entity.InexistenteException;
import mecanico.control.Mecanicos;
import mecanico.entity.Mecanico;
import view.InputTypes;

public class MecanicosIO {

	private Mecanicos mecanicos;
	private Scanner scanner;


	public MecanicosIO(Mecanicos mecanicos, Scanner scanner) {
		this.mecanicos = mecanicos;
		this.scanner = scanner;
	}

	public void a�adir() {
		Mecanico mecanico = MecanicoIO.ingresar(scanner);
		mecanicos.a�adir(mecanico);
	}

	public void eliminar() throws InexistenteException{
		int codigoMecanico;
		codigoMecanico = InputTypes.readInt(scanner, "Código del mecanico: ");
		mecanicos.eliminar(codigoMecanico);
	}

	public void listar() {
		Mecanico mecanico;

		for(Iterator<Mecanico> iterator = mecanicos.getMecanicos().iterator(); iterator.hasNext();) {
			mecanico = iterator.next();
			System.out.println(mecanico);
		}
	}

	public Mecanicos getMecanicos() {
		return mecanicos;
	}
	
}
