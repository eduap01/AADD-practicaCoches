package persistencia;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import dominio.Persona;

public class PersonaDao {
	public PersonaDao() {

	}

	// Leer personas
	public List<Persona> leer() {
		 List<Persona> personas = new ArrayList<Persona>();
	        try {
	            //Se busca el fichero y se comprueba que existe
	            File file = new File("personas.dat");
	            if (file.exists()) {
	                //Transformamos los datos del ficheros en objetos personas
	                FileInputStream fis = new FileInputStream(file);
	                ObjectInputStream ois = new ObjectInputStream(fis);
	                personas = (ArrayList<Persona>) ois.readObject();
	                ois.close();
	                fis.close();
	            }
	        } catch (IOException ex) {
	            System.err.println(ex.getMessage());
	        } catch (ClassNotFoundException ex) {
	            System.err.println(ex.getMessage());
	        }
	        return personas;
	}

	// Escribir personas
	public void escribir(List<Persona> personas) {
		   try {
	            //Indicamos el fichero de buscar
	            File file = new File("personas.dat");
	            if (!file.exists()) {//Sino existe, se crea
	                file.createNewFile();
	            }
	            if (file.canRead()) {//Si se puede leer, se procede a ello
	                //Transformamos los objetos personas en datos del fichero
	                FileOutputStream fos = new FileOutputStream(file);
	                ObjectOutputStream oos = new ObjectOutputStream(fos);
	                oos.writeObject(personas);
	                oos.close();
	                fos.close();
	            }
	        } catch (FileNotFoundException ex) {
	            System.err.println(ex.getMessage());
	        } catch (IOException ex) {
	            System.err.println(ex.getMessage());
	        }
	}

}
