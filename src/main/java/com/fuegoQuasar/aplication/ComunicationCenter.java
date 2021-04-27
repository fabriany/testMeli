package com.fuegoQuasar.aplication;

import java.util.List;

public interface ComunicationCenter {

	public Response getLocationMessage(List<SateliteData> sateliteDatas);
	
	public Response getLocationMessageSplit();
	
	public boolean setSateliteData(SateliteData sateliteData);
	
}
