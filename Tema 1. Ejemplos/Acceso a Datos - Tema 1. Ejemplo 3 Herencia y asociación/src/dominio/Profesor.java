package dominio;

import java.util.List;

import persistencia.ProfesorDao;

public class Profesor extends Persona {
	private double sueldo;
	private ProfesorDao profesordao;

	public Profesor(String dNI, String nombre, String apellidos, int edad, double sueldo) {
		super(dNI, nombre, apellidos, edad);
		this.sueldo = sueldo;
		profesordao = new ProfesorDao();
	}

	public Profesor() {
		profesordao = new ProfesorDao();
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Profesor [DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", sueldo= " + sueldo + "]";
	}

	public List<Persona> leer() {
		return profesordao.leer();
	}

	public void escribir(List<Persona> personas) {
		profesordao.escribir(personas);
	}

}
