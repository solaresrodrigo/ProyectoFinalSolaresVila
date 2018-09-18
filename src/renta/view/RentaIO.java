package renta.view;

import java.util.Calendar;
import java.util.Scanner;

import renta.entity.Renta;
import view.InputTypes;

public class RentaIO {
	
	public static Renta ingresar(Scanner scanner){

		int codigoCliente = InputTypes.readInt(scanner,"Codigo del cliente: ");
		int codigoAgencia = InputTypes.readInt(scanner,"Codigo de  la agencia: ");
		int codigoAuto = InputTypes.readInt(scanner,"Codigo del automovil: ");
		Calendar fechaInicio = InputTypes.readCalendar(scanner,"Fecha de inicio de la renta: (AA/MM/DD) ");
		Calendar fechaFin = InputTypes.readCalendar(scanner,"Fecha de fin de la renta: (AA/MM/DD) ");

		return new Renta(codigoCliente, codigoAgencia, codigoAuto, fechaInicio, fechaFin);
	}

}
