package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Alquiler {

	private Cliente cliente;
	private Turismo turismo;
	
	private DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private final int PRECIO_DIA = 20;
	private LocalDate fechaAlquiler, fechaDevolucion;
	
	public Alquiler (Cliente cliente, Turismo turismo, LocalDate fechaAlquiler) {
		setCliente(cliente);
		setTurismo(turismo);
		setFechaAlquiler(fechaAlquiler);
		
	}
	
	public Alquiler (Alquiler alquiler) {
		if (alquiler == null)
			throw new NullPointerException("ERROR: El alquiler no puede ser nulo.");
		else {
		setCliente(alquiler.getCliente());
		setTurismo(alquiler.getTurismo());
		setFechaAlquiler(alquiler.getFechaAlquiler());
		}
	}

	public void devolver (LocalDate fechaDevolucion) {
		setFechaDevolucion(fechaDevolucion);
	}
	
	public int getPrecio() {
		int factorCilindrada;
		factorCilindrada=turismo.getCilindrada()/10;
		long numDias = DAYS.between(fechaAlquiler, fechaDevolucion);
		int precio =  ((factorCilindrada+PRECIO_DIA)*(int)numDias);
		return precio;
		
	}
	
	
	//Métodos Setters and Getters
	//---------------------------
	
	
	private void setCliente(Cliente cliente) {
		if (cliente == null)
			throw new NullPointerException("ERROR: El cliente no puede ser nulo.");
		this.cliente = cliente;
	}

	private void setTurismo(Turismo turismo) {
		if (turismo == null)
			throw new NullPointerException("ERROR: El turismo no puede ser nulo.");
		this.turismo = turismo;
	}

	private void setFechaAlquiler(LocalDate fechaAlquiler) {
		if (fechaAlquiler == null)
			throw new NullPointerException("ERROR: La fecha de alquiler no puede ser nula.");
		else if (fechaAlquiler.isAfter(LocalDate.now()))
			throw new DateTimeException("ERROR: La fecha de alquiler no puede ser posterior a hoy.");
		
		this.fechaAlquiler = fechaAlquiler;
	}

	private void setFechaDevolucion(LocalDate fechaDevolucion) {
		if (fechaDevolucion == null)
			throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
		else if (fechaDevolucion.isBefore(fechaAlquiler)||fechaDevolucion.equals(fechaAlquiler))
			throw new DateTimeException("ERROR:La fecha de devolución no puede ser antes que la de alquiler.");
		else if (fechaDevolucion.isAfter(LocalDate.now()))
				throw new DateTimeException("ERROR: La fecha de devolución no puede ser posterior a hoy.");
		this.fechaDevolucion = fechaDevolucion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Turismo getTurismo() {
		return turismo;
	}

	public LocalDate getFechaAlquiler() {
		return fechaAlquiler;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, fechaAlquiler, turismo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alquiler other = (Alquiler) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fechaAlquiler, other.fechaAlquiler)
				&& Objects.equals(turismo, other.turismo);
	}

	@Override
	public String toString() {
		return "Alquiler [cliente=" + cliente + ", turismo=" + turismo + ", fechaAlquiler=" + fechaAlquiler.format(FORMATO_FECHA)
				+ ", fechaDevolucion=" + fechaDevolucion.format(FORMATO_FECHA) + "]";
	}
	
	
	
	
	
	
	
	
	
}
