package devolucion.entity;

public class Devolucion {

	private int codDevolucion;
	private int codTaller;
	private String da�os;
	public Devolucion(int codDevolucion, int codTaller, String da�os) {
		this.codDevolucion = codDevolucion;
		this.codTaller = codTaller;
		this.da�os = da�os;
	}
	public Integer getCodDevolucion() {
		return codDevolucion;
	}
	public void setCodDevolucion(int codDevolucion) {
		this.codDevolucion = codDevolucion;
	}
	public int getCodTaller() {
		return codTaller;
	}
	public void setCodTaller(int codTaller) {
		this.codTaller = codTaller;
	}
	public String getDa�os() {
		return da�os;
	}
	public void setDa�os(String da�os) {
		this.da�os = da�os;
	}

	public int hashCode() {
		return this.getCodDevolucion().hashCode();
	}

	public boolean equals(Object obj) {
		boolean respuesta = false;
		if(obj != null) {
			Devolucion devolucion = (Devolucion) obj;
			if(this.getCodDevolucion()==devolucion.getCodTaller()) {
				respuesta = true;
			}
		}
		return respuesta;
	}

	public String toString() {
		return "Devolucion [codDevolucion=" + codDevolucion + ", codTaller=" + codTaller + ", da�os=" + da�os + "]";
	}
	
	
}
