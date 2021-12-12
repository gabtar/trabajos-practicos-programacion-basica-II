package trabajoPractico1.ejercicio02;

public class Montacarga {

	private Double pesoMaximo;
	private Carga cargas[];
	private Double pesoActual;
	

	private final Integer CANTIDAD_MAXIMA_DE_CARGAS = 10;
	
	public Montacarga(Double pesoMaximo) {
		this.cargas = new Carga[CANTIDAD_MAXIMA_DE_CARGAS];
		this.pesoMaximo = pesoMaximo;
		this.pesoActual = 0.0;
	}
	
	/*
	 * Se agrega una nueva carga.
	 * No se puede agregar si se sobrepasa el limite del montacarga
	 * Se podría haber planteado con una excepcion
	 */
	public Boolean agregarCarga(Carga carga) {
		Boolean sePudoAgregar = Boolean.FALSE;
		
		for (int i = 0; i < cargas.length; i++) {
			if(this.cargas[i] == null && !sePudoAgregar) {
				this.cargas[i] = carga;
				this.pesoActual += carga.getPeso();
				sePudoAgregar = Boolean.TRUE;
				
				if(this.estaSobrecargado()) {
					this.pesoActual -= carga.getPeso();
					this.cargas[i] = null;
					sePudoAgregar = Boolean.FALSE;
				}
				
			}
		}
		
		return sePudoAgregar;
	}
	
	public Boolean estaSobrecargado() {
		return this.pesoActual > this.pesoMaximo;
	}

	public Double getPesoActual() {
		return pesoActual;
	}
}
