package devolucion.entity;

public class Devolucion {

	private int codDevolucion;
	private int codTaller;
	private String daños;
	public Devolucion(int codDevolucion, int codTaller, String daños) {
		this.codDevolucion = codDevolucion;
		this.codTaller = codTaller;
		this.daños = daños;
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
	public String getDaños() {
		return daños;
	}
	public void setDaños(String daños) {
		this.daños = daños;
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
		return "Devolucion [codDevolucion=" + codDevolucion + ", codTaller=" + codTaller + ", da�os=" + daños + "]";
	}
	
	
}
