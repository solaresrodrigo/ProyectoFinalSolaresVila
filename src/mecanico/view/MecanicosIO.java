package mecanico.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexion;
import mecanico.entity.Mecanico;
import view.InputTypes;

public class MecanicosIO {

	private Conexion conexion;
	private Scanner scanner;

	public MecanicosIO(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner= scanner;
	}
	
	public void anadir() {
		Mecanico mecanico = MecanicoIO.ingresar(scanner);

		try {
			conexion.consulta("INSERT INTO ADMINISTRATIVO(CODIGOTALLER, CI, NROCONTACTO) "
					+"VALUES(?,?,?) " );

			conexion.getSentencia().setInt(1, mecanico.getCodigoTaller());
			conexion.getSentencia().setInt(2, mecanico.getCI());
			conexion.getSentencia().setInt(3, mecanico.getNroContacto());

			conexion.modificacion();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void eliminar() {

		int codigoMecanico= InputTypes.readInt(scanner, "Ingrese el codigo del Mecanico que desea eliminar: ");

		try {
			conexion.consulta("DETELE FROM MECANICO "
					+"WHERE CODIGOMECANICO = ?" );

			conexion.getSentencia().setInt(1, codigoMecanico);

			conexion.modificacion();


		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void actualizar() {
		Mecanico mecanico = MecanicoIO.ingresar(scanner);
		int codigoMecanico;
		try {
			conexion.consulta("UPDATE MECANICO "
					+"SET CODIGOTALLER= ?, "
					+"CI = ?,"
					+ "NROCONTACTO = ?"
					+"WHERE CODIGOMECANICO = ? ");
			
			codigoMecanico = InputTypes.readInt(scanner, "Ingrese el codigo del Mecanico a actualizar Datos: ");
			
			conexion.getSentencia().setInt(1, mecanico.getCodigoTaller());
			conexion.getSentencia().setInt(2, mecanico.getCI());
			conexion.getSentencia().setInt(3, mecanico.getNroContacto());
			conexion.getSentencia().setInt(4, codigoMecanico);

			conexion.modificacion();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void listar() {
		int codigoTaller;
		ResultSet resultado;
		codigoTaller = InputTypes.readInt(scanner, "Ingrese el codigo del taller: ");
		try {
			conexion.consulta("SELECT * FROM MECANICO "
					+"WHERE CODIGOTALLER = ?" );

			conexion.getSentencia().setInt(1, codigoTaller);
			resultado = conexion.resultado();

			while(resultado.next()) {
				System.out.print(resultado.getInt("CODIGOTALLER"));
				System.out.println(resultado.getString("\t"));
				System.out.print(resultado.getInt("CODIGOMECANICO"));
				System.out.println(resultado.getString("\t"));
				System.out.print(resultado.getInt("CI"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("NROCONTACTO"));
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
