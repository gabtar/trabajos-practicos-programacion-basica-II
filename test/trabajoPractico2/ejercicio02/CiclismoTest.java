package trabajoPractico2.ejercicio02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CiclismoTest {

	private Ciclismo nuevaActividadDeCiclismo;
	
	@Before
	public void setUp() throws Exception {
		
		nuevaActividadDeCiclismo = new Ciclismo();
	}

	@Test
	public void queSePuedaObtenerLaVelocidadEnKilometrosPorHoraSiNoSeRecorieronKilometros() {
		Double valorEsperado = 0.0;
		
		assertEquals(valorEsperado, nuevaActividadDeCiclismo.obtenerVelocidadMedia());
	}
	
	@Test
	public void queSePuedaObtenerLaVelocidadEnKilometrosPorHoraDespuesDeVariosKilometros() {
		Double valorEsperado = 36.0;
		
		/*
		 * Se registran 10 metros por segundo (constantes) 
		 * Al cabo de 1 hora deberia dar 36 km/h (3600*10)
		 */
		Double distanciaInicial = 10.0;
		for (int i = 0; i < 3600; i++) {
			nuevaActividadDeCiclismo.agregarRegistroDeDistancia(distanciaInicial);
		}

		assertEquals(valorEsperado, nuevaActividadDeCiclismo.obtenerVelocidadMedia());
	}
	
	@Test
	public void queSePuedaObtenerLaCadenciaEnRPM() {
		Double valorEsperado = 72.0;
		
		/*
		 * Se registran 10 metros por segundo (constantes) 
		 * Al cabo de 1 hora deberia dar 36 km/h (3600*10)
		 */
		Double distanciaInicial = 10.0;
		for (int i = 0; i < 3600; i++) {
			nuevaActividadDeCiclismo.agregarRegistroDeDistancia(distanciaInicial);
		}
		// La cadencia deberia resultar la velocidad * 2 = 72 pedaleadas por minuto
		
		assertEquals(valorEsperado, nuevaActividadDeCiclismo.obtenerCadencia());
	}

}
