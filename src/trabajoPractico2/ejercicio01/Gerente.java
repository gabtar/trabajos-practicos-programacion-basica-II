package trabajoPractico2.ejercicio01;

public class Gerente extends Empleado {
	/*
	 *  Los gerentes cuentan con la	posibilidad de 
	 *  tener una cochera en donde estacionar sus vehículos 
	 */

	private Integer numeroDeCochera; 
	
	public Gerente(String nombre, String apellido, String fechaDeNacimiento, Double salario) {
		super(nombre, apellido, fechaDeNacimiento, salario);
		
		this.numeroDeCochera = 0; // Se toma como que 0 es que no tiene cochera asignada
	}
	
	public void asignarCochera(Integer numeroCochera) {
		this.numeroDeCochera = numeroCochera;
	}

	public Integer getNumeroDeCochera() {
		return this.numeroDeCochera;
	}

}
