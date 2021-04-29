package com.fuegoQuasar.aplication;

import java.util.List;

import com.fuegoQuasar.Dto.ResponseTopsecretDto;
import com.fuegoQuasar.Dto.SateliteDataDto;

public interface ComunicationCenter {

	public ResponseTopsecretDto getLocationMessage(List<SateliteDataDto> sateliteDatas);
	
	public ResponseTopsecretDto getLocationMessageSplit();
	
	public boolean setSateliteData(SateliteDataDto sateliteData);
	
}
