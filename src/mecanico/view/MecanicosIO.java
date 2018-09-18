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
			conexion.consulta("INSERT INTO MECANICOS(CODIGOTALLER, CI, NROCONTACTO) "
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
			conexion.consulta("DELETE FROM MECANICOS "
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
			conexion.consulta("UPDATE MECANICOS "
					+"SET CODIGOTALLER= ?, CI = ?, NROCONTACTO = ? "
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
		ResultSet resultado;
		try {
			conexion.consulta("SELECT * FROM MECANICOS ");

			resultado = conexion.resultado();
			System.out.println("Codigo Taller\tCodigo Mecanico\tCI\tnro Contacto");
			while(resultado.next()) {
				
				int codigoTaller = resultado.getInt("CODIGOTALLER");
				int codigoMecanico = resultado.getInt("CODIGOMECANICO");
				int ci = resultado.getInt("CI");
				int nroContacto = resultado.getInt("NROCONTACTO");
				
				System.out.println(codigoTaller + "\t\t"+ codigoMecanico +"\t\t"+ci +"\t\t" +nroContacto);

			}
			resultado.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
