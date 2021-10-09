package trabajoPractico0.ejercicio02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PartidoDeFutbolTest {

	private Jugador jugadorLocal, jugadorVisitante;
	private EquipoDeFutbol local, visitante;
	
	private PartidoDeFutbol partido;
	
	private Evento gol;
	
	@Before
	public void setUp() throws Exception {
		
		// Jugadores
		jugadorLocal = new Jugador(10, "Martin", 35, 100000.0);
		jugadorVisitante = new Jugador(5, "Juan", 35, 100000.0);
		
		// Equipos
		local = new EquipoDeFutbol("Local");
		visitante = new EquipoDeFutbol("Visitante");
		
		// Agrego un jugador a cada equipo para testear
		local.agregarJugador(jugadorLocal);
		visitante.agregarJugador(jugadorVisitante);
		
		partido = new PartidoDeFutbol(local, visitante);
		
	}

	@Test
	public void siSeConvierteUnGolAFavorDelLocalSeSumeAlMarcadorLocal() {
		Integer valorEsperado = 1;
		Integer valorObtenido;
		Evento gol = new Evento(10, jugadorLocal, TipoDeEvento.GOL_A_FAVOR);
		
		partido.marcar(gol);
		
		valorObtenido = partido.getGolesEquipoLocal();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void siSeConvierteUnGolEnContraDelLocalSeSumeAlMarcadorVisitante() {
		Integer valorEsperado = 1;
		Integer valorObtenido;
		Evento gol = new Evento(10, jugadorLocal, TipoDeEvento.GOL_EN_CONTRA);
		
		partido.marcar(gol);
		
		valorObtenido = partido.getGolesEquipoVisitante();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void siSeConvierteUnGolAFavorDelVisitanteSeSumeAlMarcadorVisitante() {
		Integer valorEsperado = 1;
		Integer valorObtenido;
		Evento gol = new Evento(10, jugadorVisitante, TipoDeEvento.GOL_A_FAVOR); // Jugador 2 es del visitante!
		
		partido.marcar(gol);
		
		valorObtenido = partido.getGolesEquipoVisitante();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void siSeConvierteUnGolEnContraDelVisitanteSeSumeAlMarcadorLocal() {
		Integer valorEsperado = 1;
		Integer valorObtenido;
		Evento gol = new Evento(10, jugadorVisitante, TipoDeEvento.GOL_EN_CONTRA);
		
		partido.marcar(gol);
		
		valorObtenido = partido.getGolesEquipoLocal();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaAmonestarAUnJugador() {
		Boolean estaAmolestado;

		Evento amonestar = new Evento(10, jugadorLocal, TipoDeEvento.AMONESTACION);
		partido.amonestar(amonestar);
		
		estaAmolestado = partido.estaAmontestado(jugadorLocal);
		// System.out.println(estaAmolestado);
		
		// Verificacion
		assertTrue(estaAmolestado);
	}
	
	@Test
	public void queNoSePuedaAgregarMasDeDosAmonestacionACadaJugador() {
		Integer valorEsperado = 2;
		Integer valorObtenido;
		
		Evento amonestacion = new Evento(10, jugadorLocal, TipoDeEvento.AMONESTACION);
		Evento segundaAmonestacion = new Evento(11, jugadorLocal, TipoDeEvento.AMONESTACION);
		Evento terceraAmonestacion = new Evento(12, jugadorLocal, TipoDeEvento.AMONESTACION);
		
		partido.amonestar(amonestacion);
		partido.amonestar(segundaAmonestacion);
		partido.amonestar(terceraAmonestacion);
		
		valorObtenido = partido.obtenerCantidadDeAmonestaciones(jugadorLocal);
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSiSeAmonestaDosVecesAUnJugadorSeaExpulsado() {
		Boolean estaExpulsado;
		
		Evento amonestacion = new Evento(10, jugadorLocal, TipoDeEvento.AMONESTACION);
		Evento segundaAmonestacion = new Evento(11, jugadorLocal, TipoDeEvento.AMONESTACION);
		
		partido.amonestar(amonestacion);
		partido.amonestar(segundaAmonestacion);
		
		estaExpulsado = partido.estaExpulsado(jugadorLocal);
		
		assertTrue(estaExpulsado);
	}
	
	@Test
	public void queSePuedaRegistrarUnaExpulsion() {
		Boolean estaExpulsado;

		Evento expulsar = new Evento(10, jugadorLocal, TipoDeEvento.EXPULSION);
		partido.expulsar(expulsar);
		
		estaExpulsado = partido.estaExpulsado(jugadorLocal);
		
		// Verificacion
		assertTrue(estaExpulsado);
	}
	
	@Test
	public void queNoSePuedaExpulsarAUnJugadorQueHaSidoExpulsado() {
		
		Boolean primeraExpulsion;
		Boolean segundaExpulsion;

		Evento expulsar = new Evento(10, jugadorLocal, TipoDeEvento.EXPULSION);
		primeraExpulsion = partido.expulsar(expulsar);
		segundaExpulsion = partido.expulsar(expulsar);
		
		// Verificacion
		assertTrue(primeraExpulsion);
		assertFalse(segundaExpulsion);
	}
	
	@Test
	public void queSiElLocalHaceDosGolesAFavorSeaElGanador() {
		EquipoDeFutbol valorEsperado = local;
		EquipoDeFutbol valorObtenido;
		
		Evento golLocal = new Evento(10, jugadorLocal, TipoDeEvento.GOL_A_FAVOR);
		Evento segundoGolLocal = new Evento(20, jugadorLocal, TipoDeEvento.GOL_A_FAVOR);
		
		partido.marcar(golLocal);
		partido.marcar(segundoGolLocal);
		
		valorObtenido = partido.getGanador();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSiElVisitanteHaceDosGolesAFavorSeaElGanador() {
		EquipoDeFutbol valorEsperado = visitante;
		EquipoDeFutbol valorObtenido;
		
		Evento golLocal = new Evento(10, jugadorVisitante, TipoDeEvento.GOL_A_FAVOR);
		Evento segundoGolLocal = new Evento(20, jugadorVisitante, TipoDeEvento.GOL_A_FAVOR);
		
		partido.marcar(golLocal);
		partido.marcar(segundoGolLocal);
		
		valorObtenido = partido.getGanador();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSiElLocalHaceUnGolAFavorYOtroSeaUnEmpate() {
		EquipoDeFutbol valorEsperado = null;
		EquipoDeFutbol valorObtenido;
		
		Evento golAFavorLocal = new Evento(10, jugadorLocal, TipoDeEvento.GOL_A_FAVOR);
		Evento golEnContraLocal = new Evento(20, jugadorLocal, TipoDeEvento.GOL_EN_CONTRA);
		
		valorObtenido = partido.getGanador();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void pruebaDelToString() {
		/* Prueba del resumen del partido por consola */
		Evento golAFavorLocal = new Evento(10, jugadorLocal, TipoDeEvento.GOL_A_FAVOR);
		Evento golEnContraLocal = new Evento(20, jugadorLocal, TipoDeEvento.GOL_EN_CONTRA);
		Evento golAFavorVisitante = new Evento(20, jugadorVisitante, TipoDeEvento.GOL_A_FAVOR);
		Evento amarillaLocal = new Evento(25, jugadorLocal, TipoDeEvento.AMONESTACION);
		Evento segundaAmarillaLocal = new Evento(28, jugadorLocal, TipoDeEvento.AMONESTACION);
		Evento expulsadoVisitante = new Evento(40, jugadorVisitante, TipoDeEvento.EXPULSION);
		
		partido.marcar(golAFavorLocal);
		partido.marcar(golEnContraLocal);
		partido.marcar(golAFavorVisitante); // 2 a 1 gana el visitante
		partido.amonestar(amarillaLocal);
		partido.amonestar(segundaAmarillaLocal); // Se expulsa el jugadorLocal
		partido.expulsar(expulsadoVisitante);
		
		System.out.println(partido);
	}

}
