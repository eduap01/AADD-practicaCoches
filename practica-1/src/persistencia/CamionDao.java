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

import dominio.Camion;

public class CamionDao {
	public CamionDao() {

	}

	// Leer camiones
	public List<Camion> leer() {
		 List<Camion> camiones = new ArrayList<Camion>();
	        try {
	            //Se busca el fichero y se comprueba que existe
	            File file = new File("camion.txt");
	            if (file.exists()) {
	                //Transformamos los datos del ficheros en objetos personas
	                FileInputStream fis = new FileInputStream(file);
	                ObjectInputStream ois = new ObjectInputStream(fis);
	                camiones = (ArrayList<Camion>) ois.readObject();
	                ois.close();
	                fis.close();
	            }
	        } catch (IOException ex) {
	            System.err.println(ex.getMessage());
	        } catch (ClassNotFoundException ex) {
	            System.err.println(ex.getMessage());
	        }
	        return camiones;
	}

	// Escribir camiones
	public void escribir(List<Camion> camiones) {
		   try {
	            //Indicamos el fichero a buscar
	            File file = new File("camion.txt");
	            if (!file.exists()) {//Sino existe, se crea
	                file.createNewFile();
	            }
	            //Si se puede leer, se procede a ello
	            if (file.canRead()) {
	                //Transformamos los objetos camiones en datos del fichero
	                FileOutputStream fos = new FileOutputStream(file);
	                ObjectOutputStream oos = new ObjectOutputStream(fos);
	                oos.writeObject(camiones);
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
