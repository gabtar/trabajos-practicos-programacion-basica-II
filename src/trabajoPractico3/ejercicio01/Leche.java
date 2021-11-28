package trabajoPractico3.ejercicio01;

import java.util.Objects;

/*
 * Representa un producto genérico del tipo Leche
 * @param Double tamanioEnvasePorLitro Capacidad en litros del envase. Ej 1.0 es 1Lt, .5 es 1/2 litro, etc
 */
public class Leche extends Producto implements DescuentoPorCantidad {

	private String marca;
	private Double tamanioEnvasePorLitro;
	private Integer cantidadDeUnidades;
	
	public Leche(Integer codigo, Double precio, String marca, Double tamanioEnvasePorLitro) {
		super(codigo, precio);
		this.marca = marca;
		this.tamanioEnvasePorLitro = tamanioEnvasePorLitro;
		this.cantidadDeUnidades = 1;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getTamanioEnvasePorLitro() {
		return tamanioEnvasePorLitro;
	}

	public void setTamanioEnvasePorLitro(Double tamanioEnvasePorLitro) {
		this.tamanioEnvasePorLitro = tamanioEnvasePorLitro;
	}
	
	public void setCantidadDeUnidades(Integer cantidadDeUnidades) {
		this.cantidadDeUnidades = cantidadDeUnidades;
	}
	
	public Integer getCantidadDeUnidades() {
		return this.cantidadDeUnidades;
	}

	/*
	 * Si se compran más de 5 unidades se hace un descuento de 10%
	 */
	@Override
	public void aplicarDescuentoPorCantidad() {
		this.setPrecio(this.getPrecio()*.90/this.cantidadDeUnidades);
	}

	@Override
	public int hashCode() {
		return Objects.hash(marca, tamanioEnvasePorLitro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Leche other = (Leche) obj;
		return Objects.equals(marca, other.marca) && Objects.equals(tamanioEnvasePorLitro, other.tamanioEnvasePorLitro);
	}
	
	@Override
	public Double getPrecio() {
		return super.getPrecio()*this.cantidadDeUnidades;
	}
	
}