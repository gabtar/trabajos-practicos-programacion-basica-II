package trabajoPractico2.ejercicio01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IngenieroTest {

	private Ingeniero ingenieroDePrueba;
	private final Double MUY_PRODUCTIVO = 1.2;
	private final Double BASTANTE_PRODUCTIVO = 1.1;
	
	@Before
	public void setUp() throws Exception {
		ingenieroDePrueba = new Ingeniero("Juan", "Perez", "10-10-2021", 5000.0);
	}

	@Test
	public void queSePuedaAsignarLaProductividad() {
		Double valorEsperado = BASTANTE_PRODUCTIVO;
		Double valorObtenido;
		
		ingenieroDePrueba.establecerProductividad(BASTANTE_PRODUCTIVO);
		valorObtenido = ingenieroDePrueba.getProductividad();
		
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queLaProductividadInicialSeaUnitaria() {
		Double valorEsperado = 1.0;
		Double valorObtenido;
		
		valorObtenido = ingenieroDePrueba.getProductividad();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void siSeLoCalificaComoBastanteProductivoElSueldoSeaUnDiezProcientoMas() {
		Double sueldoEsperado = 6000.0;
		Double sueldoObtenido;
		
		ingenieroDePrueba.establecerProductividad(MUY_PRODUCTIVO);
		sueldoObtenido = ingenieroDePrueba.getSalario();
		
		assertEquals(sueldoEsperado, sueldoObtenido);
	}
	
	@Test
	public void siSeLoCalificaComoMuyProductivoElSueldoSeaUnVeinteProcientoMas() {
		Double sueldoEsperado = 5500.0;
		Double sueldoObtenido;
		
		ingenieroDePrueba.establecerProductividad(BASTANTE_PRODUCTIVO);
		sueldoObtenido = ingenieroDePrueba.getSalario();
		
		assertEquals(sueldoEsperado, sueldoObtenido);
	}
	
	

}
