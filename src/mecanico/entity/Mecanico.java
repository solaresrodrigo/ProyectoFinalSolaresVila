package mecanico.entity;


public class Mecanico {
	
	private int codigoMecanico;
	private int codigoTaller;
	private int ci;
	private int nroContacto;
	
	public Mecanico(int codigoMecanico, int codigoTaller, int ci, int nroContacto) {
		this.codigoMecanico = codigoMecanico;
		this.codigoTaller = codigoTaller;
		this.ci = ci;
		this.nroContacto = nroContacto;
	}

	public Integer getCodigoMecanico() {
		return codigoMecanico;
	}

	public void setCodigoMecanico(int codigoMecanico) {
		this.codigoMecanico = codigoMecanico;
	}

	public int getCodigoTaller() {
		return codigoTaller;
	}

	public void setCodigoTaller(int codigoTaller) {
		this.codigoTaller = codigoTaller;
	}

	public int getCi() {
		return ci;
	}

	public void setCi(int ci) {
		this.ci = ci;
	}

	public int getNroContacto() {
		return nroContacto;
	}

	public void setNroContacto(int nroContacto) {
		this.nroContacto = nroContacto;
	}

	@Override
	public String toString() {
		return "Mecanico [codigoMecanico=" + codigoMecanico + ", codigoTaller=" + codigoTaller + ", ci=" + ci
				+ ", nroContacto=" + nroContacto + "]";
	}

	public int HashCode() {
		return this.getCodigoMecanico().hashCode();
	}
	
	public boolean equals(Object objeto) {
		boolean respuesta = false;
		if(objeto != null) {
			Mecanico mecanico = (Mecanico) objeto;
			if(this.getCodigoMecanico()==mecanico.getCodigoMecanico()) {
				respuesta = true;
			}
		}
		return respuesta;
	}
	

}
