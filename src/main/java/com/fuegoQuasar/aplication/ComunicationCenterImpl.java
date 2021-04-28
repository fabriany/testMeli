package com.fuegoQuasar.aplication;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fuegoQuasar.model.Decoder;
import com.fuegoQuasar.model.Location;
import com.fuegoQuasar.model.Position;

@Repository
public class ComunicationCenterImpl implements ComunicationCenter {
	
	private static String SATO = "sato";
	private static String KENOBI = "kenobi";
	private static String SKYWALKER = "skywalker";
	
	private static SateliteData sateliteDataSato;
	private static SateliteData sateliteDataKenobi;
	private static SateliteData sateliteDataSkywalker;
	

	@Override
	public Response getLocationMessage(List<SateliteData> sateliteDatas) {
		
		double distaceSato = 0;
		double distanceKenobi = 0;
		double distanceSkywalker = 0;
		
		String[] messageSato = null;
		String[] messageKenobi = null;
		String[] messageSkywalker = null;
		
		Response response = null;
		
		for (SateliteData sateliteData : sateliteDatas) {
			
			if (sateliteData != null && sateliteData.getName() != null && sateliteData.getMessage() != null) {	
				if (sateliteData.getName().equals(SATO)) {
					distaceSato = sateliteData.getDistance();
					messageSato = new String[sateliteData.getMessage().length];
					messageSato = sateliteData.getMessage();
				}else if (sateliteData.getName().equals(KENOBI)) {
					distanceKenobi = sateliteData.getDistance();
					messageKenobi = new String[sateliteData.getMessage().length];
					messageKenobi = sateliteData.getMessage();
				}else if (sateliteData.getName().equals(SKYWALKER)) {
					distanceSkywalker = sateliteData.getDistance();
					messageSkywalker = new String[sateliteData.getMessage().length];
					messageSkywalker = sateliteData.getMessage();
				}
			}else {
				return null;
			}
		}
		
		Decoder decoder = new Decoder();
		Location locator = new Location();
		Position PositionNave = locator.getLocation(distaceSato,  distanceKenobi, distanceSkywalker);
		String messageNave = decoder.getMessage(messageSato, messageKenobi, messageSkywalker);
		
		if (PositionNave != null && messageNave != null) {
			response = new Response(PositionNave, messageNave);
		}
		
		
		return response;
	}

	@Override
	public Response getLocationMessageSplit() {

		
		if (sateliteDataSato != null && sateliteDataKenobi != null && sateliteDataSkywalker != null) {
			
			Response response = getLocationMessage(Arrays.asList(sateliteDataSato, sateliteDataKenobi, sateliteDataSkywalker));
			return response;
		}
		
		return null;
	}

	@Override
	public boolean setSateliteData(SateliteData sateliteData) {

		if (sateliteData != null) {
			if (sateliteData.getName().equals(SATO)) {
				sateliteDataSato = sateliteData;
			}else if (sateliteData.getName().equals(KENOBI)) {
				sateliteDataKenobi = sateliteData;
			}else if (sateliteData.getName().equals(SKYWALKER)) {
				sateliteDataSkywalker = sateliteData;
			}else {
				return false;
			}
		}else {
			return false;
		}
		return true;
	}
	


}
