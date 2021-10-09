package trabajoPractico0.ejercicio02;

public class PartidoDeFutbol {
	private EquipoDeFutbol local;
	private EquipoDeFutbol visitante;
	private Evento goles[];
	private Evento amontestados[];
	private Evento expulsados[];
	
	private Integer golesEquipoLocal;
	private Integer golesEquipoVisitante;
	private Integer cantidadDeAmonestados;
	private Integer cantidadDeExpulsados;
	
	private final Integer NUMERO_MAXIMO_DE_GOLES_POR_PARTIDO = 20;
	private final Integer NUMERO_MAXIMO_DE_INCIDENCIAS_POR_PARTIDO = 20;
	
	
	public PartidoDeFutbol(EquipoDeFutbol local, EquipoDeFutbol visitante) {
		this.local = local;
		this.visitante = visitante;
		
		this.golesEquipoLocal = 0;
		this.golesEquipoVisitante = 0;
		this.cantidadDeAmonestados = 0;
		this.cantidadDeExpulsados = 0;
		this.goles = new Evento[NUMERO_MAXIMO_DE_GOLES_POR_PARTIDO];
		this.amontestados = new Evento[NUMERO_MAXIMO_DE_INCIDENCIAS_POR_PARTIDO];
		this.expulsados = new Evento[NUMERO_MAXIMO_DE_INCIDENCIAS_POR_PARTIDO];
	}
	
	/*
	 * Se debe marcar un nuevo Gol 
	 * Dependiendo del autor (según al equipo que pertenezca) y del tipo (si es a favor o en contra) se sabrá a quien contabilizarlo
	 */
	public void marcar(Evento gol) {

		if(gol.getTipo() == TipoDeEvento.GOL_A_FAVOR) {
			
			if(gol.getAutor().getEquipo().equals(this.local.getNombre())) {
				// Es un gol a favor del equipo local, equipo local suma +1 gol
				this.goles[golesEquipoLocal+golesEquipoVisitante] = gol;
				this.golesEquipoLocal++;
			} else {
				// Es gol encontra del equipo local, suma +1 el visitante
				this.goles[golesEquipoLocal+golesEquipoVisitante] = gol;
				this.golesEquipoVisitante++;
			}
			
		} else if(gol.getTipo() == TipoDeEvento.GOL_EN_CONTRA) {
			
			if(gol.getAutor().getEquipo().equals(this.local.getNombre())) {
				// Es un gol en contra del equipo local, equipo visitante suma +1 gol
				this.goles[golesEquipoLocal+golesEquipoVisitante] = gol;
				this.golesEquipoVisitante++;
			} else {
				// Es gol encontra del equipo local, suma +1 el visitante
				this.goles[golesEquipoLocal+golesEquipoVisitante] = gol;
				this.golesEquipoLocal++;
			}
			
		}
		
	}
	
	/*
	 * Se registra un nuevo amonestado en el partido. 
	 * Si el mismo ya poseía una amonestación previa, se lo debe expulsar. 
	 * El método devuelve la cantidad de amonestaciones del jugador. 
	 * Los valores posibles de retorno son:
	 * 1 - Si no tenía amonestación previa o 
	 * 2 - Si ya poseía una amonestación previa y termina siendo expulsado
	 * 
	 */
	public Integer amonestar(Evento amonestado) {
		Integer cantidadDeAmonestaciones = this.obtenerCantidadDeAmonestaciones(amonestado.getAutor());
		
		if(cantidadDeAmonestaciones == 0) {
			this.amontestados[this.cantidadDeAmonestados++] = amonestado;
			cantidadDeAmonestaciones++;
		} else if (cantidadDeAmonestaciones == 1) {
			this.amontestados[this.cantidadDeAmonestados++] = amonestado;
			cantidadDeAmonestaciones++;
			
			// Se genera la expulsion
			Evento expulsado = new Evento(amonestado.getMinuto(), amonestado.getAutor(), TipoDeEvento.EXPULSION);
			this.expulsar(expulsado);
		}
		
		return cantidadDeAmonestaciones;
	} 


	/*
	 * Se registra un nuevo expulsado en el partido. 
	 */
	public Boolean expulsar(Evento expulsado) {
		/*
		 * El metodo devuelve Boolean para verificar que solo se expulse una vez a cada jugador
		 */
		Boolean seExpulso = Boolean.FALSE; 
		
		if(!this.estaExpulsado(expulsado.getAutor())) {
			this.expulsados[this.cantidadDeExpulsados++] = expulsado;
			seExpulso = Boolean.TRUE;
		}
		
		return seExpulso;
	}
	
	/*
	 * Se cuentan la cantidad de goles por equipo (Se debe considerar si el gol resultó a favor o en contra), y devuelve el equipo ganador (Si hubo un empate retorna null) 
	 */
	public EquipoDeFutbol getGanador() {
		EquipoDeFutbol ganador = null;
		
		if(this.golesEquipoLocal > this.golesEquipoVisitante) {
			ganador = local;
		} else if(this.golesEquipoLocal < this.golesEquipoVisitante) {
			ganador = visitante;
		}
		
		return ganador;
	}
	
	/*
	 * El método toString debe describir el ESTADO del partido (Equipos que se enfrentan, los goles realizados, los amonestado y expulsados).
	 */
	public String toString() {
		String resumen = "Resumen del Partido: \n";
		resumen += "Equipo Local: " + this.local + "(" + this.golesEquipoLocal + ")" + "\n";
		resumen += "Equipo Visitante: " + this.visitante + "(" + this.golesEquipoVisitante + ")" + "\n";
		resumen += "------------------------------\n";
		
		resumen += "Goles: \n";
		for (int i = 0; i < this.golesEquipoLocal+this.golesEquipoVisitante; i++) {
			resumen += this.goles[i] + "\n";
		}
		resumen += "------------------------------\n";
		resumen += "Amonestados: \n";
		for (int i = 0; i < this.cantidadDeAmonestados; i++) {
			resumen += this.amontestados[i] + "\n";
		}
		resumen += "------------------------------\n";
		resumen += "Expulsados: \n";
		for (int i = 0; i < this.cantidadDeAmonestados; i++) {
			resumen += this.expulsados[i] + "\n";
		}

		return resumen;
	}
	
	public Boolean estaAmontestado(Jugador jugador) {
		Boolean estaAmontestado = Boolean.FALSE;
		
		for (int i = 0; i < amontestados.length; i++) {
			if(amontestados[i] != null && amontestados[i].getAutor().equals(jugador)) {
				estaAmontestado = Boolean.TRUE;
			}
		}
		
		return estaAmontestado;
	}
	
	public Boolean estaExpulsado(Jugador jugador) {
		Boolean estaExpulsado = Boolean.FALSE;
		
		for (int i = 0; i < expulsados.length; i++) {
			if(expulsados[i] != null && expulsados[i].getAutor().equals(jugador)) {
				estaExpulsado = Boolean.TRUE;
			}
		}
		
		return estaExpulsado;
	}
	
	public Integer obtenerCantidadDeAmonestaciones(Jugador jugador) {
		Integer cantidadDeAmonestaciones = 0;
		
		for (int i = 0; i < amontestados.length; i++) {
			if(this.amontestados[i] != null && this.amontestados[i].getAutor().equals(jugador)) {
				cantidadDeAmonestaciones++;
			}
		}
		
		return cantidadDeAmonestaciones;
	}

	public EquipoDeFutbol getLocal() {
		return local;
	}

	public EquipoDeFutbol getVisitante() {
		return visitante;
	}
	
	public Integer getGolesEquipoLocal() {
		return golesEquipoLocal;
	}
	
	public Integer getGolesEquipoVisitante() {
		return golesEquipoVisitante;
	}

}
