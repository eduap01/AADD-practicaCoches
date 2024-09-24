package dominio;


import java.util.List;

import persistencia.AlumnoDao;

public class Alumno extends Persona {
	private Beca beca;
	private AlumnoDao alumnodao;

	public Alumno(String dNI, String nombre, String apellidos, int edad, Beca beca) {
		super(dNI, nombre, apellidos, edad);
		this.beca = beca;
		alumnodao = new AlumnoDao();
	}

	public Alumno() {
		alumnodao = new AlumnoDao();
	}

	public Beca getBeca() {
		return beca;
	}

	public void setBeca(Beca beca) {
		this.beca = beca;
	}

	public String toString() {

		return "Alumno [DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", beca cuota= " + beca.getCuota() + ", beca descripcion= " + beca.getDescripcion() + "]";
	}

	public List<Persona> leer() {
		return alumnodao.leer();
	}

	public void escribir(List<Persona> personas) {
		alumnodao.escribir(personas);
	}

}
