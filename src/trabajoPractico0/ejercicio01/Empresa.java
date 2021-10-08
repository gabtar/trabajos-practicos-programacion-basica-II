package trabajoPractico0.ejercicio01;

public class Empresa {

	/*
	 * Se deben incorporar los atributos necesarios.
	 */
	private String nombre;
	private Contacto[] contactos;
	private final Integer[] zonasDeCobertura; 

	private final Integer MAXIMO_NUMERO_DE_CONTACTOS = 500;
	private final Integer MAXIMA_CANTIDAD_DE_ZONAS_DE_COBERTURA = 10;
	
	private Integer candidatosEncontrados;
	
	public Empresa(String nombre) {
		this.nombre = nombre;
		
		this.contactos = new Contacto[MAXIMO_NUMERO_DE_CONTACTOS];
		this.zonasDeCobertura = new Integer[MAXIMA_CANTIDAD_DE_ZONAS_DE_COBERTURA];
		this.candidatosEncontrados = 0;
	}
	
	public String getNombreEmpresa() {
		/*
		 * Devuelve el nombre de la empresa
		 */
		return this.nombre;
	}
	
	public Boolean agregarNuevoContacto(Contacto nuevo) {
	
		/*
		 * Incorpora un nuevo contacto a la empresa
		 */		
		Boolean seAgrego = Boolean.FALSE;
		
		if (!nuevo.esValido()) {
			return seAgrego;
		}
		
		for (int i = 0; i < contactos.length; i++) {
			if (this.contactos[i] == null && !seAgrego) {
				this.contactos[i] = nuevo;
				seAgrego = Boolean.TRUE;
			}
		}
		
		return seAgrego;
	}
	
	public Boolean agregarNuevaZonaDeCobertura(Integer codigoPostal) {
		/*
		 * Incorpora una nueva zona de cobertura (Las zonas de cobertura se identifican por el codigo postal)
		 */
		Boolean seAgrego = Boolean.FALSE;
				
		for (int i = 0; i < zonasDeCobertura.length; i++) {
			if (this.zonasDeCobertura[i] == null && !seAgrego) {
				this.zonasDeCobertura[i] = codigoPostal;
				seAgrego = Boolean.TRUE;
			}
		}
		
		return seAgrego;
	}	
	
	public Boolean elCodigoPostalEstaDentroDeLaZonaDeCobertura(Integer codigoPostal) {
		/*
		 * Determina si un código postal está dentro de la zona de cobertura
		 */
		Boolean estaDentroDeLaZona = Boolean.FALSE;
		
		for (int i = 0; i < this.zonasDeCobertura.length; i++) {
			if (this.zonasDeCobertura[i] != null && this.zonasDeCobertura[i].equals(codigoPostal) && !estaDentroDeLaZona) {
				estaDentroDeLaZona = Boolean.TRUE;
			}
		}
		
		return estaDentroDeLaZona;
	}
	
	public Contacto buscarCandidato() {
		/*
		 * Para determinar qué contacto el sistema debe mostrar, se debe realizar la siguiente búsqueda:
		 * 1.	El contacto NO debe ser cliente aún.
		 * 2.	El contacto desea ser llamado o al menos no informó lo contrario.
		 * 3.	El código postal del contacto debe existir en las zonas de cobertura existente.
		 * 4.	Del conjunto de contactos resultante se debe seleccionar aleatoriamente el próximo llamado.
		 */
		Contacto[] posiblesCandidatos = this.posiblesCandidatos();
		Contacto candidatoAlAzar = null;
		
		if (this.candidatosEncontrados != 0) {
			Integer numeroAlAzar = this.candidatosEncontrados + 1;
			
			while (numeroAlAzar >= this.candidatosEncontrados) {
				numeroAlAzar = (int) Math.round(Math.random()*this.candidatosEncontrados);				
			}
			
			candidatoAlAzar = posiblesCandidatos[numeroAlAzar];
			
		}
		

		return candidatoAlAzar;
	}
	
	private Contacto[] posiblesCandidatos() {
		
		Contacto[] posiblesCandidatos = new Contacto[MAXIMO_NUMERO_DE_CONTACTOS];
		Integer candidatosEncontrados = 0;
		
		for (int i = 0; i < contactos.length; i++) {
			
			if (this.contactos[i] != null && !this.contactos[i].esCliente() && this.contactos[i].deseaSerLlamadoNuevamente() && elCodigoPostalEstaDentroDeLaZonaDeCobertura(this.contactos[i].getCodigoPostal())) {
				posiblesCandidatos[candidatosEncontrados] = this.contactos[i];
				candidatosEncontrados++;
				
			}
			
		}
		
		this.candidatosEncontrados = candidatosEncontrados;
		
		return posiblesCandidatos;	
	}
	
}
