package org.foobarspam.proyectofinal.service.Carrera;

import org.foobarspam.proyectofinal.model.Carrera;
import org.foobarspam.proyectofinal.model.Conductor;
import org.foobarspam.proyectofinal.model.Valoracion;
import org.foobarspam.proyectofinal.repository.CarreraRepository;
import org.foobarspam.proyectofinal.service.component.Tarifa;

public interface CarreraService {
	
	void asignarCarrera(Carrera carrera);

	void asignarConductor();
		
	void setValoracion(Valoracion valoracion);
	
	void calcularCoste();
	
	void guardarCarrera();

	void liberarConductor();

	Conductor getConductor();

	Carrera getCarrera();

	void setDistancia(double d);

	void setTiempo(double t);

	void setCarrera(Carrera c);

	CarreraRepository getCarreras();

	Tarifa getTarifa();

	double valoracionMedia();

	Long conductorActualID();

}
