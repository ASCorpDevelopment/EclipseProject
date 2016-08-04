package com.bsangola.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.bsangola.modelos.Permissao;
import com.bsangola.modelos.Usuario;
import com.bsangola.servico.Usuarios;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ConsultaUsuarioBean implements Serializable {

	private List<Usuario> usuario;
	private List<Permissao> permissao;

	public ConsultaUsuarioBean() {
	}

	@PostConstruct
	private void init() {
		this.usuario = new Usuarios().buscarTodos();
	}

	public List<Usuario> getLista() {
		return usuario;
	}

	public void setLista(List<Usuario> lista) {
		this.usuario = lista;
	}

	public List<Permissao> getPermissao() {
		return permissao;
	}

	public void setPermissao(List<Permissao> permissao) {
		this.permissao = permissao;
	}
}
