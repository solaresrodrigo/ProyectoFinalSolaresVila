package administrativo.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import administrativo.entity.Administrativo;
import control.Conexion;
import view.InputTypes;

public class AdministrativosIO {
	private Conexion conexion;
	private Scanner scanner;

	public AdministrativosIO(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner= scanner;
	}
	
	public void anadir() {
		Administrativo admin = AdministrativoIO.ingresar(scanner);

		try {
			conexion.consulta("INSERT INTO ADMINISTRATIVOS(CODIGOAGENCIA, CI, NROCONTACTO) "
					+"VALUES(?,?,?) " );

			conexion.getSentencia().setInt(1, admin.getCodigoAgencia());
			conexion.getSentencia().setInt(2, admin.getCI());
			conexion.getSentencia().setInt(3, admin.getNroContacto());

			conexion.modificacion();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void eliminar() {

		int codigoAdmin;
		codigoAdmin = InputTypes.readInt(scanner, "Ingrese el codigo del Administrador que desea eliminar: ");

		try {
			conexion.consulta("DELETE FROM ADMINISTRATIVOS "
					+"WHERE CODIGOADMINISTRATIVO = ?" );

			conexion.getSentencia().setInt(1, codigoAdmin);

			conexion.modificacion();


		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void actualizar() {
		Administrativo admin = AdministrativoIO.ingresar(scanner);
		int codigoAdmin;
		try {
			conexion.consulta("UPDATE ADMINISTRATIVOS "
					+"SET CODIGOAGENCIA= ?, "
					+"CI = ?,"
					+ "NROCONTACTO = ?"
					+"WHERE CODIGOADMINISTRATIVO = ? ");
			
			codigoAdmin = InputTypes.readInt(scanner, "Ingrese el codigo del Administrativo a actualizar Datos: ");
			
			conexion.getSentencia().setInt(1, admin.getCodigoAgencia());
			conexion.getSentencia().setInt(2, admin.getCI());
			conexion.getSentencia().setInt(3, admin.getNroContacto());
			conexion.getSentencia().setInt(4, codigoAdmin);

			conexion.modificacion();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void listar() {
		int codigoAgencia;
		ResultSet resultado;
		codigoAgencia = InputTypes.readInt(scanner, "Ingrese el codigo de la agencia de la "
				+ "cual quiere saber quienes la administran: ");
		try {
			conexion.consulta("SELECT * FROM ADMINISTRATIVOS "
					+"WHERE CODIGOAGENCIA = ? " );

			conexion.getSentencia().setInt(1, codigoAgencia);
			resultado = conexion.resultado();

			while(resultado.next()) {
				System.out.print(resultado.getInt("CODIGOAGENCIA"));
				System.out.println(resultado.getString("\t"));
				System.out.print(resultado.getInt("CODIGOADIMINISTRATIVO"));
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
