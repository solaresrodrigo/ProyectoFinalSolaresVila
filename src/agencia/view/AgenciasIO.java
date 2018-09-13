package agencia.view;

import java.sql.SQLException;
import java.util.Scanner;

import agencia.entity.Agencia;
import control.Conexion;

public class AgenciasIO {

	private Conexion conexion;
	private Scanner scanner;
	public AgenciasIO(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}
	
	public void anadir() {
		Agencia agencia = AgenciaIO.ingresar(scanner);
		
		try {
			conexion.consulta("INSERT INTO AGENCIA(DIRECCION, CIUDAD)"
					+ "VALUES(?,?)" );
			
			conexion.getSentencia().setString(1,agencia.getDireccion());
			conexion.getSentencia().setString(2,agencia.getCiudad());
			
			conexion.modificacion();
			conexion.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
}
