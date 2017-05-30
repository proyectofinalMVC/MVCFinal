package org.foobarspam.proyectofinal.controller;

import org.foobarspam.proyectofinal.service.Carrera.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

	CarreraService carreraService;

	@Autowired
	public TestController(CarreraService carreraService) {
		this.carreraService = carreraService;
	}
	
	
	
}
