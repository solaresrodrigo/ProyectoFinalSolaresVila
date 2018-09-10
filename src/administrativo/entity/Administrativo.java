package administrativo.entity;

import automovil.entity.Auto;

public class Administrativo {

	private int codAdministrativo;
	private int codAgencia;
	private int CI;
	private int nroContacto;

	public Administrativo(int codAdministrativo, int codAgencia, int cI, int nroContacto) {
		this.codAdministrativo = codAdministrativo;
		this.codAgencia = codAgencia;
		CI = cI;
		this.nroContacto = nroContacto;
		this.dirección = dirección;
	}
	public Integer getCodAdministrativo() {
		return codAdministrativo;
	}
	public void setCodAdministrativo(int codAdministrativo) {
		this.codAdministrativo = codAdministrativo;
	}
	public int getCodAgencia() {
		return codAgencia;
	}
	public void setCodAgencia(int codAgencia) {
		this.codAgencia = codAgencia;
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
	
	@Override
	public int hashCode() {
		return this.getCodAdministrativo().hashcode();
	}
	@Override
	public boolean equals(Object obj) {
		boolean respuesta = false;
		if(obj != null) {
			Administrativo administrativo=(Administrativo) obj;
			if(this.getCodAdministrativo()==administrativo.getCodAdministrativo()) {
				respuesta = true;
			}
		}
		return respuesta
	}
	@Override
	public String toString() {
		return "Administrativo [codAdministrativo=" + codAdministrativo + ", codAgencia=" + codAgencia + ", CI=" + CI
				+ ", nroContacto=" + nroContacto + ", dirección=" + dirección + "]";
	}
	
	
	
}
