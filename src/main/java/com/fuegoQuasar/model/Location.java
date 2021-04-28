package com.fuegoQuasar.model;


public class Location {
	
	private static Position POSITION_SATO  = new Position(500, 100);
	private static Position POSITION_KENOBI = new Position(-500, -200);
	private static Position POSITION_SKYWALKER = new Position(100, -100);
	
	public Position getLocation(Double distaceSato, Double distanceKenobi, Double distanceSkywalker){
		
		Position positionNave = null;
		
		if (validateDistance(distaceSato, distanceKenobi, distanceSkywalker)) {

			coordinate coorSato = new coordinate(POSITION_SATO, distaceSato);
			coordinate coorKenobi = new coordinate(POSITION_KENOBI, distanceKenobi);
			coordinate coorSkywalker = new coordinate(POSITION_SKYWALKER, distanceSkywalker);
			
			double numerator_y = (coorKenobi.x() - coorSato.x()) * (Math.pow(coorSkywalker.x(), 2)  + Math.pow(coorSkywalker.y(), 2) - Math.pow(coorSkywalker.r(), 2)) +     
								 (coorSato.x() - coorSkywalker.x()) * (Math.pow(coorKenobi.x(), 2)  + Math.pow(coorKenobi.y(), 2) - Math.pow(coorKenobi.r(), 2)) +  
								 (coorSkywalker.x() - coorKenobi.x()) * (Math.pow(coorSato.x(), 2)  + Math.pow(coorSato.y(), 2) - Math.pow(coorSato.r(), 2));  
			double denominator_y  = 2 * (coorSkywalker.y() * (coorKenobi.x() - coorSato.x()) + coorKenobi.y() * (coorSato.x() - coorSkywalker.x()) + coorSato.y() * 
									(coorSkywalker.x() - coorKenobi.x()));
			double y = (numerator_y)/(denominator_y);
			
			
			double numerator_x = (Math.pow(coorKenobi.r(), 2) + Math.pow(coorSato.x(), 2) + Math.pow(coorSato.y(), 2) -
					Math.pow(coorSato.r(), 2) - Math.pow(coorKenobi.x(), 2) - Math.pow(coorKenobi.y(), 2) -(2 * (coorSato.y() - coorKenobi.y()) * y));
			double denominator_x  = (2 * (coorSato.x() -coorKenobi.x()));
			double x = numerator_x / denominator_x;
			
			positionNave = new Position(x, y);
			
		}
		
		return positionNave;
	}
	
	private boolean validateDistance(Double distaceSato, Double distanceKenobi, Double distanceSkywalker) {
		
		if(distaceSato  != null && distanceKenobi != null && distanceSkywalker != null) {
			if (distaceSato  != 0.0 && distanceKenobi != 0.0 && distanceSkywalker != 0.0) {
				return true;
			}
		}
		return false;
		
	}
}
