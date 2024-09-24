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
import dominio.Profesor;

public class ProfesorDao extends PersonaDao {

	public ProfesorDao() {

	}

	public List<Persona> leer() {
		List<Persona> personas = new ArrayList<Persona>();
		try {
		Scanner in = new Scanner(new FileReader("profesores.txt"));
		in.next();
		int contador = in.nextInt();
		// Leer profesor

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
			double sueldo=in.nextDouble();
			Persona persona = new Profesor(DNI, nombre, apellidos, edad,sueldo);
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
		PrintWriter out = new PrintWriter(new FileWriter("profesores.txt"));
		out.println("profesores:");
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
			out.println("sueldo:");
			String sueldo=((Profesor)personas.get(i)).getSueldo()+"";
			sueldo=sueldo.replace(".", ",");
			out.println(sueldo);

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
