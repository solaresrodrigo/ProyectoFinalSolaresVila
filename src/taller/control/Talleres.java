package taller.control;

import java.util.HashSet;
import java.util.Iterator;

import entity.InexistenteException;
import taller.entity.Taller;

public class Talleres {

	private HashSet<Taller> talleres;

	public Talleres() {
		talleres = new HashSet<Taller>();
	}

	public void añadir(Taller taller) {

		talleres.add(taller);
	}

	public Taller buscar(int codTaller) throws InexistenteException{
		Taller buscado=null;
		Taller taller;

		for(Iterator<Taller> iterator = talleres.iterator(); iterator.hasNext();) {
			taller = iterator.next();
			if( taller.getCodTaller().equals(codTaller) ) { 
				buscado=taller;
			}
		}
		if(buscado==null) {
			throw new InexistenteException();
		}
		return buscado;
	}


	public void eliminar(int codTaller) throws InexistenteException{
		Taller taller=buscar(codTaller);

		talleres.remove(taller);
	}


	public HashSet<Taller> getTalleres() {
		return talleres;
	}
}
