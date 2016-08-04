package com.bsangola.controladores;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.bsangola.enums.Categoria;
import com.bsangola.enums.Estado;
import com.bsangola.modelos.Artigo;
import com.bsangola.modelos.Usuario;
import com.bsangola.servico.Artigos;
import com.bsangola.util.CalendarUtil;
import com.bsangola.util.FacesUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CadastroArtigoBean implements Serializable {
	
	private Artigo artigo;
	private Estado[] estado;
	private Categoria[] categoria;
	private Usuario usuario;
	
	public CadastroArtigoBean() {
		this.artigo = new Artigo();
		init();
	}
	
	private void init(){
		this.setEstado(Estado.values());
		this.setCategoria(Categoria.values());
	}
	
	public void salvar(){
		this.getArtigo().setDataCadastro(CalendarUtil.dataDeHoje());

		if(this.getArtigo().getEstado().equals(Estado.PUBLICADO)){
			this.getArtigo().setDataPublicacao(CalendarUtil.dataDeHoje());	
		}
		
		try {
			new Artigos().criar(this.getArtigo());
			this.setArtigo(new Artigo());
			FacesUtil.addMensagemInformacao("Artigo salvo com sucesso!");
		} catch (Exception e) {
			FacesUtil.addMensagemInformacao("Erro ao salvar arquivo.");
			e.printStackTrace();
		}
	}

	public Artigo getArtigo() {
		return artigo;
	}

	public void setArtigo(Artigo artigo) {
		this.artigo = artigo;
	}

	public Estado[] getEstado() {
		return estado;
	}

	public void setEstado(Estado[] estado) {
		this.estado = estado;
	}

	public Categoria[] getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria[] categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
