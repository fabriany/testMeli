package com.fuegoQuasar.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fuegoQuasar.aplication.ComunicationCenter;
import com.fuegoQuasar.aplication.Response;
import com.fuegoQuasar.aplication.SateliteData;

@RestController
@RequestMapping
public class TestRest {
	
	@Autowired
	private ComunicationCenter centerSrv;
	
	@PostMapping("topsecret")
	public Response topSecret(@RequestBody RequestDto resquest) {
				
		Response response = centerSrv.getLocationMessage(resquest.getSatelites());

		return response;
	}
	
	@GetMapping("topsecret_split")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Response> getTopsecretSplit() {
				
		Response response = centerSrv.getLocationMessageSplit();

		if (response != null) {
			return   new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		return   new ResponseEntity<Response>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("topsecret_split/{sateliteName}")
	public ResponseEntity<String> postTopsecretSplit(@PathVariable("sateliteName") String sateliteName, @RequestBody SateliteData sateliteData) {
		
		sateliteData.setName(sateliteName);
		boolean response = centerSrv.setSateliteData(sateliteData);
		
		if (response) {
			return new ResponseEntity<>("saved satellite information", HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("satellite name not found", HttpStatus.BAD_REQUEST);
		}
		
		
		 
	}

}
