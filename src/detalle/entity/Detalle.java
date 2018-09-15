package detalle.entity;

public class Detalle {

	private int codigoRenta;
	private int codigoServicio;
	
	public Detalle(int codigoRenta, int codigoServicio) {
		this.codigoRenta = codigoRenta;
		this.codigoServicio = codigoServicio;
	}
	public int getCodigoRenta() {
		return codigoRenta;
	}
	public void setCodigoRenta(int codigoRenta) {
		this.codigoRenta = codigoRenta;
	}
	public int getCodigoServicio() {
		return codigoServicio;
	}
	public void setCodigoServicio(int codigoServicio) {
		this.codigoServicio = codigoServicio;
	}
	
	
	
	
}
