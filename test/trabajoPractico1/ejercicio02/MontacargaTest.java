package trabajoPractico1.ejercicio02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import trabajoPractico1.ejercicio02.Carga;
import trabajoPractico1.ejercicio02.Montacarga;

public class MontacargaTest {

	private Montacarga montacargaCienKilos;
	private Carga cargaUno;
	private Carga cargaDos;
	private Carga cargaTres;
	private Carga cargaCuatro;
	private Carga cargaCinco;
	
	@Before
	public void setUp() {
		montacargaCienKilos = new Montacarga(100.0);
		
		cargaUno = new Carga(20.0);
		cargaDos = new Carga(10.0);
		cargaTres = new Carga(50.0);
		cargaCuatro = new Carga(40.0); // Se pasa de peso (Luego del acumulado)
		cargaCinco = new Carga(10.0); // No se pasa (si no se agrego la anterior)
		
	}
	
	@Test
	public void sePuedeAgregarCorrectamenteUnaCargaValida() {
		Double valorEsperado = 20.0;
		Double valorObtenido;
		
		montacargaCienKilos.agregarCarga(cargaUno);
		
		valorObtenido = montacargaCienKilos.getPesoActual();
		
		assertEquals(valorEsperado, valorObtenido);
		
	}

	@Test
	public void noAgregaLaCargaSiSeSobrepasaElPesoMaximo() {
		
		Double valorEsperado = 80.0;
		Double valorObtenido;
		
		montacargaCienKilos.agregarCarga(cargaUno);
		montacargaCienKilos.agregarCarga(cargaDos);
		montacargaCienKilos.agregarCarga(cargaTres);
		montacargaCienKilos.agregarCarga(cargaCuatro);

		
		valorObtenido = montacargaCienKilos.getPesoActual();
		
		assertEquals(valorEsperado, valorObtenido);
		
	}
	
	@Test
	public void noAgregaLaCargaSiSeSobrepasaElPesoMaximoPeroLuegoSeAgregaSiLaSiguienteCargaNoPasaElPesoMaximo() {
		
		Double valorEsperado = 90.0;
		Double valorObtenido;
		
		montacargaCienKilos.agregarCarga(cargaUno);
		montacargaCienKilos.agregarCarga(cargaDos);
		montacargaCienKilos.agregarCarga(cargaTres);
		montacargaCienKilos.agregarCarga(cargaCuatro);
		montacargaCienKilos.agregarCarga(cargaCinco);

		
		valorObtenido = montacargaCienKilos.getPesoActual();
		
		assertEquals(valorEsperado, valorObtenido);
		
	}

}
