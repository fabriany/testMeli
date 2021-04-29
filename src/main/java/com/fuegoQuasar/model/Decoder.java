package com.fuegoQuasar.model;

public class Decoder {
	
	private String[] menssageSato;
	private String[] menssageKenobi;
	private String[] menssageSkywalker;
	
	public Decoder(String[] menssageSato, String[] menssageKenobi, String[] menssageSkywalker) {
		this.menssageSato = menssageSato;
		this.menssageKenobi = menssageKenobi;
		this.menssageSkywalker = menssageSkywalker;
	}

	public String getMessage() {
		
		int sizeMessage = biggerNumber(new int[]{ menssageSato.length, menssageKenobi.length, menssageSkywalker.length});
		String[] menssage = new String[sizeMessage];;
		
		for (int i = 0 ; i < sizeMessage; i ++ ) {
			
			menssage[i] = validateMessage(menssageSato, i) ? menssageSato[i] : validateMessage(menssageKenobi, i) ? 
							menssageKenobi[i] : validateMessage(menssageSkywalker, i) ? menssageSkywalker[i] : " ";
			
		}
		return toString(menssage);
	}
	
	private int biggerNumber(int[] sizes) {
		
		int[] numeros = sizes;
		int mayor = numeros[0];
		for (int x = 1; x < numeros.length; x++) {
			if (numeros[x] > mayor) {
				mayor = numeros[x];
			}
		}
		
		return mayor;
		
	}
	
	private boolean validateMessage(String[] message, int position) {
		
		if (message.length > position) {
			if (!message[position].equals(" ")) {
				return true;
			}
		}
		
		return false;
	}
	
	private String toString(String[] messages) {
		
		StringBuffer message = new StringBuffer();
		int cont = 1;
		for (String data : messages) {
			message.append(data);
			if (cont != messages.length) {
				message.append(" ");
				cont++;
			}
		}
		
		return message.toString();
		
	}
	


}
