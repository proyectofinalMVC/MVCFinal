package org.foobarspam.proyectofinal.service.Valoracion;

import org.foobarspam.proyectofinal.model.Conductor;
import org.foobarspam.proyectofinal.model.Valoracion;
import org.foobarspam.proyectofinal.repository.ValoracionRepository;

import java.util.List;

/**
 * Created by palliser on 29/05/2017.
 */
public interface ValoracionService {

	void setValoracion(Valoracion valoracion);

	ValoracionRepository getValoraciones();

	List<Valoracion> findAllByConductor(Conductor conductor);
}
