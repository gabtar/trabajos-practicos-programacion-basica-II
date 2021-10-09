package trabajoPractico0.ejercicio02;

public class EquipoDeFutbol {
	private String nombre;
	private Jugador jugadores[];
	
	private Integer cantidadDeJugadoresEnElEquipo;
	
	private static final Integer CANTIDAD_MAXIMA_DE_JUGADORES_POR_EQUIPO = 5;
	
	public EquipoDeFutbol(String nombre) {
		this.nombre = nombre;
		
		this.jugadores = new Jugador[CANTIDAD_MAXIMA_DE_JUGADORES_POR_EQUIPO];
		this.cantidadDeJugadoresEnElEquipo = 0;
	}
	
	public String getNombre() {
		return nombre;
	}

	/*
	 * La capacidad máxima de un equipo es 5. No se permiten jugadores repetidos (ya sea el número o nombre del jugador)
	 * Se retorna el resultado de la operación
	 */
	public Boolean agregarJugador(Jugador nuevo) {
		Boolean sePudoAgregar = Boolean.FALSE;
		
		if (this.buscar(nuevo.getNumero()) != null || this.buscar(nuevo.getNombre()) != null) {
			return sePudoAgregar;
		}
			
		for (int i = 0; i < this.jugadores.length; i++) {
			if (!sePudoAgregar && this.jugadores[i] == null) {
				this.jugadores[i] = nuevo;
				this.jugadores[i].setEquipo(this.nombre);
				this.cantidadDeJugadoresEnElEquipo++;
				sePudoAgregar = Boolean.TRUE;
			}
		}
				
		return sePudoAgregar;
	}
	
	/*
	 * Permite buscar un jugador por su numero. 
	 * 
	 */
	public Jugador buscar(int numero) {
		Boolean seEncontro = Boolean.FALSE;
		Jugador jugadorBuscado = null;
		
		for (int i = 0; i < jugadores.length; i++) {
			if (this.jugadores[i] != null && this.jugadores[i].getNumero() == numero && !seEncontro) {
				jugadorBuscado = this.jugadores[i];
				seEncontro = Boolean.TRUE;
			}
		}
		
		return jugadorBuscado;
	}
	
	/*
	 * Permite buscar un jugador por su nombre. 
	 * 
	 */
	public Jugador buscar(String nombre) {
		Boolean seEncontro = Boolean.FALSE;
		Jugador jugadorBuscado = null;
		
		for (int i = 0; i < jugadores.length; i++) {
			if (this.jugadores[i] != null && this.jugadores[i].getNombre().equals(nombre) && !seEncontro) {
				jugadorBuscado = this.jugadores[i];
				seEncontro = Boolean.TRUE;
			}
		}
		
		return jugadorBuscado;
	}
	
	/*
	 * Calcula el valor del equipo. 
	 * 
	 */
	public Double calcularLaEdadPromedioDelEquipo() {
		Double edadPromedioDelEquipo = 0.0;
		Integer cantidadDeJugadoresEnElEquipo = 0;
		
		for (int i = 0; i < jugadores.length; i++) {
			if (this.jugadores[i] != null ) {
				edadPromedioDelEquipo += this.jugadores[i].getEdad();
				cantidadDeJugadoresEnElEquipo++;
			}
		}
		
		edadPromedioDelEquipo = (cantidadDeJugadoresEnElEquipo != 0) ? edadPromedioDelEquipo / cantidadDeJugadoresEnElEquipo : cantidadDeJugadoresEnElEquipo;
		
		return edadPromedioDelEquipo;
	}
	
	/*
	 * Calcula el valor del equipo
	 * 
	 */
	public Double calcularElValorDelEquipo() {
		Double valorDelEquipo = 0.0;
		
		for (int i = 0; i < jugadores.length; i++) {
			if (this.jugadores[i] != null) {
				valorDelEquipo+=this.jugadores[i].getPrecio();
			}
		}
		
		return valorDelEquipo;
	}
	
	public String toString() {
		return this.nombre;
	}
	
	public Integer getCantidadDeJugadoresEnElEquipo() {
		return cantidadDeJugadoresEnElEquipo;
	}
	
}
