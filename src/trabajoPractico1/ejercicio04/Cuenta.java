package trabajoPractico1.ejercicio04;

public abstract class Cuenta {

	protected Double saldo;
	protected Cliente cliente;
	protected TipoDeCuenta tipoDeCuenta;
	protected Integer numeroDeCuenta;
	protected static Integer cantidadDeCuentas = 0;
	
	public Cuenta(Cliente cliente) {
		this.cliente = cliente;
		this.numeroDeCuenta = cantidadDeCuentas++;
		
		// Por defecto se inicializa la cuenta con saldo nulo
		this.saldo = 0.0;
		
	}

	abstract public Boolean extraer(Double cantidad);
	
	public void depositar(Double cantidad) {
		this.saldo += cantidad;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public Integer getNumeroDeCuenta() {
		return numeroDeCuenta;
	}
	
	@Override
	public String toString() {
		return "Num. Cuenta: " + this.numeroDeCuenta + "(" + this.tipoDeCuenta + ")"+ " > " + "Cliente: " + this.cliente.toString();
	}
	
	public TipoDeCuenta getTipoDeCuenta() {
		return tipoDeCuenta;
	}
	
}
