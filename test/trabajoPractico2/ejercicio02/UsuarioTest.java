package trabajoPractico2.ejercicio02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void queSePuedaObtenerElNombre() {
		String valorEsperado = "Nombre";
		
		Usuario nuevo = new Usuario("Nombre", 25, 70.0, 180);
		
		assertEquals(valorEsperado, nuevo.getNombre());
	}
	
	@Test
	public void queSePuedaObtenerLaEdad() {
		Integer valorEsperado = 25;
		
		Usuario nuevo = new Usuario("Nombre", 25, 70.0, 180);
		
		assertEquals(valorEsperado, nuevo.getEdadActual());
	}
	
	@Test
	public void queSePuedaObtenerElPesoActual() {
		Double valorEsperado = 70.0;
		
		Usuario nuevo = new Usuario("Nombre", 25, 70.0, 180);
		
		assertEquals(valorEsperado, nuevo.getPesoActual());
	}
	
	@Test
	public void queSePuedaObtenerLaAlturaActual() {
		Integer valorEsperado = 180;
		
		Usuario nuevo = new Usuario("Nombre", 25, 70.0, 180);
		
		assertEquals(valorEsperado, nuevo.getAlturaActual());
	}
}
