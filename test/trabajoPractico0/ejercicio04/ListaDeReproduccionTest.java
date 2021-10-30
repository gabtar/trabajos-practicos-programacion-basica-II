package trabajoPractico0.ejercicio04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListaDeReproduccionTest {

	private Cancion cancionUno;
	private Cancion cancionDos;
	private Cancion cancionTres;
	
	private ListaDeReproduccion listaDeReproduccion;
	
	@Before
	public void setUp() throws Exception {
		
		cancionUno = new Cancion("Tema 1", "Autor 1", 300, Genero.OTRO);
		cancionDos = new Cancion("Tema 2", "Autor 2", 280, Genero.OTRO);
		cancionTres = new Cancion("Tema 3", "Autor 3", 230, Genero.OTRO);
		
		listaDeReproduccion = new ListaDeReproduccion("Lista OTROS");
		
	}

	@Test
	public void queSePuedaAgregarUnaCancion() {
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido = listaDeReproduccion.agregarCancion(cancionUno);
		
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void queSePuedaBuscarEliminarUnaCancion() {
		Boolean valorEsperado = Boolean.TRUE;		
		Boolean valorObtenido; 
		
		listaDeReproduccion.agregarCancion(cancionUno);
		valorObtenido = listaDeReproduccion.eliminarCancion("Tema 1");
		
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void queSePuedaObtenerElListadoDeCanciones() {
		
		String valorEsperado = "Lista de reproduccion: Lista OTROS\n"
				+ "Titulo: Tema 1 Autor: Autor 1 Duración: 300seg Género: OTRO\n"
				+ "Titulo: Tema 2 Autor: Autor 2 Duración: 280seg Género: OTRO\n"
				+ "Titulo: Tema 3 Autor: Autor 3 Duración: 230seg Género: OTRO\n"
				+ "Duración total: 810seg\n";
		String valorObtenido;
		
		listaDeReproduccion.agregarCancion(cancionUno);
		listaDeReproduccion.agregarCancion(cancionDos);
		listaDeReproduccion.agregarCancion(cancionTres);
		
		valorObtenido = listaDeReproduccion.toString();
		
		assertEquals(valorEsperado,valorObtenido);
	}

}
