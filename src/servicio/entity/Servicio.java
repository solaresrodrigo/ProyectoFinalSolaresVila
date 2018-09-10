package servicio.entity;


public class Servicio {
	
	private int codigoServicio;
	private String gps;
	private String seguro;
	private String asistenciaRemolque;
	
	
	public Servicio(int codigoServicio, String gps, String seguro, String asistenciaRemolque) {
		this.codigoServicio = codigoServicio;
		this.gps = gps;
		this.seguro = seguro;
		this.asistenciaRemolque = asistenciaRemolque;
	}


	public Integer getCodigoServicio() {
		return codigoServicio;
	}


	public void setCodigoServicio(int codigoServicio) {
		this.codigoServicio = codigoServicio;
	}


	public String getGps() {
		return gps;
	}


	public void setGps(String gps) {
		this.gps = gps;
	}


	public String getSeguro() {
		return seguro;
	}


	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}


	public String getAsistenciaRemolque() {
		return asistenciaRemolque;
	}


	public void setAsistenciaRemolque(String asistenciaRemolque) {
		this.asistenciaRemolque = asistenciaRemolque;
	}


	@Override
	public String toString() {
		return "Servicio [codigoServicio=" + codigoServicio + ", gps=" + gps + ", seguro=" + seguro
				+ ", asistenciaRemolque=" + asistenciaRemolque + "]";
	}
	
	public int HashCode() {
		return this.getCodigoServicio().hashCode();
	}
	
	public boolean equals(Object objeto) {
		boolean respuesta = false;
		if(objeto != null) {
			Servicio servicio = (Servicio) objeto;
			if(this.getCodigoServicio()==servicio.getCodigoServicio()) {
				respuesta = true;
			}
		}
		return respuesta;
	}

}
