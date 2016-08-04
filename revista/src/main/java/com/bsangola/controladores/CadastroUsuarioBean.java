package com.bsangola.controladores;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.bsangola.enums.Sexo;
import com.bsangola.modelos.Permissao;
import com.bsangola.modelos.Usuario;
import com.bsangola.servico.Permissoes;
import com.bsangola.servico.Usuarios;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

	private Usuario usuario;
	private List<Permissao> permissaos;

	public CadastroUsuarioBean() {
		this.usuario = new Usuario();
		init();
	}

	public Sexo[] getSexo() {
		return Sexo.values();
	}

	private void init() {
		this.permissaos = new Permissoes().buscarTodos();
	}

	public boolean isEditando() {
		return this.usuario.getCodigo() != null;
	}

	public void salvar() {
		new Usuarios().criar(this.usuario);
		this.setUsuario(new Usuario());
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
		if (this.usuario == null) {
			this.usuario = new Usuario();
		}
	}

	public List<Permissao> getPermissaos() {
		return permissaos;
	}

	public void setPermissaos(List<Permissao> permissaos) {
		this.permissaos = permissaos;
	}
}
