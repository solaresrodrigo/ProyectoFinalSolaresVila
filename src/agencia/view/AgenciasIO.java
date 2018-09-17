package agencia.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import agencia.entity.Agencia;
import control.Conexion;
import view.InputTypes;

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
	
	public void eliminar() {
		int codigoAgencia = InputTypes.readInt(scanner, "Ingrese el codigo de la Agencia que desea eliminar: ");
		
		try {
			conexion.consulta("DELETE FROM AGENCIA "
					+ "WHERE CODIGOAGENCIA = ?");
			conexion.getSentencia().setInt(1, codigoAgencia);
			
			conexion.modificacion();	
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void actualizar() {
		Agencia agencia = AgenciaIO.ingresar(scanner);
		int codigoAgencia;
		
		try {
			conexion.consulta("UPDATE AGENCIA "
					+ "SET DIRECCION = ?, CIUDAD = ? "
					+ "WHERE CODIGOAGENCIA=?");
			codigoAgencia = InputTypes.readInt(scanner, "Ingrese el codigo de la Agencia a actualizar: ");
			
			conexion.getSentencia().setString(1, agencia.getDireccion());
			conexion.getSentencia().setString(2, agencia.getCiudad());
			conexion.getSentencia().setInt(3, codigoAgencia);
			
			conexion.modificacion();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	
	public void listar() {
		String ciudad=InputTypes.readString(scanner, "Ingrese la ciudad de la que desea saber las agencias existentes: ");
		ResultSet resultado;
		
		try {
			conexion.consulta("SELECT * FROM AGENCIA "
					+ "WHERE CIUDAD = ? ");
			conexion.getSentencia().setString(1, ciudad);
			resultado = conexion.resultado();
			
			while(resultado.next()) {
				System.out.println(resultado.getString("CIUDAD"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("CODIGO AGENCIA"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getString("DIRECION"));
				System.out.println(resultado.getString("\t"));
			}
			resultado.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
