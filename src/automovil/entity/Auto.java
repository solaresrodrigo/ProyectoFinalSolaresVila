package automovil.entity;

public class Auto {
	
	private int placa;
	private String tipo;
	private int capacidad;
	private int modelo;
	private String estado;
	private int precio;
	
	public Auto(int placa, String tipo, int capacidad, int modelo, String estado, int precio) {
		this.placa = placa;
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.modelo = modelo;
		this.estado = estado;
		this.precio = precio;
	}


	public int getPlaca() {
		return placa;
	}

	public void setPlaca(int placa) {
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

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
	

}
