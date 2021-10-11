package trabajoPractico2.ejercicio01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GerenteTest {

	private Gerente gerenteDePrueba;

	@Before
	public void setUp() {
		gerenteDePrueba = new Gerente("Juan", "Perez", "10-10-2021", 5000.0);
	}
	
	@Test
	public void queSePuedaAsignarCocheraAlGerente() {
		Integer valorEsperado = 1;
		Integer valorObtenido;
		
		gerenteDePrueba.asignarCochera(valorEsperado);
		valorObtenido = gerenteDePrueba.getNumeroDeCochera();
		
		assertEquals(valorEsperado, valorObtenido);
	}

}
