package trabajoPractico3.ejercicio01;

import java.util.HashMap;
import java.util.Map;

/*
 * Simula un carrito de compras de un sitio web / supermercado generico 
 */
public class CarritoCompras {
	
	private Map<Integer, Producto> productos;
	private Integer productosEnElCarrito;
	
	public CarritoCompras() {
		productos = new HashMap<Integer, Producto>();
		productosEnElCarrito = 0;
	}
	
	public void agregarUnProducto(Integer numero, Producto producto) throws NoPesadoAunException {
		
		// Se podria definir una subClase productos Pesables que implementen la interfaz directamente
		if(producto instanceof Pesable && !((Pesable)producto).fuePesado()) {
			throw new NoPesadoAunException();
		}
		
		this.productos.put(numero, producto);
		this.productosEnElCarrito++;
		
	}
	
	public Producto verDetallesDelProducto(Integer numero) {
		return this.productos.get(numero);
	}
	
	public Double obtenerElImporteTotalDelCarrito() {
		Double importeTotal = 0.0;
		
		for (Producto producto : productos.values()) {
				importeTotal += producto.getPrecio();		
		}
		
		return importeTotal;
	}
	
	public Boolean verificarSiHayDescuentosPorCantidad() {
		Boolean seAplicaronDescuentos = Boolean.FALSE;
		
		for(Producto producto : productos.values()) {
			
			if(producto instanceof Leche && ((Leche) producto).getCantidadDeUnidades() >= 5) {
				((Leche)producto).aplicarDescuentoPorCantidad();
				seAplicaronDescuentos = Boolean.TRUE;
			}
			
			if(producto instanceof Manzana && ((Manzana) producto).getCantidadEnKg() >= 3.0) {
				((Manzana)producto).aplicarDescuentoPorPeso();
				seAplicaronDescuentos = Boolean.TRUE;
			}
			
		}
		
		return seAplicaronDescuentos;
	}
	


}
