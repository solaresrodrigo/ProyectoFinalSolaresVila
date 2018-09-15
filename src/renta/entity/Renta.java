package renta.entity;

import java.sql.Date;

public class Renta {
	
	private int codigoCliente;
	private int codigoAgencia;
	private Date fechaInicio;
	private Date fechaFin;
	
	
	public Renta(int codigoCliente, int codigoAgencia, Date fechaInicio, Date fechaFin) {
		this.codigoCliente = codigoCliente;
		this.codigoAgencia = codigoAgencia;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	public int getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public int getCodigoAgencia() {
		return codigoAgencia;
	}
	public void setCodigoAgencia(int codigoAgencia) {
		this.codigoAgencia = codigoAgencia;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	

}
