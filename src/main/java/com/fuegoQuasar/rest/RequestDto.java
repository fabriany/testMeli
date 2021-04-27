package com.fuegoQuasar.rest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fuegoQuasar.aplication.SateliteData;


public class RequestDto {
	
	@JsonProperty("satelites")
	private List<SateliteData> satelites;

	public List<SateliteData> getSatelites() {
		return satelites;
	}

	public void setSatelites(List<SateliteData> satelites) {
		this.satelites = satelites;
	}

	
}
