package cliente.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import cliente.entity.Cliente;
import control.Conexion;
import view.InputTypes;

public class ClientesIO {

	private Conexion conexion;
	private Scanner scanner;
	public ClientesIO(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void anadir() {
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
	
	public void eliminar() {

		int codigoCliente;
		codigoCliente = InputTypes.readInt(scanner, "Ingrese el codigo del Cliente que desea eliminar: ");

		try {
			conexion.consulta("DETELE FROM CLIENTE "
					+"WHERE CODIGOCLIENTE = ?" );

			conexion.getSentencia().setInt(1, codigoCliente);

			conexion.modificacion();


		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void actualizar() {
		Cliente cliente = ClienteIO.ingresar(scanner);
		int codigoCliente;
		try {
			conexion.consulta("UPDATE CLIENTE "
					+"SET NROCONTACTO= ?, "
					+"CI = ?,"
					+ "DIRECCION = ?"
					+"WHERE CODIGOACLIENTE = ? ");
			
			codigoCliente = InputTypes.readInt(scanner, "Ingrese el codigo del Cliente a actualizar Datos: ");
			
			conexion.getSentencia().setInt(1, cliente.getNroContacto());
			conexion.getSentencia().setInt(2, cliente.getCI());
			conexion.getSentencia().setString(3, cliente.getDireccion());
			conexion.getSentencia().setInt(4, codigoCliente);

			conexion.modificacion();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void listar() {
		ResultSet resultado;
		
		try {
			conexion.consulta("SELECT * FROM ADMINISTRATIVO ");

			resultado = conexion.resultado();

			while(resultado.next()) {
				System.out.print(resultado.getInt("CODIGOCLIENTE"));
				System.out.println(resultado.getString("\t"));
				System.out.print(resultado.getInt("NROCONTACTO"));
				System.out.println(resultado.getString("\t"));
				System.out.print(resultado.getInt("CI"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getString("DIRECCION"));
				System.out.println(resultado.getString("\t"));
			}
			resultado.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}

