package dominio;

import java.util.List;
import persistencia.ExtraDao;

public class Extra {
	private int id;
	private String descr;
	private ExtraDao extradao;
	

	public Extra(int id, String descr) {
		this.id = id;
		this.descr = descr;
	}

	public Extra() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	@Override
	public String toString() {
		return "Extra [id=" + id + ", descr=" + descr + "]";
	}
	
	public List<Extra> leer(){
		return extradao.leer();
	}
	
	public void escribir(List<Extra> extras) {
		extradao.escribir(extras);
	}
	
	
	
	
	
	
	

}
