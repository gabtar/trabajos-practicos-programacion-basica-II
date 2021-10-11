package trabajoPractico2.ejercicio01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmpleadoTest {

	@Test
	public void queSePuedaCrearUnEmpleado() {
		Empleado empleadoDePrueba = new Empleado("Juan", "Perez", "10-10-2021", 5000.0);
		
		assertNotNull(empleadoDePrueba);
	}

}
