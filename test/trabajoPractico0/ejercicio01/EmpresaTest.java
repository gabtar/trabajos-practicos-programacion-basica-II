package trabajoPractico0.ejercicio01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmpresaTest {

	// Empresa
	private Empresa oesteCableColor;
	private String nombreEmpresa = "Oeste Cable Color";
	
	private final Integer NUMERO_MAXIMO_DE_CONTACTOS = 500;
	private final Integer MAXIMA_CANTIDAD_DE_ZONAS_DE_COBERTURA = 10;
	
	// Contacto
	private Contacto contacto;
	private String nombre = "Manuel"; 
	private String apellido = "Gomez";
	private Long celular = 541122222222L;
	private String email = "mail@google.com";
	private String direccion = "Rivadavia 13000";
	private Integer codigoPostal = 1111;
	private String localidad = "Ciudadela";
	private Provincia provincia = Provincia.BUENOS_AIRES;
			
	@Before
	public void instanciarClase() {
		oesteCableColor = new Empresa(nombre);
		
		contacto = new Contacto(nombre, apellido, celular,email, direccion, codigoPostal, localidad, provincia);
	}
	
	@Test
	public void sePuedeObtenerElNombreDeLaEmpresa() {
		
		String valorEsperado = nombre;
		String valorObtenido = oesteCableColor.getNombreEmpresa();
		
		assertEquals(valorObtenido, valorEsperado);
	}
	
	@Test
	public void sePuedeAgregarUnNuevoContacto() {
		// Ejecucion
		Boolean valorEsperado = oesteCableColor.agregarNuevoContacto(contacto);

		assertTrue(valorEsperado);
	}
	
	@Test
	public void noSePuedeAgregarUnNuevoContactoSiNoHayMasLugar() {
		Boolean valorEsperado = Boolean.FALSE;
		
		for (int i = 0; i < NUMERO_MAXIMO_DE_CONTACTOS + 1; i++) {
			valorEsperado = oesteCableColor.agregarNuevoContacto(contacto);
		}
		
		assertFalse(valorEsperado);
	}
	
	@Test
	public void noSePuedeAgregarUnNuevoContactoSiNoEsUnContactoValido() {
		Boolean valorEseperado;
		contacto = new Contacto(nombre, "Gomez1111", celular,email, direccion, codigoPostal, localidad, provincia);
		
		Boolean valorEsperado = oesteCableColor.agregarNuevoContacto(contacto);
		
		assertFalse(valorEsperado);
	}
	
	@Test
	public void siLaEmpresaTieneCoberturaelCodigoPostalEstaDentroDeLaZonaDeCobertura() {
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido;
		
		oesteCableColor.agregarNuevaZonaDeCobertura(codigoPostal);
		
		valorObtenido = oesteCableColor.elCodigoPostalEstaDentroDeLaZonaDeCobertura(codigoPostal);
				
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaObtenerUnContactoAlAzar() {
		Contacto valorEsperado;
		Contacto valorObtenido;
		
		valorEsperado = contacto;
		oesteCableColor.agregarNuevaZonaDeCobertura(codigoPostal);
		
		// Se agregan todos los contactos posibles para llamar
		for (int i = 0; i < NUMERO_MAXIMO_DE_CONTACTOS; i++) {
			oesteCableColor.agregarNuevoContacto(contacto);
		}
			
		valorObtenido = oesteCableColor.buscarCandidato();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void siSeRealizaUnaLlamadaExitosaNoSePuedaVolverALlamarAlCliente() {
		Boolean valorEsperado = Boolean.FALSE;
		Contacto candidatoALlamar;
		
		oesteCableColor.agregarNuevaZonaDeCobertura(codigoPostal);
		
		// Se agregan todos los contactos posibles para llamar
		for (int i = 0; i < NUMERO_MAXIMO_DE_CONTACTOS; i++) {
			oesteCableColor.agregarNuevoContacto(contacto);
		}
		
		candidatoALlamar = oesteCableColor.buscarCandidato();
		Llamada llamadaExitosa = new Llamada(true, "Vendido");
		
		candidatoALlamar.registrarNuevaLlamada(llamadaExitosa);
		
		assertEquals(valorEsperado, candidatoALlamar.deseaSerLlamadoNuevamente());
	}

}
