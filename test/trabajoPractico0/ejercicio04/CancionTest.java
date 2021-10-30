package trabajoPractico0.ejercicio04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CancionTest {

	@Test
	public void queSePuedaCrearUnaCancion() {
		Cancion nuevoTema = new Cancion("Tema 1", "Autor", 300, Genero.OTRO);
		
		assertNotNull(nuevoTema);
	}
	
	@Test
	public void queSePuedaObtenerElDetalleDeUnaCancion() {
		String valorEsperado = "Titulo: Tema 1 Autor: Autor Duraci�n: 300seg G�nero: OTRO";
		
		Cancion nuevoTema = new Cancion("Tema 1", "Autor", 300, Genero.OTRO);
		
		assertEquals(valorEsperado, nuevoTema.toString());
	}

}
