package agencia.control;

import java.util.HashSet;
import java.util.Iterator;

import agencia.entity.Agencia;
import entity.InexistenteException;


public class Agencias {

	private HashSet<Agencia> agencias;

	public Agencias() {
		agencias = new HashSet<Agencia>();
	}

	public void añadir(Agencia agencia) {

		agencias.add(agencia);
	}

	public Agencia buscar(int codigoAgencia) throws InexistenteException{
		Agencia buscado=null;
		Agencia agencia;

		for(Iterator<Agencia> iterator = agencias.iterator(); iterator.hasNext();) {
			agencia = iterator.next();
			if( agencia.getCodigoAgencia().equals(codigoAgencia) ) { 
				buscado=agencia;
			}
		}
		if(buscado==null) {
			throw new InexistenteException();
		}
		return buscado;
	}


	public void eliminar(int codigoAgencia) throws InexistenteException{
		Agencia agencia=buscar(codigoAgencia);

		agencias.remove(agencia);
	}


	public HashSet<Agencia> getAgencias() {
		return agencias;
	}
}
