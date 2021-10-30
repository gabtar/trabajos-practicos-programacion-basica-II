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
				+ "Titulo: Tema 1 Autor: Autor 1 Duraci�n: 300seg G�nero: OTRO\n"
				+ "Titulo: Tema 2 Autor: Autor 2 Duraci�n: 280seg G�nero: OTRO\n"
				+ "Titulo: Tema 3 Autor: Autor 3 Duraci�n: 230seg G�nero: OTRO\n"
				+ "Duraci�n total: 810seg\n";
		String valorObtenido;
		
		listaDeReproduccion.agregarCancion(cancionUno);
		listaDeReproduccion.agregarCancion(cancionDos);
		listaDeReproduccion.agregarCancion(cancionTres);
		
		valorObtenido = listaDeReproduccion.toString();
		
		assertEquals(valorEsperado,valorObtenido);
	}

}
