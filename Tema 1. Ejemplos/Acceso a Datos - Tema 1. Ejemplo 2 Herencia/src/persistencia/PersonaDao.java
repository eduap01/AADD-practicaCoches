package persistencia;


import java.util.List;

import dominio.Persona;

abstract public class PersonaDao {
	public PersonaDao() {
	}

	abstract public List<Persona> leer();

	abstract public void escribir(List<Persona> personas);

}
