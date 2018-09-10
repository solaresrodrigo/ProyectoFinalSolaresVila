package automovil.control;

import java.util.HashSet;
import java.util.Iterator;

import automovil.entity.Auto;


public class Autos {

	private HashSet<Auto> autos;
	
	public Autos() {
		autos = new HashSet<Auto>();
	}
	public void añadir(Auto auto){
		autos.add(auto);
	}
	
	public void eliminar(int codAuto) {
		Auto auto=buscar(codAuto);
		autos.remove(auto);
	}
	
	public Auto buscar(int codAuto) {
		Auto buscando= null;
		Auto auto;
		
		for(Iterator<Auto> iterator=autos.iterator(); iterator.hasNext();) {
			auto=iterator.next();
			if(auto.getCodAuto().equals(codAuto)) {
				buscando=auto;
			}
		}
		if(buscando == null) {
			
		}
		return buscando;
	}
	
	public HashSet<Auto> getAutos(){
		return autos;
	}
}
