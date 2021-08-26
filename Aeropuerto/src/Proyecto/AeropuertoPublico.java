package Proyecto;

public class AeropuertoPublico extends Aeropuerto {
	
	private double subvencion;

	public AeropuertoPublico(String nombre, String ciudad, String pais) {
		super(nombre, ciudad, pais);
		// TODO Auto-generated constructor stub
	}

	public AeropuertoPublico(double subvencion, String nombre, String ciudad, String pais, Compañia[] c) {
		super(nombre, ciudad, pais, c);
		this.subvencion = subvencion;
		// TODO Auto-generated constructor stub
		
	}

	public AeropuertoPublico(double subvencion, String nombre, String ciudad, String pais) {
		super(nombre, ciudad, pais);
		this.subvencion= subvencion;
		// TODO Auto-generated constructor stub
	}

	public double getSubvencion() {
		return subvencion;
	}



	
	}
	







