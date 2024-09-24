package presentacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dominio.SistemaGestionVehiculos;
import dominio.Turismo;
import dominio.Vehiculo;
import persistencia.VehiculoDao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class main {

	public static void main(String[] args) {
		VehiculoDao vehiculoDao = new VehiculoDao();
        SistemaGestionVehiculos sistema = new SistemaGestionVehiculos(vehiculoDao);
        Turismo turismo1 = new Turismo("2424FNS", "Peugeot", "307", "Azul celeste", 4, 6500);
        // Cargar los vehículos desde el archivo
        System.out.println("Cargando vehículos desde el archivo...");
        List<Vehiculo> vehiculosCargados = vehiculoDao.leer();
        if (vehiculosCargados.isEmpty()) {
            System.out.println("No se encontraron vehículos en el archivo.");
        } else {
            System.out.println("Vehículos cargados desde el archivo:");
            for (Vehiculo vehiculo : vehiculosCargados) {
                vehiculo.mostrarInfo();
            }
        }
        sistema.vehiculoBarato();
        sistema.vehiculoCaro();
        sistema.añadirVehiculo(turismo1);
        sistema.buscarVehiculoMatricula("2424FNS");
        sistema.eliminarVehiculo("2424FNS");
        sistema.buscarVehiculoMatricula("2424FNS");
	}
	

}
