package trabajoPractico2.ejercicio02;

import java.util.ArrayList;
import java.util.List;

/*
 * Clase padre para las distintas actividades que se pueden 
 * realizar mediante el smartwatch
 * 
 * Cada actividad guarda en un array con el listado de la posicion cada
 * 1 segundo que se obtiene del sensor Gps de la distancia en metros
 */
public abstract class Actividad {
	
	private List<Double> registroDistancias; // En metros
	private TipoActividad tipoActividad;
	
	public Actividad() {
		this.registroDistancias = new ArrayList<Double>();
	}

	public TipoActividad getTipoActividad() {
		return tipoActividad;
	}

	public void setTipoActividad(TipoActividad tipoActividad) {
		this.tipoActividad = tipoActividad;
	}
	/*
	 * Se agrega al registro de la actividad la diferencia entre la poscion
	 * anterior y la acttual que se obtiene del registro del gps
	 */
	public void agregarRegistroDeDistancia(Double nuevaDiferenciaDePosicion) {
		this.registroDistancias.add(nuevaDiferenciaDePosicion + this.ultimoRegistroDeDistancia());
	}
	
	/*
	 * Devuelve el tiempo durante el cual se ha desarrollado 
	 * la activdad (en segundos)
	 */
	public Integer tiempoEmpleado() {
		return this.registroDistancias.size();
	}
	
	public Double ultimoRegistroDeDistancia() {
		Double ultimoRegistro = 0.0;
		if (this.registroDistancias.size() > 0) {
			ultimoRegistro = this.registroDistancias.get(this.registroDistancias.size() - 1);
		}
		return ultimoRegistro;
	}

}
