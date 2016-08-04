package com.bsangola.enums;

public enum Categoria {
	
	DESPORTO("Desporto"),
	SOCIEDADE("Sociedade");
	
	private String categoria;
	
	Categoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}

}
