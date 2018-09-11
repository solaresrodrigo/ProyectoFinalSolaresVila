package agencia.view;

import java.util.Iterator;
import java.util.Scanner;

import agencia.control.Agencias;
import agencia.entity.Agencia;
import entity.InexistenteException;
import view.InputTypes;

public class AgenciasIO {

	private Agencias agencias;
	private Scanner scanner;


	public AgenciasIO(Agencias agencias, Scanner scanner) {
		this.agencias = agencias;
		this.scanner = scanner;
	}

	public void añadir() {
		Agencia agencia = AgenciaIO.ingresar(scanner);
		agencias.añadir(agencia);
	}

	public void eliminar() throws InexistenteException{
		int codigoAgencia;
		codigoAgencia = InputTypes.readInt(scanner, "CÃ³digo de la agencia: ");
		agencias.eliminar(codigoAgencia);
	}

	public void listar() {
		Agencia agencia;

		for(Iterator<Agencia> iterator = agencias.getAgencias().iterator(); iterator.hasNext();) {
			agencia = iterator.next();
			System.out.println(agencia);
		}
	}

	public Agencias getAgencias() {
		return agencias;
	}

}
