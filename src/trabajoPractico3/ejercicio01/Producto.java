package trabajoPractico3.ejercicio01;

/*
 * Representa un producto generico del proyecto
 * TODO Ver como refactorizar el tema de los descuentos y los precios. Precio unitario y 
 * que las clases hereden un precio total? o precio con descuentos?
 */
abstract class Producto {

	private Integer codigo;
	private Double precio;
	
	public Producto(Integer codigo, Double precio) {
		super();
		this.codigo = codigo;
		this.precio = precio;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}