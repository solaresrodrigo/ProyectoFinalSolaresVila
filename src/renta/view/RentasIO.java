package renta.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexion;
import renta.entity.Renta;
import view.InputTypes;

public class RentasIO {
	
	private Conexion conexion;
	private Scanner scanner;

	public RentasIO(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner= scanner;
	}
	
	public void anadir() {
		Renta renta = RentaIO.ingresar(scanner);

		try {
			conexion.consulta("INSERT INTO SERVICIOS(CODIGOCLIENTE, CODIGOAGENCIA, FECHAINICIO, FECHAFIN) "
					+"VALUES(?,?,?,?) " );

			conexion.getSentencia().setInt(1, renta.getCodigoCliente());
			conexion.getSentencia().setInt(2, renta.getCodigoAgencia());
			conexion.getSentencia().setDate(3, renta.getFechaInicio());
			conexion.getSentencia().setDate(4, renta.getFechaFin());

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

		int codigoRenta;
		codigoRenta = InputTypes.readInt(scanner, "Ingrese el codigo de la renta a eliminar: ");

		try {
			conexion.consulta("DETELE FROM RENTAS "
					+"WHERE CODIGORENTA = ?" );

			conexion.getSentencia().setInt(1, codigoRenta);

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
		Renta renta = RentaIO.ingresar(scanner);
		int codigoRenta;
		try {
			conexion.consulta("UPDATE RENTAS "
					+"SET CODIGOCLIENTE= ?, "
					+"CODIGOAGENCIA = ? "
					+"WHERE CODIGORENTA = ? ");
			
			codigoRenta = InputTypes.readInt(scanner, "Ingrese el codigo de la renta a actualizar: ");
			
			conexion.getSentencia().setInt(1, renta.getCodigoCliente());
			conexion.getSentencia().setInt(2, renta.getCodigoAgencia());
			conexion.getSentencia().setInt(3, codigoRenta);

			conexion.modificacion();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void listar() {
		int codigoRenta;
		ResultSet resultado;
		codigoRenta = InputTypes.readInt(scanner, "Ingrese el codigo de la renta a listar: ");
		try {
			conexion.consulta("SELECT * FROM RENTAS "
					+"WHERE CODIGORENTA = ?" );

			conexion.getSentencia().setInt(1, codigoRenta);
			resultado = conexion.resultado();

			while(resultado.next()) {
				System.out.print(resultado.getInt("CODIGOCLIENTE"));
				System.out.println(resultado.getString("\t"));
				System.out.print(resultado.getInt("CODIGOAGENCIA"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getString("FECHAINICIO"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getString("FECHAFIN"));
				System.out.println(resultado.getString("\t"));
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
