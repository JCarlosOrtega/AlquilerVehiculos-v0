package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Alquileres {

	private List<Alquiler> coleccionAlquileres;
	
	public Alquileres() {
		coleccionAlquileres = new ArrayList<>();
	}
	
	public List<Alquiler> get(){
		ArrayList<Alquiler> nuevaAlquileres = new ArrayList<>();
		for (Alquiler i:coleccionAlquileres) {
			nuevaAlquileres.add(i);
		}
		return nuevaAlquileres;
	}
	
	public List<Alquiler> get(Cliente cliente){
		
		
		ArrayList<Alquiler> alquilerCliente =  new ArrayList<>();
		for (Alquiler i:coleccionAlquileres) {
			if (i.getCliente().equals(cliente))
				alquilerCliente.add(i);
		}
		return alquilerCliente;
	}
	
	public List<Alquiler> get(Turismo turismo){
		
		
		ArrayList<Alquiler> alquilerTurismo = new ArrayList<>();
		for (Alquiler i:coleccionAlquileres) {
			if (i.getTurismo().equals(turismo))
				alquilerTurismo.add(i);
		}
		return alquilerTurismo;
	}
	
	
	public int getCantidad() {
		return coleccionAlquileres.size();
	}
	
	
	private void comprobarAlquiler (Cliente cliente, Turismo turismo, LocalDate fechaAlquiler) throws OperationNotSupportedException {
		for (Alquiler i:coleccionAlquileres) {
			if (i.getCliente().equals(cliente) && i.getFechaDevolucion() == null)
				throw new OperationNotSupportedException("ERROR: El cliente tiene otro alquiler.");
			else if (i.getTurismo().equals(turismo) && i.getFechaDevolucion() == null)
				throw new OperationNotSupportedException("ERROR: El turismo está alquilado.");
			else if (i.getCliente().equals(cliente) && i.getFechaDevolucion() != null && (i.getFechaDevolucion().isAfter(fechaAlquiler)))
				throw new OperationNotSupportedException("ERROR: El cliente tiene una fecha posterior.");
			else if (i.getTurismo().equals(turismo) && i.getFechaDevolucion() != null && i.getFechaDevolucion().isAfter(fechaAlquiler))
				throw new OperationNotSupportedException("ERROR: El turismo tiene una fecha posterior.");
				
			
			
			
		}
	}
	
	
	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
		}

		comprobarAlquiler(alquiler.getCliente(), alquiler.getTurismo(), alquiler.getFechaAlquiler());
		coleccionAlquileres.add(alquiler);
	}
	
	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) {
		if (alquiler == null)
			throw new NullPointerException();
		else if(fechaDevolucion == null)
			throw new DateTimeException("");
		else if (coleccionAlquileres.contains(alquiler))
			 coleccionAlquileres.get(coleccionAlquileres.indexOf(alquiler)).devolver(fechaDevolucion);
			
	}
	
	public Alquiler buscar (Alquiler alquiler) {
		if (alquiler == null) 
			throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
		
		else if (coleccionAlquileres.contains(alquiler)) 
			 return coleccionAlquileres.get(coleccionAlquileres.indexOf(alquiler));
		else 
			return null;
		
		
	}
	
	
	public void borrar (Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null)
			throw new NullPointerException("ERROR: No se puede borrar un alquiler nulo.");
		else if (coleccionAlquileres.contains(alquiler))
			coleccionAlquileres.remove(alquiler);
		else
			throw new OperationNotSupportedException("ERROR: No existe el alquiler a borrar.");
	}
	
	
	
	
	
}
