package com.fuegoQuasar.aplication;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fuegoQuasar.model.Position;

public class ComunicationCenterImpleTest {

	private ComunicationCenterImpl centerSrv = new ComunicationCenterImpl();
	
	@Test
	public void getLocationMessageTest() {
		
		Response expectedResponse = new Response(new Position(-37.5, -325.0), "este es un mensaje secreto");

		SateliteData sateliteDataSato = new SateliteData();
		sateliteDataSato.setName("sato");
		sateliteDataSato.setDistance(700);
		String[ ] messagesato = {"este", " ", "un", " ", " "};
		sateliteDataSato.setMessage(messagesato);
		
		SateliteData sateliteDataKenobi  = new SateliteData();
		sateliteDataKenobi.setName("kenobi");
		sateliteDataKenobi.setDistance(500);
		String[ ] messagekenobi = {"este", " ", " ", "mensaje", " "};
		sateliteDataKenobi.setMessage(messagekenobi);
		
		SateliteData sateliteDataSkywalker  = new SateliteData();
		sateliteDataSkywalker.setName("skywalker");
		sateliteDataSkywalker.setDistance(300);
		String[ ] messageSkywalker = {" ", "es", " ", " ", "secreto"};
		sateliteDataSkywalker.setMessage(messageSkywalker); 
		
		List<SateliteData> satelites = List.of(sateliteDataSato, sateliteDataKenobi, sateliteDataSkywalker);
		
		Response response = centerSrv.getLocationMessage(satelites);
		
		assertTrue(response.equals(expectedResponse));
	}
	
	@Test
	public void getLocationMessageTest2() {
		
		Response expectedResponse = new Response(new Position(-137.5, 75.0), "messaje para la prueba de Meli");

		SateliteData sateliteDataSato = new SateliteData();
		sateliteDataSato.setName("sato");
		sateliteDataSato.setDistance(600);
		String[ ] messagesato = {" ", " ", "la", " ", " ", "Meli"};
		sateliteDataSato.setMessage(messagesato);
		
		SateliteData sateliteDataKenobi  = new SateliteData();
		sateliteDataKenobi.setName("kenobi");
		sateliteDataKenobi.setDistance(400);
		String[ ] messagekenobi = {" ", "para", " ", " ", "de", " "};
		sateliteDataKenobi.setMessage(messagekenobi);
		
		SateliteData sateliteDataSkywalker  = new SateliteData();
		sateliteDataSkywalker.setName("skywalker");
		sateliteDataSkywalker.setDistance(200);
		String[ ] messageSkywalker = {"messaje", " ", " ", "prueba", " ", " "};
		sateliteDataSkywalker.setMessage(messageSkywalker); 
		
		List<SateliteData> satelites = List.of(sateliteDataSato, sateliteDataKenobi, sateliteDataSkywalker);
		
		Response response = centerSrv.getLocationMessage(satelites);
		
		assertTrue(response.equals(expectedResponse));
	}
	
	@Test
	public void getLocationMessageSplitFailTest() {
		
		Response response = centerSrv.getLocationMessageSplit();
		
		assertTrue(response == null);
		
	}
	
	@Test
	public void setSateliteDataSato() {
		
		SateliteData sateliteDataSato = new SateliteData();
		sateliteDataSato.setName("sato");
		sateliteDataSato.setDistance(600);
		String[ ] messagesato = {" ", " ", "la", " ", " ", "Meli"};
		sateliteDataSato.setMessage(messagesato);
		
		assertTrue(centerSrv.setSateliteData(sateliteDataSato));
	}
	
	@Test
	public void setSateliteDatakenobi() {
		
		SateliteData sateliteDataKenobi  = new SateliteData();
		sateliteDataKenobi.setName("kenobi");
		sateliteDataKenobi.setDistance(400);
		String[ ] messagekenobi = {" ", "para", " ", " ", "de", " "};
		sateliteDataKenobi.setMessage(messagekenobi);
		assertTrue(centerSrv.setSateliteData(sateliteDataKenobi));
	}
	
	@Test
	public void setSateliteDataskywalker() {
		
		SateliteData sateliteDataSkywalker  = new SateliteData();
		sateliteDataSkywalker.setName("skywalker");
		sateliteDataSkywalker.setDistance(200);
		String[ ] messageSkywalker = {"messaje", " ", " ", "prueba", " ", " "};
		sateliteDataSkywalker.setMessage(messageSkywalker); 
		assertTrue(centerSrv.setSateliteData(sateliteDataSkywalker));
	}
	
	@Test
	public void getLocationMessageSplitTest() {
		
	
			
		SateliteData sateliteDataSato = new SateliteData();
		sateliteDataSato.setName("sato");
		sateliteDataSato.setDistance(600);
		String[ ] messagesato = {" ", " ", "la", " ", " ", "Meli"};
		sateliteDataSato.setMessage(messagesato);		
		centerSrv.setSateliteData(sateliteDataSato);

		
		SateliteData sateliteDataKenobi  = new SateliteData();
		sateliteDataKenobi.setName("kenobi");
		sateliteDataKenobi.setDistance(400);
		String[ ] messagekenobi = {" ", "para", " ", " ", "de", " "};
		sateliteDataKenobi.setMessage(messagekenobi);
		centerSrv.setSateliteData(sateliteDataKenobi);
	
		SateliteData sateliteDataSkywalker  = new SateliteData();
		sateliteDataSkywalker.setName("skywalker");
		sateliteDataSkywalker.setDistance(200);
		String[ ] messageSkywalker = {"messaje", " ", " ", "prueba", " ", " "};
		sateliteDataSkywalker.setMessage(messageSkywalker); 
		centerSrv.setSateliteData(sateliteDataSkywalker);

		
		Response response = centerSrv.getLocationMessageSplit();
		
		assertTrue(response != null);
		
	}
	

}
