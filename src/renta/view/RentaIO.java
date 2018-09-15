package renta.view;

import java.sql.Date;
import java.util.Scanner;

import renta.entity.Renta;
import view.InputTypes;

public class RentaIO {
	
	public static Renta ingresar(Scanner scanner){

		int codigoCliente = InputTypes.readInt(scanner,"Codigo del cliente: ");
		int codigoAgencia = InputTypes.readInt(scanner,"Codigo de  la agencia: ");
		int codigoAuto = InputTypes.readInt(scanner,"Codigo del automovil: ");
		Date fechaInicio = InputTypes.readDate(scanner,"Fecha de inicio de la renta: ");
		Date fechaFin = InputTypes.readDate(scanner,"Fecha de fin de la renta: ");

		return new Renta(codigoCliente, codigoAgencia, codigoAuto, fechaInicio, fechaFin);
	}

}
