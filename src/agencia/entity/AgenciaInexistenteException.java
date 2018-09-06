package agencia.entity;

public class AgenciaInexistenteException extends Exception{

	private static final long serialVersionUID = 1L;

	public AgenciaInexistenteException(){
		super("No la agencia mencionada.");
	}

}
