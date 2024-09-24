package persistencia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dominio.Beca;

public class BecaDao {
	public BecaDao() {

	}

	public List<Beca> leer() {
		List<Beca> becas = new ArrayList<Beca>();
		try {
			Scanner in = new Scanner(new FileReader("becas.txt"));
			in.next();
			int contador = in.nextInt();
			// Leer beca

			while (in.hasNextLine()) {
				in.next();
				int id = in.nextInt();
				in.next();
				double cuota = in.nextDouble();
				in.next();
				in.nextLine();
				String descripcion = in.nextLine();
				Beca beca = new Beca(id, cuota, descripcion);
				becas.add(beca);
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fichero especificado no existe");
		} catch (IOException e) {
			System.out.println("Excepcion de entrada/salida:" + e.toString());
			System.out.println(e.getMessage());
		}
		return becas;
	}

	public void escribir(List<Beca> becas) {
		try {
			PrintWriter out = new PrintWriter(new FileWriter("becas.txt"));
			out.println("Becas:");
			out.println(becas.size());
			for (int i = 0; i < becas.size(); i++) {
				out.println("id:");
				out.println(becas.get(i).getId());
				out.println("cuota:");
				String cuota = becas.get(i).getCuota() + "";
				cuota = cuota.replace(".", ",");
				out.println(cuota);
				out.println("descripci�n:");
				out.println(becas.get(i).getDescripcion());

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
