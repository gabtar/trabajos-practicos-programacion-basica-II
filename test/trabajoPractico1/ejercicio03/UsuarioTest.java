package trabajoPractico1.ejercicio03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

	@Test
	public void queSePuedaCrearUnUsuario() {
		Usuario nuevo = new Usuario("Prueba");
		
		assertNotNull(nuevo);
	}
	
	public void queSePuedaObtenerElNombreDeUnUsuario() {
		Usuario nuevo = new Usuario("Prueba");
		String valorEsperado = "Prueba";
		
		assertEquals(valorEsperado, nuevo.getNombre());
	}
}
