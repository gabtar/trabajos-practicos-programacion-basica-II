package trabajoPractico1.ejercicio03;

import java.util.ArrayList;
import java.util.List;

/*
 * Representa un usuario del tablero kanban
 * Se supone que el nombre de usuario es único en el sitema del tablero
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
