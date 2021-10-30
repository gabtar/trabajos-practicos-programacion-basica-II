package trabajoPractico0.ejercicio04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
	
	private Cancion cancionUno;
	private Cancion cancionDos;
	private Cancion cancionTres;
	
	private Usuario usuarioDePruebas;

	@Before
	public void setUp() throws Exception {
		
		cancionUno = new Cancion("Tema 1", "Autor 1", 300, Genero.OTRO);
		cancionDos = new Cancion("Tema 2", "Autor 2", 280, Genero.OTRO);
		cancionTres = new Cancion("Tema 3", "Autor 3", 230, Genero.OTRO);
		
		usuarioDePruebas = new Usuario("Miguel");
	}

	@Test
	public void queSePuedaCrearUnaNuevaListaDeReproduccion() {
		assertTrue(usuarioDePruebas.agregarNuevaLista("ListaUno"));
	}
	
	@Test
	public void queSePuedaAgregarUnaCancionAUnaListaNueva() {
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido;
		
		usuarioDePruebas.agregarNuevaLista("ListaUno");
		valorObtenido = usuarioDePruebas.agregarCancionALaLista("ListaUno", cancionUno);
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedanVerLasListasDeReproduccion() {
		String valorEsperado = "Lista de reproduccion: ListaUno\n"
				+ "Titulo: Tema 1 Autor: Autor 1 Duración: 300seg Género: OTRO\n"
				+ "Duración total: 300seg\n"
				+ "Lista de reproduccion: ListaDos\n"
				+ "Titulo: Tema 2 Autor: Autor 2 Duración: 280seg Género: OTRO\n"
				+ "Duración total: 280seg\n";
		
		usuarioDePruebas.agregarNuevaLista("ListaUno");
		usuarioDePruebas.agregarCancionALaLista("ListaUno", cancionUno);
		usuarioDePruebas.agregarNuevaLista("ListaDos");
		usuarioDePruebas.agregarCancionALaLista("ListaDos", cancionDos);
		
		assertEquals(valorEsperado, usuarioDePruebas.verMisListasDeReproduccion());
	}
	
	@Test
	public void queSePuedaReproducirUnaLista() {
		String valorEsperado = "Lista de reproduccion: ListaUno\n"
				+ "Titulo: Tema 1 Autor: Autor 1 Duración: 300seg Género: OTRO\n"
				+ "Duración total: 300seg\n";
		
		usuarioDePruebas.agregarNuevaLista("ListaUno");
		usuarioDePruebas.agregarCancionALaLista("ListaUno", cancionUno);

		assertEquals(valorEsperado, usuarioDePruebas.reproducirMiLista("ListaUno"));
	}

}
