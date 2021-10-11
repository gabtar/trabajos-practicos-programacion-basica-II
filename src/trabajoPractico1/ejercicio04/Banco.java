package trabajoPractico1.ejercicio04;

public class Banco {
	
	private String nombre;

	private static final int CANTIDAD_MAXIMA_DE_CLIENTES = 1000;
	private Cliente clientes[];
	
	public Banco(String nombre) {
		this.nombre = nombre;
		this.clientes = new Cliente[CANTIDAD_MAXIMA_DE_CLIENTES];
	}
	
	public Boolean agregarCliente(String nombre, String apellido, Integer dni) {
		
		if(this.buscarClientePorDni(dni) != null) {
			return Boolean.FALSE;
		}
		
		for (int i = 0; i < clientes.length; i++) {
			if(this.clientes[i] == null) {
				this.clientes[i] = new Cliente(nombre, apellido, dni);
				return Boolean.TRUE;
			}
		}
		
		return Boolean.FALSE;
	}
	
	public Boolean crearCuentaAlCliente(Integer dni, TipoDeCuenta tipoCuenta) {
		Boolean sePudoAgregar = Boolean.FALSE;
		Cliente clienteDelBanco = this.buscarClientePorDni(dni);
		Cuenta nuevaCuenta; 
		
		if(clienteDelBanco != null) {
			
			if(tipoCuenta == TipoDeCuenta.CUENTA_SUELDO) {
				nuevaCuenta = new CuentaSueldo(clienteDelBanco);
			} else if (tipoCuenta == TipoDeCuenta.CAJA_DE_AHORRO) {
				nuevaCuenta = new CajaDeAhorro(clienteDelBanco);
			} else {
				nuevaCuenta = new CuentaCorriente(clienteDelBanco);
			}
			sePudoAgregar = clienteDelBanco.agregarCuenta(nuevaCuenta);
		}
		
		return sePudoAgregar;
	}
	
	public Cliente buscarClientePorDni(Integer dni) {
		Cliente clienteBuscado = null;
		Boolean seEncontro = Boolean.FALSE; 
		
		for (int i = 0; i < clientes.length; i++) {
			if(this.clientes[i] != null && this.clientes[i].getDni().equals(dni) && !seEncontro) {
				clienteBuscado = this.clientes[i];
				seEncontro = Boolean.TRUE;
			}
		}
		
		return clienteBuscado;
	}
	
	public TipoCliente clasificarCliente(Integer dni) {
		Double saldoDelCliente = 0.0;
		Boolean puedeSerVip = Boolean.TRUE;
		Cliente cliente = this.buscarClientePorDni(dni);
		Cuenta[] cuentas = cliente.obtenerCuentas();
		TipoCliente tipo = TipoCliente.NORMAL;
		
		for (int i = 0; i < cuentas.length; i++) {
			if (cuentas[i] != null) {
				saldoDelCliente += cuentas[i].getSaldo();
				
				// Si la cuenta corriente tiene un descubierto mayor a 0,
				// el cliente debe al banco y no puede ser VIP
				if(cuentas[i].getTipoDeCuenta() == TipoDeCuenta.CUENTA_CORRIENTE) {
					CuentaCorriente cuenta = (CuentaCorriente) cuentas[i];
					puedeSerVip = cuenta.getDescubiertoActual() > 0.0 ? Boolean.FALSE : Boolean.TRUE;
				}
			}
			
		}
		
		if(saldoDelCliente > 1000000.0 && puedeSerVip) {
			tipo = TipoCliente.VIP;
			cliente.setTipoCliente(tipo);
		}
		return tipo;
	}

}
