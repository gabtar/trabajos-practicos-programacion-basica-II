package trabajoPractico2.ejercicio02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NatacionTest {

	private Natacion nuevaActividadDeNatacion;
	
	@Before
	public void setUp() throws Exception {
		
		nuevaActividadDeNatacion = new Natacion();
		
	}

	@Test
	public void queSePuedaObtenerElRitmoSiNoSeRecorieronMetros() {
		Double valorEsperado = 0.0;

		assertEquals(valorEsperado, nuevaActividadDeNatacion.obtenerRitmoActual());
	}
	
	@Test
	public void queSePuedaObtenerElRitmoSiSeRecorieronVariosMetros() {
		Double valorEsperado = 0.8333;
		
		/*
		 * Se simula que se toman 60 registros a velocidad constante
		 * cada registro se avanza -> 2metros (constante)
		 * Son 120 metros en 1 minuto
		 * El ritmo debería resultar 0,833 minutos cada 100 metros
		 */
		Double distanciaInicial = 2.0;
		for (int i = 0; i < 60; i++) {
			nuevaActividadDeNatacion.agregarRegistroDeDistancia(distanciaInicial);
		}

		assertEquals(valorEsperado, nuevaActividadDeNatacion.obtenerRitmoActual(), .0001);
	}

}
