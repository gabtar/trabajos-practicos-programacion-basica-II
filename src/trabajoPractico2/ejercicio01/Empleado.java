package trabajoPractico2.ejercicio01;

public class Empleado {
	/*
	 * Para cada empleado se desea conocer el
	 * nombre, apellido, salario y fecha de nacimiento
	 */
	
	private String nombre;
	private String apellido;
	private String fechaDeNacimiento; // Se usa el formato dd-mm-aaaa
	private Double salario;
	
	public Empleado(String nombre, String apellido, String fechaDeNacimiento, Double salario) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.salario = salario;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
}
