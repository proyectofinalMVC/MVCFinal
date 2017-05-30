package org.foobarspam.proyectofinal;

import org.foobarspam.proyectofinal.model.Carrera;
import org.foobarspam.proyectofinal.model.Conductor;
import org.foobarspam.proyectofinal.model.Valoracion;
import org.foobarspam.proyectofinal.repository.CarreraRepository;
import org.foobarspam.proyectofinal.service.Carrera.CarreraService;
import org.foobarspam.proyectofinal.service.Carrera.CarreraServiceImpl;
import org.foobarspam.proyectofinal.service.Conductor.ConductorService;
import org.foobarspam.proyectofinal.service.Conductor.ConductorServiceImpl;
import org.foobarspam.proyectofinal.service.Valoracion.ValoracionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by palliser on 27/05/2017.
 */
@Component
public class DataLoader {

	CarreraService carreraService;
	ConductorService conductorService;
	ValoracionServiceImpl valoracionService;

	@Autowired
	public DataLoader(ConductorServiceImpl conductorService, CarreraServiceImpl carreraService, ValoracionServiceImpl valoracionService) {

		this.conductorService = conductorService;
		this.carreraService = carreraService;
		this.valoracionService = valoracionService;

	}

	@PostConstruct
	public void setUp() {

		conductorService.guardarConductor(new Conductor("Samantha", "4ABC123", "Chevy Malibu"));
		conductorService.guardarConductor(new Conductor("Fox", "SDHJ44", "Toyota Prius"));
		conductorService.guardarConductor(new Conductor("Mola", "7JKK555", "Mercedes A"));

		//valoracion por defecto 4
		valoracionService.setValoracion(new Valoracion(4, conductorService.getConductores().findOne(new Long(1))));
		valoracionService.setValoracion(new Valoracion(4, conductorService.getConductores().findOne(new Long(2))));
		valoracionService.setValoracion(new Valoracion(4, conductorService.getConductores().findOne(new Long(3))));

		//fijamos los parametros de carrera
		carreraService.setCarrera(new Carrera("Aeroport Son Sant Joan", "Magaluf"));

		carreraService.asignarConductor();

		carreraService.guardarCarrera();

	}

}
