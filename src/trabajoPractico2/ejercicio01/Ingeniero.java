package trabajoPractico2.ejercicio01;

public class Ingeniero extends Empleado {
	/*
	 * Se considera que posse un sueldo que varia segun la productividad
	 * Para simplificar el modelo se considerara
	 * MUY_PRODUCTIVO = 1.2 * sueldo
	 * BASTANTE_PRODUCTIVO = 1.1 * sueldo
	 * NORMAL = 1.0 * sueldo
	 */

	private Double modificadorDeProductividad; // Se toma como base 1.0

	public Ingeniero(String nombre, String apellido, String fechaDeNacimiento, Double salario) {
		super(nombre, apellido, fechaDeNacimiento, salario);
		
		this.modificadorDeProductividad = 1.0;
	}
	
	@Override
	public Double getSalario() {
		
		return super.getSalario()*this.modificadorDeProductividad;
	}
	
	public void establecerProductividad(Double productividad) {
		this.modificadorDeProductividad = productividad;
	}

	public Double getProductividad() {
		return this.modificadorDeProductividad;
	}
	
}
