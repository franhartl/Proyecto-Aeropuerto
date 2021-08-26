package Proyecto;

import java.util.Scanner;

public class Principal {
	static Scanner entrada = new Scanner(System.in);
	final static int num = 4; //numero de aeropuertos
	static Aeropuerto aeropuertos[] = new Aeropuerto[num];
	
	

	public static void main(String[] args) {
	
//insertar datos de los aeropuertos
		insertarDatosAeropuerto(aeropuertos);
		menu();
	}
	//creo aeropuertos con sus compañias y vuelos
   public static void insertarDatosAeropuerto(Aeropuerto aero[]){
	   aero[0] = new AeropuertoPublico(8000000, "Ezeiza", "Buenos Aires", "Argentina");
	   aero[0].insertarCompañia(new Compañia("LATAM"));
	   aero[0].insertarCompañia(new Compañia("AeroArg"));
	   aero[0].getCompañia("Ezeiza").insertarVuelo(new Vuelo("IB20", "Buenos Aires", "Rio de Janeiro", 150, 100));
	   aero[0].getCompañia("Ezeiza").insertarVuelo(new Vuelo("IB21","Buenos Aires", "Cancún", 300, 100));
	   aero[0].getCompañia("LATAM").insertarVuelo(new Vuelo("NK12", "Buenos Aires", "Londres", 350, 100));
	   aero[0].getCompañia("AeroArg").insertarVuelo(new Vuelo("AB255","Buenos Aires", "Bariloche", 50, 100));
	   aero[0].getCompañia("Ezeiza").getVuelo("IB20").insertarPasajero(new Pasajero("Francis", "40202020","Argentino"));
	   aero[0].getCompañia("Ezeiza").getVuelo("IB20").insertarPasajero(new Pasajero("Cristian","45346870","Argentino"));
	   aero[0].getCompañia("Ezeiza").getVuelo("IB20").insertarPasajero(new Pasajero("Gonzalo", "39535897","Argentino"));
	   aero[0].getCompañia("LATAM").getVuelo("NK12").insertarPasajero(new Pasajero("Maria", "25789687","Uruguaya"));
	   aero[0].getCompañia("AeroArg").getVuelo("AB255").insertarPasajero(new Pasajero("Jorge", "10055681","Argentino"));
	   
	   aero[1] = new AeropuertoPublico(20000000,"Aeropuerto Bogota", "Bogota", "Colombia");
	   aero[1].insertarCompañia(new Compañia("AirAmerica"));
       aero[1].insertarCompañia(new Compañia("VuelaBogota"));
       aero[1].getCompañia("AirAmerica").insertarVuelo(new Vuelo("AE250", "Bogota","Estados Unidos",300,100));
       aero[1].getCompañia("AirAmerica").insertarVuelo(new Vuelo("AE251", "Bogota","Madrid",400,100));
       aero[1].getCompañia("VuelaBogota").insertarVuelo(new Vuelo("ABC15","Bogota","Lima", 150, 100));
       aero[1].getCompañia("AirAmerica").getVuelo("AE250").insertarPasajero(new Pasajero("Rodrigo","4552143", "Colombiano" ));
       aero[1].getCompañia("AirAmerica").getVuelo("AE250").insertarPasajero(new Pasajero("Karina","1558143", "Argentina" ));
       aero[1].getCompañia("AirAmerica").getVuelo("AE250").insertarPasajero(new Pasajero("Marcelo","1752143", "Colombiano" ));
       
       aero[2] = new AeropuertoPublico(150000000, "Aeropuerto Mexico", "Mexico", "Mexico");
       aero[2].insertarCompañia(new Compañia("AeroMexico"));
       aero[2].getCompañia("AeroMexico").insertarVuelo(new Vuelo("MEX123","Mexico","Buenos Aires",300, 100));
       aero[2].getCompañia("AeroMexico").insertarVuelo(new Vuelo("MEX125","Mexico","Florida",50, 100));
       aero[2].getCompañia("AeroMexico").getVuelo("MEX123").insertarPasajero(new Pasajero("Pepe", "12345666","Argentino" ));
       aero[2].getCompañia("AeroMexico").getVuelo("MEX125").insertarPasajero(new Pasajero("Jorge", "18525666","Chileno" ));
	   
	   aero[3] =new AeropuertoPrivado("Central Ciudad Real", "Ciudad Real", "España");
	   aero[3].insertarCompañia(new Compañia("AirEuropa"));
	   String empresas[] = {"Cobresol","Anguila33"};
	   ((AeropuertoPrivado)aero[3]).instertarEmpresas(empresas);
	   aero[3].getCompañia("AirEuropa").insertarVuelo(new Vuelo("JK111", "Madrid", "Roma", 100,100));
	   aero[3].getCompañia("AirEuropa").getVuelo("JK111").insertarPasajero(new Pasajero("Franco","33579779","Español"));
	   
   } //creo el menu 
   public static void menu(){
	   String nombreAeropuerto, nombreCompañia, origen, destino;
	   int opcion;
	   Aeropuerto aeropuerto;
	   Compañia compañia;
	   do {
		   System.out.println("MENU:");
		   System.out.println("1- Ver aeropuertos gestionados(Publicos o Privados)");
		   System.out.println("2- Ver empresas(Privado) o subvencion (Publico)");
		   System.out.println("3- Listas compañias de un Aeropuerto");
		   System.out.println("4- Lista de vuelos por compañia");
		   System.out.println("5- Listar posibles vuelos de origen a destino");
		   System.out.println("Opcion: ");
		   opcion= entrada.nextInt();
		   
		   switch(opcion) {
		   case 1: //Ver aeropuertos gestionados
			   System.out.println("");
			   mostrarDatosAeropuertos(aeropuertos);
			   break;
			   
		   case 2: //Ver empresas(privado) o subvencion(publico)
			   System.out.println("");
			   mostrarPatrocinio(aeropuertos);
			   break;
			   
		   case 3: //Listas compañias de un aeropuerto
			   entrada.nextLine();
			   System.out.print("\nDigite el nombre del Aeropuerto");
			   nombreAeropuerto= entrada.nextLine();
			   aeropuerto= buscarAeropuerto(nombreAeropuerto, aeropuertos);
			   if(aeropuerto==null) {
				   System.out.println("El aeropuerto no existe");
				   
			   }
			   else {
				   mostrarCompañias(aeropuerto);
				   
			   }
			   break;
			   
		   case 4: //Lista de vuelos por compañia 
			   entrada.nextLine();
			   System.out.println("\nDigite el nombre del aeropuerto: ");
			   nombreAeropuerto= entrada.nextLine();
			   aeropuerto= buscarAeropuerto(nombreAeropuerto, aeropuertos);
			   if(aeropuertos==null) {
				   System.out.println("El aeropuerto no existe");
				   
			   }
			   else {
				   System.out.println("\nDigite el nombre de la compañia: ");
				   nombreCompañia= entrada.nextLine();
				   compañia= aeropuerto.getCompañia(nombreCompañia);
				   mostrarVuelos(compañia);
			   }
			   break;
			   
		   case 5: //Lista posibles vuelos de origen a destino
			   entrada.nextLine();
			   System.out.println("\nDigite la ciudad Origen: ");
			   origen=entrada.nextLine();
			   System.out.println("Digite la ciudad destino:");
			   destino=entrada.nextLine();
			   mostrarVuelosOrigenDestino(origen,destino,aeropuertos);
			   
			   
			   break;
			   
		   case 6: break;
		   default: System.out.println("Error, se equivoco de opcion de menu");
		   
		   }
		   System.out.println(""); //salto de linea
	      }while(opcion!=6);
	   
	   
	   }	   //crear metodo de case 1 
	   
    public static void mostrarDatosAeropuertos(Aeropuerto aeropuertos[]) {
	   for (int i=0; i< aeropuertos.length ; i++) {
		   if(aeropuertos[i] instanceof AeropuertoPrivado) { //instanceof determina si pertenece a aeropuertoPrivado
			   System.out.println("Aeropuerto Privado");
			   System.out.println("Nombre: "+aeropuertos[i].getNombre());
			   System.out.println("Ciudad "+aeropuertos[i].getCiudad());
			   System.out.println("Pais "+aeropuertos[i].getPais());
		
	   }
		   else {
			   System.out.println("Aeropuerto Publico");
			   System.out.println("Nombre: "+aeropuertos[i].getNombre());
			   System.out.println("Ciudad: "+aeropuertos[i].getCiudad());
			   System.out.println("Pais: "+aeropuertos[i].getPais());
			   
		   }
   
	   }
    } //metodo para case 2
    public static void mostrarPatrocinio(Aeropuerto aeropuertos[]) {
    	String empresas[];
    	for( int i=0; i<aeropuertos.length; i++) {
    		if(aeropuertos[i]instanceof AeropuertoPrivado) {
    			System.out.println("Aeropuerto Privado: "+aeropuertos[i].getNombre());
    			empresas=((AeropuertoPrivado)aeropuertos[i]).getListaEmpresas();
    			System.out.println("Empresas: ");
    			for( int j=0; j<empresas.length;j++) {
    				System.out.println(empresas[j]);
    			}
    		}
    		else {
    			System.out.println("Aeropuerto publico: " +aeropuertos[i].getNombre());
    			System.out.println("Subvencion: "+((AeropuertoPublico)aeropuertos[i]).getSubvencion());
    			
    		}
    	}
    }
    //metodo case 3
    public static Aeropuerto buscarAeropuerto(String nombre, Aeropuerto aeropuertos[]) {
    	boolean encontrado= false;
    	int i= 0;
    	Aeropuerto aero = null;
    	while ((!encontrado) && (i<aeropuertos.length)) {
    		if(nombre.equals(aeropuertos[i].getNombre())) {
    			encontrado= true;
    			aero= aeropuertos[i];
    			
    		}
    		i++;
    	}
    	return aero;
    }
    //else de case 3
    public static void mostrarCompañias(Aeropuerto aeropuertos) {
    	System.out.println("Las compañias del aeropuerto: "+aeropuertos.getNombre());
    	for(int i=0; i<aeropuertos.getNumCompañia();i++) {
    		System.out.println(aeropuertos.getCompañia(i).getNombre());
    	}
    }
    //metodo case 4
    public static void mostrarVuelos(Compañia compañia) {
    	Vuelo vuelo;
    	for(int i=0; i<compañia.getNumVuelo();i++) {
    		vuelo=compañia.getVuelo(i);
    		System.out.println("Identificador: "+vuelo.getIdentificador());
    		System.out.println("Ciudad Origen: "+vuelo.getCiudadOrigen());
    		System.out.println("Ciudad destino: "+vuelo.getCiudadDestino());
    		System.out.println("Precio: $"+vuelo.getPrecio());
    		
    	}
    }
    //metodo case 5
    	public static Vuelo[] buscarVuelosOrigenDestino(String origen, String destino, Aeropuerto aeropuertos[]) {
    		Vuelo vuelo;
    		int contador=0;
    		Vuelo listaVuelos[];
    		for(int i=0; i<aeropuertos.length;i++) { //recorro los aeropuertos
    			for(int j=0; j<aeropuertos[i].getNumCompañia();j++) { //recorro las compañias
    				for(int k=0; k<aeropuertos[i].getCompañia(j).getNumVuelo();k++) { //recorro los vuelos
    					vuelo=aeropuertos[i].getCompañia(j).getVuelo(k);
    					 if((origen.equals(vuelo.getCiudadOrigen())) && (destino.equals(vuelo.getCiudadDestino()))) {
    						contador++;
    						
    					  
    					}
    				   
    				}
    			}
    		}
    listaVuelos=new Vuelo[contador];
    int q=0;
    
    for(int i=0;i<aeropuertos.length;i++) {
    	for(int j=0;j<aeropuertos[i].getNumCompañia();j++) {
    		for(int k=0; k<aeropuertos[i].getCompañia(j).getNumVuelo();k++) {
    			vuelo=aeropuertos[i].getCompañia(j).getVuelo(k);
    			if((origen.equals(vuelo.getCiudadOrigen())) && (destino.equals(vuelo.getCiudadDestino()))) {
    				listaVuelos[q]= vuelo;
    				q++;
    			}
    		}
    	}
    }return listaVuelos;
    	}
    	
    	public static void mostrarVuelosOrigenDestino(String origen, String destino, Aeropuerto aeropuertos[]) {
    		Vuelo vuelos[];
    		vuelos= buscarVuelosOrigenDestino(origen, destino, aeropuertos);
    		if(vuelos.length==0) {
    			System.out.println("No existen vuelos de esa ciudad origen a destino");
    			
    			
    		}
    		else {
    			System.out.println("Vuelos encontrados: ");
    			for(int i=0;i<vuelos.length;i++) {
    				System.out.println("Identificador: "+vuelos[i].getIdentificador());
    				System.out.println("Ciudad Origen: "+vuelos[i].getCiudadOrigen());
    				System.out.println("Ciudad Destino: "+vuelos[i].getCiudadDestino());
    				System.out.println("Precio: $ "+vuelos[i].getPrecio());
    				System.out.println("");
    			
    		}	
    
    		}	
    		
    	}		

}
	   
   
   

	

  

