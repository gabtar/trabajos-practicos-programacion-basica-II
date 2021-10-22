package trabajoPractico1.ejercicio03;

import java.util.ArrayList;
import java.util.List;

/*
 * Modelo que representa un determinado usuario del tablero kanban
 */
public class Usuario {
	
	private String nombre;

	public Usuario(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}

}
