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
			conexion.consulta("INSERT INTO AUTOS(tipo, capacidad, modelo, estado, precio, placa) "
					+"VALUES(?,?,?,?,?,?) " );

			conexion.getSentencia().setString(1, auto.getTipo());
			conexion.getSentencia().setInt(2, auto.getCapacidad());
			conexion.getSentencia().setInt(3, auto.getModelo());
			conexion.getSentencia().setString(4, "No alquilado");
			conexion.getSentencia().setInt(5, auto.getPrecio());
			conexion.getSentencia().setInt(6, auto.getPlaca());


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
			conexion.consulta("DELETE FROM AUTOS "
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
					+"SET TIPO= ?, CAPACIDAD = ?, MODELO = ?, ESTADO = ?, PRECIO = ?, PLACA = ? "
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

	
	public void rentar() {
		String estado;
		int codigoAuto;
		estado = InputTypes.readString(scanner, "Ingrese el estado del autom[ovil: ");
		codigoAuto = InputTypes.readInt(scanner, "Ingrese el codigo del automovil: ");
		try {
			conexion.consulta("UPDATE AUTOS "
					+"SET ESTADO= ? "
					+"WHERE CODIGOAUTO = ? ");
			
			conexion.getSentencia().setString(1, estado);
			conexion.getSentencia().setInt(2, codigoAuto);

			conexion.modificacion();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void listar() {
		ResultSet resultado;
		try {
			conexion.consulta("SELECT * FROM AUTOS ");

			resultado = conexion.resultado();
			System.out.println("Codigo\tTipo\tCapacidad\tModelo\tEstado\tPrecio\tPlaca");
			while(resultado.next()) {
				int codigoAuto = resultado.getInt("CODIGOAUTO");
				String tipo = resultado.getString("TIPO");
				int capacidad=resultado.getInt("CAPACIDAD");
				int modelo = resultado.getInt("MODELO");
				String estado = resultado.getString("ESTADO");
				int precio = resultado.getInt("PRECIO");
				int placa = resultado.getInt("PLACA");
				System.out.println(codigoAuto + "\t"+ tipo +"\t"+capacidad +"\t" +modelo+"\t"+estado+"\t"+precio+"\t"+placa);
				
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
	
	public void listarPorCodigo() {
		int codigoAuto;
		ResultSet resultado;
		codigoAuto = InputTypes.readInt(scanner, "Ingrese el codigo del automovil a listar: ");
		try {
			conexion.consulta("SELECT * FROM AUTOS "
					+"WHERE CODIGOAUTO = ?" );

			conexion.getSentencia().setInt(1, codigoAuto);
			resultado = conexion.resultado();
			System.out.println("Codigo\tTipo\tCapacidad\tModelo\tEstado\tPrecio\tPlaca");
			while(resultado.next()) {
				codigoAuto = resultado.getInt("CODIGOAUTO");
				String tipo = resultado.getString("TIPO");
				int capacidad=resultado.getInt("CAPACIDAD");
				int modelo = resultado.getInt("MODELO");
				String estado = resultado.getString("ESTADO");
				int precio = resultado.getInt("PRECIO");
				int placa = resultado.getInt("PLACA");
				System.out.println(codigoAuto + "\t"+ tipo +"\t"+capacidad +"\t" +modelo+"\t"+estado+"\t"+precio+"\t"+placa);
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
			System.out.println("Codigo\tTipo\tCapacidad\tModelo\tEstado\tPrecio\tPlaca");

			while(resultado.next()) {
				int codigoAuto = resultado.getInt("CODIGOAUTO");
				tipo = resultado.getString("TIPO");
				int capacidad=resultado.getInt("CAPACIDAD");
				int modelo = resultado.getInt("MODELO");
				String estado = resultado.getString("ESTADO");
				int precio = resultado.getInt("PRECIO");
				int placa = resultado.getInt("PLACA");
				System.out.println(codigoAuto + "\t"+ tipo +"\t"+capacidad +"\t" +modelo+"\t"+estado+"\t"+precio+"\t"+placa);
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
			System.out.println("Codigo\tTipo\tCapacidad\tModelo\tEstado\tPrecio\tPlaca");

			while(resultado.next()) {
				int codigoAuto = resultado.getInt("CODIGOAUTO");
				String tipo = resultado.getString("TIPO");
				capacidad=resultado.getInt("CAPACIDAD");
				int modelo = resultado.getInt("MODELO");
				String estado = resultado.getString("ESTADO");
				int precio = resultado.getInt("PRECIO");
				int placa = resultado.getInt("PLACA");
				System.out.println(codigoAuto + "\t"+ tipo +"\t"+capacidad +"\t" +modelo+"\t"+estado+"\t"+precio+"\t"+placa);
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
			System.out.println("Codigo\tTipo\tCapacidad\tModelo\tEstado\tPrecio\tPlaca");

			while(resultado.next()) {
				int codigoAuto = resultado.getInt("CODIGOAUTO");
				String tipo = resultado.getString("TIPO");
				int capacidad=resultado.getInt("CAPACIDAD");
				modelo = resultado.getInt("MODELO");
				String estado = resultado.getString("ESTADO");
				int precio = resultado.getInt("PRECIO");
				int placa = resultado.getInt("PLACA");
				System.out.println(codigoAuto + "\t"+ tipo +"\t"+capacidad +"\t" +modelo+"\t"+estado+"\t"+precio+"\t"+placa);
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
			System.out.println("Codigo\tTipo\tCapacidad\tModelo\tEstado\tPrecio\tPlaca");

			while(resultado.next()) {
				int codigoAuto = resultado.getInt("CODIGOAUTO");
				String tipo = resultado.getString("TIPO");
				int capacidad=resultado.getInt("CAPACIDAD");
				int modelo = resultado.getInt("MODELO");
				estado = resultado.getString("ESTADO");
				int precio = resultado.getInt("PRECIO");
				int placa = resultado.getInt("PLACA");
				System.out.println(codigoAuto + "\t"+ tipo +"\t"+capacidad +"\t" +modelo+"\t"+estado+"\t"+precio+"\t"+placa);
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
			System.out.println("Codigo\tTipo\tCapacidad\tModelo\tEstado\tPrecio\tPlaca");

			while(resultado.next()) {
				int codigoAuto = resultado.getInt("CODIGOAUTO");
				String tipo = resultado.getString("TIPO");
				int capacidad=resultado.getInt("CAPACIDAD");
				int modelo = resultado.getInt("MODELO");
				String estado = resultado.getString("ESTADO");
				precio = resultado.getInt("PRECIO");
				int placa = resultado.getInt("PLACA");
				System.out.println(codigoAuto + "\t"+ tipo +"\t"+capacidad +"\t" +modelo+"\t"+estado+"\t"+precio+"\t"+placa);
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
