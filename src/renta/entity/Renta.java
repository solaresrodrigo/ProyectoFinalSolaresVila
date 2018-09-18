package renta.entity;

import java.util.Calendar;

public class Renta {
	
	private int codigoCliente;
	private int codigoAgencia;
	private int codigoAuto;
	private Calendar fechaInicio;
	private Calendar fechaFin;
	
	public Renta(int codigoCliente, int codigoAgencia, int codigoAuto, Calendar fechaInicio, Calendar fechaFin) {
		this.codigoCliente = codigoCliente;
		this.codigoAgencia = codigoAgencia;
		this.codigoAuto = codigoAuto;
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

	public int getCodigoAuto() {
		return codigoAuto;
	}

	public void setCodigoAuto(int codigoAuto) {
		this.codigoAuto = codigoAuto;
	}

	public Calendar getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Calendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Calendar getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Calendar fechaFin) {
		this.fechaFin = fechaFin;
	}
}
