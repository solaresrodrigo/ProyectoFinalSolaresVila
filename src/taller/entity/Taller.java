package taller.entity;

public class Taller {

	private int codTaller;
	private String direccion;
	private String servicios;
	private int capacidad;
	public Taller(int codTaller, String direccion, String servicios, int capacidad) {
		this.codTaller = codTaller;
		this.direccion = direccion;
		this.servicios = servicios;
		this.capacidad = capacidad;
	}
	public Integer getCodTaller() {
		return codTaller;
	}
	public void setCodTaller(int codTaller) {
		this.codTaller = codTaller;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getServicios() {
		return servicios;
	}
	public void setServicios(String servicios) {
		this.servicios = servicios;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int hashCode() {
		return this.getCodTaller().hashCode();
	}

	public boolean equals(Object obj) {
		boolean respuesta = false;
		if(obj != null) {
			Taller taller = (Taller) obj;
			if(this.getCodTaller()==taller.getCodTaller()) {
				respuesta = true;
			}
		}
		return respuesta;
	}
	
	
	
}
