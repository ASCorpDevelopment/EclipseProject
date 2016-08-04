package com.bsangola.daos;

import java.util.List;

import javax.persistence.EntityManager;

import com.bsangola.cruds.PermissaoCRUD;
import com.bsangola.modelos.Permissao;
import com.bsangola.servico.NegocioException;

public class PermissaoDAO implements PermissaoCRUD{
	
	private EntityManager manager;
	
	public PermissaoDAO(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public List<Permissao> buscarTodos() throws NegocioException {
		return this.manager.createQuery("from Permissao", Permissao.class).getResultList();
	}

	@Override
	public Permissao burcarPorCodigo(Long codigo) throws NegocioException {
		return this.manager.find(Permissao.class, codigo);
	}

	@Override
	public void criar(Permissao permissao) throws NegocioException {
		this.manager.merge(permissao);
	}

	@Override
	public void elininar(Long codigo) throws NegocioException {
		this.manager.remove(this.burcarPorCodigo(codigo));
	}
}
