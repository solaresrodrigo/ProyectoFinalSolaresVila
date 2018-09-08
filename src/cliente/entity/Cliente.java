package cliente.entity;

public class Cliente {
	
	private int codigoCliente;
	private int nroContacto;
	private int ci;
	private String direccion;
	
	public Cliente(int codigoCliente, int nroContacto, int ci, String direccion) {
		this.codigoCliente = codigoCliente;
		this.nroContacto = nroContacto;
		this.ci = ci;
		this.direccion = direccion;
	}

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public int getNroContacto() {
		return nroContacto;
	}

	public void setNroContacto(int nroContacto) {
		this.nroContacto = nroContacto;
	}

	public int getCi() {
		return ci;
	}

	public void setCi(int ci) {
		this.ci = ci;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Cliente [codigoCliente=" + codigoCliente + ", nroContacto=" + nroContacto + ", ci=" + ci
				+ ", direccion=" + direccion + "]";
	}
	
	public int HashCode() {
		return this.getCodigoCliente().hashCode();
	}
	
	public boolean equals(Object objeto) {
		boolean respuesta = false;
		if(objeto != null) {
			Cliente cliente = (Cliente) objeto;
			if(this.getCodigoCliente()==cliente.getCodigoCliente()) {
				respuesta = true;
			}
		}
		return respuesta;
	}
	
	

}
