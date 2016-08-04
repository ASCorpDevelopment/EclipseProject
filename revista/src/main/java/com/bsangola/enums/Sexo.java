package com.bsangola.enums;

public enum Sexo {
	
	MASCULINO("Masculino"),
	FEMENINO("Femenino");
	
	private String sexo;
	
	Sexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSexo() {
		return sexo;
	}
}
