package automovil.view;

import java.sql.SQLException;
import java.util.Scanner;

import automovil.entity.Auto;
import control.Conexion;

public class AutosIO {

	private Conexion conexion;
	private Scanner scanner;
	
	public AutosIO(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner= scanner;
	}
	
	public void anadir() {
		Auto auto = AutoIO.ingresar(scanner);
		
		try {
			conexion.consulta("INSERT INTO AUTOS(PLACA,TIPO,CAPACIDAD,MODELO,ESTADO,PRECIO "
					+"VALUES(?,?,?,?,?,?) " );
			
			conexion.getSentencia().setInt(1, auto.getPlaca());
			conexion.getSentencia().setString(2, auto.getTipo());
			conexion.getSentencia().setInt(3, auto.getCapacidad());
			conexion.getSentencia().setInt(4, auto.getModelo());
			conexion.getSentencia().setString(5, auto.getEstado());
			conexion.getSentencia().setInt(6, auto.getPrecio());


			conexion.modificacion();
			conexion.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
	}
	
	/*public void eliminar() throws InexistenteException {
		
	}
	
	public void listar() {
		
	}*/
	
}
