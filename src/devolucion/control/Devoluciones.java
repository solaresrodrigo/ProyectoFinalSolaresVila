package devolucion.control;

import java.util.HashSet;
import java.util.Iterator;

import devolucion.entity.Devolucion;
import entity.InexistenteException;

public class Devoluciones {
	private HashSet<Devolucion> devoluciones;

	public Devoluciones() {
		devoluciones = new HashSet<Devolucion>();
	}

	public void añadir(Devolucion devolucion) {

		devoluciones.add(devolucion);
	}

	public Devolucion buscar(int codDevolucion) throws InexistenteException{
		Devolucion buscado=null;
		Devolucion devolucion;

		for(Iterator<Devolucion> iterator = devoluciones.iterator(); iterator.hasNext();) {
			devolucion = iterator.next();
			if( devolucion.getCodDevolucion().equals(codDevolucion) ) { 
				buscado=devolucion;
			}
		}
		if(buscado==null) {
			throw new InexistenteException();
		}
		return buscado;
	}


	public void eliminar(int codDevolucion) throws InexistenteException{
		Devolucion devolucion=buscar(codDevolucion);

		devoluciones.remove(devolucion);
	}


	public HashSet<Devolucion> getDevoluciones() {
		return devoluciones;
	}
}
