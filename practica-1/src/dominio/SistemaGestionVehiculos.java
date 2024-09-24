package dominio;

import java.util.List;
import java.util.Scanner;

import persistencia.VehiculoDao;

public class SistemaGestionVehiculos {
	private VehiculoDao vehiculoDao;
	Scanner scanner = new Scanner(System.in);
	
	public SistemaGestionVehiculos(VehiculoDao vehiculoDao) {
		this.vehiculoDao = new VehiculoDao();
	}
	
	public boolean añadirVehiculo(Vehiculo nuevoVehiculo) {
		//lee la lista existente
		List<Vehiculo> vehiculos = vehiculoDao.leer();
		
		//vemos si la matricula ya existe
		for(int i=0; i<vehiculos.size();i++) {
			Vehiculo vehiculo = vehiculos.get(i);
			if(vehiculo.getMatricula().equalsIgnoreCase(nuevoVehiculo.getMatricula())) {
				System.out.println("Error, ya existe en nuestro sistema un vehiculo con la matrícula: "+nuevoVehiculo.getMatricula());
				return false;
			}
		}
		//añadir vehiculo a la lista
		vehiculos.add(nuevoVehiculo);
		
		//actualizamos la lista del fichero con lo anterior
		vehiculoDao.escribir(vehiculos);
		
		System.out.println("Vehiculo añadido correctamente: "+nuevoVehiculo.getMatricula());
		return true;
	}
	
	public Vehiculo buscarVehiculoMatricula(String matricula) {
		List<Vehiculo> vehiculos = vehiculoDao.leer();
		
		for(int i=0; i<vehiculos.size();i++) {
			Vehiculo vehiculo = vehiculos.get(i);
			if(vehiculo.getMatricula().equalsIgnoreCase(matricula)) {
				System.out.println("Vehiculo encontrado: "+ vehiculo.getMatricula());
				vehiculo.mostrarInfo();
				return vehiculo;
			}
		}
		System.out.println("No se encontro ningun vehiculo con la siguiente matricula: "+matricula);
		return null;
	}
	
	public boolean modificarVehiculo(String matricula) {
		List<Vehiculo>vehiculos=vehiculoDao.leer();
		
		//buscamos el vehiculo por matricula
		for(int i=0;i<vehiculos.size();i++) {
			Vehiculo vehiculo = vehiculos.get(i);
			if(vehiculo.matricula.equalsIgnoreCase(matricula)) {
				//Se imprime la info del vehiculo
				System.out.println("Vehiculo encontrado: ");
				vehiculo.mostrarInfo();
				
				//empezar a modifiicar
				System.out.println("Introduce los nuevos datos o presiona enter para no modificar dicho dato:");
				
				//modificar marca
				System.out.println("Nueva marca: (marca actual: "+vehiculo.getMarca()+"): ");
				String newMarca = scanner.nextLine();
				if(!newMarca.isEmpty()) {
					vehiculo.setMarca(newMarca);
				}
				
				//modificar modelo
				System.out.println("Nuevo modelo: (modelo actual: "+vehiculo.getModelo()+"): ");
				String newModelo = scanner.nextLine();
				if(!newModelo.isEmpty()) {
					vehiculo.setMarca(newModelo);
				}
				
				//modificar color
				System.out.println("Nuevo color: (color actual: "+vehiculo.getColor()+"): ");
				String newColor = scanner.nextLine();
				if(!newColor.isEmpty()) {
					vehiculo.setMarca(newColor);
				}
				
				//modificar precio
				System.out.println("Nuevo precio: (precio actual: "+vehiculo.getPrecio()+"): ");
				String newPrecioString = scanner.nextLine();
				if(!newPrecioString.isEmpty()) {
					try {
						int newPrecio = Integer.parseInt(newPrecioString);
						vehiculo.setPrecio(newPrecio);
					}catch(NumberFormatException e){
						System.out.println("El precio introducido no es válido");
					}
				}
				//en caso de ser turismo se modificaran las puertas
				if(vehiculo instanceof Turismo) {
					Turismo turismo = (Turismo) vehiculo;
					System.out.println("Nuevo numero de puertas: (numero de puertas actual: "+turismo.getNumPuertas()+"): ");
					String newNumPuertasString = scanner.nextLine();
					if(!newNumPuertasString.isEmpty()) {
						try {
							int newNumPuertas=Integer.parseInt(newNumPuertasString);
							((Turismo) vehiculo).setNumPuertas(newNumPuertas);
						}catch(NumberFormatException e) {
							System.out.println("El numero de puertas introducido no es válido");
						}
					}
				}
				//en caso de ser camion se modifica la capacidad de carga
				if(vehiculo instanceof Camion) {
					Camion camion = (Camion) vehiculo;
					System.out.println("Nueva capacidad de carga: (capacidad de carga actual: "+camion.getCapacidadCarga()+"): ");
					String newCapacidadCargaString = scanner.nextLine();
					if(!newCapacidadCargaString.isEmpty()) {
						try {
							int newCapacidadCarga=Integer.parseInt(newCapacidadCargaString);
							((Camion) vehiculo).setCapacidadCarga(newCapacidadCarga);
						}catch(NumberFormatException e) {
							System.out.println("La capacidad de carga introducida no es válida");
						}
					}
				}
				//guardamos los cambios en el fichero
				vehiculoDao.escribir(vehiculos);
				System.out.println("Vehiculo modificado correctamente");
				return true;
			}
		}
		System.out.println("No se encontró ningun vehiculo con la matricula: "+matricula);
		return false;
	}
	
	public boolean eliminarVehiculo(String matricula) {
	    List<Vehiculo> vehiculos = vehiculoDao.leer();
	    //encontramos la matricula
	    for (int i = 0; i < vehiculos.size(); i++) {
	        Vehiculo vehiculo = vehiculos.get(i);
	        if (vehiculo.getMatricula().equalsIgnoreCase(matricula)) {
	            // Vehículo encontrado, proceder a eliminarlo
	            System.out.println("Vehículo encontrado: " + vehiculo.getMatricula());
	            vehiculos.remove(i);

	            // Guardar los cambios en el fichero
	            vehiculoDao.escribir(vehiculos);
	            System.out.println("Vehículo eliminado correctamente.");
	            return true;
	        }
	    }

	    // Si no se encuentra el vehículo, devolver false
	    System.out.println("No se encontró ningún vehículo con la matrícula: " + matricula);
	    return false;
	}
	
	public boolean eliminarVehiculos() {
		List<Vehiculo> vehiculos = vehiculoDao.leer();
		if(vehiculos.isEmpty()) {
			System.out.println("No hay vehiculos guardados");
			return false;
		}
		//eliminamos todos los vehiculos
		vehiculos.clear();
		
		//guardamos la lista
		vehiculoDao.escribir(vehiculos);
		System.out.println("Vehiculos eliminados correctamente");
		return true;
	}
	
	public Vehiculo vehiculoCaro() {
	    List<Vehiculo> vehiculos = vehiculoDao.leer(); 

	    // Comprobar si hay vehículos en la lista
	    if (vehiculos.isEmpty()) {
	        System.out.println("No hay vehículos guardados");
	        return null;
	    }

	    // Inicializar la variable que contendrá el vehículo más caro
	    Vehiculo vehiculoMasCaro = vehiculos.get(0);

	    // Recorrer la lista para encontrar el vehículo más caro
	    for (int i = 1; i < vehiculos.size(); i++) {
	        Vehiculo vehiculo = vehiculos.get(i);
	        if (vehiculo.getPrecio() > vehiculoMasCaro.getPrecio()) {
	        	//nuevo vehiculo caro
	            vehiculoMasCaro = vehiculo;  
	        }
	    }

	    // Mostrar el vehículo más caro
	    System.out.println("El vehículo más caro es:");
	    vehiculoMasCaro.mostrarInfo();

	    return vehiculoMasCaro;
	}
	
	public Vehiculo vehiculoBarato() {
	    List<Vehiculo> vehiculos = vehiculoDao.leer();  // Leer la lista de vehículos del archivo

	    // Comprobar si hay vehículos en la lista
	    if (vehiculos.isEmpty()) {
	        System.out.println("No hay vehículos guardados");
	        return null;
	    }

	    // Inicializar la variable que contendrá el vehículo más barato
	    Vehiculo vehiculoMasBarato = vehiculos.get(0);

	    // Recorrer la lista usando un bucle for clásico
	    for (int i = 1; i < vehiculos.size(); i++) {
	        Vehiculo vehiculo = vehiculos.get(i);
	        if (vehiculo.getPrecio() < vehiculoMasBarato.getPrecio()) {
	            //nuevo vehiculo barato
	        	vehiculoMasBarato = vehiculo;  
	        }
	    }

	    // Mostrar el vehículo más barato
	    System.out.println("El vehículo más barato es:");
	    vehiculoMasBarato.mostrarInfo();

	    return vehiculoMasBarato;
	}
}
