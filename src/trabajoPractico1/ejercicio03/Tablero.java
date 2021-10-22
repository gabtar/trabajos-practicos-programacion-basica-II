package trabajoPractico1.ejercicio03;

import java.util.List;
import java.util.ArrayList;

public class Tablero {

	private String nombre;
	
	private List<Usuario> usuarios;
	private List<Tarea> tareas;
	
	/*
	 * Para simplificar se supone que el nombre del usuario
	 * debe ser unico en el tablero
	 */
	public Tablero(String nombre) {
		this.nombre = nombre;
		
		this.usuarios = new ArrayList<Usuario>();
		this.tareas = new ArrayList<Tarea>();
	}
	
	/*
	 * Agregar un usuario al tablero
	 */
	public Boolean agregarUnNuevoUsuario(Usuario usuario) {
		return this.usuarios.add(usuario);
	}
	
	/*
	 * Se agrega una nueva tarea
	 */
	public Boolean agregarNuevaTarea(Tarea tarea) {
		return this.tareas.add(tarea);
	}
	
	/*
	 * Se asigna la tarea a un usuario
	 * - Cuando se asigna una tarea pendiente a un usuario,
	 * su estado cambia a en curso y no puede cambiar de usuario
	 * nuevamente
	 */
	public Boolean asignarTareaAUsuario(Tarea tarea, Usuario usuario) {
		Boolean sePudoAsignar = Boolean.FALSE;
		
		if(this.tareas.contains(tarea) && this.usuarios.contains(usuario)) {
			sePudoAsignar = tarea.asignarUsuario(usuario);
		}
		
		return sePudoAsignar;
	}
	
	/*
	 * El Usuario que tiene asignada la tarea la decide finalizar
	 */
	public Boolean finalizarTarea(Tarea tarea, Usuario usuario) {
		Boolean sePudoFinalizar = Boolean.FALSE;

		if(this.tareas.contains(tarea) && this.usuarios.contains(usuario) && tarea.getUsuarioAsignado().equals(usuario)) {
			sePudoFinalizar = Boolean.TRUE;
		}
		
		return sePudoFinalizar;
	}
	
	/*
	 * Se limpian las tareas finalizadas
	 */
	public void limpiarTaerasFinalizadas() {
		for(Tarea tarea : this.tareas) {
			if(tarea.getEstado() == Estado.FINALIZADA) {
				this.tareas.remove(tarea);
			}
		}
	}
	
	/*
	 * Mostrar la lista de tareas pendientes
	 */
	public List<Tarea> obtenerTareasPendientes() {
		List<Tarea> tareasPendientes = new ArrayList<Tarea>();
		
		for(Tarea tarea : this.tareas) {
			if(tarea.getEstado() == Estado.PENDIENTE) {
				tareasPendientes.add(tarea);
			}
		}
		
		return tareasPendientes;
	}
	
	/*
	 * Mostrar la lista de tareas asociadas a un determinado usuario
	 */
	public List<Tarea> obtenerTareasDelUsuario(Usuario usuario) {
		List<Tarea> tareasUsuario = new ArrayList<Tarea>();
		
		for(Tarea tarea : this.tareas) {
			if(tarea.getUsuarioAsignado().equals(usuario)) {
				tareasUsuario.add(tarea);
			}
		}
		
		return tareasUsuario;
	}
}
