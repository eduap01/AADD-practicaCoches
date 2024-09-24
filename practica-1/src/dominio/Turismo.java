package dominio;
//turismo extiende de vehiculo
public class Turismo extends Vehiculo{
	//añadimos los atributos de turismo
	private int numPuertas;
	
	//creamos el constructor
	public Turismo(String matricula, String marca, String modelo, String color, int numPuertas, int precio) {
		super(matricula, marca, modelo, color, precio);
		this.numPuertas = numPuertas;
	}

	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	@Override
	public void mostrarInfo() {
		super.mostrarInfo();
		System.out.println("Numero de puertas: "+numPuertas);
	}
	@Override
	public String getTipoVehiculo() {
		return "Turismo";
	}
	
	
	
}
