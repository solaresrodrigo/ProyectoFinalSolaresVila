package servicio.view;

import java.util.Iterator;
import java.util.Scanner;

import entity.InexistenteException;
import servicio.control.Servicios;
import servicio.entity.Servicio;
import view.InputTypes;

public class ServiciosIO {
	

	private Servicios servicios;
	private Scanner scanner;
	
	public ServiciosIO(Servicios servicios, Scanner scanner) {
		this.servicios = servicios;
		this.scanner = scanner;
	}
	
	public void añadir() {
		Servicio servicio = ServicioIO.ingresar(scanner);
		servicios.añadir(servicio);
	}
	
	public void eliminar() throws InexistenteException{
		int codigoServicio;
		codigoServicio = InputTypes.readInt(scanner, "Código del servicio: ");
		servicios.eliminar(codigoServicio);
	}

	public void listar() {
		Servicio servicio;

		for(Iterator<Servicio> iterator = servicios.getServicios().iterator(); iterator.hasNext();) {
			servicio = iterator.next();
			System.out.println(servicio);
		}
	}

	public Servicios getServicios() {
		return servicios;
	}

}
