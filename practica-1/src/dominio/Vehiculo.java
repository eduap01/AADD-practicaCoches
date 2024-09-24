package dominio;

public abstract class Vehiculo {
	protected String matricula;
	protected String marca;
	protected String modelo;
	protected String color;
	protected int precio;
	
	//constructor
	public Vehiculo(String matricula, String marca, String modelo, String color, int precio) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.precio = precio;
	}

	//getters y setters
	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public void mostrarInfo() {
		System.out.println("Matricula: "+matricula);
		System.out.println("Marca: "+marca);
		System.out.println("Matricula: "+modelo);
		System.out.println("Marca: "+color);
		System.out.println("Precio: "+precio);
	}
	
	public abstract String getTipoVehiculo();
	
	public static void buscarVehiculo() {
		
	}
	
	public static void añadirVehiculo() {
		
	}
	
	public static void modificarVehiculo() {
		
	}
	
	public static void eliminarVehiculo() {
		
	}
	
	public static void eliminarVehiculos() {
		
	}
	
	public static void vehiculoCaro() {
		
	}
	
	public static void vehiculoBarato() {
		
	}
	
}
