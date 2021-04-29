package com.fuegoQuasar.Dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class RequestTopsecretDto {
	
	@JsonProperty("satelites")
	private List<SateliteDataDto> satelites;

	public List<SateliteDataDto> getSatelites() {
		return satelites;
	}

	public void setSatelites(List<SateliteDataDto> satelites) {
		this.satelites = satelites;
	}

	
}
