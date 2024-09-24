package dominio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import persistencia.AlumnoDao;

public class Alumno extends Persona {
	private int beca;
	private AlumnoDao alumnodao;

	public Alumno(String dNI, String nombre, String apellidos, int edad, int beca) {
		super(dNI, nombre, apellidos, edad);
		this.beca = beca;
		alumnodao = new AlumnoDao();
	}

	public Alumno() {
		alumnodao = new AlumnoDao();
	}

	public int getBeca() {
		return beca;
	}

	public void setBeca(int beca) {
		this.beca = beca;
	}

	@Override
	public String toString() {
		return "Alumno [DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", beca= "
				+ beca + "]";
	}

	public List<Persona> leer() {
		return alumnodao.leer();
	}

	public void escribir(List<Persona> personas) {
		alumnodao.escribir(personas);
	}

}
