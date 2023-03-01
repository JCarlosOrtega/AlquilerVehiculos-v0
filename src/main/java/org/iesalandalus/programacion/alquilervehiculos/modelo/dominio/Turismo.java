package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public class Turismo {

	private String ER_MATRICULA = "^[0-9]{1,4}(?!.*(LL|CH))[BCDFGHJKLMNPRSTVWXYZ]{3}";
	private String ER_MARCA = "^[A-Za-z]+([\\s-][A-Za-z]+)*$";
	private String marca, modelo, matricula;
	private int cilindrada = 0;
	
	
	
	public Turismo (String marca, String modelo, int cilindrada, String matricula) {
		setMarca(marca);
		setModelo(modelo);
		setCilindrada(cilindrada);
		setMatricula(matricula);
	}
	
	public Turismo (Turismo turismo) {
		if (turismo == null)
			throw new NullPointerException("ERROR: Un turismo no puede ser nulo.");
		else
			setMarca(turismo.getMarca());
			setModelo(turismo.getModelo());
			setCilindrada(turismo.getCilindrada());
			setMatricula(turismo.getMatricula());
			
	}
	
	public static Turismo getTurismoConMatricula (String matricula) {
		Turismo turismo;
		if (matricula == null)
			throw new NullPointerException("ERROR: La matrícula no puede ser nula.");
		else if (matricula.trim().equals(""))
			throw new IllegalArgumentException("ERROR: La matricula no puede estar vacía.");
		else
		
			turismo = new Turismo ("Marca", "Modelo", 1, matricula);
		
		return turismo;
		
	}
	
	
	
	
	
	
	
	
	
	//Setters and getters
	private void setMarca(String marca) {
		if (marca == null) {
			throw new NullPointerException("ERROR: La marca de un turismo no puede ser nula.");
		}else if (marca.matches(ER_MARCA) == false) {
			throw new IllegalArgumentException("ERROR: La marca del turismo no tiene un formato válido.");
		}

		else if (marca.trim().equals("")) {
			throw new IllegalArgumentException("ERROR: La marca de un turismo no puede estar vacía.");
		} else {
			this.marca = marca;
		}
		
	}
	private void setModelo(String modelo) {
		if (modelo == null) {
			throw new NullPointerException("ERROR: El modelo de un turismo no puede ser nulo.");
		}else if (modelo.trim().equals("")) {
			throw new IllegalArgumentException("ERROR: El modelo de un turismo no puede estar vacío.");
		}else {
		
		this.modelo = modelo;
		}
	}
	private void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	private void setCilindrada(int cilindrada) {
		if (cilindrada <= 0 || cilindrada > 5000)
			throw new IllegalArgumentException("ERROR: La cilindrada no puede ser esa.");
		else
			
		this.cilindrada = cilindrada;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public String getMatricula() {
		return matricula;
	}
	public int getCilindrada() {
		return cilindrada;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turismo other = (Turismo) obj;
		return Objects.equals(matricula, other.matricula);
	}

	@Override
	public String toString() {
		return "Turismo [getMarca()=" + getMarca() + ", getModelo()=" + getModelo() + ", getMatricula()="
				+ getMatricula() + ", getCilindrada()=" + getCilindrada() + "]";
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
