package persistencia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dominio.Alumno;
import dominio.Persona;

public class AlumnoDao extends PersonaDao {

	public AlumnoDao() {

	}

	public List<Persona> leer() {
		List<Persona> personas = new ArrayList<Persona>();
		try {
			Scanner in = new Scanner(new FileReader("Alumnos.txt"));
			in.next();
			int contador = in.nextInt();
			// Leer alumnos

			for (int i = 0; i < contador; i++) {
				in.next();
				String DNI = in.next();
				in.next();
				in.nextLine();
				String nombre = in.nextLine();
				in.next();
				in.nextLine();
				String apellidos = in.nextLine();
				in.next();
				int edad = in.nextInt();
				in.next();
				int beca = in.nextInt();
				Persona persona = new Alumno(DNI, nombre, apellidos, edad, beca);
				personas.add(persona);
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fichero especificado no existe");
		} catch (IOException e) {
			System.out.println("Excepcion de entrada/salida:" + e.toString());
			System.out.println(e.getMessage());
		}

		return personas;
	}

	public void escribir(List<Persona> personas) {
		try {
			PrintWriter out = new PrintWriter(new FileWriter("alumnos.txt"));
			out.println("alumnos:");
			out.println(personas.size());
			for (int i = 0; i < personas.size(); i++) {
				out.println("dni:");
				out.println(personas.get(i).getDNI());
				out.println("nombre:");
				out.println(personas.get(i).getNombre());
				out.println("apellidos:");
				out.println(personas.get(i).getApellidos());
				out.println("edad:");
				out.println(personas.get(i).getEdad());
				out.println("beca:");
				out.println(((Alumno) personas.get(i)).getBeca());

			}
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fichero especificado no existe");
		} catch (IOException e) {
			System.out.println("Excepcion de entrada/salida:" + e.toString());
			System.out.println(e.getMessage());
		}

	}

}
