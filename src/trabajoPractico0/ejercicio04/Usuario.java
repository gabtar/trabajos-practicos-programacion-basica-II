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
		// Agrega una nueva lista de reproducción
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
		// Devuelve el listado de listas de reproducción disponible en forma de String (debe brindar información adecuada de cada lista, por ejemplo su duración)
		String listasDeReproduccion = "";
		
		for(ListaDeReproduccion lista : this.listaDeReproduccion) {
			listasDeReproduccion += lista;
		}
		
		return listasDeReproduccion;
	}
	
	public String reproducirMiLista(String nombreDeLaLista) {
		// Devuelve una lista de reproducción determinada en forma de String, incluyendo cada una de sus canciones y la información de cada canción (por ejemplo autor y duración)
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
