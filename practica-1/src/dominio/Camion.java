package dominio;
//camion hereda de vehiculo
public class Camion extends Vehiculo{
	private int capacidadCarga;
	
	//creamos el constructor
	public Camion(String matricula, String marca, String modelo, String color, int capacidadCarga, int precio) {
		super(matricula, marca, modelo, color, precio);
		this.capacidadCarga = capacidadCarga;
	}

	//setters y getters
	public void setCapacidadCarga(int capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}

	public int getCapacidadCarga() {
		return capacidadCarga;
	}
	
	// Sobrescribir el método para mostrar información
    @Override
    public void mostrarInfo() {
        // Llamar al método mostrarInfo de Vehiculo (superclase)
        super.mostrarInfo();
        // Mostrar los detalles adicionales del Camion
        System.out.println("Capacidad de carga: " + capacidadCarga + " kilos");
    }

    // Implementación del método abstracto getTipoVehiculo
    @Override
    public String getTipoVehiculo() {
        return "Camión";
    }
	
}
