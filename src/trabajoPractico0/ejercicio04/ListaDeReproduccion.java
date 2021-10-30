package trabajoPractico0.ejercicio04;

import java.util.LinkedList;
import java.util.List;

public class ListaDeReproduccion {

	private String nombre;
	private List<Cancion> canciones;
	private Double duracionTotal;

	public ListaDeReproduccion(String nombre) {
		this.nombre = nombre;
		
		this.canciones = new LinkedList<Cancion>();
		this.duracionTotal = 0.0;
	}

	public Boolean agregarCancion(Cancion nueva) {
		return this.canciones.add(nueva);
	}
	
	private Cancion buscarCancion(String titulo) {
		// Busca una canción en la lista de reproducción a partir de su titulo
		Cancion cancionABuscar = null;
		
		for(Cancion cancion : this.canciones) {
			if(cancion.getTitulo().equals(titulo)) {
				cancionABuscar = cancion;
			}
		}
		
		return cancionABuscar;
	}
	
	public Boolean eliminarCancion(String nombre) {
		Boolean sePudoEliminar = Boolean.FALSE;
		
		Cancion cancionAEliminar = this.buscarCancion(nombre);
		
		if(cancionAEliminar != null) {
			sePudoEliminar = this.canciones.remove(cancionAEliminar);	
		}
		
		return sePudoEliminar;
	}
	
	public String toString() {
		// Devuelve la lista de canciones de la lista de reproducción, junto con la información necesaria para conocer el detalle de cada canción
		String listaDeCanciones = "Lista de reproduccion: " + this.nombre + "\n";
		Integer duracion = 0;
		
		for(Cancion cancion : this.canciones) {
			listaDeCanciones += cancion + "\n";
			duracion += cancion.getDuracion();
		}
		
		listaDeCanciones += "Duración total: " + duracion + "seg\n";
		
		return listaDeCanciones;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	
}
