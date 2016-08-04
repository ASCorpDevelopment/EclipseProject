package com.bsangola.controladores;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.bsangola.modelos.Usuario;

@ManagedBean
@SessionScoped
public class LoginBean {
	
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
