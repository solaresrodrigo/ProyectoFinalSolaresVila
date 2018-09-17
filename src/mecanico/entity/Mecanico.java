package mecanico.entity;

public class Mecanico {

	
	private int codigoTaller;
	private int CI;
	private int nroContacto;
	
	public Mecanico(int codigoTaller, int cI, int nroContacto) {
		this.codigoTaller = codigoTaller;
		CI = cI;
		this.nroContacto = nroContacto;
	}

	public int getCodigoTaller() {
		return codigoTaller;
	}

	public void setCodigoTaller(int codigoTaller) {
		this.codigoTaller = codigoTaller;
	}

	public int getCI() {
		return CI;
	}

	public void setCI(int cI) {
		CI = cI;
	}

	public int getNroContacto() {
		return nroContacto;
	}

	public void setNroContacto(int nroContacto) {
		this.nroContacto = nroContacto;
	}
	
	
}
