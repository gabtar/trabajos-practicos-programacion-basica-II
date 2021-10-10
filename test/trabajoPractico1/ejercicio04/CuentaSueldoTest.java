package trabajoPractico1.ejercicio04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CuentaSueldoTest {

	private Cliente cliente;
	private CuentaSueldo cuentaSueldo;

	@Before
	public void setUp() {
		cliente = new Cliente("Juan", "Perez", 111111111);
		cuentaSueldo = new CuentaSueldo(cliente);
		
	}
	@Test
	public void queSePuedaAgregarSaldoALaCuenta() {
		Double saldoEsperado = 1000.0;
		Double saldoObtenido;
		
		cuentaSueldo.depositar(1000.0);
		
		saldoObtenido = cuentaSueldo.getSaldo();
		
		assertEquals(saldoEsperado, saldoObtenido);
	}

}
