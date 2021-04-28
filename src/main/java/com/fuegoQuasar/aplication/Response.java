package com.fuegoQuasar.aplication;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fuegoQuasar.model.Position;

public class Response {
	
	@JsonProperty("position")
	private Position position;
	
	@JsonProperty("message")
	private String message;  
	
	public Response(Position position, String message) {
		super();
		this.position = position;
		this.message = message;
	}
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}


	 public boolean equals(Response response) {
		 
		 if (this.position.x == response.position.x && this.position.y == response.position.y) {
			if (this.message.equals(response.message)) {
				return true;
			}
		 }
		 
		 return false;
		
	 }
}
