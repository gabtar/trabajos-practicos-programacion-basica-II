package trabajoPractico0.ejercicio05;

import java.util.Objects;

public class Pasajero implements Comparable<Pasajero> {
	
	private String nombre;
	private String apellido;
	private Integer dni;
	private Boolean tieneAsientoAsignado;
	
	public Pasajero(String nombre, String apellido, Integer dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		
		this.tieneAsientoAsignado = Boolean.FALSE;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Boolean getTieneAsientoAsignado() {
		return tieneAsientoAsignado;
	}

	public void setTieneAsientoAsignado(Boolean tieneAsientoAsignado) {
		this.tieneAsientoAsignado = tieneAsientoAsignado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pasajero other = (Pasajero) obj;
		return Objects.equals(dni, other.dni);
	}
	
	@Override
	public String toString() {
		return this.nombre + " / " + this.apellido + " / " + this.dni;
	}

	@Override
	public int compareTo(Pasajero o) {
		return this.dni.compareTo(o.dni);
	}

}
