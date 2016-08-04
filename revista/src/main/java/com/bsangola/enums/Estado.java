package com.bsangola.enums;

public enum Estado {
	
	PUBLICADO("Publicar"),
	DESPUBLICADO("Despublicar"),
	PENDENTE("Deixar Pendente");
	
	private String estado;
	
	Estado(String estado){
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}
}
