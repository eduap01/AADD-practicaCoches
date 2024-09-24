package presentacion;

import java.util.List;
import java.util.Scanner;

import dominio.Alumno;
import dominio.Persona;
import dominio.Profesor;
import util.Util;

public class Principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Men� principal
		boolean seguir = true;
		do {

			String mensaje = "Men�\n";
			mensaje += "1. Mostrar todas las personas\n";
			mensaje += "2. Buscar una persona\n";
			mensaje += "3. A�adir una persona\n";
			mensaje += "4. Modificar una persona\n";
			mensaje += "5. Eliminar\n";
			mensaje += "6. Log out\n";
			int opcion = Util.escribirNumeroEntero(mensaje);

			switch (opcion) {
			case 1:
				mostrarTodos();
				break;
			case 2:
				buscarPersona();
				break;
			case 3:
				añadirPersona();
				break;
			case 4:
				modificarPersona();
				break;
			case 5:
				eliminarPersona();
				break;
			case 6:
				seguir = false;
				System.out.println("Hasta pronto");
				break;
			default:
				System.out.println("Introduce un n�mero de 1 a 6");
			}

		} while (seguir);
	}

	public static void modificarPersona() {
		// Cargar datos
		Persona profesor = new Profesor();
		Persona alumno = new Alumno();
		List<Persona> alumnos = alumno.leer();
		List<Persona> profesores = profesor.leer();
		Scanner sc = new Scanner(System.in);

		boolean formatoDNI = false;
		String DNI="";
		do {
			System.out.println("Introduce el DNI");
			DNI = sc.next();
			formatoDNI = Util.compruebaDni(DNI);
			if(formatoDNI==false) {
				System.out.println("El DNI debe tener 8 digitos y una letra may�scula");
			}
		} while (formatoDNI == false);
		boolean encontrado = false;
		for (int i = 0; i < profesores.size(); i++) {
			if (profesores.get(i).getDNI().equals(DNI)) {
				String mensaje = "�Qu� deseas modificar?\n";
				mensaje += "1. DNI\n";
				mensaje += "2. Nombre\n";
				mensaje += "3. Apellidos\n";
				mensaje += "4. Edad\n";
				mensaje += "5. Sueldo\n";

				int opcion = Util.escribirNumeroEntero(mensaje);
				switch (opcion) {
				case 1:
					formatoDNI = false;
					String dni="";
					do {
						System.out.println("Introduce el nuevo DNI");
						dni = sc.next();
						formatoDNI = Util.compruebaDni(dni);
						if(formatoDNI==false) {
							System.out.println("El DNI debe tener 8 digitos y una letra may�scula");
						}
					} while (formatoDNI == false);
					profesores.get(i).setDNI(dni);
					break;
				case 2:
					System.out.println("Introduce el nuevo nombre");
					sc.nextLine();
					String nombre = sc.nextLine();
					profesores.get(i).setNombre(nombre);
					break;
				case 3:
					System.out.println("Introduce el nuevo apellido");
					sc.nextLine();
					String apellidos = sc.nextLine();
					profesores.get(i).setApellidos(apellidos);
					break;
				case 4:
					mensaje = "Introduce el nueva edad";
					int edad = Util.escribirNumeroEntero(mensaje);
					profesores.get(i).setEdad(edad);

					break;
				case 5:

					mensaje = "Introduce el nuevo sueldo";
					double sueldo = Util.escribirNumeroDecimal(mensaje);
					((Profesor) profesores.get(i)).setSueldo(sueldo);
					break;

				}
				encontrado = true;
				Persona modPersona = new Profesor();
				modPersona.escribir(profesores);

			}

		}
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getDNI().equals(DNI)) {
				String mensaje = "�Qu� deseas modificar?\n";
				mensaje += "1. DNI\n";
				mensaje += "2. Nombre\n";
				mensaje += "3. Apellidos\n";
				mensaje += "4. Edad\n";
				mensaje += "5. Beca\n";

				int opcion = Util.escribirNumeroEntero(mensaje);
				switch (opcion) {
				case 1:
					formatoDNI = false;
					String dni="";
					do {
						System.out.println("Introduce el nuevo DNI");
						dni = sc.next();
						formatoDNI = Util.compruebaDni(dni);
						if(formatoDNI==false) {
							System.out.println("El DNI debe tener 8 digitos y una letra may�scula");
						}
					} while (formatoDNI == false);
					alumnos.get(i).setDNI(dni);
					break;
				case 2:
					System.out.println("Introduce el nuevo nombre");
					sc.nextLine();
					String nombre = sc.nextLine();
					alumnos.get(i).setNombre(nombre);
					break;
				case 3:
					System.out.println("Introduce el nuevo apellido");
					sc.nextLine();
					String apellidos = sc.nextLine();
					alumnos.get(i).setApellidos(apellidos);
					break;
				case 4:

					mensaje = "Introduce el nueva edad";
					int edad = Util.escribirNumeroEntero(mensaje);
					alumnos.get(i).setEdad(edad);
					break;

				case 5:

					mensaje = "Introduce la nueva beca";
					int beca = Util.escribirNumeroEntero(mensaje);
					((Alumno) alumnos.get(i)).setBeca(beca);
					break;

				}
				encontrado = true;
				Persona modPersona = new Alumno();
				modPersona.escribir(alumnos);

			}
		}

		if (encontrado == false) {
			System.out.printf("No existe la persona con el DNI %s\n", DNI);

		}

	}

	public static void eliminarPersona() {
		// Cargar datos
		Persona profesor = new Profesor();
		Persona alumno = new Alumno();
		List<Persona> alumnos = alumno.leer();
		List<Persona> profesores = profesor.leer();
		Scanner sc = new Scanner(System.in);
		boolean formatoDNI = false;
		String DNI="";
		do {
			System.out.println("Introduce el DNI");
			DNI = sc.next();
			formatoDNI = Util.compruebaDni(DNI);
			if(formatoDNI==false) {
				System.out.println("El DNI debe tener 8 digitos y una letra may�scula");
			}
		} while (formatoDNI == false);
		boolean encontrado = false;
		for (int i = 0; i < profesores.size(); i++) {
			if (profesores.get(i).getDNI().equals(DNI)) {
				profesores.remove(i);
				Persona delPersona = new Profesor();
				delPersona.escribir(profesores);
				encontrado = true;
			}
		}
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getDNI().equals(DNI)) {
				alumnos.remove(i);
				Persona delPersona = new Alumno();
				delPersona.escribir(alumnos);
				encontrado = true;
			}
		}
		if (encontrado == false) {
			System.out.printf("No existe la persona con el DNI %s\n", DNI);
		}
	}

	public static void añadirPersona() {
		// Cargar datos
		Persona profesor = new Profesor();
		Persona alumno = new Alumno();
		List<Persona> alumnos = alumno.leer();
		List<Persona> profesores = profesor.leer();
		boolean seguir = false;
		Scanner sc = new Scanner(System.in);

		String DNI = "";
		do {
			seguir = false;
			boolean formatoDNI = false;
			DNI="";
			do {
				System.out.println("Introduce el DNI");
				DNI = sc.next();
				formatoDNI = Util.compruebaDni(DNI);
				if(formatoDNI==false) {
					System.out.println("El DNI debe tener 8 digitos y una letra may�scula");
				}
			} while (formatoDNI == false);
			for (int i = 0; i < profesores.size(); i++) {
				if (profesores.get(i).getDNI().equals(DNI)) {
					System.out.println("DNI repetido");
					seguir = true;
				}
			}
			for (int i = 0; i < alumnos.size(); i++) {
				if (alumnos.get(i).getDNI().equals(DNI)) {
					System.out.println("DNI repetido");
					seguir = true;
				}
			}

		} while (seguir);
		System.out.println("Introduzca el nombre");
		sc.nextLine();
		String nombre = sc.nextLine();
		System.out.println("Introduzca el apellido");
		String apellidos = sc.nextLine();
		int edad = 0;
		String mensaje = "Introduzca la edad";
		edad = Util.escribirNumeroEntero(mensaje);
		int tipo;
		double sueldo = 0;
		int beca = 0;
		do {
			mensaje = "�Es profesor 1 o alumno 2?";
			tipo = Util.escribirNumeroEntero(mensaje);
			if (tipo == 1) {

				mensaje = "Introduzca el sueldo";
				sueldo = Util.escribirNumeroDecimal(mensaje);

				Persona newPersona = new Profesor(DNI, nombre, apellidos, edad, sueldo);
				profesores.add(newPersona);
				newPersona.escribir(profesores);
			} else if (tipo == 2) {

				mensaje = "Introduzca la beca";
				beca = Util.escribirNumeroEntero(mensaje);

				Persona newPersona = new Alumno(DNI, nombre, apellidos, edad, beca);
				alumnos.add(newPersona);
				newPersona.escribir(alumnos);
			}
		} while (tipo < 1 || tipo > 2);
	}

	public static void buscarPersona() {
		// Cargar datos
		Persona profesor = new Profesor();
		Persona alumno = new Alumno();
		List<Persona> alumnos = alumno.leer();
		List<Persona> profesores = profesor.leer();
		Scanner sc = new Scanner(System.in);
		boolean formatoDNI = false;
		String DNI="";
		do {
			System.out.println("Introduce el DNI");
			DNI = sc.next();
			formatoDNI = Util.compruebaDni(DNI);
			if(formatoDNI==false) {
				System.out.println("El DNI debe tener 8 digitos y una letra may�scula");
			}
		} while (formatoDNI == false);
		boolean encontrado = false;
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getDNI().equals(DNI)) {
				System.out.println(alumnos.get(i).toString());
				encontrado = true;
			}
		}
		for (int i = 0; i < profesores.size(); i++) {
			if (profesores.get(i).getDNI().equals(DNI)) {
				System.out.println(profesores.get(i).toString());
				encontrado = true;
			}
		}
		if (encontrado == false) {
			System.out.printf("No existe la persona con el DNI %s\n", DNI);

		}
	}

	public static void mostrarTodos() {
		// Cargar datos
		Persona profesor = new Profesor();
		Persona alumno = new Alumno();
		List<Persona> alumnos = alumno.leer();
		List<Persona> profesores = profesor.leer();
		System.out.println("Profesores");
		for (int i = 0; i < profesores.size(); i++) {
			System.out.println(profesores.get(i).toString());
		}
		System.out.println("Alumnos");
		for (int i = 0; i < alumnos.size(); i++) {
			System.out.println(alumnos.get(i).toString());
		}
	}

}
