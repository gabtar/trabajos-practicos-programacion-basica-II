package trabajoPractico0.ejercicio03;

import java.util.Objects;

public class Usuario {
	
	private String nombreDeUsuario;
	private String contrasenia;
	
	private Boolean estaLogueado;
	private Boolean estaBloqueado;

	public Usuario(String nombreDeUsuario, String contrasenia) {
		super();
		this.nombreDeUsuario = nombreDeUsuario;
		this.contrasenia = contrasenia;
		this.estaLogueado = Boolean.FALSE;
		this.estaBloqueado = Boolean.FALSE;
	}

	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}

	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Boolean estaLogueado() {
		return estaLogueado;
	}

	public void setEstaLogueado(Boolean estaLogueado) {
		this.estaLogueado = estaLogueado;
	}

	public void setBloqueado(Boolean bloqueo) {
		this.estaBloqueado = bloqueo;
	}

	public Boolean estaBloqueado() {
		return this.estaBloqueado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombreDeUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(nombreDeUsuario, other.nombreDeUsuario);
	}

}

