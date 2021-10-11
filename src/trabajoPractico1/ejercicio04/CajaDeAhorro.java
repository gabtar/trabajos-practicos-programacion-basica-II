package trabajoPractico1.ejercicio04;

public class CajaDeAhorro extends Cuenta {
	
	private static final Integer LIMITE_DE_EXTRACCIONES_SIN_COSTO = 5;
	private static final Double COSTO_ADICIONAL = 6.0;
		
	private Integer cantidadDeExtracciones;

	public CajaDeAhorro(Cliente cliente) {
		super(cliente);
		
		this.tipoDeCuenta = TipoDeCuenta.CAJA_DE_AHORRO;
		this.cantidadDeExtracciones = 0;
	}

	@Override
	public Boolean extraer(Double cantidad) {
		/*
		 * Luego de la 5ta extraccion se cobra un adicional
		 */
		Boolean sePudoExtraer = Boolean.FALSE;
		Double saldoADescontar = cantidad;
		
		if (this.cantidadDeExtracciones >= LIMITE_DE_EXTRACCIONES_SIN_COSTO) {
			saldoADescontar = cantidad + COSTO_ADICIONAL;
		}
		
		if (saldoADescontar <= this.saldo ) {
			this.saldo -= saldoADescontar;
			sePudoExtraer = Boolean.TRUE;
			this.cantidadDeExtracciones++;
		}
		
		return sePudoExtraer;
	}

}
