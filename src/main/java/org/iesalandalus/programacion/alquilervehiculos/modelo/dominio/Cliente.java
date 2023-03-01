 package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {

	private static final String ER_NOMBRE = "^[A-Z][a-zñáéíóú]+([\\s][A-Z][a-zñáéíóú]+)*$", ER_DNI = "([0-9]{8})([a-zA-Z])", ER_TELEFONO = "[0-9]{9}";

	private String nombre, dni, telefono;

	public Cliente(String nombre, String dni, String telefono) {
		setNombre(nombre);
		setDni(dni);
		setTelefono(telefono);

	}

	public Cliente(Cliente cliente) {
		if (cliente == null)
			throw new NullPointerException("ERROR: No es posible copiar un cliente nulo.");
		else
			setNombre(cliente.getNombre());
			setDni(cliente.getDni());
			setTelefono(cliente.getTelefono());

	}
	
	public static Cliente getClienteConDni (String dni) {
		
		Cliente cliente = new Cliente ("Nombre", dni, "950123456");
		
		return cliente;
		
	}

	private boolean comprobarLetraDni(String dni) {
		// falta si es nulo o si es diferente al patron
		Pattern p = Pattern.compile(ER_DNI);
		Matcher m;
		m = p.matcher(dni);
		m.matches();
		int numDni = Integer.parseInt(m.group(1));
		char letraDni = dni.charAt(8);
		switch (numDni % 23) {
		case 0:
			if (letraDni == 'T' || letraDni == 't')
				return true;
			else
				return false;
		case 1:
			if (letraDni == 'R' || letraDni == 'r')
				return true;
			else
				return false;

		case 2:
			if (letraDni == 'W' || letraDni == 'w')
				return true;
			else
				return false;

		case 3:
			if (letraDni == 'A' || letraDni == 'a')
				return true;
			else
				return false;

		case 4:
			if (letraDni == 'G' || letraDni == 'g')
				return true;
			else
				return false;

		case 5:
			if (letraDni == 'M' || letraDni == 'm')
				return true;
			else
				return false;

		case 6:
			if (letraDni == 'Y' || letraDni == 'y')
				return true;
			else
				return false;

		case 7:
			if (letraDni == 'F' || letraDni == 'f')
				return true;
			else
				return false;

		case 8:
			if (letraDni == 'P' || letraDni == 'p')
				return true;
			else
				return false;

		case 9:
			if (letraDni == 'D' || letraDni == 'd')
				return true;
			else
				return false;

		case 10:
			if (letraDni == 'X' || letraDni == 'x')
				return true;
			else
				return false;

		case 11:
			if (letraDni == 'B' || letraDni == 'b')
				return true;
			else
				return false;

		case 12:
			if (letraDni == 'N' || letraDni == 'n')
				return true;
			else
				return false;

		case 13:
			if (letraDni == 'J' || letraDni == 'j')
				return true;
			else
				return false;

		case 14:
			if (letraDni == 'Z' || letraDni == 'z')
				return true;
			else
				return false;

		case 15:
			if (letraDni == 'S' || letraDni == 's')
				return true;
			else
				return false;

		case 16:
			if (letraDni == 'Q' || letraDni == 'q')
				return true;
			else
				return false;

		case 17:
			if (letraDni == 'V' || letraDni == 'v')
				return true;
			else
				return false;

		case 18:
			if (letraDni == 'H' || letraDni == 'h')
				return true;
			else
				return false;

		case 19:
			if (letraDni == 'L' || letraDni == 'l')
				return true;
			else
				return false;

		case 20:
			if (letraDni == 'C' || letraDni == 'c')
				return true;
			else
				return false;

		case 21:
			if (letraDni == 'K' || letraDni == 'k')
				return true;
			else
				return false;

		case 22:
			if (letraDni == 'E' || letraDni == 'e')
				return true;
			else
				return false;

		default:
			return false;
		}

	}


	// ----------------------------
	// Métodos getters and setters
	private void setDni(String dni) {
		if (dni == null) {
			throw new NullPointerException("ERROR: El dni de un cliente no puede ser nulo.");
		} else if (comprobarLetraDni(dni) == false) {
			throw new IllegalArgumentException("ERROR: El Dni introducido es incorrecto");
		} else {

			this.dni = dni;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null) {
			throw new NullPointerException("ERROR: El nombre de un cliente no puede ser nulo.");
		}else if (nombre.matches(ER_NOMBRE) == false) {
			throw new IllegalArgumentException("ERROR: El nombre del cliente no tiene un formato válido.");
		}

		else if (nombre.trim().equals("")) {
			throw new IllegalArgumentException("ERROR: El nombre de un cliente no puede estar vacío.");
		} else {
			this.nombre = nombre;
		}
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		if (telefono == null) {
			throw new NullPointerException("ERROR: El teléfono de un cliente no puede ser nulo.");
		} else if (telefono.matches(ER_TELEFONO) == false) {
			throw new IllegalArgumentException("ERROR: El teléfono del cliente no tiene un formato válido.");
		} else {
			this.telefono = telefono;
		}
	}

	public String getDni() {
		return dni;
	}

	// -----------------------------------------

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return "Cliente [getNombre()=" + getNombre() + ", getTelefono()=" + getTelefono() + ", getDni()=" + getDni()
				+ "]";
	}

}
