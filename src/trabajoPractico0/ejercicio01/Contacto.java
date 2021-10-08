package trabajoPractico0.ejercicio01;

public class Contacto {
	
	/*
	 * Se deben incorporar los atributos necesarios.
	 * 
	 * •	Nombre y Apellido: No se aceptan números.
	 * •	Celular: Compuesto del código de país + código de área + número de celular.
	 * •	E-Mail: Debe contener al menos el símbolo ‘@’ y el caracter ‘.’.
	 * •	Dirección: Valor alfanumérico.
	 * •	Código Postal: Valor numérico.
	 * •	Localidad: Valor alfanumérico.
	 * •	Provincia. Enumerador que contenga las 23 provincias argentinas.
	 * •	Es cliente (Si o No): Inicialmente se carga en “No”.
	 * •	Desea ser llamado nuevamente (Si o No): Inicialmente se carga en “Si”.
	 */
	
	private String nombre;
	private String apellido;
	private Long celular; // Ej 541199999999 (son 12 digítos) (máx con  Integer es hasta 10 digítos)
	private String email;
	private String direccion;
	private Integer codigoPostal;
	private String localidad;
	private Provincia provincia;
	private Boolean esCliente;
	private Boolean deseaSerLlamadoNuevamente;
	
	private final int CANTIDAD_MAXIMA_DE_LLAMADAS_POR_CONTACTO = 10;
	private Llamada[] llamadasRegistradas;
	private Boolean esContactoValido;
	
	private final String ATRIBUTO_INVALIDO = "Invalido";

	
	public Contacto(String nombre, String apellido, Long celular, String email, String direccion, Integer codigoPostal,
			String localidad, Provincia provincia) {
		
		this.nombre = this.esNombreOApellidoValido(nombre) ? nombre : ATRIBUTO_INVALIDO;
		this.apellido = this.esNombreOApellidoValido(apellido) ? apellido : ATRIBUTO_INVALIDO;
		this.email = this.esEmailValido(email) ? email : ATRIBUTO_INVALIDO;
		this.celular = celular;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.localidad = localidad;
		this.provincia = provincia;
		
		// Valores por defecto
		this.llamadasRegistradas = new Llamada[CANTIDAD_MAXIMA_DE_LLAMADAS_POR_CONTACTO];
		this.esContactoValido = this.esUnContactoValido();
		this.esCliente = Boolean.FALSE;
		this.deseaSerLlamadoNuevamente = Boolean.TRUE;
		
	}
	
//	// Constructor para pruebas
//	public Contacto(String nombre, String apellido, String email) {
//		
//		this.nombre = nombre;
//		this.apellido = apellido;
//		this.email = email;
//		
//		// Valores por defecto
//		this.esCliente = Boolean.FALSE;
//		this.deseaSerLlamadoNuevamente = Boolean.FALSE;
//		
//	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public Boolean esValido() {
		return this.esContactoValido;
	}
			
	public Boolean esCliente() {
		return this.esCliente;
	}
	
	public Boolean deseaSerLlamadoNuevamente() {
		return this.deseaSerLlamadoNuevamente;
	}
	
	public Integer getCodigoPostal() {
		return this.codigoPostal;
	}

	public Boolean esNombreOApellidoValido(String nombreOApellido) {
		/*
		 * Evalua si un String determinado puede ser almacenado como Nombre o Apellido del contacto 
		 */
		Boolean esValido = true;
		
		for (int i = 0; i < nombreOApellido.length(); i++) {
			
			esValido = Character.isDigit(nombreOApellido.charAt(i)) ? Boolean.FALSE : Boolean.TRUE;
			
		}
		
		return esValido;
	}

	public Boolean esEmailValido(String eMail) {
		/*
		 * Evalúa si un String determinado puede ser almacenado como E-MAIL.
		 */
		Boolean tieneArroba = Boolean.FALSE;
		Boolean tienePunto = Boolean.FALSE;
		
		for (int i = 0; i < eMail.length(); i++) {
			tieneArroba = (eMail.charAt(i) == '@') ? Boolean.TRUE : tieneArroba;
			tienePunto = (eMail.charAt(i) == '.') ? Boolean.TRUE : tienePunto;
		}
		
		return tieneArroba && tienePunto;
	}
	
	private Boolean esUnContactoValido() {
		/*
		 * Determina si un contacto es valido o no
		 */
		this.esContactoValido = Boolean.TRUE;
		
		if (this.nombre == ATRIBUTO_INVALIDO || this.apellido == ATRIBUTO_INVALIDO || this.email == ATRIBUTO_INVALIDO) {
			this.esContactoValido = Boolean.FALSE;
		}
		
		return this.esContactoValido;
	}
	
	public Boolean registrarNuevaLlamada(Llamada nueva) {
		/*
		 * Registra una nueva llamada asociada al contacto actual.
		 */
		Boolean sePudoRegistrar = Boolean.FALSE;
		
		for (int i = 0; i < llamadasRegistradas.length; i++) {
			if (this.llamadasRegistradas[i] == null && !sePudoRegistrar) {
				this.llamadasRegistradas[i] = nueva;
				sePudoRegistrar = Boolean.TRUE;
			}
		}
		
		if (sePudoRegistrar && nueva.isFueExitosa()) {
			this.esCliente = Boolean.TRUE;
			this.deseaSerLlamadoNuevamente = Boolean.FALSE;
		}
		
		return sePudoRegistrar;
	}
	
	public String toString() {
		/*
		 * Muestra los datos de un contacto, entre los que se debe incluir el registro de las llamadas realizadas.
		 */
		String esCliente = this.esCliente ? "Si" : "No";
		String deseaSerLLamado = this.deseaSerLlamadoNuevamente ? "Si" : "No";
		
		return "Nombre: " + this.nombre +
				"\nApellido: "+ this.apellido +
				"\nDireccion: "+ this.direccion +
				"\nCodigo Postal: "+ this.codigoPostal +
				"\nLocalidad: "+ this.localidad +
				"\nProvincia: "+ this.provincia +
				"\nEs Valido: "+ this.esContactoValido +
				"\nEs Cliente: " + esCliente +
				"\nDesea ser llamado: "+ deseaSerLLamado;
	}

	
}
