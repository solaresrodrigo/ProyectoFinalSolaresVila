package taller.entity;

public class Taller {

	private String direccion;
	private int capacidad;
	
	public Taller(String direccion, int capacidad) {
		this.direccion = direccion;
		this.capacidad = capacidad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	
}
