package trabajoPractico0.ejercicio05;

import java.util.Comparator;

public class PorApellidoComparator implements Comparator<Pasajero> {

	@Override
	public int compare(Pasajero o1, Pasajero o2) {
		return o1.getApellido().compareTo(o2.getApellido());
	}

}
