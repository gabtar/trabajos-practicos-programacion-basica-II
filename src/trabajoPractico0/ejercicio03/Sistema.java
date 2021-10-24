package trabajoPractico0.ejercicio03;

import java.util.HashSet;
import java.util.Set;

public class Sistema {
	
	private String nombre;
	private Set<Usuario> usuarios;
	
	private Integer cantidadMaximaDeUsuarios;
	private Integer cantidadDeUsuariosBloqueados;
	private Integer cantidadDeUsuariosLogueados;
	
	public Sistema(String nombreDelSistema, Integer cantidadMaximaDeUsuarios) {
		this.usuarios = new HashSet<Usuario>();
		
		this.cantidadMaximaDeUsuarios = cantidadMaximaDeUsuarios;
		this.nombre = nombreDelSistema;
		this.cantidadDeUsuariosBloqueados = 0;
		this.cantidadDeUsuariosLogueados = 0;
	}
	
	/*
	 * Se agrega un nuevo usuario al sistema
	 */
	public Boolean agregarUsuario(String nombreDeUsuario, String contrasenia) {
		return this.usuarios.add(new Usuario(nombreDeUsuario, contrasenia));
	}
	
	/*
	 * Loguea a un usuario solo si el nombre y la contrasenia es correcto
	 */
	public Boolean loguearUsuario(String nombreDeUsuario, String contrasenia) {
		Usuario usuarioALoguear = this.buscarUsuarioPorNombre(nombreDeUsuario);
		Boolean sePudoLoguear = Boolean.FALSE;
		
		if(this.usuarios.contains(usuarioALoguear) && !usuarioALoguear.estaBloqueado() && usuarioALoguear.getNombreDeUsuario().equals(nombreDeUsuario) && usuarioALoguear.getContrasenia().equals(contrasenia)) {
			sePudoLoguear = Boolean.TRUE;
			usuarioALoguear.setEstaLogueado(Boolean.TRUE);
			this.cantidadDeUsuariosLogueados++;
		}
		
		return sePudoLoguear;
	}
	
	/*
	 * Si el usuario esta logueado cierra la session
	 */
	public Boolean cerrarLaSessionDelUsuario(String nombreDeUsuario) {
		Usuario usuarioALoguear = this.buscarUsuarioPorNombre(nombreDeUsuario);
		Boolean sePudoCerrarLaSession = Boolean.FALSE;
		
		if(this.usuarios.contains(usuarioALoguear) && usuarioALoguear.getNombreDeUsuario().equals(nombreDeUsuario) && usuarioALoguear.estaLogueado()) {
			sePudoCerrarLaSession = Boolean.TRUE;
			usuarioALoguear.setEstaLogueado(Boolean.FALSE);
			this.cantidadDeUsuariosLogueados--;
		}
		
		return sePudoCerrarLaSession;
	}
	
	/*
	 * Calcula el porcentaje de usuarios logueados con respecto al total de usuarios
	 */
	public Double calcularElPorcentajeDeUsuariosLogueados() {
		Double porcentaje = 0.0;
		
		if(this.cantidadDeUsuariosLogueados > 0) {
			porcentaje = (this.cantidadDeUsuariosLogueados / (double) this.usuarios.size()) * 100.0;
		}
		
		return porcentaje;
	}

	/*
	 * Permite buscar a un usuario del sistema por su nombre de usuario
	 * Se toma como el nombreDeUsuario es un identificador único
	 * Devuelve null si no existe el usuario
	 */
	private Usuario buscarUsuarioPorNombre(String nombreDeUsuario) {
		Usuario usuarioABuscar = null;
		
		for (Usuario usuario : this.usuarios) {
			if (usuario.getNombreDeUsuario().equals(nombreDeUsuario)) {
				usuarioABuscar = usuario;
			}
		}
		return usuarioABuscar;
	}
	
	public Integer getCantidadDeUsuariosLogueados() {
		return this.cantidadDeUsuariosLogueados;
	}

	/*
	 * Cambia el estado de bloqueo del Usuario
	 */
	public void bloquearODesBloquearUsuario(String nombreDeUsuario) {
		Usuario usuarioABuscar = this.buscarUsuarioPorNombre(nombreDeUsuario);
		
		if(usuarioABuscar != null) {
			usuarioABuscar.setBloqueado(!usuarioABuscar.estaBloqueado());
		}
	}
	
	public Integer cantidadDeUsuariosBloqueados() {
		return this.cantidadDeUsuariosBloqueados;
	}
	
	/*
	 * Devuelve si un usuario esta bloqueado. 
	 * Si no existe el usuario devuelve Boolean.FALSE
	 */
	public Boolean estaBloqueadoElUsuario(String nombreDeUsuario) {
		Boolean estaBloqueado = Boolean.FALSE;
		Usuario usuarioABuscar = this.buscarUsuarioPorNombre(nombreDeUsuario);
		
		if(usuarioABuscar != null) {
			estaBloqueado = usuarioABuscar.estaBloqueado();
		}
		
		return estaBloqueado;
	}
}
