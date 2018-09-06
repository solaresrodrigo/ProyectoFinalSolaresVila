package agencia.entity;


public class Agencia {
	
	private int codigoAgencia;
	private String direccion;
	private String ciudad;
	
	
	public Agencia(int codigoAgencia, String direccion, String ciudad) {
		this.codigoAgencia = codigoAgencia;
		this.direccion = direccion;
		this.ciudad = ciudad;
	}


	public Integer getCodigoAgencia() {
		return codigoAgencia;
	}


	public void setCodigoAgencia(int codigoAgencia) {
		this.codigoAgencia = codigoAgencia;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	@Override
	public String toString() {
		return "Agencia [codigoAgencia=" + codigoAgencia + ", direccion=" + direccion + ", ciudad=" + ciudad + "]";
	}
	
	public int HashCode() {
		return this.getCodigoAgencia().hashCode();
		 
	}
	
	public boolean equals(Object objeto) {
		boolean respuesta = false;
		if(objeto != null) {
			Agencia agencia = (Agencia) objeto;
			if(this.getCodigoAgencia()==agencia.getCodigoAgencia()) {
				respuesta = true;
			}
		}
		return respuesta;
	}
	

}
