package trabajoPractico0.ejercicio02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EquipoDeFutbolTest {

	
	private EquipoDeFutbol equipoLocal;
	private EquipoDeFutbol equipoVisitante;
	
	private Jugador jugador1, jugador2, jugador3, jugador4, jugador5, jugador6;

	
	// Variables auxiliares
	Boolean valorEsperado;
	Boolean valorObtenido;
	
	
	@Before
	public void inicializar() {
		// Equipos
		equipoLocal = new EquipoDeFutbol("Locales");
		
		
		// Jugadores
		jugador1 = new Jugador(10, "Martin", 35, 100000.0);
		jugador2 = new Jugador(5, "Juan", 35, 100000.0);
		jugador3 = new Jugador(7, "Damian", 35, 100000.0);
		jugador4 = new Jugador(8, "Miguel", 35, 100000.0);
		jugador5 = new Jugador(9, "Eduardo", 35, 100000.0);
		jugador6 = new Jugador(1, "Daniel", 35, 100000.0);
		
		
		// Variables para comparar
		valorEsperado = Boolean.TRUE;
		
	}
	
	@Test
	public void queSePuedaAgregarJugadoresALosEquipos() {
		
		valorObtenido = equipoLocal.agregarJugador(jugador1);
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queNoSePuedaAgregarJugadoresConIgualNombre() {
		jugador2 = new Jugador(5, "Martin", 35, 100000.0);
		
		equipoLocal.agregarJugador(jugador1);
		valorObtenido = equipoLocal.agregarJugador(jugador2);
		
		assertFalse(valorObtenido);
	}
	
	@Test
	public void queNoSePuedaAgregarJugadoresConIgualNumero() {
		jugador2 = new Jugador(10, "Juan", 35, 100000.0);
		
		equipoLocal.agregarJugador(jugador1);
		valorObtenido = equipoLocal.agregarJugador(jugador2);
		
		assertFalse(valorObtenido);
	}
	
	@Test
	public void queNoSePuedaAgregarJugadoresSiElEquipoEstaCompleto() {
		equipoLocal.agregarJugador(jugador1);
		equipoLocal.agregarJugador(jugador2);
		equipoLocal.agregarJugador(jugador3);
		equipoLocal.agregarJugador(jugador4);
		equipoLocal.agregarJugador(jugador5);
		valorObtenido = equipoLocal.agregarJugador(jugador6);
		
		assertFalse(valorObtenido);

	}
	
	@Test
	public void queSePuedaCalcularElValorDelEquipo() {
		Double valorDelEquipo = jugador1.getPrecio() + jugador2.getPrecio() + jugador3.getPrecio() + jugador4.getPrecio() + jugador5.getPrecio();
		
		equipoLocal.agregarJugador(jugador1);
		equipoLocal.agregarJugador(jugador2);
		equipoLocal.agregarJugador(jugador3);
		equipoLocal.agregarJugador(jugador4);
		equipoLocal.agregarJugador(jugador5);
		
		assertEquals(valorDelEquipo, equipoLocal.calcularElValorDelEquipo());
		
	}
	
	@Test
	public void queSePuedaCalcularLaEdadPromedioDelEquipo() {
		Double edadPromedio;
		Double valorEsperado;
		
		equipoLocal.agregarJugador(jugador1);
		equipoLocal.agregarJugador(jugador2);
		equipoLocal.agregarJugador(jugador3);
		equipoLocal.agregarJugador(jugador4);
		equipoLocal.agregarJugador(jugador5);
		
		edadPromedio = (double) (jugador1.getEdad() + jugador2.getEdad() + jugador3.getEdad() + jugador4.getEdad() + jugador5.getEdad()) / 5;
		
		valorEsperado = equipoLocal.calcularLaEdadPromedioDelEquipo();
		
		assertEquals(edadPromedio, valorEsperado);
		
		
		
	}
	

}
