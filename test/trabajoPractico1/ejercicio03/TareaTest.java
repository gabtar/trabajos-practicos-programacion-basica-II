package trabajoPractico1.ejercicio03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TareaTest {

	private Usuario usuarioDePrueba;
	private Usuario usuarioDePruebaDos;
	private Tarea tareaDePrueba;
	
	@Before
	public void setUp() throws Exception {
		usuarioDePrueba = new Usuario("Prueba");
		usuarioDePruebaDos = new Usuario("PruebaDos");
		tareaDePrueba = new Tarea("Titulo", "Descripcion");
	}

	@Test
	public void queSePuedaObtenerElTituloDeUnaTarea() {
		String valorEsperado = "Titulo";
		
		assertEquals(valorEsperado, tareaDePrueba.getTitulo());
	}
	
	@Test
	public void queSePuedaObtenerLaDescripcionDeUnaTarea() {
		String valorEsperado = "Descripcion";
		
		assertEquals(valorEsperado, tareaDePrueba.getDescripcion());
	}
	
	@Test
	public void queSePuedaObtenerElEstadoDeUnaTarea() {
		Estado valorEsperado = Estado.PENDIENTE;
		
		assertEquals(valorEsperado, tareaDePrueba.getEstado());
	}
	
	@Test
	public void queSePuedaCambiarElEstadoDeUnaTarea() {
		Estado valorEsperado = Estado.EN_CURSO;
		
		tareaDePrueba.setEstado(Estado.EN_CURSO);
		
		assertEquals(valorEsperado, tareaDePrueba.getEstado());
	}
	
	@Test
	public void queSePuedaAsignarUnUsuarioALaTarea() {
		Usuario valorEsperado = usuarioDePrueba;
		
		tareaDePrueba.asignarUsuario(usuarioDePrueba);
		
		assertEquals(valorEsperado, tareaDePrueba.getUsuarioAsignado());
	}
	
	@Test
	public void queNoSePuedaAsignarUnUsuarioALaTareaSiEstaEnCurso() {
		Usuario valorEsperado = usuarioDePrueba;
		
		tareaDePrueba.asignarUsuario(usuarioDePrueba);
		tareaDePrueba.setEstado(Estado.EN_CURSO);
		tareaDePrueba.asignarUsuario(usuarioDePruebaDos);
		
		assertEquals(valorEsperado, tareaDePrueba.getUsuarioAsignado());
	}
	
	@Test
	public void queNoSePuedaAsignarUnUsuarioALaTareaSiEstaFinalizada() {
		Usuario valorEsperado = usuarioDePrueba;
		
		tareaDePrueba.asignarUsuario(usuarioDePrueba);
		tareaDePrueba.setEstado(Estado.FINALIZADA);
		tareaDePrueba.asignarUsuario(usuarioDePruebaDos);
		
		assertEquals(valorEsperado, tareaDePrueba.getUsuarioAsignado());
	}
	
}
