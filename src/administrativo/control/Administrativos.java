package administrativo.control;

import java.util.HashSet;
import java.util.Iterator;

import administrativo.entity.Administrativo;

public class Administrativos {

	private HashSet<Administrativo> administrativos;
	
	public Administrativos() {
		administrativos = new HashSet<Administrativo>;
		
	}
	
	public void añadir(Administrativo administrativo) {
		administrativos.add(administrativo);
	}
	
	public void eliminar(int codAdministrativo) throws InexistenteException {
		Administrativo administrativo=buscar(codAdministrativo);
		administrativos.remove(administrativo);
	}
	
	public Administrativo buscar(int codAdministrativo) throws inexistenteException {
		Administrativo buscando= null;
		Administrativo administrativo;
		
		for(Iterator<Administrativo> iterator=administrativos.iterator(); iterator.hasNext();) {
			administrativo=iterator.next();
			if(administrativo.getCodAdministrativo().equals(codAdministrativo)) {
				buscando=administrativo;
			}
		}
		if(buscando==null) {
			throw new InexistenteException();
		}
		return buscando;
	}
	
	public HashSet<Administrativo> getAdministrativos(){
		return administrativos;
	}
	
	
}
