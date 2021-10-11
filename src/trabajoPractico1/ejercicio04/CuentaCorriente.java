package trabajoPractico1.ejercicio04;

public class CuentaCorriente extends Cuenta {
	/*
	 * La más compleja de las cuentas, ésta permite establecer una cantidad de dinero a
	 * girar en descubierto. Es por ello que cada vez que se desee extraer dinero, no sólo
	 * se considera el que se posee, sino el límite adicional que el banco estará brindando.
	 * Por supuesto esto no es gratis, ya que el banco nos cobrará un 5% como comisión
	 *  sobre todo el monto en descubierto consumido en la operación.
	 */
	
	private static final Double DESCUBIERTO_MAXIMO = 150.0;
	private static final Integer PORCENTAJE_DESCUENTO = 5;
	
	private Double descubiertoActual;
	private Double deuda; // Si el saldo queda negativo, se reinicia a cero y se establece la deuda con el banco

	public CuentaCorriente(Cliente cliente) {
		super(cliente);
		
		this.tipoDeCuenta = TipoDeCuenta.CUENTA_CORRIENTE;
		this.descubiertoActual = 0.0;
		this.deuda = 0.0;
	}

	@Override
	public Boolean extraer(Double cantidad) {
		Boolean sePudoExtraer = Boolean.FALSE;
		Double maximoDescubiertoPosible = (DESCUBIERTO_MAXIMO - this.descubiertoActual);
		
		Double saldoARetirar = 0.0;
		Double descubiertoEnEstaOperacion = 0.0;
		
		if(cantidad <= this.saldo + maximoDescubiertoPosible) {
			// Se puede realizar la operacion
			saldoARetirar = cantidad;
			
			if(cantidad > this.saldo) {
				// Debo usar el descubierto
				saldoARetirar = this.saldo;
				descubiertoEnEstaOperacion = cantidad - this.saldo;
				
			}
			sePudoExtraer = Boolean.TRUE;
		}
		
		this.saldo -= saldoARetirar;
		this.descubiertoActual += descubiertoEnEstaOperacion;
		this.deuda += descubiertoEnEstaOperacion*0.05;
		return sePudoExtraer;
	}

	@Override
	public void depositar(Double cantidad) {
		Double cantidadADepositar = cantidad;
		
		if(this.deuda > 0.0) {
			// Debo descontar la deuda	
			if(cantidadADepositar < this.deuda) {
				this.deuda -= cantidadADepositar;
				cantidadADepositar = 0.0;
			} else {
				cantidadADepositar -= this.deuda;
				this.deuda = 0.0;
			}
			
		}
		
		if(this.descubiertoActual > 0.0 && cantidadADepositar > 0.0) {
			// Si sigue quedando saldo y tengo un descubierto lo cubro
			if(cantidadADepositar < this.descubiertoActual) {
				this.descubiertoActual -= cantidadADepositar;
				cantidadADepositar = 0.0;
			} else {
				cantidadADepositar -= this.descubiertoActual;
				this.descubiertoActual = 0.0;
			}
		}
		

		this.saldo += cantidadADepositar;
	}

	public Double getDescubiertoActual() {
		return this.descubiertoActual;
	}

	public Double getDeuda() {
		return this.deuda;
	}

}
