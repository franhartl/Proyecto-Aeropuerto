package Proyecto;

public class AeropuertoPrivado extends Aeropuerto {
	private String listaEmpresas[] = new String[10];
	private int numEmpresa;
	
	
	public AeropuertoPrivado(String nombre, String ciudad, String pais) {
		super(nombre, ciudad, pais);
		
	}
	public AeropuertoPrivado(String nombre, String ciudad, String pais, Compa�ia[] c, String e[]) {
		super(nombre, ciudad, pais, c);
		this.listaEmpresas= e;
		numEmpresa = e.length;
		

	}
	public void instertarEmpresas(String e[]) {
		this.listaEmpresas=e;
		this.numEmpresa= e.length;
		
	}
	public void instertarEmpresa(String e) {
		listaEmpresas[numEmpresa]=e;
		numEmpresa++;
		
	}
	public String[] getListaEmpresas() {
		return listaEmpresas;
	}
	public int getNumEmpresa() {
		return numEmpresa;
	}
	
	
}
