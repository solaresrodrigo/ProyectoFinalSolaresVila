package automovil.entity;

public class Auto {

	private Integer codAuto;
	private int codAgencia;
	private int codTaller;
	private String placa;
	private String tipo;
	private int capacidad;
	private int nroPuertas;
	private String modelo;
	private int kilometraje;
	private String estado;
	
	public Auto(int codAuto, int codAgencia, int codTaller, String placa, String tipo, int capacidad,
			int nroPuertas, String modelo, int kilometraje, String estado) {
		this.codAuto = codAuto;
		this.codAgencia = codAgencia;
		this.codTaller = codTaller;
		this.placa = placa;
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.nroPuertas = nroPuertas;
		this.modelo = modelo;
		this.kilometraje = kilometraje;
		this.estado = estado;
	}
	public Integer getCodAuto() {
		return codAuto;
	}
	public void setCodAuto(int codAuto) {
		this.codAuto = codAuto;
	}
	public int getCodAgencia() {
		return codAgencia;
	}
	public void setCodAgencia(int codAgencia) {
		this.codAgencia = codAgencia;
	}
	public int getCodTaller() {
		return codTaller;
	}
	public void setCodTaller(int codTaller) {
		this.codTaller = codTaller;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public int getNroPuertas() {
		return nroPuertas;
	}
	public void setNroPuertas(int nroPuertas) {
		this.nroPuertas = nroPuertas;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getKilometraje() {
		return kilometraje;
	}
	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	public int hashCode() {
		return this.getCodAuto().hashCode();
	}
	
	public boolean equals(Object obj) {
		boolean respuesta = false;
		if(obj != null) {
			Auto auto=(Auto) obj;
			if(this.getCodAuto()==auto.getCodAuto()) {
				respuesta = true;
			}
		}
		return respuesta;
	}
	
	public String toString() {
		return "Automovil [codAuto=" + codAuto + ", codAgencia=" + codAgencia + ", codTaller=" + codTaller + ", placa="
				+ placa + ", tipo=" + tipo + ", capacidad=" + capacidad + ", nroPuertas=" + nroPuertas + ", modelo="
				+ modelo + ", kilometraje=" + kilometraje +"Km"+ ", estado=" + estado + "]";
	}
	
}
