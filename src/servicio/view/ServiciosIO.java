package servicio.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexion;
import servicio.entity.Servicio;
import view.InputTypes;

public class ServiciosIO {
	
	private Conexion conexion;
	private Scanner scanner;

	public ServiciosIO(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner= scanner;
	}
	
	public void anadir() {
		Servicio servicio = ServicioIO.ingresar(scanner);

		try {
			conexion.consulta("INSERT INTO SERVICIOS(PRECIO, TIPO) "
					+"VALUES(?,?) " );

			conexion.getSentencia().setInt(1, servicio.getPrecio());
			conexion.getSentencia().setString(2, servicio.getTipo());

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

		int codigoServicio;
		codigoServicio = InputTypes.readInt(scanner, "Ingrese el codigo del servicio a eliminar: ");

		try {
			conexion.consulta("DELETE FROM SERVICIOS "
					+"WHERE CODIGOSERVICIO = ?" );

			conexion.getSentencia().setInt(1, codigoServicio);

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
		Servicio servicio = ServicioIO.ingresar(scanner);
		int codigoServicio;
		try {
			conexion.consulta("UPDATE SERVICIOS "
					+"SET PRECIO= ?, TIPO = ? "
					+"WHERE CODIGOSERVICIO = ? ");
			
			codigoServicio = InputTypes.readInt(scanner, "Ingrese el codigo del servicio a actualizar: ");
			
			conexion.getSentencia().setInt(1, servicio.getPrecio());
			conexion.getSentencia().setString(2, servicio.getTipo());
			conexion.getSentencia().setInt(3, codigoServicio);

			conexion.modificacion();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void listar() {
		ResultSet resultado;
		try {
			conexion.consulta("SELECT * FROM SERVICIOS ");

			resultado = conexion.resultado();
			System.out.println("Codigo Taller\tCodigo Mecanico\tCI\tnro Contacto");
			System.out.println("Codigo Servicio\tPrecio\tTipo");

			while(resultado.next()) {
				int codigoServicio = resultado.getInt("CODIGOSERVICIO");
				int precio = resultado.getInt("PRECIO");
				String tipo = resultado.getString("TIPO");
				
				System.out.println(codigoServicio + "\t\t"+ precio +"\t\t"+tipo);

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
