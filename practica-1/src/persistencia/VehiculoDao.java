package persistencia;

import dominio.Camion;
import dominio.Turismo;
import dominio.Vehiculo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehiculoDao {

    public VehiculoDao() {
    }

    // Leer vehiculos desde un archivo de texto personalizado
    public List<Vehiculo> leer() {
        List<Vehiculo> vehiculos = new ArrayList<>();
        try {
            File file = new File("vehiculo.txt");
            if (file.exists()) {
                // Usamos FileReader y Scanner para leer el archivo línea por línea
                FileReader fr = new FileReader(file);
                Scanner scanner = new Scanner(fr);

                while (scanner.hasNextLine()) {
                    String linea = scanner.nextLine().trim();

                    // Identificar sección de camiones
                    if (linea.equals("Camiones:")) {
                        int numCamiones = Integer.parseInt(scanner.nextLine().trim());
                        for (int i = 0; i < numCamiones; i++) {
                            scanner.nextLine(); // Matricula:
                            String matricula = scanner.nextLine().trim();
                            scanner.nextLine(); // Marca:
                            String marca = scanner.nextLine().trim();
                            scanner.nextLine(); // Modelo:
                            String modelo = scanner.nextLine().trim();
                            scanner.nextLine(); // Color:
                            String color = scanner.nextLine().trim();
                            scanner.nextLine(); // Capacidad de carga:
                            int capacidadCarga = Integer.parseInt(scanner.nextLine().trim());
                            scanner.nextLine(); // Precio:
                            int precio = Integer.parseInt(scanner.nextLine().trim());

                            // Crear un objeto Camion y añadirlo a la lista
                            Camion camion = new Camion(matricula, marca, modelo, color, capacidadCarga, precio);
                            vehiculos.add(camion);
                        }
                    }

                    // Identificar sección de turismos
                    else if (linea.equals("Turismos:")) {
                        int numTurismos = Integer.parseInt(scanner.nextLine().trim());
                        for (int i = 0; i < numTurismos; i++) {
                            scanner.nextLine(); // Matricula:
                            String matricula = scanner.nextLine().trim();
                            scanner.nextLine(); // Marca:
                            String marca = scanner.nextLine().trim();
                            scanner.nextLine(); // Modelo:
                            String modelo = scanner.nextLine().trim();
                            scanner.nextLine(); // Color:
                            String color = scanner.nextLine().trim();
                            scanner.nextLine(); // Numero de puertas:
                            int numPuertas = Integer.parseInt(scanner.nextLine().trim());
                            scanner.nextLine(); // Precio:
                            int precio = Integer.parseInt(scanner.nextLine().trim());

                            // Crear un objeto Turismo y añadirlo a la lista
                            Turismo turismo = new Turismo(matricula, marca, modelo, color, numPuertas, precio);
                            vehiculos.add(turismo);
                        }
                    }
                }
                scanner.close();
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Error: archivo no encontrado.");
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        return vehiculos;
    }

    // Escribir vehiculos a un archivo de texto personalizado
    public void escribir(List<Vehiculo> vehiculos) {
        try {
            File file = new File("vehiculo.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            // Usamos PrintWriter para escribir en el archivo
            PrintWriter pw = new PrintWriter(new FileWriter(file));

            // Escribir camiones
            pw.println("Camiones:");
            List<Camion> camiones = new ArrayList<>();
            for (Vehiculo vehiculo : vehiculos) {
                if (vehiculo instanceof Camion) {
                    camiones.add((Camion) vehiculo);
                }
            }
            pw.println(camiones.size());
            for (Camion camion : camiones) {
                pw.println("Matricula:");
                pw.println(camion.getMatricula());
                pw.println("Marca:");
                pw.println(camion.getMarca());
                pw.println("Modelo:");
                pw.println(camion.getModelo());
                pw.println("Color:");
                pw.println(camion.getColor());
                pw.println("Capacidad de carga:");
                pw.println(camion.getCapacidadCarga());
                pw.println("Precio:");
                pw.println(camion.getPrecio());
            }

            // Escribir turismos
            pw.println("Turismos:");
            List<Turismo> turismos = new ArrayList<>();
            for (Vehiculo vehiculo : vehiculos) {
                if (vehiculo instanceof Turismo) {
                    turismos.add((Turismo) vehiculo);
                }
            }
            pw.println(turismos.size());
            for (Turismo turismo : turismos) {
                pw.println("Matricula:");
                pw.println(turismo.getMatricula());
                pw.println("Marca:");
                pw.println(turismo.getMarca());
                pw.println("Modelo:");
                pw.println(turismo.getModelo());
                pw.println("Color:");
                pw.println(turismo.getColor());
                pw.println("Numero de puertas:");
                pw.println(turismo.getNumPuertas());
                pw.println("Precio:");
                pw.println(turismo.getPrecio());
            }

            pw.close();
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo: " + ex.getMessage());
        }
    }
}
