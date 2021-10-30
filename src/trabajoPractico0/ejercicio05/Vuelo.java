package trabajoPractico0.ejercicio05;

import java.util.Set;
import java.util.TreeSet;

public class Vuelo {

	private static Integer identificadorDeVuelo = 0;
	private final Integer CANTIDAD_MAXIMA_DE_PASAJEROS_POR_FILA = 20;
	private final Integer CANTIDAD_MAXIMA_DE_PASAJEROS_POR_COLUMNA = 4;
	
	private Integer numeroDeVuelo;
	private String origen;
	private String destino;
	private Set<Pasajero> pasajeros;
	private Boolean asientosOcupados[][];
	
	public Vuelo(String origen, String destino) {
		
		this.numeroDeVuelo = identificadorDeVuelo++;
		this.origen = origen;
		this.destino = destino;
		
		this.pasajeros = new TreeSet<Pasajero>();
		this.asientosOcupados = new Boolean[CANTIDAD_MAXIMA_DE_PASAJEROS_POR_FILA][CANTIDAD_MAXIMA_DE_PASAJEROS_POR_COLUMNA];
		
		// Se inicializan los asientos en False, sin asignar
		for (int i = 0; i < asientosOcupados.length; i++) {
			for (int j = 0; j < asientosOcupados[0].length; j++) {
				asientosOcupados[i][j] = Boolean.FALSE;
			}
		}
	}

	/*
	 * Agrega un pasajero, no puede haber 2 pasajeros con igual dni
	 */
	public Boolean agregarPasajero(Pasajero pasajero) {
		return this.pasajeros.add(pasajero);
	}

	/*
	 * Verifica si el asiento indicado se encuentra disponible.
	 */
	public Boolean elAsientoEstaOcupado(int fila, int columna) {
		Boolean estaDisponible = Boolean.FALSE;
		
		if(fila < CANTIDAD_MAXIMA_DE_PASAJEROS_POR_FILA && columna < CANTIDAD_MAXIMA_DE_PASAJEROS_POR_COLUMNA) {
			estaDisponible = this.asientosOcupados[fila][columna];
		}
		
		return estaDisponible;
	}

	/*
	 * Busca un pasajero en la lista de pasajeros a partir del DNI. Si no lo
	 * encuentra devuelve null.
	 */
	public Pasajero buscarPasajero(Integer dni) {
		Pasajero pasajeroABuscar = null;
		
		for (Pasajero pasajero : this.pasajeros) {
			if(pasajero.getDni().equals(dni)) {
				pasajeroABuscar = pasajero;
			}
		}
		
		return pasajeroABuscar;
	}

	public boolean asignarAsiento(Pasajero pasajero, int fila, int columna) {
		Boolean sePuedeAsignar = Boolean.FALSE;
		
		if(!pasajero.getTieneAsientoAsignado() && fila < CANTIDAD_MAXIMA_DE_PASAJEROS_POR_FILA && columna < CANTIDAD_MAXIMA_DE_PASAJEROS_POR_COLUMNA && !this.asientosOcupados[fila][columna]) {
			// Se puede asignar
			sePuedeAsignar = Boolean.TRUE;
			this.asientosOcupados[fila][columna] = sePuedeAsignar;
			pasajero.setTieneAsientoAsignado(sePuedeAsignar);
		}
		
		return sePuedeAsignar;
	}

	/*
	 * Los devuelve ordenados naturalmente por el criterio de Comparable en pasajero (por apellido)
	 */
	public TreeSet<Pasajero> getPasajeros() {
		return (TreeSet<Pasajero>) this.pasajeros;
	}
	
	/*
	 * Se devuelven los datos ordenados por Dni
	 */
	public TreeSet<Pasajero> obtenerPasajerosOrdenadosPorApellido() {
		TreeSet<Pasajero> ordenadosPorDni = new TreeSet<Pasajero>(new PorApellidoComparator());
		ordenadosPorDni.addAll(this.pasajeros);
		
		return ordenadosPorDni;
	}

	public String toString() {
		/*
		 * Devuelve un mapa de los asientos del vuelo indicando por cada uno si se
		 * encuentra libre "L" u ocupado "O".
		 */
		String mapaDeAsientos = "";
		
		for (int i = 0; i < asientosOcupados.length; i++) {
			for (int j = 0; j < asientosOcupados[i].length; j++) {
				mapaDeAsientos += (asientosOcupados[i][j]) ? "O " : "L ";
			}
			mapaDeAsientos += "\n";
		}

		return mapaDeAsientos;
	}

	public Integer getCantidadDePasajeros() {
		return this.pasajeros.size();
	}

}
