package taller.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexion;
import taller.entity.Taller;
import view.InputTypes;

public class TalleresIO {
	
	private Conexion conexion;
	private Scanner scanner;

	public TalleresIO(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner= scanner;
	}
	
	public void anadir() {
		Taller taller = TallerIO.ingresar(scanner);

		try {
			conexion.consulta("INSERT INTO TALLERES(DIRECCION, CAPACIDAD) "
					+"VALUES(?,?) " );

			conexion.getSentencia().setString(1, taller.getDireccion());
			conexion.getSentencia().setInt(2, taller.getCapacidad());

			conexion.modificacion();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void eliminar() {

		int codigoTaller;
		codigoTaller = InputTypes.readInt(scanner, "Ingrese el codigo del taller a eliminar: ");

		try {
			conexion.consulta("DELETE FROM TALLERES "
					+"WHERE CODIGOTALLER = ?" );

			conexion.getSentencia().setInt(1, codigoTaller);

			conexion.modificacion();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void actualizar() {
		Taller taller = TallerIO.ingresar(scanner);
		int codigoTaller;
		try {
			conexion.consulta("UPDATE TALLERES "
					+"SET DIRECCION= ?, CAPACIDAD = ? " 
					+"WHERE CODIGOTALLER = ? ");
			
			codigoTaller = InputTypes.readInt(scanner, "Ingrese el codigo del taller a actualizar: ");
			
			conexion.getSentencia().setString(1, taller.getDireccion());
			conexion.getSentencia().setInt(2, taller.getCapacidad());
			conexion.getSentencia().setInt(3, codigoTaller);

			conexion.modificacion();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void listar() {
		ResultSet resultado;
		try {
			conexion.consulta("SELECT * FROM TALLERES ");

			resultado = conexion.resultado();
			System.out.println("Codigo Taller\tDireccion\tCapacidad");

			while(resultado.next()) {
				
				int codigoTaller = resultado.getInt("CODIGOTALLER");
				String direccion = resultado.getString("DIRECCION");
				int capacidad = resultado.getInt("CAPACIDAD");
				
				System.out.println(codigoTaller + "\t\t"+ direccion +"\t\t"+capacidad);
				
			}
			resultado.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
