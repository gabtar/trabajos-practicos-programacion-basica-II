package trabajoPractico0.ejercicio04;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private String nombre;
	private List<ListaDeReproduccion> listaDeReproduccion = new ArrayList(); 
	
	public Usuario(String nombre) {
		this.nombre = nombre;
	}
	
	public Boolean agregarNuevaLista(String nombreDeLaLista) {
		// Agrega una nueva lista de reproducci�n
		return this.listaDeReproduccion.add(new ListaDeReproduccion(nombreDeLaLista));
	}
	
	public Boolean agregarCancionALaLista(String nombreDeLaLista, Cancion cancion) {
		Boolean sePudoAgregar = Boolean.FALSE;
		ListaDeReproduccion listaAAgregarCancion = this.buscarListaPorNombre(nombreDeLaLista);
		
		if(listaAAgregarCancion != null) {
			sePudoAgregar = listaAAgregarCancion.agregarCancion(cancion);
		}
		
		return sePudoAgregar;
	}
	
	public String verMisListasDeReproduccion() {
		// Devuelve el listado de listas de reproducci�n disponible en forma de String (debe brindar informaci�n adecuada de cada lista, por ejemplo su duraci�n)
		String listasDeReproduccion = "";
		
		for(ListaDeReproduccion lista : this.listaDeReproduccion) {
			listasDeReproduccion += lista;
		}
		
		return listasDeReproduccion;
	}
	
	public String reproducirMiLista(String nombreDeLaLista) {
		// Devuelve una lista de reproducci�n determinada en forma de String, incluyendo cada una de sus canciones y la informaci�n de cada canci�n (por ejemplo autor y duraci�n)
		ListaDeReproduccion lista = this.buscarListaPorNombre(nombreDeLaLista);
		String reproduccion;
		
		reproduccion = (lista != null) ? lista.toString() : "";
		
		return reproduccion;
	}

	private ListaDeReproduccion buscarListaPorNombre(String nombreDeLaLista) {
		ListaDeReproduccion listaABuscar = null;
		
		for(ListaDeReproduccion lista : this.listaDeReproduccion) {
			if(lista.getNombre().equals(nombreDeLaLista)) {
				listaABuscar = lista;
			}
		}
		
		return listaABuscar;
	}
	
}
