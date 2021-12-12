package trabajoPractico0.ejercicio04;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private String nombre;
	private List<ListaDeReproduccion> listaDeReproduccion = new ArrayList(); 
	
	public Usuario(String nombre) {
		this.nombre = nombre;
	}
	
	/*
	 * Crea una nueva lista vacia de canciones
	 * Se supone que no existen dos listas con el mismo nombre
	 * Se podria haber agregado una exception al agregar nombre de lista existente
	 */
	public Boolean agregarNuevaLista(String nombreDeLaLista) {
		// Agrega una nueva lista de reproducción
		return this.listaDeReproduccion.add(new ListaDeReproduccion(nombreDeLaLista));
	}
	
	/*
	 * Agrega una cancion a una determinada lista de canciones
	 */
	public Boolean agregarCancionALaLista(String nombreDeLaLista, Cancion cancion) {
		Boolean sePudoAgregar = Boolean.FALSE;
		ListaDeReproduccion listaAAgregarCancion = this.buscarListaPorNombre(nombreDeLaLista);
		
		if(listaAAgregarCancion != null) {
			sePudoAgregar = listaAAgregarCancion.agregarCancion(cancion);
		}
		
		return sePudoAgregar;
	}
	
	/*
	 * Muestra por pantalla las listas de reproduccion con sus canciones y detalles
	 */
	public String verMisListasDeReproduccion() {
		String listasDeReproduccion = "";
		
		for(ListaDeReproduccion lista : this.listaDeReproduccion) {
			listasDeReproduccion += lista;
		}
		
		return listasDeReproduccion;
	}
	
	/*
	 * Reproduce por pantalla la lista que se pasa por parametro 
	 */
	public String reproducirMiLista(String nombreDeLaLista) {
		ListaDeReproduccion lista = this.buscarListaPorNombre(nombreDeLaLista);
		String reproduccion;
		
		reproduccion = (lista != null) ? lista.toString() : "";
		
		return reproduccion;
	}

	/*
	 * Busca una lista de reproduccion por su nombre
	 */
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
