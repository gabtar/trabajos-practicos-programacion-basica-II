package trabajoPractico1.ejercicio04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BancoTest {

	private Banco frances;
	
	@Before
	public void setUp() {
		frances = new Banco("Francés");
	}

	@Test
	public void queSePuedaAgregarUnClineteAlBanco() {
		
		frances.agregarCliente("Juan", "Perez", 1111111111);
		
		Cliente clienteAgregado = frances.buscarClientePorDni(1111111111);
		
		assertNotNull(clienteAgregado);
		
	}
	
	@Test
	public void queNoSePuedaAgregarUnClienteConElMismoDni() {
		Boolean valorEsperado = Boolean.FALSE;
		Boolean valorObtenido;
		
		
		frances.agregarCliente("Juan", "Perez", 1111111111);
		valorObtenido = frances.agregarCliente("Juan", "Perez", 1111111111);
		
		assertEquals(valorEsperado,valorObtenido);
		
	}
	
	@Test
	public void queSePuedaCrearUnaCuentaEnUnCliente() {
		Cuenta valorEsperado;
		Boolean crearCuentaSueldo, crearCajaAhorro, crearCuentaCorriente;
		
		frances.agregarCliente("Juan", "Perez", 1111111111);
		crearCuentaSueldo = frances.crearCuentaAlCliente(1111111111, TipoDeCuenta.CUENTA_SUELDO);
		crearCajaAhorro = frances.crearCuentaAlCliente(1111111111, TipoDeCuenta.CAJA_DE_AHORRO); 
		crearCuentaCorriente = frances.crearCuentaAlCliente(1111111111, TipoDeCuenta.CUENTA_CORRIENTE);
		
		valorEsperado = frances.buscarClientePorDni(1111111111).obtenerCuentas()[0];
		
		assertNotNull(valorEsperado);
		assertTrue(crearCuentaSueldo);
		assertTrue(crearCajaAhorro);
		assertTrue(crearCuentaCorriente);
	}
	
	@Test
	public void siUnClienteTieneSaldoMayorAUnMillonSeaVIP() {
		TipoCliente tipoEsperado = TipoCliente.VIP;
		TipoCliente tipoObtenido;
		
		Cliente cliente;
		
		frances.agregarCliente("Juan", "Perez", 1111111111);
		frances.crearCuentaAlCliente(1111111111, TipoDeCuenta.CUENTA_SUELDO);
		
		// Si se deposita 1 millon deberia devolver que es VIP
		frances.buscarClientePorDni(1111111111).obtenerCuentas()[0].depositar(1000001.0); 
		
		tipoObtenido = frances.clasificarCliente(1111111111);
		
		assertEquals(tipoEsperado, tipoObtenido);
		
	}
	
	@Test
	public void siUnClienteTieneSaldoMayorAUnMillonPeroSaldoNEgativoEnUnaCuentaCorrienteNoEsVIP() {
		TipoCliente tipoEsperado = TipoCliente.NORMAL;
		TipoCliente tipoObtenido;
		
		Cliente cliente;
		
		frances.agregarCliente("Juan", "Perez", 1111111111);
		frances.crearCuentaAlCliente(1111111111, TipoDeCuenta.CUENTA_SUELDO);
		frances.crearCuentaAlCliente(1111111111, TipoDeCuenta.CUENTA_CORRIENTE);
		
		// Si se deposita 1 millón deberia devolver que es VIP
		frances.buscarClientePorDni(1111111111).obtenerCuentas()[0].depositar(1000001.0);
		// Si extraigo menos del descubierto, la cuenta queda con saldo negativo
		frances.buscarClientePorDni(1111111111).obtenerCuentas()[1].extraer(100.0);
		
		tipoObtenido = frances.clasificarCliente(1111111111);
		System.out.println(tipoObtenido);
		
		assertEquals(tipoEsperado, tipoObtenido);
		
	}

}
