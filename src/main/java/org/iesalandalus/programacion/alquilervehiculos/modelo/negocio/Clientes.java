package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;

public class Clientes {

	private List<Cliente> coleccionClientes;
	
	public Clientes() {
		coleccionClientes = new ArrayList<>();
	}
	
	public List<Cliente> get(){
		ArrayList<Cliente> nuevaClientes = new ArrayList<>();
		for (Cliente i:coleccionClientes) {
			nuevaClientes.add(i);
		}
		return nuevaClientes; 
	}
	
	public int getCantidad() {
		return coleccionClientes.size();
		
	}
	
	public void insertar (Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null)
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		else if (coleccionClientes.contains(cliente))
			throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese dni.");
		else
			coleccionClientes.add(cliente);
	}
	
	public Cliente buscar (Cliente cliente) {
		if (cliente == null)
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
		else if (coleccionClientes.contains(cliente))
			return coleccionClientes.get(coleccionClientes.indexOf(cliente));
		else
			return null;
	}
	
	
	public void borrar (Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null)
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
		else if (coleccionClientes.contains(cliente))
			coleccionClientes.remove(coleccionClientes.indexOf(cliente));
		else
			throw new OperationNotSupportedException("ERROR: No se encuentra ese cliente.");
			
	}
	
	public void modificar (Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		if (cliente == null || nombre == null || telefono == null)
			throw new NullPointerException("ERROR: No se puede modificar un cliente nulo.");
		else if (nombre.trim().equals("")|| telefono.trim().equals(""))
			throw new OperationNotSupportedException("ERROR: El cliente no puede estar en blanco");
		else if (coleccionClientes.contains(cliente))
			coleccionClientes.get(coleccionClientes.indexOf(cliente)).setNombre(nombre);
			coleccionClientes.get(coleccionClientes.indexOf(cliente)).setTelefono(telefono);
	
	}
	
	
	
	
	
	
}
