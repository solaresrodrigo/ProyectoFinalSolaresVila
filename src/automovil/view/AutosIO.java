package automovil.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import automovil.entity.Auto;
import control.Conexion;
import view.InputTypes;

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
			conexion.consulta("INSERT INTO AUTOS(TIPO,CAPACIDAD,MODELO,ESTADO,PRECIO,PLACA "
					+"VALUES(?,?,?,?,?,?) " );

			conexion.getSentencia().setInt(1, auto.getPlaca());
			conexion.getSentencia().setString(2, auto.getTipo());
			conexion.getSentencia().setInt(3, auto.getCapacidad());
			conexion.getSentencia().setInt(4, auto.getModelo());
			conexion.getSentencia().setString(5, auto.getEstado());
			conexion.getSentencia().setInt(6, auto.getPrecio());


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

		int codigoAuto;
		codigoAuto = InputTypes.readInt(scanner, "Ingrese el codigo del automovil a eliminar: ");

		try {
			conexion.consulta("DETELE FROM AUTOS "
					+"WHERE CODIGOAUTO = ?" );

			conexion.getSentencia().setInt(1, codigoAuto);

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
		Auto auto = AutoIO.ingresar(scanner);
		int codigoAuto;
		try {
			conexion.consulta("UPDATE AUTOS "
					+"SET TIPO= ?, "
					+"CAPACIDAD = ? "
					+"MODELO = ? "
					+"ESTADO = ? "
					+"PRECIO = ? "
					+"PLACA = ? "
					+"WHERE CODIGOAUTO = ? ");
			
			codigoAuto = InputTypes.readInt(scanner, "Ingrese el codigo del automovil a actualizar: ");
			
			conexion.getSentencia().setString(1, auto.getTipo());
			conexion.getSentencia().setInt(2, auto.getCapacidad());
			conexion.getSentencia().setInt(3, auto.getModelo());
			conexion.getSentencia().setString(4, auto.getEstado());
			conexion.getSentencia().setInt(5, auto.getPrecio());
			conexion.getSentencia().setInt(6, auto.getPlaca());
			conexion.getSentencia().setInt(7, codigoAuto);

			conexion.modificacion();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listarPorCodigo() {
		int codigoAuto;
		ResultSet resultado;
		codigoAuto = InputTypes.readInt(scanner, "Ingrese el codigo del automovil a listar: ");
		try {
			conexion.consulta("SELECT * FROM AUTOS "
					+"WHERE CODIGOAUTO = ?" );

			conexion.getSentencia().setInt(1, codigoAuto);
			resultado = conexion.resultado();

			while(resultado.next()) {
				System.out.print(resultado.getInt("CODIGOAUTO"));
				System.out.println(resultado.getString("\t"));
				System.out.print(resultado.getString("TIPO"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("CAPACIDAD"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("MODELO"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getString("ESTADO"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("PRECIO"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("PLACA"));
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
	
	public void listarPorTipo() {
		String tipo;
		ResultSet resultado;
		tipo = InputTypes.readString(scanner, "Ingrese el tipo del automovil: ");
		try {
			conexion.consulta("SELECT * FROM AUTOS "
					+"WHERE TIPO = ?" );

			conexion.getSentencia().setString(1, tipo);
			resultado = conexion.resultado();

			while(resultado.next()) {
				System.out.print(resultado.getInt("CODIGOAUTO"));
				System.out.println(resultado.getString("\t"));
				System.out.print(resultado.getString("TIPO"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("CAPACIDAD"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("MODELO"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getString("ESTADO"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("PRECIO"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("PLACA"));
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
	

	public void listarPorCapacidad() {
		int capacidad;
		ResultSet resultado;
		capacidad = InputTypes.readInt(scanner, "Ingrese la capacidad del autoovil: ");
		try {
			conexion.consulta("SELECT * FROM AUTOS "
					+"WHERE CAPACIDAD = ?" );

			conexion.getSentencia().setInt(1, capacidad);
			resultado = conexion.resultado();

			while(resultado.next()) {
				System.out.print(resultado.getInt("CODIGOAUTO"));
				System.out.println(resultado.getString("\t"));
				System.out.print(resultado.getString("TIPO"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("CAPACIDAD"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("MODELO"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getString("ESTADO"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("PRECIO"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("PLACA"));
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
	
	public void listarPorModelo() {
		int modelo;
		ResultSet resultado;
		modelo = InputTypes.readInt(scanner, "Ingrese modelo del automovil: ");
		try {
			conexion.consulta("SELECT * FROM AUTOS "
					+"WHERE MODELO = ?" );

			conexion.getSentencia().setInt(1, modelo);
			resultado = conexion.resultado();

			while(resultado.next()) {
				System.out.print(resultado.getInt("CODIGOAUTO"));
				System.out.println(resultado.getString("\t"));
				System.out.print(resultado.getString("TIPO"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("CAPACIDAD"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("MODELO"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getString("ESTADO"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("PRECIO"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("PLACA"));
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
	
	public void listarPorEstado() {
		String estado;
		ResultSet resultado;
		estado = InputTypes.readString(scanner, "Alquilado o No alquilado: ");
		try {
			conexion.consulta("SELECT * FROM AUTOS "
					+"WHERE ESTADO = ?" );

			conexion.getSentencia().setString(1, estado);
			resultado = conexion.resultado();

			while(resultado.next()) {
				System.out.print(resultado.getInt("CODIGOAUTO"));
				System.out.println(resultado.getString("\t"));
				System.out.print(resultado.getString("TIPO"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("CAPACIDAD"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("MODELO"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getString("ESTADO"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("PRECIO"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("PLACA"));
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
	
	public void listarPorPrecio() {
		int precio;
		ResultSet resultado;
		precio = InputTypes.readInt(scanner, "Ingrese el precio por dia del automovil: ");
		try {
			conexion.consulta("SELECT * FROM AUTOS "
					+"WHERE PRECIO = ?" );

			conexion.getSentencia().setInt(1, precio);
			resultado = conexion.resultado();

			while(resultado.next()) {
				System.out.print(resultado.getInt("CODIGOAUTO"));
				System.out.println(resultado.getString("\t"));
				System.out.print(resultado.getString("TIPO"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("CAPACIDAD"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("MODELO"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getString("ESTADO"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("PRECIO"));
				System.out.println(resultado.getString("\t"));
				System.out.println(resultado.getInt("PLACA"));
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
