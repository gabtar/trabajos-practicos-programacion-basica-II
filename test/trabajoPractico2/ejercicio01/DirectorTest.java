package trabajoPractico2.ejercicio01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DirectorTest {

	private Director directorDePrueba;

	@Before
	public void setUp() throws Exception {
		directorDePrueba = new Director("Juan", "Perez", "10-10-2021", 5000.0);
	}

	@Test
	public void queSePuedaAsignarCocheraAlDirector() {
		Integer valorEsperado = 1;
		Integer valorObtenido;

		directorDePrueba.asignarCochera(valorEsperado);
		valorObtenido = directorDePrueba.getNumeroDeCochera();

		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queElSalarioDelDirectorTengaElAdicionalPorSerDirector() {
		Double salarioEsperado = 5000.0 + 5000.0; // Normal + Adicional
		Double salarioObtenido;
		
		salarioObtenido = directorDePrueba.getSalario();
		
		assertEquals(salarioEsperado, salarioObtenido);
	}

}
