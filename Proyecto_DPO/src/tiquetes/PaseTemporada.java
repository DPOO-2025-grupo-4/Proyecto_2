package tiquetes;


import java.util.List;

import Usuarios.Usuario;

public class PaseTemporada extends TiqueteMultiple {

	public PaseTemporada() {
		super();
	}
    public PaseTemporada(List<TiqueteIndividual> tiquetes,double precioBasePaquete,double porcentajeServicio,double cobroEmision) {
        super(tiquetes, precioBasePaquete, porcentajeServicio, cobroEmision);
    }
}