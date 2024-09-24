package dominio;


import java.util.List;

import persistencia.PersonaDao;

abstract public class Persona {
	protected String DNI;
	protected String nombre;
	protected String apellidos;
	protected int edad;
	private PersonaDao personadao;

	public Persona(String DNI, String nombre, String apellidos, int edad) {
		this.DNI = DNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}

	public Persona() {
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

	abstract public List<Persona> leer();

	abstract public void escribir(List<Persona> personas);

}
