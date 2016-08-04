package com.bsangola.servico;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import com.bsangola.daos.ArtigoDAO;
import com.bsangola.modelos.Artigo;
import com.bsangola.util.FacesUtil;

@SuppressWarnings("serial")
public class Artigos implements Serializable {

	private EntityManager manager;
	private ArtigoDAO artigoDAO;

	public Artigos() {
		this.manager = FacesUtil.getRequestManager();
		this.artigoDAO = new ArtigoDAO(manager);
	}

	public List<Artigo> buscarTodos() {
		try {

			return this.artigoDAO.buscarTodos();

		} catch (NegocioException e) {
			FacesUtil.addMensagemErro("Não foi possivel buscar a lista das artigos.");
			e.printStackTrace();
		}
		return null;
	}

	public void criar(Artigo artigo) {
		try {

			this.artigoDAO.criar(artigo);
			this.manager.flush();

		} catch (NegocioException e) {
			FacesUtil.addMensagemErro("Não foi possível efectuar a operação.");
			e.printStackTrace();
		}
	}

	public Artigo buscarPorCodigo(Long codigo) {
		try {

			return this.artigoDAO.burcarPorCodigo(codigo);

		} catch (NegocioException e) {
			FacesUtil.addMensagemErro("Não foi possível efectuar a operação.");
			e.printStackTrace();
		}
		return null;
	}

	public void eliminar(Long codigo) {
		try {

			this.artigoDAO.elininar(codigo);
		} catch (NegocioException e) {
			FacesUtil.addMensagemErro("Não foi possível eliminar a artigo.");
			e.printStackTrace();
		}
	}
}
