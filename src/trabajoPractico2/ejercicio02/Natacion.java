package trabajoPractico2.ejercicio02;

public class Natacion extends Actividad implements Ritmo {
	
	private final Double FACTOR_DE_CONVERSION_DE_SEGUNDOS_A_MINUTOS = 60.0;
	private final Double FACTOR_DE_CONVERSION_DE_METROS_A_HECTOMETROS = 100.0;

	private Double ritmoActualEnMinPorHectometros; // Ritmo expresado en min cada 100 mts
	private Double zonaFrecuenciaCardiaca; // Refactorizar como objeto?
	
	public Natacion() {
		super();
		this.setTipoActividad(TipoActividad.NATACION);
		this.ritmoActualEnMinPorHectometros = 0.0;
	}
	
	/*
	 * Devuelve el ritmo actual en base a los km recorridos y el tiempo empleado
	 */
	@Override
	public Double obtenerRitmoActual() {
		Double ritmoActual = 0.0;
		
		if(this.tiempoEmpleado() > 0) {
			ritmoActual = (this.tiempoEmpleado() / FACTOR_DE_CONVERSION_DE_SEGUNDOS_A_MINUTOS) /(this.ultimoRegistroDeDistancia() / FACTOR_DE_CONVERSION_DE_METROS_A_HECTOMETROS) ;
			this.ritmoActualEnMinPorHectometros = ritmoActual;
		}

		return ritmoActual;
	}
	

}
