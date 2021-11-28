package trabajoPractico3.ejercicio01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LecheTest {

	@Test
	public void queSePuedaCrearUnProductoDelTipoLeche() {
		
		Leche sachetUnLitro = new Leche(000, 100.0, "Serenisima", 1.0);
		
		assertEquals((Integer) 000 , sachetUnLitro.getCodigo());
		assertEquals((Double) 100.0 , sachetUnLitro.getPrecio());
		assertEquals((String) "Serenisima" , sachetUnLitro.getMarca());
		assertEquals((Double) 1.0 , sachetUnLitro.getTamanioEnvasePorLitro());
	}
	
	@Test
	public void queSePuedaAplicarElDescuentoPorCantidad() {
		Double valorEsperado = 90.0;
		
		Leche sachetUnLitro = new Leche(000, 100.0, "Serenisima", 1.0);
		
		sachetUnLitro.aplicarDescuentoPorCantidad();
		
		assertEquals(valorEsperado, sachetUnLitro.getPrecio());
	}
	
	@Test
	public void queSePuedaObtenerElPrecioTotalSiLaCantidadEsMayorQueUno() {
		Double valorEsperado = 90.0*5;
		
		Leche sachetUnLitro = new Leche(000, 100.0, "Serenisima", 1.0);
		sachetUnLitro.setCantidadDeUnidades(5);
		
		sachetUnLitro.aplicarDescuentoPorCantidad();
		
		assertEquals(valorEsperado, sachetUnLitro.getPrecio());
	}

}
