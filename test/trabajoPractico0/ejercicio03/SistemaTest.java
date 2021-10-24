package trabajoPractico0.ejercicio03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SistemaTest {

	private Sistema servidorCentral;
	
	@Before
	public void setUp() throws Exception {
		servidorCentral = new Sistema("Server01", 100);
	}

	@Test
	public void queSePuedaAgregarUnUsuarioAlSistema() {
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido;
		
		valorObtenido = servidorCentral.agregarUsuario("Juan", "1234");
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queNoSePuedaAgregarUnUsuarioAlSistemaSiYaExisteUnUsuarioConEseNombre() {
		Boolean valorEsperado = Boolean.FALSE;
		Boolean valorObtenido;
		
		servidorCentral.agregarUsuario("Juan", "1234");
		valorObtenido = servidorCentral.agregarUsuario("Juan", "1234");
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaLoguearUnUsuarioAlSistemaSiEscribeLaContraseniaYNombreValido() {
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido;
		
		servidorCentral.agregarUsuario("Juan", "1234");
		valorObtenido = servidorCentral.loguearUsuario("Juan", "1234");
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaCerrarLaSesionDeUnUsuarioLogueado() {
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido;
		
		servidorCentral.agregarUsuario("Juan", "1234");
		servidorCentral.loguearUsuario("Juan", "1234");
		valorObtenido = servidorCentral.cerrarLaSessionDelUsuario("Juan");
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaObtenerLaCantidadDeUsuariosLogueados() {
		Integer valorEsperado = 1;
		Integer valorObtenido;
		
		servidorCentral.agregarUsuario("Juan", "1234");
		servidorCentral.agregarUsuario("Miguel", "1234");
		servidorCentral.loguearUsuario("Juan", "1234");

		valorObtenido = servidorCentral.getCantidadDeUsuariosLogueados();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaObtenerElPorcentajeDeUsuariosLogueados() {
		Double valorEsperado = 50.0;
		Double valorObtenido;
		
		servidorCentral.agregarUsuario("Juan", "1234");
		servidorCentral.agregarUsuario("Miguel", "1234");
		servidorCentral.loguearUsuario("Juan", "1234");

		valorObtenido = servidorCentral.calcularElPorcentajeDeUsuariosLogueados();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaBloquearUnUsuario() {
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido;
		
		servidorCentral.agregarUsuario("Juan", "1234");
		servidorCentral.bloquearODesBloquearUsuario("Juan");

		valorObtenido = servidorCentral.estaBloqueadoElUsuario("Juan");
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void siUnUsuarioEstaBloqueadoQueNoSePuedaLoguearAlSistema() {
		Boolean valorEsperado = Boolean.FALSE;
		Boolean valorObtenido;
		
		servidorCentral.agregarUsuario("Juan", "1234");
		servidorCentral.bloquearODesBloquearUsuario("Juan");

		valorObtenido = servidorCentral.loguearUsuario("Juan", "1234");
		
		assertEquals(valorEsperado, valorObtenido);
	}

}
