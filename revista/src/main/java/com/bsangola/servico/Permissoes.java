package com.bsangola.servico;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import com.bsangola.daos.PermissaoDAO;
import com.bsangola.modelos.Permissao;
import com.bsangola.util.FacesUtil;

@SuppressWarnings("serial")
public class Permissoes implements Serializable{

	private EntityManager manager;
	private PermissaoDAO permissaoDAO;
	
	public Permissoes() {
		this.manager = FacesUtil.getRequestManager();
		this.permissaoDAO = new PermissaoDAO(manager);
	}
	
	

	public List<Permissao> buscarTodos() {
		try {

			return this.permissaoDAO.buscarTodos();

		} catch (NegocioException e) {
			FacesUtil.addMensagemErro("Não foi possivel buscar a lista das permissões.");
			e.printStackTrace();
		}
		return null;
	}

	public void criar(Permissao permissao) {
		try {

			this.permissaoDAO.criar(permissao);
			this.manager.flush();

		} catch (NegocioException e) {
			FacesUtil.addMensagemErro("Não foi possível efectuar a operação.");
			e.printStackTrace();
		}
	}

	public Permissao buscarPorCodigo(Long codigo) {
		try {

			return this.permissaoDAO.burcarPorCodigo(codigo);

		} catch (NegocioException e) {
			FacesUtil.addMensagemErro("Não foi possível efectuar a operação.");
			e.printStackTrace();
		}
		return null;
	}

	public void eliminar(Long codigo) {
		try {

			this.permissaoDAO.elininar(codigo);
		} catch (NegocioException e) {
			FacesUtil.addMensagemErro("Não foi possível eliminar a permissão.");
			e.printStackTrace();
		}
	}
}
