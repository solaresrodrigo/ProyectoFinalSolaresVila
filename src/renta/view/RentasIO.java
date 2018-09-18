package renta.view;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexion;
import detalle.entity.Detalle;
import detalle.view.DetalleIO;
import renta.entity.Renta;
import servicio.view.ServiciosIO;
import view.InputTypes;

public class RentasIO {

	private Conexion conexion;
	private Scanner scanner;

	public RentasIO(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner= scanner;
	}

	public void anadir() {
		boolean servicio=true;
		int opcion;
		Renta renta = RentaIO.ingresar(scanner);
		try {
			conexion.consulta("INSERT INTO RENTAS(CODIGOCLIENTE, CODIGOAGENCIA, CODIGOAUTO, FECHAINICIO, FECHAFIN) "
					+"VALUES(?,?,?,?,?) " );

			conexion.getSentencia().setInt(1, renta.getCodigoCliente());
			conexion.getSentencia().setInt(2, renta.getCodigoAgencia());
			conexion.getSentencia().setInt(3, renta.getCodigoAuto());
			conexion.getSentencia().setDate(4, new java.sql.Date(renta.getFechaInicio().getTimeInMillis()));
			conexion.getSentencia().setDate(5, new java.sql.Date(renta.getFechaFin().getTimeInMillis()));


			conexion.modificacion();
			System.out.println("Su codigo de renta: "+ ultimoCodigoRenta());
			anadirServicio();

			while(servicio) {
				System.out.println("1. Anadir servicio.");
				System.out.println("0. Finalizar.");

				opcion = InputTypes.readInt(scanner, "Ingrese su opcion deseada: ");
				if(opcion >= 0 && opcion<= 1){
					switch(opcion) {
					case 0:
						servicio = false;
						break;
					case 1:
						System.out.println("Su codigo de renta: "+ ultimoCodigoRenta());
						anadirServicio();
						break;
					}
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public int ultimoCodigoRenta() {
		int codigoRenta=0;
		ResultSet resultado;
		try {
			conexion.consulta("SELECT R.CODIGORENTA FROM RENTAS R ORDER BY R.CODIGORENTA DESC LIMIT 1 ");

			resultado = conexion.resultado();
			
			while(resultado.next()) {
				codigoRenta = resultado.getInt("CODIGORENTA");
			}		
			resultado.close();
		} catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return codigoRenta;
	}

	public void anadirServicio() {
		try {
			ServiciosIO servicios = new ServiciosIO(conexion, scanner);
			servicios.listar();
			conexion.consulta("INSERT INTO DETALLES(CODIGOSERVICIO, CODIGORENTA) "
					+"VALUES(?,?) " );
			
			Detalle detalle = DetalleIO.ingresar(scanner);

			conexion.getSentencia().setInt(1, detalle.getCodigoServicio());
			conexion.getSentencia().setInt(2, detalle.getCodigoRenta());

			conexion.modificacion();
		}
		catch (SQLException e) {
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
			conexion.consulta("DELETE FROM RENTAS "
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
					+"SET CODIGOCLIENTE= ?, CODIGOAGENCIA = ?, CODIGOAUTO = ?, FECHAINICIO = ?, FECHAFIN = ? "
					+"WHERE CODIGORENTA = ? ");

			codigoRenta = InputTypes.readInt(scanner, "Ingrese el codigo de la renta a actualizar: ");

			conexion.getSentencia().setInt(1, renta.getCodigoCliente());
			conexion.getSentencia().setInt(2, renta.getCodigoAgencia());
			conexion.getSentencia().setInt(3, renta.getCodigoAuto());

			conexion.getSentencia().setDate(4, new java.sql.Date(renta.getFechaInicio().getTimeInMillis()));
			conexion.getSentencia().setDate(5, new java.sql.Date(renta.getFechaFin().getTimeInMillis()));
			conexion.getSentencia().setInt(6, codigoRenta);
			conexion.modificacion();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void listar() {
		ResultSet resultado;
		try {
			conexion.consulta("SELECT * FROM RENTAS ");

			resultado = conexion.resultado();
			System.out.println("Codigo Renta\tCodigo Cliente\tCodigo Agencia\tCodigo Auto\tInicio\t\tFin");
			while(resultado.next()) {
				int codigoRenta = resultado.getInt("CODIGORENTA");
				int codigoCliente = resultado.getInt("CODIGOCLIENTE");
				int codigoAgencia = resultado.getInt("CODIGOAGENCIA");
				int codigoAuto = resultado.getInt("CODIGOAUTO");
				Date Inicio = resultado.getDate("FECHAINICIO");
				Date Fin = resultado.getDate("FECHAFIN");

				System.out.println(codigoRenta + "\t\t"+ codigoCliente +"\t\t"+codigoAgencia +"\t\t" +codigoAuto+"\t\t"+Inicio+"\t\t"+Fin);

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
		int codigoRenta;
		ResultSet resultado;
		codigoRenta = InputTypes.readInt(scanner, "Ingrese el codigo de la renta a listar: ");
		try {
			conexion.consulta("SELECT * FROM RENTAS "
					+"WHERE CODIGORENTA = ?" );

			conexion.getSentencia().setInt(1, codigoRenta);
			resultado = conexion.resultado();
			System.out.println("Codigo Renta\tCodigo Cliente\tCodigo Agencia\tCodigo Auto\tInicio\t\tFin");

			while(resultado.next()) {
				codigoRenta = resultado.getInt("CODIGORENTA");
				int codigoCliente = resultado.getInt("CODIGOCLIENTE");
				int codigoAgencia = resultado.getInt("CODIGOAGENCIA");
				int codigoAuto = resultado.getInt("CODIGOAUTO");
				Date Inicio = resultado.getDate("FECHAINICIO");
				Date Fin = resultado.getDate("FECHAFIN");

				System.out.println(codigoRenta + "\t\t"+ codigoCliente +"\t\t"+codigoAgencia +"\t\t" +codigoAuto+"\t\t"+Inicio+"\t\t"+Fin);

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

	public void listarPorCliente() {
		int codigoCliente;
		ResultSet resultado;
		codigoCliente = InputTypes.readInt(scanner, "Ingrese el codigo del cliente a listar: ");
		try {
			conexion.consulta("SELECT r.codigoRenta, c.codigoCliente, r.codigoAgencia, r.codigoAuto, r.fechaInicio, r.fechaFin FROM RENTAS r "
					+ "INNER JOIN clientes c ON  r.codigoCliente = c.codigoCliente "
					+"WHERE R.CODIGOCLIENTE = ?" );

			conexion.getSentencia().setInt(1, codigoCliente);
			resultado = conexion.resultado();
			System.out.println("Codigo Renta\tCodigo Cliente\tCodigo Automovil\tInicio\t\tFin");
			while(resultado.next()) {
				int codigoRenta = resultado.getInt("CODIGORENTA");
				codigoCliente = resultado.getInt("CODIGOCLIENTE");
				int codigoAgencia = resultado.getInt("CODIGOAGENCIA");
				int codigoAuto = resultado.getInt("CODIGOAUTO");
				Date Inicio = resultado.getDate("FECHAINICIO");
				Date Fin = resultado.getDate("FECHAFIN");

				System.out.println(codigoRenta + "\t\t"+ codigoCliente +"\t\t"+codigoAgencia +"\t\t" +codigoAuto+"\t\t"+Inicio+"\t\t"+Fin);

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



	public void calcularMonto() {
		int codigoRenta;
		ResultSet resultado;
		codigoRenta = InputTypes.readInt(scanner, "Ingrese el codigo de la renta a listar: ");

		try {
			conexion.consulta("SELECT R.CODIGORENTA, R.CODIGOCLIENTE, A.PRECIO AS PRECIODIA, (A.PRECIO*(DATEDIFF(R.FECHAFIN,R.FECHAINICIO))) AS PRECIO ,(SUM(S.PRECIO)+A.PRECIO*(DATEDIFF(R.FECHAFIN,R.FECHAINICIO))) AS MONTO "
					+ "FROM CLIENTES C INNER JOIN RENTAS R "
					+ "ON C.CODIGOCLIENTE = R.CODIGOCLIENTE "
					+ "INNER JOIN AUTOS A ON R.CODIGOAUTO = A.CODIGOAUTO "
					+ "INNER JOIN DETALLES D ON d.codigoRenta = R.CODIGORENTA "
					+ "INNER JOIN SERVICIOS S ON S.CODIGOSERVICIO = D.CODIGOSERVICIO "
					+"WHERE R.CODIGORENTA = ?" );

			conexion.getSentencia().setInt(1, codigoRenta);
			resultado = conexion.resultado();
			System.out.println("Codigo Renta\tCodigo Cliente\tPrecioPorDia\tPrecio\t\tMonto");

			while(resultado.next()) {

				codigoRenta = resultado.getInt("CODIGORENTA");
				int codigoCliente = resultado.getInt("CODIGOCLIENTE");
				int precioDia = resultado.getInt("PRECIODIA");
				int precio = resultado.getInt("PRECIO");
				int monto = resultado.getInt("MONTO");

				System.out.println(codigoRenta + "\t\t"+ codigoCliente +"\t\t"+precioDia+"\t\t"+precio+"\t\t"+monto);
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
