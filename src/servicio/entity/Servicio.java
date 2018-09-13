package servicio.entity;

public class Servicio {
	
	private int precio;
	private String tipo;
	
	public Servicio(int precio, String tipo) {
		this.precio = precio;
		this.tipo = tipo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
