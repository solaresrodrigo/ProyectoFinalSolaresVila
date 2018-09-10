package automovil.view;

import java.util.Iterator;
import java.util.Scanner;

import automovil.control.Autos;
import view.InputTypes;

public class AutosIO {

	private Autos autos;
	private Scanner scanner;
	
	public AutosIO(Autos autos, Scanner scanner) {
		this.autos = autos;
		this.scanner= scanner;
	}
	
	public void a�adir() {
		Auto auto = AutoIO.ingresar(scanner);
		autos.a�adir(auto);
	}
	
	public void eliminar() {
		int codAuto;
		codAuto= InputTypes.readInt(scanner, "C�digo de Auto: ");
		autos.eliminar(codAuto);
	}
	
	public void listar() {
		Auto auto;
		for(Iterator<Auto> iterator = autos.getAutos().iterator(); iterator.hasNext(); ) {
			auto = iterator.next();
			System.out.println(auto);
		}
	}
	
	public Autos getAutos() {
		return autos;
	}
}
