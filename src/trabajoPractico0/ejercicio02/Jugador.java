package trabajoPractico0.ejercicio02;

public class Jugador {

	private int numero;
	private String nombre;
	private int edad;
	private double precio;
	private String equipo;
	
	public Jugador(int numero, String nombre, int edad, double precio) {
		this.nombre = nombre;
		this.numero = numero;
		this.edad = edad;
		this.precio = precio;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	
	public String toString() {
		return nombre + "(" + this.equipo + ")";
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
}
