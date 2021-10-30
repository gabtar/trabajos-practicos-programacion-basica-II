package trabajoPractico0.ejercicio05;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class VueloTest {

	private Vuelo vuelo;
	private Pasajero pasajeroUno;
	private Pasajero pasajeroDos;
	private Pasajero pasajeroTres;
	private Pasajero pasajeroCuatro;
	private Pasajero pasajeroCinco;

	@Before
	public void setUp() throws Exception {
		
		pasajeroUno = new Pasajero("Miguel", "Gutierrez", 10000000);
		pasajeroDos = new Pasajero("Damian", "Martinez", 10000000);
		pasajeroTres = new Pasajero("Juan", "Lopez", 10000001);
		pasajeroCuatro = new Pasajero("Andrea", "Gutierrez", 10000006);
		pasajeroCinco = new Pasajero("Ramon", "Perez", 9000001);
		
		vuelo = new Vuelo("Buenos Aires", "New York");
	}

	@Test
	public void queSePuedaAgregarUnPasajero() {
		assertTrue(vuelo.agregarPasajero(pasajeroUno));
	}
	
	@Test
	public void queNoSePuedaAgregarUnPasajeroSiYaExisteOtroConIgualDni() {
		Boolean valorEsperado = Boolean.FALSE;
		Boolean valorObtenido;
		
		vuelo.agregarPasajero(pasajeroUno);
		valorObtenido = vuelo.agregarPasajero(pasajeroDos);
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaBuscarUnPasajeroPorDni() {
		Pasajero pasajeroEsperado = pasajeroUno;
		Pasajero pasajeroObtenido;
		
		vuelo.agregarPasajero(pasajeroUno);
		vuelo.agregarPasajero(pasajeroTres);
		vuelo.agregarPasajero(pasajeroCuatro);
		
		pasajeroObtenido = vuelo.buscarPasajero(10000000);
		
		assertEquals(pasajeroEsperado,pasajeroObtenido);
	}
	
	
	@Test
	public void queSeVerifiqueSiUnAsientoNoFueAsignadoANingunPasajero() {
		Boolean valorEsperado = Boolean.FALSE;
		Boolean valorObtenido;
		
		valorObtenido = vuelo.elAsientoEstaOcupado(0, 0); // No se asigno a nadie, debe ser False
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSeVerifiqueSiUnAsientoYaFueAsignadoAUnPasajero() {
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido;
		
		vuelo.agregarPasajero(pasajeroUno);
		vuelo.asignarAsiento(pasajeroUno, 0, 0);
		
		valorObtenido = vuelo.elAsientoEstaOcupado(0, 0); // No se asigno a nadie, debe ser False
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test 
	public void queSePuedanObtenerLosPasajerosOrdenadosPorDniDeMayorAMenor() {
		// Segun el orden la interfaz comparable del TreeSet
		TreeSet<Pasajero> pasajerosOrdenadosPorDni;
		Integer cantidadDePasajeros = 3;
		
		vuelo.agregarPasajero(pasajeroCuatro); // 10000006
		vuelo.agregarPasajero(pasajeroUno); // 10000000
		vuelo.agregarPasajero(pasajeroDos); // 10000000 - Duplicado no lo admite
		vuelo.agregarPasajero(pasajeroCinco); // 9000001
		
		pasajerosOrdenadosPorDni = vuelo.getPasajeros();
		
		assertEquals(cantidadDePasajeros, vuelo.getCantidadDePasajeros());
		assertEquals(pasajeroCinco, pasajerosOrdenadosPorDni.first());
		assertEquals(pasajeroCuatro, pasajerosOrdenadosPorDni.last());
	}
	
	@Test 
	public void queSePuedanObtenerLosPasajerosOrdenadosPorApellido() {
		// Segun el orden la interfaz comparable del TreeSet
		TreeSet<Pasajero> pasajerosOrdenadosPorApellido;
		
		vuelo.agregarPasajero(pasajeroDos); // Martinez
		vuelo.agregarPasajero(pasajeroCinco); // Perez
		vuelo.agregarPasajero(pasajeroUno); // Gutierez
		
		pasajerosOrdenadosPorApellido = vuelo.obtenerPasajerosOrdenadosPorApellido();
		
		assertEquals(pasajeroUno, pasajerosOrdenadosPorApellido.first());
		assertEquals(pasajeroCinco, pasajerosOrdenadosPorApellido.last());
	}

}
