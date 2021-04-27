package com.fuegoQuasar.model;

public class Decoder {


	public String getMessage(String[] menssageSato, String[] menssageKenobi, String[] menssageSkywalker) {
		
		String[] menssage = new String[5];;
		
		for (int i = 0 ; i < menssageSato.length; i ++ ) {
			
			menssage[i] = !menssageSato[i].equals(" ") ? menssageSato[i] : !menssageKenobi[i].equals(" ") ? menssageKenobi[i] : !menssageSkywalker[i].equals(" ")  ? menssageSkywalker[i] : " ";
			
		}
		return toString(menssage);
	}
	
	private String toString(String[] messages) {
		String message = "";
		for (String data : messages) {
			message = message + " " +  data;
		}
		return message;
	}

}
