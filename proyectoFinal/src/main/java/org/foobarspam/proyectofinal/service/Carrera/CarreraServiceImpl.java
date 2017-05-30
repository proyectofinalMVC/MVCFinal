package org.foobarspam.proyectofinal.service.Carrera;

import org.foobarspam.proyectofinal.model.Carrera;
import org.foobarspam.proyectofinal.model.Conductor;
import org.foobarspam.proyectofinal.model.Valoracion;
import org.foobarspam.proyectofinal.repository.CarreraRepository;
import org.foobarspam.proyectofinal.service.Conductor.ConductorService;
import org.foobarspam.proyectofinal.service.Conductor.ConductorServiceImpl;
import org.foobarspam.proyectofinal.service.Valoracion.ValoracionServiceImpl;
import org.foobarspam.proyectofinal.service.component.Tarifa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by palliser on 27/05/2017.
 */
@Service
public class CarreraServiceImpl implements CarreraService {

	private ConductorService conductorService;
	private CarreraRepository carreras;
	private ValoracionServiceImpl valoracionService;
	private Carrera carrera;
	private Tarifa tarifa;

	@Autowired
	public CarreraServiceImpl(ConductorServiceImpl conductorService, ValoracionServiceImpl valoracionService, Tarifa tarifa) {
		this.conductorService = conductorService;
		this.valoracionService = valoracionService;
		this.tarifa = tarifa;
	}

	public CarreraRepository getCarreras() {
		return carreras;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	@Autowired
	public void setCarreras(CarreraRepository carreras) {
		this.carreras = carreras;
	}

	public Tarifa getTarifa() {
		return this.tarifa;
	}

	@Override
	public void asignarCarrera(Carrera carrera){
		this.carrera = carrera;
		carreras.save(carrera);
	}

	@Override
	public void setValoracion(Valoracion valoracion) {

		this.getCarrera().setValoracion(valoracion);
		valoracionService.setValoracion(valoracion);
	}

	public Long conductorActualID() {
		return this.carrera.getConductor().getId();
	}
	
	public void setDistancia(double distancia) {
		this.tarifa.setDistancia(distancia);
	}
	
	public void setTiempo(double minutos) {
		this.tarifa.setMinutos(minutos);
	}

	public Conductor getConductor() {
		return this.carrera.getConductor();
	}

	@Override
	public void guardarCarrera() {
		getCarreras().save(this.carrera);
	}

	@Override
	public void asignarConductor() {
		//TODO: añadir try catch para gestionar si no existen conductores libres
		carrera.setConductor(conductorService.asignarConductor());
		carrera.getConductor().setOcupado(true);
		conductorService.guardarConductor(carrera.getConductor());
	}

	@Override
	public void calcularCoste() {
		getCarrera().setPrecioCarrera(tarifa.getCosteTarifa());
	}

	public void liberarConductor(){
		getConductor().setOcupado(false);
		conductorService.guardarConductor(this.getConductor());
	}

	public double valoracionMedia() {
		double valoracionMedia = 0.0d;
		for (Valoracion valoracion : valoracionService.getValoraciones().findAllByConductor(this.getConductor())) {
			valoracionMedia += valoracion.getValoracion();
		}
		return valoracionMedia / valoracionService.getValoraciones().findAllByConductor(this.getConductor()).size();
	}
}
