package cliente.view;

import java.util.Scanner;

import cliente.entity.Cliente;
import control.Conexion;

public class ClientesIO {

	private Conexion conexion;
	private Scanner scanner;
	public ClientesIO(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}
	
	public void añadir() {
		Cliente cliente = ClienteIO.ingresar(scanner);
		
		try {
			conexion.consulta("INSERT INTO CLIENTE(NROCONTACTO, CI, DIRECCION)"
					+ "VALUES(?,?,?)" );
			
			conexion.getSentencia().setInt(1,cliente.getNroContacto());
			conexion.getSentencia().setInt(2,cliente.getCI());
			conexion.getSentencia().setString(3,cliente.getDireccion());
			
			conexion.modificacion();
			conexion.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Throwable e) {
			e.printStackTrace();
		}
}
