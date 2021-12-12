package trabajoPractico3.ejercicio01;

public class Manzana extends Producto implements Pesable, DescuentoPorPeso {

	private Double cantidadEnKg;
	private Double precioPorKg;
	private TipoManzana tipo;
	private Boolean fuePesado;
	
	public Manzana(Integer codigo, Double precioPorKg, TipoManzana tipo) {
		super(codigo, 0.0); // Hasta que no se pese el producto el precio es nulo
		this.precioPorKg = precioPorKg;
		this.tipo = tipo;
		this.cantidadEnKg = 0.0;
		this.fuePesado = Boolean.FALSE;
	}
	
	@Override
	public void pesar(Double peso) {
		this.cantidadEnKg = peso;
		this.fuePesado = Boolean.TRUE;
		
		// Actualizar el precio del producto
		this.setPrecio(this.cantidadEnKg * this.precioPorKg);
	}

	public boolean fuePesado() {
		return this.fuePesado;
	}

	/*
	 * Si se lleva 3 kg o más el descuento es del 5%
	 * TODO Habría que ver de hacerlo con la exception de no fue pesado
	 * O mejor refactorizar todo a una clase padre para los productos pesables
	 */
	@Override
	public void aplicarDescuentoPorPeso() {
		
		if(this.fuePesado() && this.cantidadEnKg >= 3.0) {
			this.setPrecio(this.getPrecio() * .95); 
		}
	}
	
	public Double getCantidadEnKg() {
		return this.cantidadEnKg;
	}

}