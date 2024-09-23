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

import dominio.Vehiculo;

public class VehiculoDao {
	public VehiculoDao() {

	}

	// Leer personas
	public List<Vehiculo> leer() {
		 List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
	        try {
	            //Se busca el fichero y se comprueba que existe
	            File file = new File("vehiculos.txt");
	            if (file.exists()) {
	                //Transformamos los datos del ficheros en objetos personas
	                FileInputStream fis = new FileInputStream(file);
	                ObjectInputStream ois = new ObjectInputStream(fis);
	                vehiculos = (ArrayList<Vehiculo>) ois.readObject();
	                ois.close();
	                fis.close();
	            }
	        } catch (IOException ex) {
	            System.err.println(ex.getMessage());
	        } catch (ClassNotFoundException ex) {
	            System.err.println(ex.getMessage());
	        }
	        return vehiculos;
	}

	// Escribir personas
	public void escribir(List<Vehiculo> vehiculos) {
		   try {
	            //Indicamos el fichero a buscar
	            File file = new File("vehiculos.txt");
	            if (!file.exists()) {//Sino existe, se crea
	                file.createNewFile();
	            }
	            //Si se puede leer, se procede a ello
	            if (file.canRead()) {
	                //Transformamos los objetos vehiculos en datos del fichero
	                FileOutputStream fos = new FileOutputStream(file);
	                ObjectOutputStream oos = new ObjectOutputStream(fos);
	                oos.writeObject(vehiculos);
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