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

import dominio.Turismo;

public class TurismoDao {
	public TurismoDao() {

	}

	// Leer Turismos
	public List<Turismo> leer() {
		 List<Turismo> Turismos = new ArrayList<Turismo>();
	        try {
	            //Se busca el fichero y se comprueba que existe
	            File file = new File("turismo.txt");
	            if (file.exists()) {
	                //Transformamos los datos del ficheros en objetos turismos
	                FileInputStream fis = new FileInputStream(file);
	                ObjectInputStream ois = new ObjectInputStream(fis);
	                Turismos = (ArrayList<Turismo>) ois.readObject();
	                ois.close();
	                fis.close();
	            }
	        } catch (IOException ex) {
	            System.err.println(ex.getMessage());
	        } catch (ClassNotFoundException ex) {
	            System.err.println(ex.getMessage());
	        }
	        return Turismos;
	}

	// Escribir Turismos
	public void escribir(List<Turismo> Turismos) {
		   try {
	            //Indicamos el fichero a buscar
	            File file = new File("turismo.txt");
	            if (!file.exists()) {//Sino existe, se crea
	                file.createNewFile();
	            }
	            //Si se puede leer, se procede a ello
	            if (file.canRead()) {
	                //Transformamos los objetos Turismos en datos del fichero
	                FileOutputStream fos = new FileOutputStream(file);
	                ObjectOutputStream oos = new ObjectOutputStream(fos);
	                oos.writeObject(Turismos);
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
