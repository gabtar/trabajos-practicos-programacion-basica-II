package trabajoPractico2.ejercicio02;

public class Carrera extends Actividad implements Ritmo {
	
	private final Double FACTOR_DE_CONVERSION_DE_SEGUNDOS_A_MINUTOS = 60.0;
	private final Double FACTOR_DE_CONVERSION_DE_METROS_A_KILOMETROS = 1000.0;

	private Double ritmoActual; // Ritmo expresado en min/km
	private Double zonaFrecuenciaCardiaca; //objeto?
	
	
	public Carrera() {
		super();
		this.setTipoActividad(TipoActividad.CARRERA);
		this.zonaFrecuenciaCardiaca = 0.0;
	}

	/*
	 * Devuelve el ritmo actual en base a los km recorridos y el tiempo empleado
	 */
	@Override
	public Double obtenerRitmoActual() {
		Double ritmo = 0.0;
		
		if(this.tiempoEmpleado() > 0) {
			ritmo = (this.tiempoEmpleado() / FACTOR_DE_CONVERSION_DE_SEGUNDOS_A_MINUTOS) / (this.ultimoRegistroDeDistancia()/ FACTOR_DE_CONVERSION_DE_METROS_A_KILOMETROS);
			this.ritmoActual = ritmo;
		}

		return ritmo;
	}
}
