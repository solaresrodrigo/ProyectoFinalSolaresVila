package agencia.entity;

public class Agencia {

	private String direccion;
	private string ciudad;
	
	public Agencia(int codigoAgencia, String direccion, string ciudad) {
		this.codigoAgencia = codigoAgencia;
		this.direccion = direccion;
		this.ciudad = ciudad;
	}
	public int getCodigoAgencia() {
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
	public string getCiudad() {
		return ciudad;
	}
	public void setCiudad(string ciudad) {
		this.ciudad = ciudad;
	}
	
	
}
