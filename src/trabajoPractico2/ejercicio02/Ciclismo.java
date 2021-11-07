package trabajoPractico2.ejercicio02;

/*
 * Representa la actividad de ciclismo
 * Para obtener la cadencia en RPM, se simplifica de forma tal que se multiplica
 * la velocidad por un factor fijo(se supone la bici no tiene cambios).
 */
public class Ciclismo extends Actividad {

	private final Double FACTOR_DE_RELACION_DE_PLATOS_Y_RUEDA = 2.0;
	private final Double FACTOR_DE_CONVERSION_DE_SEGUNDOS_A_HORAS = 3600.0;
	private final Double FACTOR_DE_CONVERSION_DE_METROS_A_KILOMETROS = 1000.0;
	
	private Double velocidadMediaEnKmPorHora; // En km por hora
	private Double cadencia; // en RPM
	private Double zonaFrecuenciaCardiaca;
	
	public Ciclismo() {
		super();
		this.setTipoActividad(TipoActividad.CICLISMO);
		this.velocidadMediaEnKmPorHora = 0.0;
		this.cadencia = 0.0;
		this.zonaFrecuenciaCardiaca = 0.0;
	}

	/*
	 * Devuelve la velocidad media actual
	 */
	public Double obtenerVelocidadMedia() {
		Double velocidadMedia = 0.0;
		
		if(this.tiempoEmpleado() > 0) {
			velocidadMedia = (this.ultimoRegistroDeDistancia() / FACTOR_DE_CONVERSION_DE_METROS_A_KILOMETROS)/ (this.tiempoEmpleado() / FACTOR_DE_CONVERSION_DE_SEGUNDOS_A_HORAS);
			this.velocidadMediaEnKmPorHora = velocidadMedia;
		}
		
		return velocidadMedia;
	}
	
	/*
	 * Devuelve la cadencia en rpm
	 */
	public Double obtenerCadencia() {
		return this.obtenerVelocidadMedia()*FACTOR_DE_RELACION_DE_PLATOS_Y_RUEDA;
	}

}
