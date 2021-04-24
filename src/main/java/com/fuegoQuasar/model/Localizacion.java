package com.fuegoQuasar.model;


public class Localizacion {
	
	public CordenadasDTO getLocation(){
		
		CordenadasDTO cordenadasDTO = new CordenadasDTO();
		Satelite c1 = new Satelite(832.165, 5148.059, 86.814);
		Satelite c2 = new Satelite(741.264, 5242.310, 69.409);
		Satelite c3 = new Satelite(863.763, 5245.127, 55.448);
		
		double parte1y = Math.pow(c3.x, 2)  + Math.pow(c3.y, 2) - Math.pow(c3.r, 2);     
		double parte2y = Math.pow(c2.x, 2)  + Math.pow(c2.y, 2) - Math.pow(c2.r, 2);   
		double parte3y = Math.pow(c1.x, 2)  + Math.pow(c1.y, 2) - Math.pow(c1.r, 2);  
		double divy  = 2 * (c3.y * (c2.x - c1.x) + c2.y * (c1.x - c3.x) + c1.y * (c3.x - c2.x));
		double y = ((c2.x - c1.x) * parte1y + (c1.x - c3.x) * parte2y + (c3.x - c2.x) * parte3y)/(divy);
		
		double x = (Math.pow(c2.r, 2) + Math.pow(c1.x, 2) + Math.pow(c1.y, 2) - Math.pow(c1.r, 2) - Math.pow(c2.x, 2) - Math.pow(c2.y, 2) -(2 * (c1.y - c2.y) * y)) / (2 * (c1.x -c2.x));
		
		cordenadasDTO.setX(x);
		cordenadasDTO.setY(y);
		
		return cordenadasDTO;
	}
}
