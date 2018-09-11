package renta.entity;


public class Renta {
	
	private int codigoRenta;
	private int codigoAutomovil;
	private int codigoCliente;
	private int codigoAdministrativo;
	private int codigoServicio;
	private int codigoAgencia;
	private int montoTotal;
	//private int fechaInicio;
	//private int fechaFin;
	
	
	
	public Renta(int codigoRenta, int codigoAutomovil, int codigoCliente, int codigoAdministrativo, int codigoServicio,
			int codigoAgencia, int montoTotal) {
		super();
		this.codigoRenta = codigoRenta;
		this.codigoAutomovil = codigoAutomovil;
		this.codigoCliente = codigoCliente;
		this.codigoAdministrativo = codigoAdministrativo;
		this.codigoServicio = codigoServicio;
		this.codigoAgencia = codigoAgencia;
		this.montoTotal = montoTotal;
	}

	public Integer getCodigoRenta() {
		return codigoRenta;
	}


	


	public void setCodigoRenta(int codigoRenta) {
		this.codigoRenta = codigoRenta;
	}


	public int getCodigoAutomovil() {
		return codigoAutomovil;
	}


	public void setCodigoAutomovil(int codigoAutomovil) {
		this.codigoAutomovil = codigoAutomovil;
	}


	public int getCodigoCliente() {
		return codigoCliente;
	}


	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}


	public int getCodigoServicio() {
		return codigoServicio;
	}


	public void setCodigoServicio(int codigoServicio) {
		this.codigoServicio = codigoServicio;
	}


	public int getCodigoAdministrativo() {
		return codigoAdministrativo;
	}


	public void setCodigoAdministrativo(int codigoAdministrativo) {
		this.codigoAdministrativo = codigoAdministrativo;
	}


	public int getCodigoAgencia() {
		return codigoAgencia;
	}


	public void setCodigoAgencia(int codigoAgencia) {
		this.codigoAgencia = codigoAgencia;
	}


	public int getMontoTotal() {
		return montoTotal;
	}


	public void setMontoTotal(int montoTotal) {
		this.montoTotal = montoTotal;
	}


	@Override
	public String toString() {
		return "Renta [codigoRenta=" + codigoRenta + ", codigoAutomovil=" + codigoAutomovil + ", codigoCliente="
				+ codigoCliente + ", codigoServicio=" + codigoServicio + ", codigoAdministrativo="
				+ codigoAdministrativo + ", codigoAgencia=" + codigoAgencia + ", montoTotal=" + montoTotal + "]";
	}
	
	@Override
	public int hashCode() {
		return this.getCodigoRenta().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		boolean respuesta = false;
		if(obj != null) {
			Renta renta=(Renta) obj;
			if(this.getCodigoRenta()==renta.getCodigoRenta()) {
				respuesta = true;
			}
		}
		return respuesta;
	}
	

}
