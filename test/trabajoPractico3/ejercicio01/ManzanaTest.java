package trabajoPractico3.ejercicio01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ManzanaTest {

	@Test
	public void queSePuedaPesarUnObjetoDeManzana() {
		
		Manzana bolsaConManzanas = new Manzana(001, 150.0, TipoManzana.ROJA);
		
		bolsaConManzanas.pesar(2.5); // Se pesan 2,5kg
		
		assertTrue(bolsaConManzanas.fuePesado());
	}
	
	@Test
	public void queNoTengaPrecioSiNoFuePesada() {
		
		Manzana bolsaConManzanas = new Manzana(001, 150.0, TipoManzana.ROJA);
		
		assertEquals(0.0, bolsaConManzanas.getPrecio(), .01);
		
	}
	
	@Test
	public void queSePuedaObtenerElPrecioCorrectoSegunElPesoSiYaFuePesada() {
		
		Double valorEsperado = 150.0*2.5;
		
		Manzana bolsaConManzanas = new Manzana(001, 150.0, TipoManzana.ROJA);
		
		bolsaConManzanas.pesar(2.5);
		
		assertEquals(valorEsperado, bolsaConManzanas.getPrecio(), .01);
		
	}
	
	@Test 
	public void queSePuedaAplicarElDescuento() {
		Double valorEsperado = 150.0*3.0*.95;
		
		Manzana bolsaConManzanas = new Manzana(001, 150.0, TipoManzana.ROJA);
		
		bolsaConManzanas.pesar(3.0);
		bolsaConManzanas.aplicarDescuentoPorPeso();
		
		assertEquals(valorEsperado, bolsaConManzanas.getPrecio());
		
	}

}
