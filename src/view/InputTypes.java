package view;

import java.sql.Date;
import java.util.Scanner;

public class InputTypes {

	public static int readInt(Scanner scanner, String msg) {
		int valor=0;

		while(true) {
			try {
				System.out.print(msg);
				valor=scanner.nextInt();
				scanner.nextLine();
				break;
			}
			catch(java.util.InputMismatchException e){
				System.out.print("El valor debe ser un número entero: ");
				scanner.nextLine();
			}
		}
		return valor;	 
	}

	public static double readDouble(Scanner scanner, String msg) {
		double valor=0;

		while(true) {
			try {
				System.out.print(msg);
				valor=scanner.nextDouble();
				scanner.nextLine();
				break;
			}
			catch(java.util.InputMismatchException e){
				System.out.print("El valor debe ser un número.");
				scanner.nextLine();
			}
		}
		return valor;	
	}

	public static String readString(Scanner scanner, String msg) { 
		String texto;
		System.out.print(msg);
		texto=scanner.nextLine();
		return texto;	
	}

	public static Date readDate(Scanner scanner, String msg) {
		Date fecha=null;
		int year, month, date;

		while(true) {
			try {
				System.out.print(msg);
				year=scanner.nextInt();
				month=scanner.nextInt();
				date=scanner.nextInt();
				fecha.setYear(year);
				fecha.setMonth(month);
				fecha.setDate(date);
				break;
			}
			catch(java.util.InputMismatchException e) {
				System.out.print("El valor debe ser un número entero.");
				scanner.nextLine();
			}

		}
		return fecha;
		
	}

}
