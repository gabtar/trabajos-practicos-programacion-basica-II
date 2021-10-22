package trabajoPractico1.ejercicio03;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TableroTest {

	private Tablero kanban;
	
	private Usuario usuarioUno;
	private Usuario usuarioDos;
	
	private Tarea tareaUno;
	private Tarea tareaDos;
	
	@Before
	public void setUp() throws Exception {
		kanban = new Tablero("Tareas");
		
		usuarioUno = new Usuario("Uno");
		usuarioDos = new Usuario("Dos");
		
		tareaUno = new Tarea("Uno", "Limpiar");
		tareaDos = new Tarea("Dos", "Formatear PC");
	}

	@Test
	public void queSePuedaAgregarUnUsuarioAlTablero() {
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido;
		
		valorObtenido = kanban.agregarUnNuevoUsuario(usuarioUno);
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaAgregarUnaTareaAlTablero() {
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido;
		
		valorObtenido = kanban.agregarNuevaTarea(tareaUno);
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test 
	public void queSePuedaAsignarUnaTareaPendienteAUnUsuario() {
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido;
		
		kanban.agregarUnNuevoUsuario(usuarioUno);
		kanban.agregarNuevaTarea(tareaUno);
		
		valorObtenido = kanban.asignarTareaAUsuario(tareaUno, usuarioUno);
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test 
	public void queNoSePuedaAsignarUnaTareaEnCursoAUnUsuarioDistintoAlQueLaTomo() {
		Boolean valorEsperado = Boolean.FALSE;
		Boolean valorObtenido;
		
		// Se asigna al usuario uno y se cambia el estado
		tareaUno.asignarUsuario(usuarioUno);
		tareaUno.setEstado(Estado.EN_CURSO);
		
		kanban.agregarUnNuevoUsuario(usuarioUno);
		kanban.agregarUnNuevoUsuario(usuarioDos);
		kanban.agregarNuevaTarea(tareaUno);
		
		valorObtenido = kanban.asignarTareaAUsuario(tareaUno, usuarioDos);
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test 
	public void queUnUsuarioPuedaFinalizarUnaTareaQueTieneAsignada() {
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido;
		
		// Se asigna al usuario uno y se cambia el estado
		tareaUno.asignarUsuario(usuarioUno);
		tareaUno.setEstado(Estado.EN_CURSO);
		
		kanban.agregarUnNuevoUsuario(usuarioUno);
		kanban.agregarNuevaTarea(tareaUno);
		
		valorObtenido = kanban.finalizarTarea(tareaUno, usuarioUno);
		
		assertEquals(valorEsperado, valorObtenido);
		
	}
	
	@Test
	public void queUnUsuarioNoPuedaFinalizarUnaTareaQueTieneAsignada() {
		Boolean valorEsperado = Boolean.FALSE;
		Boolean valorObtenido;
		
		// Se asigna al usuario uno y se cambia el estado
		tareaUno.asignarUsuario(usuarioUno);
		tareaUno.setEstado(Estado.EN_CURSO);
		
		kanban.agregarUnNuevoUsuario(usuarioUno);
		kanban.agregarUnNuevoUsuario(usuarioDos);
		kanban.agregarNuevaTarea(tareaUno);
		
		valorObtenido = kanban.finalizarTarea(tareaUno, usuarioDos);
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedanObtenerLaListaDeTareasPendientesEnElTablero() {
		List<Tarea> listaEsperada = new ArrayList<Tarea>();
		
		kanban.agregarNuevaTarea(tareaUno);
		kanban.agregarNuevaTarea(tareaDos);
		
		listaEsperada = kanban.obtenerTareasPendientes();
		
		assertTrue(listaEsperada.contains(tareaUno));
		assertTrue(listaEsperada.contains(tareaDos));
	}
	
	@Test
	public void queSePuedanObtenerLaListaDeTareasDeUnUsuario() {
		List<Tarea> listaEsperada = new ArrayList<Tarea>();
		
		tareaUno.asignarUsuario(usuarioUno);
		tareaDos.asignarUsuario(usuarioDos);
		
		kanban.agregarNuevaTarea(tareaUno);
		kanban.agregarNuevaTarea(tareaDos);
		
		
		listaEsperada = kanban.obtenerTareasDelUsuario(usuarioUno);
		
		assertTrue(listaEsperada.contains(tareaUno));
		assertFalse(listaEsperada.contains(tareaDos));
	}

}
