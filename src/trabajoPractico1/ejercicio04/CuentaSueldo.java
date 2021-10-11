package trabajoPractico1.ejercicio04;

public class CuentaSueldo extends Cuenta {
	
	public CuentaSueldo(Cliente cliente) {
		super(cliente);
		this.tipoDeCuenta = TipoDeCuenta.CUENTA_SUELDO;
	}

	@Override
	public Boolean extraer(Double cantidad) {
		Boolean sePudoExtraer = Boolean.FALSE;
		
		if (cantidad <= this.saldo ) {
			this.saldo -= cantidad;
			sePudoExtraer = Boolean.TRUE;
		}
		
		return sePudoExtraer;
	}

}
