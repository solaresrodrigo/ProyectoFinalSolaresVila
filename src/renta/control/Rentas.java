package renta.control;

import java.util.HashSet;
import java.util.Iterator;

import entity.InexistenteException;
import renta.entity.Renta;

public class Rentas {
	
private HashSet<Renta> rentas;
	
	public Rentas() {
		rentas = new HashSet<Renta>();
	}
	
	public void añadir(Renta renta) {

		rentas.add(renta);
	}
	
	public void eliminar(int codigoRenta) throws InexistenteException {
		Renta renta = buscar(codigoRenta);
		rentas.remove(renta);
	}

	
	public Renta buscar(int codigoRenta) throws InexistenteException{
		Renta buscado=null;
		Renta renta;

		for(Iterator<Renta> iterator = rentas.iterator(); iterator.hasNext();) {
			renta = iterator.next();
			if( renta.getCodigoRenta().equals(codigoRenta) ) { 
				buscado=renta;
			}
		}
		if(buscado==null) {
			throw new InexistenteException();
		}
		return buscado;
	}
	
	public HashSet<Renta> getRentas() {
		return rentas;
	}

}
