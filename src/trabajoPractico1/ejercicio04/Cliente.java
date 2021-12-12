package trabajoPractico1.ejercicio04;

public class Cliente {

	private String nombre;
	private String apellido;
	private Integer dni;
	
	private TipoCliente tipoDeCliente;
	
	private Cuenta cuentas[];
	
	private static final Integer NUMERO_MAXIMO_DE_CUENTAS_POR_CLIENTE = 3; // Se fija un maximo por defecto

	public Cliente(String nombre, String apellido, Integer dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		
		this.tipoDeCliente = TipoCliente.NORMAL; // Se inicializa en normal
		this.cuentas = new Cuenta[NUMERO_MAXIMO_DE_CUENTAS_POR_CLIENTE];
	}
	
	public Integer getDni() {
		return this.dni;
	}
	
	/*
	 * Agrega una nueva cuenta al cliente
	 */
	public Boolean agregarCuenta(Cuenta nuevaCuenta) {
		Boolean seAgrego = Boolean.FALSE;
		
		for (int i = 0; i < cuentas.length; i++) {
			if(this.cuentas[i] == null && !seAgrego) {
				this.cuentas[i] = nuevaCuenta;
				seAgrego = Boolean.TRUE;
			}
		}
		
		return seAgrego;
	}
	
	public Cuenta[] obtenerCuentas() {
		return this.cuentas;
	}
	
	@Override
	public String toString() {
		return this.nombre + " " + this.apellido + "(DNI: " + this.dni + ")";
	}
	
	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoDeCliente = tipoCliente;
	}
	
}
