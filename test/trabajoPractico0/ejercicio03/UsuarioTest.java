package trabajoPractico0.ejercicio03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

	private Usuario usuarioUno;
	
	@Before
	public void setUp() throws Exception {
		usuarioUno = new Usuario("Miguel", "1234");
	}

	@Test
	public void queSePuedaCrearUnUsuario() {
		Usuario usuarioNuevo = new Usuario("Juan", "1234");
		assertNotNull(usuarioNuevo);
	}
	
	@Test
	public void queObtenerElNombreDelUsuario() {
		String valorEsperado = "Miguel";
		
		assertEquals(valorEsperado, usuarioUno.getNombreDeUsuario());
	}
	
	@Test
	public void queObtenerLaContraseniaDelUsuario() {
		String valorEsperado = "1234";
		
		assertEquals(valorEsperado, usuarioUno.getContrasenia());
	}
	
	// TODO Resto

}
