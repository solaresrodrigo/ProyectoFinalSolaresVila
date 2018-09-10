package mecanico.control;

import java.util.HashSet;
import java.util.Iterator;

import entity.InexistenteException;
import mecanico.entity.Mecanico;

public class Mecanicos {

	private HashSet<Mecanico> mecanicos;

	public Mecanicos() {
		mecanicos = new HashSet<Mecanico>();
	}

	public void añadir(Mecanico mecanico) {

		mecanicos.add(mecanico);
	}

	public void eliminar(int codigoMecanico) throws InexistenteException {
		Mecanico mecanico = buscar(codigoMecanico);
		mecanicos.remove(mecanico);
	}


	public Mecanico buscar(int codigoMecanico) throws InexistenteException{
		Mecanico buscado=null;
		Mecanico mecanico;

		for(Iterator<Mecanico> iterator = mecanicos.iterator(); iterator.hasNext();) {
			mecanico = iterator.next();
			if( mecanico.getCodigoMecanico().equals(codigoMecanico) ) { 
				buscado=mecanico;
			}
		}
		if(buscado==null) {
			throw new InexistenteException();
		}
		return buscado;
	}

	public HashSet<Mecanico> getMecanicos() {
		return mecanicos;
	}

}
