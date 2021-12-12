package trabajoPractico2.ejercicio02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CarreraTest {

	private Carrera nuevaCarrera;
	
	@Before
	public void setUp() throws Exception {
		
		nuevaCarrera = new Carrera();
	}

	@Test
	public void queSePuedanAgregarRegistrosDeLaDistancia() {
		// El utimo registro sera la posicion acumulada con respecto a la inicial
		Double valorEsperado = 10.0; 
		
		nuevaCarrera.agregarRegistroDeDistancia(1.0);
		nuevaCarrera.agregarRegistroDeDistancia(2.0);
		nuevaCarrera.agregarRegistroDeDistancia(3.0);
		nuevaCarrera.agregarRegistroDeDistancia(4.0);
		
		assertEquals(valorEsperado, nuevaCarrera.ultimoRegistroDeDistancia());
	}
	
	@Test 
	public void queSePuedaObtenerElRitmoDeCarrera() {
		Double valorEsperado = 0.0;
		
		assertEquals(valorEsperado, nuevaCarrera.obtenerRitmoActual());
	}
	
	@Test 
	public void queSePuedaObtenerElRitmoDeCarreraLuegoDeVariosRegirtros() {
		
		Double valorEsperado = (5.0/3.0);  // 10 metros en 1 seg equivale a 1,66 minutos por km
		
		nuevaCarrera.agregarRegistroDeDistancia(10.0);
		
		assertEquals(valorEsperado, nuevaCarrera.obtenerRitmoActual(), .0001);
	}

}
