package com.bsangola.controladores;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.bsangola.modelos.Artigo;
import com.bsangola.servico.Artigos;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ConsultaArtigoBean implements Serializable {

	private List<Artigo> artigo;

	public ConsultaArtigoBean() {
		init();
	}

	private void init() {
		this.setArtigo(new Artigos().buscarTodos());
	}

	public List<Artigo> getArtigo() {
		return artigo;
	}

	public void setArtigo(List<Artigo> artigo) {
		this.artigo = artigo;
	}

}
