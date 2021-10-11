package trabajoPractico2.ejercicio01;

public class Director extends Empleado {
	/*
	 * Los directores quienes además de tener su cochera, poseen un “sueldo extra”
	 *  producto de tener la responsabilidad de ser directivo de la empresa.
	 */

	private Integer numeroDeCochera; 
	private Double sueldoAdicional; // Se considera adicional de 5.000, puede modificarse
	
	private final Double SUELDO_ADICIONAL_POR_DEFECTO = 5000.0;
	
	public Director(String nombre, String apellido, String fechaDeNacimiento, Double salario) {
		super(nombre, apellido, fechaDeNacimiento, salario);
		
		this.sueldoAdicional = SUELDO_ADICIONAL_POR_DEFECTO;
		this.numeroDeCochera = 0;
	}

	@Override
	public Double getSalario() {
		return super.getSalario() + sueldoAdicional;
	}
	
	public void setSueldoAdicional(Double sueldoAdicional) {
		this.sueldoAdicional = sueldoAdicional;
	}
	
	public void asignarCochera(Integer numeroCochera) {
		this.numeroDeCochera = numeroCochera;
	}

	public Integer getNumeroDeCochera() {
		return this.numeroDeCochera;
	}
	
	
}
