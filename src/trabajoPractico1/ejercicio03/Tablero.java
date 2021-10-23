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
		Boolean sePudoAgregar = Boolean.FALSE;
		
		if(this.buscarUsuarioPorNombre(usuario.getNombre()) == null) {
			sePudoAgregar = this.usuarios.add(usuario);
		}
		
		return sePudoAgregar;
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
	public Boolean asignarTareaAUsuario(Tarea tarea, String nombreUsuario) {
		Boolean sePudoAsignar = Boolean.FALSE;
		Usuario usuario = this.buscarUsuarioPorNombre(nombreUsuario);
		
		if(this.tareas.contains(tarea) && this.usuarios.contains(usuario)) {
			sePudoAsignar = tarea.asignarUsuario(usuario);
		}
		
		return sePudoAsignar;
	}
	
	/*
	 * El Usuario que tiene asignada la tarea la decide finalizar
	 */
	public Boolean finalizarTarea(Tarea tarea, String nombreDeUsuario) {
		Boolean sePudoFinalizar = Boolean.FALSE;
		Usuario usuario = this.buscarUsuarioPorNombre(nombreDeUsuario);

		if(this.tareas.contains(tarea) && this.usuarios.contains(usuario) && tarea.getUsuarioAsignado().equals(usuario)) {
			tarea.setEstado(Estado.FINALIZADA);
			sePudoFinalizar = Boolean.TRUE;
		}
		
		return sePudoFinalizar;
	}
	
	/*
	 * Se limpian las tareas finalizadas
	 */
	public void limpiarTaerasFinalizadas() {
		List<Tarea> finalizadas = this.obtenerTareasPorEstado(Estado.FINALIZADA);
		this.tareas.removeAll(finalizadas);
	}
	
	/*
	 * Mostrar la lista de tareas según el estado que se pasa como argumento
	 */
	public List<Tarea> obtenerTareasPorEstado(Estado estado) {
		List<Tarea> tareasPorEstado = new ArrayList<Tarea>();
		
		for(Tarea tarea : this.tareas) {
			if(tarea.getEstado() == estado) {
				tareasPorEstado.add(tarea);
			}
		}
		
		return tareasPorEstado;
	}
	
	/*
	 * Mostrar la lista de tareas asociadas a un determinado usuario
	 */
	public List<Tarea> obtenerTareasDelUsuario(String nombre) {
		List<Tarea> tareasUsuario = new ArrayList<Tarea>();
		Usuario usuario = this.buscarUsuarioPorNombre(nombre);
		
		for(Tarea tarea : this.tareas) {
			if(tarea.getUsuarioAsignado().equals(usuario)) {
				tareasUsuario.add(tarea);
			}
		}
		
		return tareasUsuario;
	}
	

	public Usuario buscarUsuarioPorNombre(String nombre) {
		Usuario usuarioABuscar = null;
		
		for(Usuario usuario : this.usuarios) {
			if(usuario.getNombre().equals(nombre)) {
				usuarioABuscar = usuario;
			}
		}
		
		return usuarioABuscar;
	}

}
