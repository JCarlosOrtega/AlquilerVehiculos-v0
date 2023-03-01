package org.iesalandalus.programacion.alquilervehiculos.modelo;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Turismos;

public class Modelo {

	private Clientes clientes;
	private Turismos turismos;
	private Alquileres alquileres;
	
	
	public Modelo() {
		
	}
	
	public void comenzar() {
		clientes = new Clientes();
		turismos = new Turismos();
		alquileres = new Alquileres();
	}
	
	public void terminar() {
		System.out.println("_______________________");
		System.out.println("El modelo ha terminado.");
		
	}
	
	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		clientes.insertar(cliente);
	}
	
	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		turismos.insertar(turismo);
	}
	
	public void insertar (Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null)
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
		
		Cliente buscarCliente = buscar(alquiler.getCliente());
		Turismo buscarTurismo = buscar(alquiler.getTurismo());
		if (buscarCliente == null) 
			throw new OperationNotSupportedException("ERROR: El cliente del alquiler es nulo.");
		else if (buscarTurismo == null)
			throw new OperationNotSupportedException("ERROR: El turismo del alquiler es nulo.");
		else
			alquileres.insertar(alquiler);
	}
	
	public Cliente buscar(Cliente cliente) {
		Cliente buscaCliente = new Cliente(clientes.buscar(cliente));
		return buscaCliente;

	}

	public Turismo buscar(Turismo turismo) {
		Turismo buscaTurismo = new Turismo(turismos.buscar(turismo));
		return buscaTurismo;
	}

	public Alquiler buscar(Alquiler alquiler) {
		Alquiler buscaAlquiler = new Alquiler(alquileres.buscar(alquiler));
		return buscaAlquiler;
	}
	
	
	
	
	
	
	
	
	
}
