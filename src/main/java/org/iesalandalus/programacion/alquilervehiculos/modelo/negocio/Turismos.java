package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Turismos {

	private List<Turismo> coleccionTurismos;
	
	public Turismos() {
		coleccionTurismos = new ArrayList<>();
	}
	
	public List<Turismo> get(){
		ArrayList<Turismo> nuevaTurismos = new ArrayList<>();
		for (Turismo i:coleccionTurismos) {
			nuevaTurismos.add(i);
		}
		return nuevaTurismos;
		
	}
	
	public int getCantidad() {
		return coleccionTurismos.size();
		
	}
	
	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		if (turismo == null)
			throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
		else if (coleccionTurismos.contains(turismo))
			throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula.");
		else
			coleccionTurismos.add(turismo);
	}
	
	public Turismo buscar(Turismo turismo) {
		if (turismo == null)
			throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");
		else if (coleccionTurismos.contains(turismo))
			return coleccionTurismos.get(coleccionTurismos.indexOf(turismo));
		else
			return null;
	}
	
	public void borrar(Turismo turismo) throws OperationNotSupportedException {
		if (turismo == null)
			throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");
		else if (coleccionTurismos.contains(turismo))
			coleccionTurismos.remove(coleccionTurismos.indexOf(turismo));
		else
			throw new OperationNotSupportedException("ERROR: No se encuentra ese turismo.");
	}
	
	
	
	
}
