package dominio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import persistencia.BecaDao;

public class Beca {
	private int id;
	private double cuota;
	private String descripcion;
	private BecaDao becadao;

	public Beca(int id, double cuota, String descripcion) {
		this.id = id;
		this.cuota = cuota;
		this.descripcion = descripcion;
		becadao = new BecaDao();
	}

	public Beca() {
		becadao = new BecaDao();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCuota() {
		return cuota;
	}

	public void setCuota(double cuota) {
		this.cuota = cuota;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Beca [id=" + id + ", cuota=" + cuota + ", descripci�n=" + descripcion + "]";
	}

	public List<Beca> leer() {
		return becadao.leer();
	}

	public void escribir(List<Beca> becas) {
		becadao.escribir(becas);
	}
}
