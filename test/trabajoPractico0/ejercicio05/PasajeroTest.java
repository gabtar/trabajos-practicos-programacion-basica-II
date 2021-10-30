package trabajoPractico0.ejercicio05;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PasajeroTest {

	@Test
	public void queSePuedaObtenerElNombre() {
		String valorEsperado = "Martin";
		
		Pasajero pasajeroUno = new Pasajero("Martin", "Gomez", 10000000);
		
		assertEquals(valorEsperado, pasajeroUno.getNombre());
	}
	
	@Test
	public void queSePuedaObtenerApellido() {
		String valorEsperado = "Gomez";
		
		Pasajero pasajeroUno = new Pasajero("Martin", "Gomez", 10000000);
		
		assertEquals(valorEsperado, pasajeroUno.getApellido());
	}
	
	@Test
	public void queSePuedaObtenerElDni() {
		Integer valorEsperado = 10000000;
		
		Pasajero pasajeroUno = new Pasajero("Martin", "Gomez", 10000000);
		
		assertEquals(valorEsperado, pasajeroUno.getDni());
	}

}
