package trabajoPractico0.ejercicio04;

public class Cancion {
	
	private String titulo;
	private String autor;
	private Integer duracion; // En segundos
	private Genero genero;
	
	
	public Cancion(String titulo, String autor, Integer duracion, Genero genero) {
		this.titulo = titulo;
		this.autor = autor;
		this.duracion = duracion;
		this.genero = genero;
	}
	
	@Override
	public String toString() {
		return "Titulo: " + this.titulo + " Autor: " + this.autor + " Duraci�n: " + this.duracion + "seg " + "G�nero: " + this.genero;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public Integer getDuracion() {
		return this.duracion;
	}
	

}
