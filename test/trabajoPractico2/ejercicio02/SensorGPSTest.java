package trabajoPractico2.ejercicio02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/*
 * Es dificil testear cuando se espera un valor aleatorio
 * Para el caso se podria obtener la velocidad instantanea 
 * en cada vez que actualiza la posicion porque resulta ser
 * la diferencia entre posicones (ya que se toma la variacion 
 * en 1 segundo
 */
public class SensorGPSTest {

	private SensorGPS sensorGps;
	private SensorGPS sensorGpsConectado;
	
	@Before
	public void setUp() throws Exception {
		
		sensorGps = new SensorGPS();
		
		sensorGpsConectado = new SensorGPS();
		
		do {
			sensorGpsConectado.obtenerSenal();
		} while(!sensorGpsConectado.estaConectadoAlSatelite());
		
	}

	@Test
	public void queSePuedaObtenerLaPosicionActual() {
		Double valorEsperado = 0.0;
		
		assertEquals(valorEsperado, sensorGps.getPosicionActual());
	}
	
	@Test
	public void queSePuedaActualizarLaPosicionActual() {
		Double valorReferencia = 0.0;
		
		try {
			sensorGpsConectado.actualizarPosicion();
		} catch (SinSenalException e) {
			e.printStackTrace();
		}
		
		assertNotEquals(valorReferencia, sensorGpsConectado.getPosicionActual());
	}
	
	@Test 
	public void queSePuedaObtenerLaVelocidadInstantanea() {
		Double valorEsperado = 0.0;
		
		try {
			sensorGpsConectado.actualizarPosicion();
			sensorGpsConectado.actualizarPosicion();
			sensorGpsConectado.actualizarPosicion();
		} catch (SinSenalException e) {
			e.printStackTrace();
		}
		
		assertNotEquals(valorEsperado, sensorGpsConectado.obtenerVelocidadInstantanea());
	}
	
	@Test 
	public void queElGPSPuedaObtenerSenalDelSatelite() {
		Boolean valorEsperado = Boolean.TRUE;
		
		while(!sensorGps.estaConectadoAlSatelite()) {
			sensorGps.obtenerSenal();
		}
		
		assertEquals(valorEsperado, sensorGps.estaConectadoAlSatelite());
	}
	
	@Test
	public void queSiNoEstaConectadoAlSateliteLanzeUnaSinSenalException() {
		Boolean valorEsperado;
		Boolean valorObtenido;
		
		try {
			sensorGps.actualizarPosicion();
			valorObtenido = sensorGps.estaConectadoAlSatelite();
			valorEsperado = Boolean.TRUE;
		} catch (SinSenalException e) {
			valorObtenido = sensorGps.estaConectadoAlSatelite();
			valorEsperado = Boolean.FALSE;
		}
		
		assertEquals(valorEsperado, valorObtenido);
		
	}

}
