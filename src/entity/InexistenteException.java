package entity;

public class InexistenteException extends Exception{

	private static final long serialVersionUID = 1L;

	public InexistenteException(){
		super("No existe el elemento buscado.");
	}

}
