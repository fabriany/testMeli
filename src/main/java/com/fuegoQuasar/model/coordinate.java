package com.fuegoQuasar.model;

public class coordinate {

	private double coordinate_x;
	double coordinate_y;
	double radius;
	
	public coordinate(Position position, double radius) {
		super();
		this.coordinate_x = position.getX();
		this.coordinate_y = position.getY();
		this.radius = radius;
	}
	
	public double x() {
		return coordinate_x;
	}

	public double y() {
		return coordinate_y;
	}

	public double r() {
		return radius;
	}
}
