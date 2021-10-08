package trabajoPractico0.ejercicio01;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContactoTest {

	private Contacto contacto;
	private Contacto contactoNombreInvalido;
	private Contacto contactoApellidoInvalido;
	private Contacto contactoEmailInvalido;
	
	// Atributos para instanciacion
	private String nombre = "Manuel"; 
	private String apellido = "Gomez";
	private Long celular = 541122222222L;
	private String email = "mail@google.com";
	private String direccion = "Rivadavia 13000";
	private Integer codigoPostal = 1111;
	private String localidad = "Ciudadela";
	private Provincia provincia = Provincia.BUENOS_AIRES;
	
	// Atributos invalidos
	private String nombreInvalido = "Manuel1111";
	private String apellidoInvalido = "Gomez111";
	private String emailInvalido = "estoNoE.sUnEmailValido";
	
	private final String ATRIBUTO_INVALIDO = "Invalido";
	
	
	// Instanciacion de la calse de para las pruebas
	@Before
	public void instanciacion() {
		contacto = new Contacto(nombre, apellido, celular,email, direccion, codigoPostal, localidad, provincia);
		contactoNombreInvalido = new Contacto(nombreInvalido, apellido, celular,email, direccion, codigoPostal, localidad, provincia);
		contactoApellidoInvalido = new Contacto(nombre, apellidoInvalido, celular,email, direccion, codigoPostal, localidad, provincia);
		contactoEmailInvalido = new Contacto(nombre, apellido, celular,emailInvalido, direccion, codigoPostal, localidad, provincia);
	}

	@Test
	public void siElNombreTieneNumerosEsInvalido() {
		Boolean valorObtenido = contactoNombreInvalido.esValido();
		
		assertFalse(valorObtenido);
	}
	
	@Test
	public void siElApellidoTieneNumerosEsInvalido() {
		Boolean valorObtenido = contactoApellidoInvalido.esValido();
		
		assertFalse(valorObtenido);
	}
	
	@Test
	public void siNoContieneNiArrobaNiPuntoNoEsUnEmailValido() {
		Boolean valorObtenido = contactoEmailInvalido.esValido();
		
		assertFalse(valorObtenido);
	}

}
