package administrativo.view;


import java.util.Iterator;
import java.util.Scanner;

import administrativo.control.Administrativos;
import administrativo.entity.Administrativo;
import entity.InexistenteException;
import view.InputTypes;

public class AdministrativosIO {

	private Administrativos administrativos;
	private Scanner scanner;
	
	public AdministrativosIO(Administrativos administrativos, Scanner scanner) {
		this.administrativos = administrativos;
		this.scanner= scanner;
	}
	
	public void añadir() {
		Administrativo administrativo = AdministrativoIO.ingresar(scanner);
		administrativos.añadir(administrativo);
	}
	
	public void eliminar() throws InexistenteException {
		int codAdministrativo;
		codAdministrativo= InputTypes.readInt(scanner, "Código Administrativo: ");
		administrativos.eliminar(codAdministrativo);
	}
	
	public void listar() {
		Administrativo administrativo;
		for(Iterator<Administrativo> iterator = administrativos.getAdministrativos().iterator(); iterator.hasNext(); ) {
			administrativo = iterator.next();
			System.out.println(administrativo);
		}
	}
	
	public Administrativos getAutos() {
		return administrativos;
	}
	
}
