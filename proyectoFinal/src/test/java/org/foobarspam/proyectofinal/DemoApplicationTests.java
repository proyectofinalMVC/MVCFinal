package org.foobarspam.proyectofinal;

import org.foobarspam.proyectofinal.model.Valoracion;
import org.foobarspam.proyectofinal.service.Carrera.CarreraService;
import org.foobarspam.proyectofinal.service.Conductor.ConductorService;
import org.foobarspam.proyectofinal.service.Valoracion.ValoracionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	@Autowired
	CarreraService carreraService;
	@Autowired
	ConductorService conductorService;
	@Autowired
	ValoracionService valoracionService;

	@Test
	public void primeraHistoria() {

		carreraService.setDistancia(7.75);
		carreraService.setTiempo(10);

		//Set Pickup
		assertEquals(carreraService.getCarrera().getOrigen(), "Aeroport Son Sant Joan");
		assertEquals(carreraService.getCarrera().getDestino(), "Magaluf");
		assertEquals(carreraService.getTarifa().getDistancia(), 7.75, 0);
		assertEquals(carreraService.getTarifa().getMinutos(), 10, 0);
	}

	@Test
	public void segundaHistoria(){

		carreraService.setDistancia(7.75);
		carreraService.setTiempo(10);
		carreraService.calcularCoste();

		//See your Cost
		assertEquals(13.9625, carreraService.getCarrera().getCoste(), 0);

		carreraService.setDistancia(5.00);
		carreraService.setTiempo(5);
		assertEquals( 8.5, carreraService.getTarifa().getCosteTarifa(), 0 );

	}

	@Test
	public void terceraHistoria() {

		//quinta historia, setea otra valoracion.
		carreraService.setValoracion(new Valoracion(2, carreraService.getConductor()));
		carreraService.setValoracion(new Valoracion(3, carreraService.getConductor()));
		carreraService.setValoracion(new Valoracion(2, carreraService.getConductor()));
		carreraService.setValoracion(new Valoracion(4, carreraService.getConductor()));

		assertEquals(1, carreraService.getConductor().getId(),0);

		assertEquals(5, valoracionService.findAllByConductor(carreraService.getConductor()).size());
		assertEquals(3, carreraService.valoracionMedia(),0);

		//Falta hacer que sea aleatorio y gestionar si no quedan conductores.
		assertTrue( conductorService.getConductores().exists(carreraService.conductorActualID()));
		assertEquals(3,conductorService.getConductores().count());

	}

	@Test
	public void cuartaHistoria() {

		carreraService.getCarrera().setPropina(5);
		carreraService.getCarrera().setModoPago("Android Pay");

		assertEquals(5,carreraService.getCarrera().getPropina(),0);
		assertTrue(carreraService.getCarrera().getModoPago().equals("Android Pay"));

	}


}
