package administrativo.entity;

public class Administrativo {

	private int codigoAgencia;
	private int CI;
	private int nroContacto;
	
	public Administrativo(int codigoAgencia, int CI, int nroContacto) {
		this.codigoAgencia = codigoAgencia;
		this.CI = CI;
		this.nroContacto = nroContacto;
	}

	public int getCodigoAgencia() {
		return codigoAgencia;
	}

	public void setCodigoAgencia(int codigoAgencia) {
		this.codigoAgencia = codigoAgencia;
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
