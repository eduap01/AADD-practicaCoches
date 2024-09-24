package presentacion;

import java.util.List;
import java.util.Scanner;

import dominio.Persona;
import util.Util;

public class Principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Men� principal
		boolean seguir = true;
		do {

			String mensaje = "Men�\n";
			mensaje += "1. Mostrar todos las personas\n";
			mensaje += "2. Buscar una persona\n";
			mensaje += "3. Insertar una persona\n";
			mensaje += "4. modificar una persona\n";
			mensaje += "5. Eliminar una persona\n";
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
		// Cargar los datos
		Persona persona = new Persona();
		List<Persona> personas = persona.leer();
		Scanner sc = new Scanner(System.in);
		boolean formatoDNI = false;
		String DNI="";
		do {
			System.out.println("Indica el DNI");
			DNI = sc.next();
			formatoDNI = Util.compruebaDni(DNI);
			if(formatoDNI==false) {
				System.out.println("El DNI debe tener 8 digitos y una letra may�scula");
			}
		} while (formatoDNI == false);
		boolean encontrado = false;

		// comprobar si existe la persona
		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).getDNI().equals(DNI)) {
				String mensaje = "�Qu� deseas modificar?\n";
				mensaje += "1. DNI\n";
				mensaje += "2. Nombre\n";
				mensaje += "3. Apellidos\n";
				mensaje += "4. Edad\n";
				int opcion = Util.escribirNumeroEntero(mensaje);

				// switch para modificar un campo concreto
				switch (opcion) {
				case 1:
					formatoDNI = false;
					String dni="";
					do {
						System.out.println("Introduce el nuevo DNI");
						dni = sc.next();
						formatoDNI = Util.compruebaDni(DNI);
						if(formatoDNI==false) {
							System.out.println("El DNI debe tener 8 digitos y una letra may�scula");
						}
					} while (formatoDNI == false);
					personas.get(i).setDNI(dni);
					break;
				case 2:
					System.out.println("Introduce el nuevo nombre");
					sc.nextLine();
					String nombre = sc.nextLine();
					personas.get(i).setNombre(nombre);
					break;
				case 3:
					System.out.println("Introduce el nuevo apellido");
					sc.nextLine();
					String apellidos = sc.nextLine();
					personas.get(i).setApellidos(apellidos);
					break;
				case 4:

					mensaje = "Introduce el nueva edad";
					int edad = Util.escribirNumeroEntero(mensaje);
					personas.get(i).setEdad(edad);
					break;

				}
				encontrado = true;
				Persona modPersona = new Persona();
				modPersona.escribir(personas);
			}
		}

		// si no existe la persona, se indica
		if (encontrado == false) {
			System.out.printf("No existe la persona con el DNI %s\n", DNI);

		}

	}

	public static void eliminarPersona() {
		// Cargar los datos
		Persona persona = new Persona();
		List<Persona> personas = persona.leer();
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

		// For para buscar la persona
		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).getDNI().equals(DNI)) {
				personas.remove(i);
				Persona delPersona = new Persona();
				delPersona.escribir(personas);
				encontrado = true;
			}
		}
		// si no existe la persona, se indica

		if (encontrado == false) {
			System.out.printf("No existe la persona con el DNI %s\n", DNI);
		}
	}

	public static void añadirPersona() {
		// Cargar los datos
		Persona persona = new Persona();
		List<Persona> personas = persona.leer();
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
			// For para buscar la persona
			for (int i = 0; i < personas.size(); i++) {
				if (personas.get(i).getDNI().equals(DNI)) {
					System.out.println("DNI repetido");
					seguir = true;
				}
			}

		} while (seguir);

		// Rellenar datos
		System.out.println("Introduzca el nombre");
		sc.nextLine();
		String nombre = sc.nextLine();
		System.out.println("Introduzca el apellido");
		String apellidos = sc.next();
		String mensaje = "Introduzca la edad";
		int edad = Util.escribirNumeroEntero(mensaje);

		Persona newPersona = new Persona(DNI, nombre, apellidos, edad);
		personas.add(newPersona);
		newPersona.escribir(personas);
	}

	public static void buscarPersona() {
		// Cargar los datos
		Persona persona = new Persona();
		List<Persona> personas = persona.leer();
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

		// For para buscar la persona
		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).getDNI().equals(DNI)) {
				System.out.println(personas.get(i).toString());
				encontrado = true;
			}
		}

		// si no existe la persona, se indica
		if (encontrado == false) {
			System.out.printf("No existe la persona con el DNI %s\n", DNI);

		}
	}

	public static void mostrarTodos() {
		// Cargar los datos
		Persona persona = new Persona();
		List<Persona> personas = persona.leer();
		// For que imprime todas las personas
		for (int i = 0; i < personas.size(); i++) {
			System.out.println(personas.get(i).toString());
		}
	}

}
