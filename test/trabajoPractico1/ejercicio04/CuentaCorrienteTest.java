package trabajoPractico1.ejercicio04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CuentaCorrienteTest {

	private Cliente cliente;
	private CuentaCorriente cuentaCorriente;

	@Before
	public void setUp() {
		cliente = new Cliente("Juan", "Perez", 111111111);
		cuentaCorriente = new CuentaCorriente(cliente);
		
	}

	@Test
	public void queSeCobreCincoPorcientoDeComisionAlDepositarDineroLuegoDeHaberRealizadoUnaExtraccionMayorAlSaldo() {
		Double valorEsperado = 95.0;
		
		cuentaCorriente.depositar(100.0);
		// Al extraer < al descubierto el banco nos presta esos 100, pero cobra 5 de comision
		cuentaCorriente.extraer(200.0);
		// Repongo los 100 que me presto el banco y la por el gasto de comision deben quedar $95
		cuentaCorriente.depositar(200.0); 
		
		Double valorObtenido = cuentaCorriente.getSaldo();
		
		assertEquals(valorEsperado, valorObtenido);	
	}
	
	@Test
	public void queSeCobreElCincoPorCientoDeComisionPorMasQueElProximoDepositoNoSeaSuficieteParaCubrirElDescubierto( ) {
		Double valorEsperado = 5.0;
		
		cuentaCorriente.depositar(100.0);
		// Al extraer < al descubierto el banco nos presta esos 100, pero cobra 5 de comision
		cuentaCorriente.extraer(200.0);
		// Repongo los 100 que me presto el banco y la por el gasto de comision deben quedar $95
		cuentaCorriente.depositar(100.0); 
		
		Double valorObtenido = cuentaCorriente.getDescubiertoActual();
		
		assertEquals(valorEsperado, valorObtenido);	
	}
	
	@Test
	public void queUnaExtraccionCuandoYaSeTieneDeudaIncrementeLaDeuda() {
		Double valorDeudaEsperado = 7.5;
		Double descubiertoEsperado = 150.0;
		
		cuentaCorriente.depositar(100.0);
		cuentaCorriente.extraer(200.0);
		cuentaCorriente.extraer(50.0); 
		
		Double valorDeudaObtenido = cuentaCorriente.getDeuda();
		Double descubiertoObtenido = cuentaCorriente.getDescubiertoActual();
		
		assertEquals(valorDeudaEsperado, valorDeudaObtenido);	
		assertEquals(descubiertoEsperado, descubiertoObtenido);
		
	}
	
	@Test
	public void queVariasOperacionesDeDepositoYExtraccionGenerenElSaldoYLaDeudaCorrecto() {
		
		Double valorDeudaEsperado = 0.0;
		Double descubiertoEsperado = 0.0;
		Double valorSaldoEsperado = 0.5;
		Double valorDeudaObtenido;
		Double valorDescubiertoObtenido;
		Double valorSaldoObtenido;
		
		cuentaCorriente.depositar(100.0);
		cuentaCorriente.extraer(200.0);
		cuentaCorriente.extraer(50.0); 
		cuentaCorriente.depositar(50.0);
		cuentaCorriente.extraer(40.0); 
		cuentaCorriente.depositar(150.0);
		
		valorDeudaObtenido = cuentaCorriente.getDeuda();
		valorSaldoObtenido = cuentaCorriente.getSaldo();
		valorDescubiertoObtenido = cuentaCorriente.getDescubiertoActual();
		
		assertEquals(valorDeudaEsperado, valorDeudaObtenido);	
		assertEquals(descubiertoEsperado, valorDescubiertoObtenido);
		assertEquals(valorSaldoEsperado, valorSaldoObtenido);
		
	}

}
