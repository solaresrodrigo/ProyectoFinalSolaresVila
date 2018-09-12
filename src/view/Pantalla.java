package view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexion;

public class Pantalla {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);


		ResultSet resultado;
		try {
			Conexion conexion = new Conexion("root", "","serviciorenta");

			Menu.menu(scanner, conexion);


		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
