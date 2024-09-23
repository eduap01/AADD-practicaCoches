package persistencia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dominio.Extra;

public class ExtraDao {
	public ExtraDao() {

	}

	public List<Extra> leer() {
		List<Extra> extras = new ArrayList<Extra>();
		try {
			Scanner sc = new Scanner(new FileReader("extras.txt"));
			sc.next();
			int cont = sc.nextInt();

			// id, descripcion
			while (sc.hasNextLine()) {
				sc.next();
				int id = sc.nextInt();
				sc.next();
				sc.nextLine();
				String descripcion = sc.nextLine();
				sc.next();
				Extra extra = new Extra(id, descripcion);
				extras.add(extra);

			}

		} catch (FileNotFoundException e) {
			System.err.println("Este fichero no existe");
		} catch (IOException e) {
			System.err.println("Excepcion de entrada/salida:" + e.toString());
			System.err.println(e.getMessage());
		}
		return extras;
	}
	
	public void escribir(List<Extra> extras) {
		
		try {
			PrintWriter out = new PrintWriter(new FileWriter("extras.txt"));
			out.println("Extras:");
			out.println(extras.size());
			
			for(int i=0;i<extras.size();i++) {
				out.println("id:");
				out.println(extras.get(i).getId());
				out.println("Descripcion:");
				out.println(extras.get(i).getDescr());
			}
			out.close();
			
		}catch (FileNotFoundException e) {
			System.err.println("Este fichero no existe");
		} catch (IOException e) {
			System.err.println("Excepcion de entrada/salida:" + e.toString());
			System.err.println(e.getMessage());
		}
		
	}

}


