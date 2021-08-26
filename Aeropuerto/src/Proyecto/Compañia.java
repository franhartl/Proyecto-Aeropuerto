package Proyecto;

public class Compa�ia {

	private String nombre;
	private Vuelo listaVuelos[] = new Vuelo [10];
	private int numVuelo=0;
	

    public Compa�ia(String nombre) {
	this.nombre=nombre;
}
	
	public Compa�ia(String nombre, Vuelo v[]) {
		super();
		this.nombre = nombre;
		listaVuelos = v;
		numVuelo = v.length;

	}
	public void insertarVuelo(Vuelo vuelo) {
		listaVuelos[numVuelo] = vuelo;
		 numVuelo++;
		 
	}
	public String getNombre() {
		return nombre;
	}
	public int getNumVuelo() {
		return numVuelo;
	}
	
	public Vuelo getVuelo(int i) {
		return listaVuelos[i];
		
	}
	public Vuelo getVuelo(String id) {
		boolean encontrado = false;
		int i= 0;
		Vuelo v = null;
		while((!encontrado)&&(i<listaVuelos.length)) {
			if(id.equals(listaVuelos[i].getIdentificador())) {
				encontrado = true;
				v = listaVuelos[i];
			}
			i++;
		}
		return v;
	}
}
