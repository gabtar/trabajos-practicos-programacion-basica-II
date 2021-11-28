package trabajoPractico2.ejercicio02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SmartWatchTest {

	private SmartWatch garmin;
	private Carrera nuevaCarrera;
	
	@Before
	public void setUp() throws Exception {
		
		garmin = new SmartWatch();
		
		nuevaCarrera = new Carrera();
	}

	@Test
	public void queSePuedaIniciarUnaNuevaActividad() {
		Integer valorEsperado = 1;
		try {
			garmin.inicarActividad(TipoActividad.CARRERA, 100);
		} catch (SinSenalException e) {
			valorEsperado = 0;
		}
		
		assertEquals(valorEsperado, garmin.getCantidadDeActividadesRegistradas());
	}
	
	@Test
	public void queSePuedaObtenerLaUltimaActividadRegistrada() {
		Actividad ultimaActividad;
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido;
		Boolean seConecto;
		
		do {
			// SE ASEGURA QUE ANTES DEL TEST HAYA CONEXION GPS
			seConecto = garmin.conectarConSateliteGPS();
		} while(!seConecto);
		
		try {
			garmin.inicarActividad(TipoActividad.CARRERA, 100);
		} catch (SinSenalException e) {
			// Nunca llegaria aca
			e.printStackTrace();
		}
		
		ultimaActividad = garmin.ultimaActividadRegistrada();
		
		valorObtenido = ultimaActividad instanceof Carrera;
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSiElGpsNoEstaConectadoNoSePuedaIniciarLaActividad() {
		Boolean seProdujoException;
		Integer cantidadDeActividadesConException = 0;
		Integer cantidadDeActividadesSinException = 1;
		
		try {
			garmin.inicarActividad(TipoActividad.NATACION, 100);
			seProdujoException = Boolean.FALSE;
		} catch (SinSenalException e) {
			seProdujoException = Boolean.TRUE;
		}
		
		if(seProdujoException) {
			assertEquals(cantidadDeActividadesConException,garmin.getCantidadDeActividadesRegistradas());
		} else {
			assertEquals(cantidadDeActividadesSinException,garmin.getCantidadDeActividadesRegistradas());
		}
		
	}

}
