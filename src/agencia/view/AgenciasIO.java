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
			conexion.consulta("INSERT INTO AGENCIAS(DIRECCION, CIUDAD)"
					+ "VALUES(?,?)" );
			
			conexion.getSentencia().setString(1,agencia.getDireccion());
			conexion.getSentencia().setString(2,agencia.getCiudad());
			
			conexion.modificacion();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void eliminar() {
		int codigoAgencia = InputTypes.readInt(scanner, "Ingrese el codigo de la Agencia que desea eliminar: ");
		
		try {
			conexion.consulta("DELETE FROM AGENCIAS "
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
			conexion.consulta("UPDATE AGENCIAS "
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
		ResultSet resultado;
		
		try {
			conexion.consulta("SELECT * FROM AGENCIAS " );
			resultado = conexion.resultado();
			System.out.println("Ciudad\t\tCodigo Agencia\t\tdireccion");
			while(resultado.next()) {
				String ciudad = resultado.getString("CIUDAD");
				int codigoAgencia = resultado.getInt("CODIGOAGENCIA");
				String direccion = resultado.getString("DIRECCION");
				System.out.println(ciudad + "\t\t"+ codigoAgencia +"\t\t"+direccion);
				
			}
			resultado.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
