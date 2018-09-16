package cliente.entity;

public class Cliente {

	private int nroContacto;
	private int CI;
	private String direccion;
	public Cliente(int nroContacto, int CI, String direccion) {

		this.nroContacto = nroContacto;
		this.CI = CI;
		this.direccion = direccion;
	}
	public int getNroContacto() {
		return nroContacto;
	}
	public void setNroContacto(int nroContacto) {
		this.nroContacto = nroContacto;
	}
	public int getCI() {
		return CI;
	}
	public void setCI(int CI) {
		this.CI = CI;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
