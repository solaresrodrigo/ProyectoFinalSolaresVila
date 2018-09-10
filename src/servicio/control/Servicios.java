package servicio.control;

import java.util.HashSet;
import java.util.Iterator;

import entity.InexistenteException;
import servicio.entity.Servicio;

public class Servicios {
	
	private HashSet<Servicio> servicios;
	
	public Servicios() {
		servicios = new HashSet<Servicio>();
	}
	
	public void añadir(Servicio servicio) {

		servicios.add(servicio);
	}
	
	public void eliminar(int codigoServicio) throws InexistenteException {
		Servicio servicio = buscar(codigoServicio);
		servicios.remove(servicio);
	}

	
	public Servicio buscar(int codigoServicio) throws InexistenteException{
		Servicio buscado=null;
		Servicio servicio;

		for(Iterator<Servicio> iterator = servicios.iterator(); iterator.hasNext();) {
			servicio = iterator.next();
			if( servicio.getCodigoServicio().equals(codigoServicio) ) { 
				buscado=servicio;
			}
		}
		if(buscado==null) {
			throw new InexistenteException();
		}
		return buscado;
	}
	
	public HashSet<Servicio> getServicios() {
		return servicios;
	}

}
