package trabajoPractico2.ejercicio02;

/*
 * Representa un usuario del smartwatch y sus caracteristicas 
 */
public class Usuario {

	private String nombre;
	private Integer edadActual;
	private Double pesoActual;  // Se supone en metros
	private Integer alturaActual; // Se supone en cm
	private Integer pasosDiarios;
	
	public Usuario(String nombre, Integer edadActual, Double pesoActual, Integer alturaActual) {
		super();
		this.nombre = nombre;
		this.edadActual = edadActual;
		this.pesoActual = pesoActual;
		this.alturaActual = alturaActual;
		this.pasosDiarios = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdadActual() {
		return edadActual;
	}

	public void setEdadActual(Integer edadActual) {
		this.edadActual = edadActual;
	}

	public Double getPesoActual() {
		return pesoActual;
	}

	public void setPesoActual(Double pesoActual) {
		this.pesoActual = pesoActual;
	}

	public Integer getAlturaActual() {
		return alturaActual;
	}

	public void setAlturaActual(Integer alturaActual) {
		this.alturaActual = alturaActual;
	}

	public Integer getPasosDiarios() {
		return pasosDiarios;
	}

	public void setPasosDiarios(Integer pasosDiarios) {
		this.pasosDiarios = pasosDiarios;
	}

}
