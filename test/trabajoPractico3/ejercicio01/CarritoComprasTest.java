package trabajoPractico3.ejercicio01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CarritoComprasTest {

	private CarritoCompras carritoSitioWeb;
	private Leche sachetUnLitro;
	private Manzana manzanasRojas;
	
	@Before
	public void setUp() {
		
		carritoSitioWeb = new CarritoCompras();
		
		sachetUnLitro = new Leche(000, 100.0, "Serenisima", 1.0);
		
		manzanasRojas = new Manzana(001, 150.0, TipoManzana.ROJA);
	}

	@Test
	public void queSePuedaAgregarUnProductoAlCarrito() throws NoPesadoAunException{
		
		carritoSitioWeb.agregarUnProducto(1, sachetUnLitro);
		
		assertEquals(sachetUnLitro, carritoSitioWeb.verDetallesDelProducto(1));
	}
	
	@Test 
	public void queSePuedaAgregarUnProductoYaPesadoAlCarrito() throws NoPesadoAunException {
		
		manzanasRojas.pesar(2.0);
		
		carritoSitioWeb.agregarUnProducto(1, manzanasRojas);
		
		assertEquals(manzanasRojas, carritoSitioWeb.verDetallesDelProducto(1));
	}
	
	@Test(expected = NoPesadoAunException.class) 
	public void queNoSePuedaAgregarUnProductoAlCarritoSiNoFuePesado() throws NoPesadoAunException{
		
		carritoSitioWeb.agregarUnProducto(1, manzanasRojas);
		
	}
	
	@Test
	public void queSePuedaObtenerElImporteTotalDelCarrito() throws NoPesadoAunException{
		Double valorEsperado = 2*150.0 + 100.0;
				
		manzanasRojas.pesar(2.0);
		carritoSitioWeb.agregarUnProducto(1, manzanasRojas);
		carritoSitioWeb.agregarUnProducto(2, sachetUnLitro);
		
		assertEquals(valorEsperado, carritoSitioWeb.obtenerElImporteTotalDelCarrito());
	}
	
	@Test
	public void queSePuedaObtenerElImporteTotalDelCarritoConLosDescuentos() throws NoPesadoAunException{
		Double valorEsperado = 3*150.0*.95 + 100.0*.9*5;
		
		manzanasRojas.pesar(3.0);
		sachetUnLitro.setCantidadDeUnidades(5);
		
		carritoSitioWeb.agregarUnProducto(1, manzanasRojas);
		carritoSitioWeb.agregarUnProducto(2, sachetUnLitro);
		
		carritoSitioWeb.verificarSiHayDescuentosPorCantidad();
		
		assertEquals(valorEsperado, carritoSitioWeb.obtenerElImporteTotalDelCarrito());
	}

}
