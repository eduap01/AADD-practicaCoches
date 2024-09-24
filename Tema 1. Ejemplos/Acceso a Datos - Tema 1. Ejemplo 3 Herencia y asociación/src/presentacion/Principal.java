package presentacion;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import dominio.Alumno;
import dominio.Beca;
import dominio.Persona;
import dominio.Profesor;
import util.Util;

public class Principal {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		// Men� principal
		boolean seguir = true;
		do {

			String mensaje = "Men�\n";
			mensaje += "1. Mostrar todas las personas\n";
			mensaje += "2. Buscar una persona\n";
			mensaje += "3. A�adir una persona\n";
			mensaje += "4. Modificar una persona\n";
			mensaje += "5. Eliminar una persona\n";
			mensaje += "6. Mostrar todas las becas\n";
			mensaje += "7. A�adir beca\n";
			mensaje += "8. Eliminar beca\n";
			mensaje += "9. Log out\n";
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
				mostrarBecas();
				break;
			case 7:
				añadirBeca();
				break;
			case 8:
				eliminarBeca();
				break;
			case 9:
				seguir = false;
				System.out.println("Hasta pronto");
				break;
			default:
				System.out.println("Introduce un n�mero de 1 a 9");
			}

		} while (seguir);
	}

	public static void eliminarBeca() {
		// Cargar los datos
		Beca beca = new Beca();
		List<Beca> becas = beca.leer();
		Scanner sc = new Scanner(System.in);
		String mensaje = "Indica el Id";
		int id = Util.escribirNumeroEntero(mensaje);
		boolean encontrado = false;
		for (int i = 0; i < becas.size(); i++) {
			if (becas.get(i).getId() == id) {
				becas.remove(i);
				Beca delBeca = new Beca();
				delBeca.escribir(becas);
				encontrado = true;
				break;
			}
		}

		if (encontrado == false) {
			System.out.printf("No existe la beca con el Id %s\n", id);
		}
	}

	public static void añadirBeca() {
		// Cargar los datos
		Beca beca = new Beca();
		List<Beca> becas = beca.leer();
		Scanner sc = new Scanner(System.in);
		boolean seguir = false;
		int id = 0;
		mostrarBecas();
		String mensaje = "Introduzca el Id";
		id = Util.escribirNumeroEntero(mensaje);
		for (int i = 0; i < becas.size(); i++) {
			if (becas.get(i).getId() == id) {
				System.out.println("Id repetido");
				seguir = true;
			}
		}

		System.out.println("Introduzca la descripcion");
		String descripcion = sc.nextLine();
		mensaje = "Introduzca la cuota";
		double cuota = Util.escribirNumeroDecimal(mensaje);

		Beca newBeca = new Beca(id, cuota, descripcion);
		becas.add(newBeca);
		newBeca.escribir(becas);

	}

	public static void mostrarBecas() {
		// Cargar los datos
		Beca beca = new Beca();
		List<Beca> becas = beca.leer();
		System.out.println("Becas");
		for (int i = 0; i < becas.size(); i++) {
			System.out.println(becas.get(i).toString());
		}

	}

	public static void modificarPersona() {
		// Cargar los datos

		Persona profesor = new Profesor();
		Persona alumno = new Alumno();
		List<Persona> alumnos = alumno.leer();
		List<Persona> profesores = profesor.leer();
		Beca beca = new Beca();
		List<Beca> becas = beca.leer();
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
					int becaId = Util.escribirNumeroEntero(mensaje);
					encontrado = false;
					for (int j = 0; j < becas.size(); j++) {
						if (becas.get(j).getId() == becaId) {
							encontrado = true;
							((Alumno) alumnos.get(i)).setBeca(becas.get(j));
							break;
						}
					}
					if (encontrado == false) {
						Beca sinBeca = new Beca(0, 0, "Sin beca");
						((Alumno) alumnos.get(i)).setBeca(sinBeca);

					}
					break;

				}
				Persona modPersona = new Alumno();
				modPersona.escribir(alumnos);

			}
		}

		if (encontrado == false) {
			System.out.printf("No existe la persona con el DNI %s\n", DNI);

		}

	}

	public static void eliminarPersona() {
		// Cargar los datos

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
		// Cargar los datos

		Persona profesor = new Profesor();
		Persona alumno = new Alumno();
		List<Persona> alumnos = alumno.leer();
		List<Persona> profesores = profesor.leer();
		Beca beca = new Beca();
		List<Beca> becas = beca.leer();
		Scanner sc = new Scanner(System.in);
		boolean seguir = false;
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

		String mensaje = "Introduzca la edad";
		int edad = Util.escribirNumeroEntero(mensaje);

		int tipo = 0;
		double sueldo = 0;
		int becaId = 0;
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
				Beca be = new Beca();

				mostrarBecas();
				mensaje = "Introduzca la beca";
				becaId = Util.escribirNumeroEntero(mensaje);
				boolean encontrado = false;
				for (int j = 0; j < becas.size(); j++) {
					if (becas.get(j).getId() == becaId) {
						encontrado = true;
						be = becas.get(j);
					}
				}
				if (encontrado == false) {
					be = new Beca(0, 0, "Sin beca");

				}

				Persona newPersona = new Alumno(DNI, nombre, apellidos, edad, be);
				alumnos.add(newPersona);
				newPersona.escribir(alumnos);
			}

		} while (tipo < 1 || tipo > 2);

	}

	public static void buscarPersona() {
		// Cargar los datos

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
		// Cargar los datos

		Persona profesor = new Profesor();
		Persona alumno = new Alumno();
		List<Persona> alumnos = alumno.leer();
		List<Persona> profesores = profesor.leer();
		Scanner sc = new Scanner(System.in);
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
