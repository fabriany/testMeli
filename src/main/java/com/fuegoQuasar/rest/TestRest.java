package com.fuegoQuasar.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuegoQuasar.model.CordenadasDTO;
import com.fuegoQuasar.model.Localizacion;

@RestController
@RequestMapping("topsecret")
public class TestRest {
	
	@GetMapping("")
	public CordenadasDTO Main() {
		
		Localizacion localizacion = new Localizacion();
		CordenadasDTO cordenadasDTO = localizacion.getLocation();
		return cordenadasDTO;
	}
	
	@GetMapping("/{id}")
	public String cosa(@PathVariable("id") Integer id) {
		return "hola mundo" + id;
	}

}
