package com.fuegoQuasar.aplication;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fuegoQuasar.Dto.ResponseTopsecretDto;
import com.fuegoQuasar.Dto.SateliteDataDto;
import com.fuegoQuasar.model.Decoder;
import com.fuegoQuasar.model.Location;
import com.fuegoQuasar.model.Position;

@Service
public class ComunicationCenterImpl implements ComunicationCenter {
	
	private static String SATO = "sato";
	private static String KENOBI = "kenobi";
	private static String SKYWALKER = "skywalker";
	
	private static SateliteDataDto sateliteDataSato;
	private static SateliteDataDto sateliteDataKenobi;
	private static SateliteDataDto sateliteDataSkywalker;
	

	@Override
	public ResponseTopsecretDto getLocationMessage(List<SateliteDataDto> sateliteDatas) {
		
		double distaceSato = 0;
		double distanceKenobi = 0;
		double distanceSkywalker = 0;
		
		String[] messageSato = null;
		String[] messageKenobi = null;
		String[] messageSkywalker = null;
		
		ResponseTopsecretDto response = null;
		
		for (SateliteDataDto sateliteData : sateliteDatas) {
			
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
		
		Decoder decoder = new Decoder(messageSato, messageKenobi, messageSkywalker);
		Location locator = new Location(distaceSato,  distanceKenobi, distanceSkywalker);
		Position PositionNave = locator.getLocation();
		String messageNave = decoder.getMessage();
		
		if (PositionNave != null && messageNave != null) {
			response = new ResponseTopsecretDto(PositionNave, messageNave);
		}
		
		
		return response;
	}

	@Override
	public ResponseTopsecretDto getLocationMessageSplit() {

		
		if (sateliteDataSato != null && sateliteDataKenobi != null && sateliteDataSkywalker != null) {
			
			ResponseTopsecretDto response = getLocationMessage(Arrays.asList(sateliteDataSato, sateliteDataKenobi, sateliteDataSkywalker));
			return response;
		}
		
		return null;
	}

	@Override
	public boolean setSateliteData(SateliteDataDto sateliteData) {

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
