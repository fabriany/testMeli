package com.fuegoQuasar.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fuegoQuasar.aplication.ComunicationCenter;
import com.fuegoQuasar.aplication.Response;
import com.fuegoQuasar.aplication.SateliteData;

@RestController
public class ComunicationCenterController {
	
	@Autowired
	private ComunicationCenter centerSrv;
	
	@PostMapping("topsecret")
	public ResponseEntity<Response> topSecret(@RequestBody RequestDto resquest) {
		
		try {
			
			Response response = centerSrv.getLocationMessage(resquest.getSatelites());
			if (response != null) {
				return   new ResponseEntity<Response>(response, HttpStatus.OK);
			}			
			return   new ResponseEntity<Response>(HttpStatus.NOT_FOUND);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("topsecret_split")
	public ResponseEntity<Response> getTopsecretSplit() {
				
		try {
			Response response = centerSrv.getLocationMessageSplit();
			if (response != null) {
				return   new ResponseEntity<Response>(response, HttpStatus.OK);
			}
			return   new ResponseEntity<Response>(HttpStatus.NOT_FOUND);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("topsecret_split/{sateliteName}")
	public ResponseEntity<String> postTopsecretSplit(@PathVariable("sateliteName") String sateliteName, @RequestBody SateliteData sateliteData) {
		
		try {
			sateliteData.setName(sateliteName);
			boolean response = centerSrv.setSateliteData(sateliteData);
			
			if (response) {
				return new ResponseEntity<>(HttpStatus.CREATED);
			}else {
				return new ResponseEntity<>("satellite name not found", HttpStatus.NOT_FOUND);
			}
			
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		 
	}

}
