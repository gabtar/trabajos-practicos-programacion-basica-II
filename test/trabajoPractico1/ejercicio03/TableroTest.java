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
		Usuario valorEsperado = usuarioUno;
		Usuario valorObtenido;
		Boolean sePudoAgregar;
		
		sePudoAgregar = kanban.agregarUnNuevoUsuario(usuarioUno);
		valorObtenido = kanban.buscarUsuarioPorNombre("Uno");
		
		assertTrue(sePudoAgregar);
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queNoSePuedaAgregarUnUsuarioAlTableroSiYaExisteConEseNombre() {
		Boolean sePudoAgregar;
		
		kanban.agregarUnNuevoUsuario(usuarioUno);
		sePudoAgregar = kanban.agregarUnNuevoUsuario(usuarioUno);
		
		assertFalse(sePudoAgregar);
	}
	
	@Test
	public void queSePuedaAgregarUnaTareaAlTablero() {
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido;
		List<Tarea> tareas = new ArrayList<Tarea>();
		
		valorObtenido = kanban.agregarNuevaTarea(tareaUno);
		tareas = kanban.obtenerTareasPorEstado(Estado.PENDIENTE);

		assertEquals(valorEsperado, valorObtenido);
		assertTrue(tareas.contains(tareaUno));
	}
	
	@Test 
	public void queSePuedaAsignarUnaTareaPendienteAUnUsuario() {
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido;
		List<Tarea> tareasDelUsuario = new ArrayList<Tarea>();
		
		kanban.agregarUnNuevoUsuario(usuarioUno);
		kanban.agregarNuevaTarea(tareaUno);
		
		valorObtenido = kanban.asignarTareaAUsuario(tareaUno, "Uno");
		tareasDelUsuario = kanban.obtenerTareasDelUsuario("Uno");
		
		assertEquals(valorEsperado, valorObtenido);
		assertTrue(tareasDelUsuario.contains(tareaUno));
	}
	
	@Test 
	public void queNoSePuedaAsignarUnaTareaEnCursoAUnUsuarioDistintoAlQueLaTomo() {
		Boolean valorEsperado = Boolean.FALSE;
		Boolean valorObtenido;
		List<Tarea> tareasDelUsuario = new ArrayList<Tarea>();
		
		// Se asigna al usuario uno y se cambia el estado
		tareaUno.asignarUsuario(usuarioUno);
		tareaUno.setEstado(Estado.EN_CURSO);
		
		kanban.agregarUnNuevoUsuario(usuarioUno);
		kanban.agregarUnNuevoUsuario(usuarioDos);
		kanban.agregarNuevaTarea(tareaUno);
		
		valorObtenido = kanban.asignarTareaAUsuario(tareaUno, "Dos");
		tareasDelUsuario = kanban.obtenerTareasDelUsuario("Dos");
		
		assertEquals(valorEsperado, valorObtenido);
		assertFalse(tareasDelUsuario.contains(tareaUno));
	}
	
	@Test 
	public void queUnUsuarioPuedaFinalizarUnaTareaQueTieneAsignada() {
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido;
		List<Tarea> tareasFinalizadas = new ArrayList<Tarea>();
		
		// Se asigna al usuario uno y se cambia el estado
		tareaUno.asignarUsuario(usuarioUno);
		tareaUno.setEstado(Estado.EN_CURSO);
		
		kanban.agregarUnNuevoUsuario(usuarioUno);
		kanban.agregarNuevaTarea(tareaUno);
		
		valorObtenido = kanban.finalizarTarea(tareaUno, "Uno");

		tareasFinalizadas = kanban.obtenerTareasPorEstado(Estado.FINALIZADA);
		
		assertEquals(valorEsperado, valorObtenido);
		assertTrue(tareasFinalizadas.contains(tareaUno));
	}
	
	@Test
	public void queUnUsuarioNoPuedaFinalizarUnaTareaQueTieneAsignada() {
		Boolean valorEsperado = Boolean.FALSE;
		Boolean valorObtenido;
		List<Tarea> tareasFinalizadas = new ArrayList<Tarea>();
		
		// Se asigna al usuario uno y se cambia el estado
		tareaUno.asignarUsuario(usuarioUno);
		tareaUno.setEstado(Estado.EN_CURSO);
		
		kanban.agregarUnNuevoUsuario(usuarioUno);
		kanban.agregarUnNuevoUsuario(usuarioDos);
		kanban.agregarNuevaTarea(tareaUno);
		
		valorObtenido = kanban.finalizarTarea(tareaUno, "Dos");
		tareasFinalizadas = kanban.obtenerTareasPorEstado(Estado.FINALIZADA);
		
		assertEquals(valorEsperado, valorObtenido);
		assertFalse(tareasFinalizadas.contains(tareaUno));
	}
	
	@Test
	public void queSePuedanObtenerLaListaDeTareasPendientesEnElTablero() {
		List<Tarea> listaEsperada = new ArrayList<Tarea>();
		
		kanban.agregarNuevaTarea(tareaUno);
		kanban.agregarNuevaTarea(tareaDos);
		
		listaEsperada = kanban.obtenerTareasPorEstado(Estado.PENDIENTE);
		
		assertTrue(listaEsperada.contains(tareaUno));
		assertTrue(listaEsperada.contains(tareaDos));
	}
	
	@Test
	public void queSePuedanObtenerLaListaDeTareasDeUnUsuario() {
		List<Tarea> listaEsperada = new ArrayList<Tarea>();
		
		tareaUno.asignarUsuario(usuarioUno);
		tareaDos.asignarUsuario(usuarioDos);
		
		kanban.agregarUnNuevoUsuario(usuarioUno);
		
		kanban.agregarNuevaTarea(tareaUno);
		kanban.agregarNuevaTarea(tareaDos);
		kanban.asignarTareaAUsuario(tareaDos, "Uno");
		
		listaEsperada = kanban.obtenerTareasDelUsuario("Uno");
		
		assertTrue(listaEsperada.contains(tareaUno));
		assertTrue(listaEsperada.contains(tareaDos));
	}
	
	@Test
	public void queSePuedanLimpiarLasTareasFinalizadas() {
		List<Tarea> listaEsperada = new ArrayList<Tarea>();
		
		kanban.agregarUnNuevoUsuario(usuarioUno);
		kanban.agregarUnNuevoUsuario(usuarioDos);
		
		kanban.agregarNuevaTarea(tareaUno);	
		kanban.asignarTareaAUsuario(tareaUno, "Uno");
		kanban.finalizarTarea(tareaUno, "Uno");
		
		kanban.agregarNuevaTarea(tareaDos);	
		kanban.asignarTareaAUsuario(tareaDos, "Dos");
		kanban.finalizarTarea(tareaDos, "Dos");

		kanban.limpiarTaerasFinalizadas();
		
		listaEsperada = kanban.obtenerTareasPorEstado(Estado.FINALIZADA);
		
		assertFalse(listaEsperada.contains(tareaUno));
		assertFalse(listaEsperada.contains(tareaDos));
	}

}
