package com.fuegoQuasar.aplication;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fuegoQuasar.Dto.ResponseTopsecretDto;
import com.fuegoQuasar.Dto.SateliteDataDto;
import com.fuegoQuasar.model.Position;

public class ComunicationCenterImpleTest {

	private ComunicationCenterImpl centerSrv = new ComunicationCenterImpl();
	
	@Test
	public void getLocationMessageTest() {
		
		ResponseTopsecretDto expectedResponse = new ResponseTopsecretDto(new Position(-37.5, -325.0), "este es un mensaje secreto");

		SateliteDataDto sateliteDataSato = new SateliteDataDto();
		sateliteDataSato.setName("sato");
		sateliteDataSato.setDistance(700);
		String[ ] messagesato = {"este", " ", "un", " ", " "};
		sateliteDataSato.setMessage(messagesato);
		
		SateliteDataDto sateliteDataKenobi  = new SateliteDataDto();
		sateliteDataKenobi.setName("kenobi");
		sateliteDataKenobi.setDistance(500);
		String[ ] messagekenobi = {"este", " ", " ", "mensaje", " "};
		sateliteDataKenobi.setMessage(messagekenobi);
		
		SateliteDataDto sateliteDataSkywalker  = new SateliteDataDto();
		sateliteDataSkywalker.setName("skywalker");
		sateliteDataSkywalker.setDistance(300);
		String[ ] messageSkywalker = {" ", "es", " ", " ", "secreto"};
		sateliteDataSkywalker.setMessage(messageSkywalker); 
		
		List<SateliteDataDto> satelites = List.of(sateliteDataSato, sateliteDataKenobi, sateliteDataSkywalker);
		
		ResponseTopsecretDto response = centerSrv.getLocationMessage(satelites);
		
		assertTrue(response.equals(expectedResponse));
	}
	
	@Test
	public void getLocationMessageTest2() {
		
		ResponseTopsecretDto expectedResponse = new ResponseTopsecretDto(new Position(-137.5, 75.0), "messaje para la prueba de Meli");

		SateliteDataDto sateliteDataSato = new SateliteDataDto();
		sateliteDataSato.setName("sato");
		sateliteDataSato.setDistance(600);
		String[ ] messagesato = {" ", " ", "la", " ", " ", "Meli"};
		sateliteDataSato.setMessage(messagesato);
		
		SateliteDataDto sateliteDataKenobi  = new SateliteDataDto();
		sateliteDataKenobi.setName("kenobi");
		sateliteDataKenobi.setDistance(400);
		String[ ] messagekenobi = {" ", "para", " ", " ", "de", " "};
		sateliteDataKenobi.setMessage(messagekenobi);
		
		SateliteDataDto sateliteDataSkywalker  = new SateliteDataDto();
		sateliteDataSkywalker.setName("skywalker");
		sateliteDataSkywalker.setDistance(200);
		String[ ] messageSkywalker = {"messaje", " ", " ", "prueba", " ", " "};
		sateliteDataSkywalker.setMessage(messageSkywalker); 
		
		List<SateliteDataDto> satelites = List.of(sateliteDataSato, sateliteDataKenobi, sateliteDataSkywalker);
		
		ResponseTopsecretDto response = centerSrv.getLocationMessage(satelites);
		
		assertTrue(response.equals(expectedResponse));
	}
	
	@Test
	public void getLocationMessageSplitFailTest() {
		
		ResponseTopsecretDto response = centerSrv.getLocationMessageSplit();
		
		assertTrue(response == null);
		
	}
	
	@Test
	public void setSateliteDataSato() {
		
		SateliteDataDto sateliteDataSato = new SateliteDataDto();
		sateliteDataSato.setName("sato");
		sateliteDataSato.setDistance(600);
		String[ ] messagesato = {" ", " ", "la", " ", " ", "Meli"};
		sateliteDataSato.setMessage(messagesato);
		
		assertTrue(centerSrv.setSateliteData(sateliteDataSato));
	}
	
	@Test
	public void setSateliteDatakenobi() {
		
		SateliteDataDto sateliteDataKenobi  = new SateliteDataDto();
		sateliteDataKenobi.setName("kenobi");
		sateliteDataKenobi.setDistance(400);
		String[ ] messagekenobi = {" ", "para", " ", " ", "de", " "};
		sateliteDataKenobi.setMessage(messagekenobi);
		assertTrue(centerSrv.setSateliteData(sateliteDataKenobi));
	}
	
	@Test
	public void setSateliteDataskywalker() {
		
		SateliteDataDto sateliteDataSkywalker  = new SateliteDataDto();
		sateliteDataSkywalker.setName("skywalker");
		sateliteDataSkywalker.setDistance(200);
		String[ ] messageSkywalker = {"messaje", " ", " ", "prueba", " ", " "};
		sateliteDataSkywalker.setMessage(messageSkywalker); 
		assertTrue(centerSrv.setSateliteData(sateliteDataSkywalker));
	}
	
	@Test
	public void getLocationMessageSplitTest() {
		
		SateliteDataDto sateliteDataSato = new SateliteDataDto();
		sateliteDataSato.setName("sato");
		sateliteDataSato.setDistance(600);
		String[ ] messagesato = {" ", " ", "la", " ", " ", "Meli"};
		sateliteDataSato.setMessage(messagesato);		
		centerSrv.setSateliteData(sateliteDataSato);

		
		SateliteDataDto sateliteDataKenobi  = new SateliteDataDto();
		sateliteDataKenobi.setName("kenobi");
		sateliteDataKenobi.setDistance(400);
		String[ ] messagekenobi = {" ", "para", " ", " ", "de", " "};
		sateliteDataKenobi.setMessage(messagekenobi);
		centerSrv.setSateliteData(sateliteDataKenobi);
	
		SateliteDataDto sateliteDataSkywalker  = new SateliteDataDto();
		sateliteDataSkywalker.setName("skywalker");
		sateliteDataSkywalker.setDistance(200);
		String[ ] messageSkywalker = {"messaje", " ", " ", "prueba", " ", " "};
		sateliteDataSkywalker.setMessage(messageSkywalker); 
		centerSrv.setSateliteData(sateliteDataSkywalker);
		ResponseTopsecretDto response = centerSrv.getLocationMessageSplit();
		
		assertTrue(response != null);
		
	}
}
