package trabajoPractico1.ejercicio03;

public class Tarea {

	private String titulo;
	private String descripcion;
	private Usuario usuarioAsignado;
	
	private Estado estado;

	public Tarea(String titulo, String descripcion) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.estado = Estado.PENDIENTE; // Se inicializa por defecto en pendiente
		
		this.usuarioAsignado = null; 
	}
	
	/*
	 * No se puede asignar el usuario si la tarea tiene un
	 * estado distinto a PENDIENTE 
	 */
	public Boolean asignarUsuario(Usuario usuarioAsignado) {
		Boolean sePudoAsignar = Boolean.FALSE;
		
		if(this.estado == Estado.PENDIENTE) {
			this.usuarioAsignado = usuarioAsignado;
			sePudoAsignar = Boolean.TRUE;
		}
		
		return sePudoAsignar;
	}
	
	public Usuario getUsuarioAsignado() {
		return this.usuarioAsignado;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	@Override
	public String toString() {
		return this.titulo + ": " + this.descripcion;
	}
}
