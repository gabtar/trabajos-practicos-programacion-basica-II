package trabajoPractico2.ejercicio02;

/*
 * Simula obtener la posicion mediante el registro de un gps
 * Todos los valores de posicion se toman en metros
 */
public class SensorGPS {

	private Double posicionReferencia; // Siempre se inicia en 0 es la referencia, representa la coordenada gps
	private Double posicionAnterior;
	private Double posicionActual;
	private Boolean tieneSenal;
	
	
	public SensorGPS() {
		this.posicionReferencia = 0.0;
		this.posicionAnterior = 0.0;
		this.posicionActual = 0.0;
		
		this.tieneSenal = Boolean.FALSE;
	}
	
	/*
	 * Metodo que simula registrar la posicion actual
	 * Para simplificar se toma como referencia la anterior y se le
	 * suma un valor aleatorio 
	 * Devuelve el valor en metros
	 */
	public void actualizarPosicion() throws SinSenalException {
		
		if(!this.tieneSenal) {
			throw new SinSenalException("No se encuentra conectado al satelite");
		}
		
		Double variacionEnLaPosicion = Math.random()*5;
		this.posicionAnterior = this.posicionActual;
		this.posicionActual = this.posicionAnterior + variacionEnLaPosicion;
	}
	
	/*
	 * Devuelve la variacion de la posicion
	 * Se supone que la calse contenedora ejecutara el metodo en intervalos
	 * de 1 segundo
	 */
	public Double obtenerVelocidadInstantanea() {
		return this.posicionActual - this.posicionAnterior;
	}
	
	public Double getPosicionActual() {
		return this.posicionActual;
	}
	/*
	 * Se simula que hay un 20% de probabilidad que no se conecte
	 * al satelite
	 */
	public void obtenerSenal() {
		this.tieneSenal = Math.random() > 0.2 ? Boolean.TRUE : Boolean.FALSE;
	}
	
	public Boolean estaConectadoAlSatelite() {
		return this.tieneSenal;
	}
	
}
