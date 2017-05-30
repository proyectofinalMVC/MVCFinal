package org.foobarspam.proyectofinal.controller;

import org.foobarspam.proyectofinal.model.Carrera;
import org.foobarspam.proyectofinal.service.Carrera.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	CarreraService carreraService;

	@Autowired
	public TestController(CarreraService carreraService) {
		this.carreraService = carreraService;
	}

	@RequestMapping("/carrera")
	public String home(Model model) {
		model.addAttribute("carrera", new Carrera());
		return "index";
	}

	@RequestMapping( value= "carrera/guardar", method = RequestMethod.POST)
	public String asignarCarrera(Carrera carrera) {
		carreraService.setCarrera(carrera);
		carreraService.guardarCarrera();
		return "redirect:/carrera";
	}
	
	
}
