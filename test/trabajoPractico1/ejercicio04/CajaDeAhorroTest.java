package trabajoPractico1.ejercicio04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CajaDeAhorroTest {

	private Cliente cliente;
	private CajaDeAhorro cajaDeAhorro;
	
	@Before
	public void setUp() {
		cliente = new Cliente("Juan", "Perez", 111111111);
		cajaDeAhorro = new CajaDeAhorro(cliente);
		
		// Deposito 2000.0 
		cajaDeAhorro.depositar(2000.0);
	}

	@Test
	public void luegoDePasarLasCincoExtraccionesSeCobreLaComision() {
		Double extraccion = 100.0;
		Double valorEsperado = 2000.0 - 5* extraccion - 106.0;
		
		cajaDeAhorro.extraer(extraccion);
		cajaDeAhorro.extraer(extraccion);
		cajaDeAhorro.extraer(extraccion);
		cajaDeAhorro.extraer(extraccion);
		cajaDeAhorro.extraer(extraccion);
		// Se debe cobar el adicional
		cajaDeAhorro.extraer(extraccion);
		
		Double valorObtenido = cajaDeAhorro.getSaldo();
		
		assertEquals(valorEsperado, valorObtenido);
	}

}
