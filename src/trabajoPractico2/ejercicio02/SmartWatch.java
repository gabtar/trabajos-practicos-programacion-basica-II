package trabajoPractico2.ejercicio02;

import java.util.ArrayList;
import java.util.List;

/*
 * Representa un reloj que registra actividades deportivas 
 */
public class SmartWatch {

	private SensorGPS gps; 
	private List<Actividad> actividadesRegistradas;
	// TODO Habria que agregar otro sensor para las pulsaciones
	
	public SmartWatch() {
		this.gps = new SensorGPS();
		
		this.actividadesRegistradas = new ArrayList<Actividad>();
	}
	
	/*
	 * Inicia el registro de una nueva actividad
	 * Para simplificar el problema se pasa por parametros la cantidad
	 * de segundos que durara la actividad
	 * Genera un array que contiene la distancia acumulada recorrida y el indice
	 * del array es el tiempo en segundos
	 * Si el gps no agarra senal, lanza una excepcion y no inicia la actividad
	 */
	public void inicarActividad(TipoActividad tipo, Integer segundosARegistrar) throws SinSenalException {
		Actividad nuevaActividad = null;
		
		// Si no esta conectado aun, se hace un nuevo intento
		if(!this.gps.estaConectadoAlSatelite()) {
			this.gps.obtenerSenal();
		}
		
		if(!this.gps.estaConectadoAlSatelite()) {
			throw new SinSenalException("No se encuentra conectado al satelite");
		}
		
		switch(tipo) {
		case CARRERA:
			nuevaActividad = new Carrera();
			break;
		case CICLISMO:
			nuevaActividad = new Ciclismo();
			break;
		case NATACION:
			nuevaActividad = new Natacion();
			break;
		case CAMINATA:
			nuevaActividad = new Caminata();
			break;
		default:
			break;
		}
		
		Integer tiempo = 0;
		if(nuevaActividad != null) {
			while (tiempo < segundosARegistrar ) {
				
				/*
				 * Si por alguna razon se pierde senal durante la actividad, 
				 * se agrega la ultima posicion de satelite disponible al registro 
				 */
				try {
					this.gps.actualizarPosicion();
					nuevaActividad.agregarRegistroDeDistancia(this.gps.getPosicionActual());					
				} catch(SinSenalException e) {
					nuevaActividad.agregarRegistroDeDistancia(this.gps.getPosicionActual());
				}
				
				tiempo++;
			}
		}
		
		this.actividadesRegistradas.add(nuevaActividad);
	}
	
	public Integer getCantidadDeActividadesRegistradas() {
		return this.actividadesRegistradas.size();
	}
	
	public Actividad ultimaActividadRegistrada() {
		Actividad ultimaActividad = null;
		
		if(this.actividadesRegistradas.size() > 0) {
			ultimaActividad = this.actividadesRegistradas.get(this.actividadesRegistradas.size() - 1);
		}
		return ultimaActividad;
	}
	
	/*
	 * Intento de conexion del Sensor GPS
	 */
	public Boolean conectarConSateliteGPS() {
		this.gps.obtenerSenal();
		return this.gps.estaConectadoAlSatelite();
	}

}
