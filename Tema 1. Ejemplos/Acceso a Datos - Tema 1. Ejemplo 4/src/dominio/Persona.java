package dominio;

import java.io.Serializable;
import java.util.List;

import persistencia.PersonaDao;

public class Persona implements Serializable{
	public static final long serialVersionUID = 1L;
	private String DNI;
	private String nombre;
	private String apellidos;
	private int edad;
	private PersonaDao personadao;

	public Persona(String dNI, String nombre, String apellidos, int edad) {
		DNI = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		personadao = new PersonaDao();
	}

	public Persona() {
		personadao = new PersonaDao();
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Persona [DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + "]";
	}

	public List<Persona> leer() {
		return personadao.leer();
	}

	public void escribir(List<Persona> personas) {
		personadao.escribir(personas);
	}

}
