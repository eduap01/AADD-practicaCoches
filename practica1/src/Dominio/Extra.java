package dominio;

import java.util.Scanner;
import java.util.List;
import Persistencia.ExtraDao;

public class Extra {
	private int id;
	private String descr;
	private ExtraDao extradao;

	public Extra(int id, String descr) {
		this.id = id;
		this.descr = descr;
	}

	public Extra() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	@Override
	public String toString() {
		return "Extra [id=" + id + ", descr=" + descr + "]";
	}

	// borrar Extra
	public static void eliminarExtra() {
		// cargar los datos
		Extra extra = new Extra();
		List<Extra> extras = extra.leer();
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe el identificador del extra que quieras eliminar");
		int idBorrar = sc.nextInt();
		boolean encontrado = false;
		for (int i = 0; i < extras.size(); i++) {
			if (extras.get(i).getId() == idBorrar) {
				extras.remove(i);
				Extra delExtra = new Extra();
				delExtra.escribir(extras);
				encontrado = true;
				break;
			}
		}

		if (!encontrado) {
			System.out.println("No existe el extra con la identificación " + idBorrar + ".");
		}

	}

	// añadir extras
	public static void añadirExtra() {
		// cargar los datos
		Extra extra = new Extra();
		List<Extra> extras = extra.leer();
		Scanner sc = new Scanner(System.in);
		boolean seguir = false;
		mostrarExtras();
		int id=0;
		
		while (seguir) {

			System.out.println("Introduce la identificación del nuevo extra.");
			int nId = sc.nextInt();
			for (int i = 0; i < extras.size(); i++) {
				if (extras.get(i).getId() == nId) {
					System.out.println("La identificación ya existe.");
				}
			}
			id=nId;
			seguir = true;
		}

		System.out.println("Introduce la descripción del nuevo extra.");
		String descripcion = sc.nextLine();
		Extra nExtra = new Extra(id, descripcion);
		extras.add(nExtra);
		nExtra.escribir(extras);
	}

	// mostrar extras
	public static void mostrarExtras() {
		Extra extra = new Extra();
		List<Extra> extras = extra.leer();
		System.out.println("Extras");
		for (int i = 0; i < extras.size(); i++) {
			System.out.println(extras.get(i).toString());
		}
	}

	public List<Extra> leer() {
		return extradao.leer();
	}

	public void escribir(List<Extra> extras) {
		extradao.escribir(extras);
	}

}
